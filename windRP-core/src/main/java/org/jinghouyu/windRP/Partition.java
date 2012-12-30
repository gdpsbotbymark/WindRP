package org.jinghouyu.windRP;

import java.util.Date;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.jinghouyu.windRP.exception.ResourceBuildException;
import org.jinghouyu.windRP.exception.ResourceReleaseException;

/**
 *
 * @author Simsir.L
 * modified by <person></person> on <data></date>
 *
 * |  created date  | modified date  |  modified person |
 * |         |           |        |
 * @description
 *
 * @since 1.0.0
 */
public class Partition<T> {

	private int maxResourceCountPerPartition;
	
	private ResourceHolder<T> resourceHolder = null;
	
	private Long idleMaxTime;
	
	private LinkedBlockingDeque<ResourceEntry<T>> avails;
	
	private LinkedList<ResourceEntry<T>> busies = new LinkedList<ResourceEntry<T>>();
	
	private AtomicInteger currentSize = new AtomicInteger(0);
	
	Partition(
			int initResourceCountPerPartition, 
			int maxResourceCountPerPartition, 
			ResourceHolder<T> resourceHolder,
			Long idleMaxTime,
			TimeUnit idleMaxTimeUnit) throws ResourceBuildException {
		this.maxResourceCountPerPartition = maxResourceCountPerPartition;
		this.resourceHolder = resourceHolder;
		this.idleMaxTime = idleMaxTime < 0 ? -1 : TimeUnit.MILLISECONDS.convert(idleMaxTime, idleMaxTimeUnit);
		avails = new LinkedBlockingDeque<ResourceEntry<T>>(maxResourceCountPerPartition);
		for(int i = 0 ; i < initResourceCountPerPartition; i++) {
			ResourceEntry<T> resourceEntry = resourceHolder.buildResource(this);
			avails.add(resourceEntry);
			currentSize.incrementAndGet();
		}
	}
	
	private ResourceEntry<T> getAvailOne(Date expiredDate) {
		ResourceEntry<T> resourceEntry = avails.poll();
		if(resourceEntry == null) {
			return null;
		}
		if(resourceEntry.getCreated().before(expiredDate)) {
			currentSize.addAndGet(-1);
			try {
				((Resource) resourceEntry.getResource()).releaseRealResource();
			} catch (ResourceReleaseException e) {
				// log in debug mode
			}
			return getAvailOne(expiredDate);
		} else {
			return resourceEntry;
		}
	}
	
	ResourceEntry<T> getResource() throws ResourceBuildException {
		if(avails.size() > 0) {   //if avail resource is exists
			synchronized(this) {
				if(avails.size() > 0) {
					ResourceEntry<T> resourceEntry;
					if(this.idleMaxTime < 0) {
						resourceEntry = avails.poll();
					} else {
						Date expiredDate = new Date(System.currentTimeMillis() - this.idleMaxTime);
						resourceEntry = getAvailOne(expiredDate);
					}
					if(resourceEntry != null) {
						busies.add(resourceEntry);
						return resourceEntry;
					}
				}
			}
		}
		if(currentSize.get() < maxResourceCountPerPartition) {  //if it has not reached up to the max count;
			synchronized(this) {
				if(currentSize.get() < maxResourceCountPerPartition) {
					ResourceEntry<T> resourceEntry = resourceHolder.buildResource(this);
					busies.add(resourceEntry);
					currentSize.incrementAndGet();
					return resourceEntry;
				}
			}
		}
		return null;
	}
	
	ResourceEntry<T> getResource(Long waitTime, TimeUnit unit) throws ResourceBuildException {
		ResourceEntry<T> resource = getResource();
		if(resource == null) {  //the event that resource is null means resource's count has reached up to the max count;
			try {
				if(waitTime < 0) {
					resource = avails.takeFirst();
				} else {
					resource = avails.pollFirst(waitTime, unit);
				}
			} catch (InterruptedException e) {
				resource = null;  //if it is interrupted, give up this Resource request;
			}
		}
		if(resource != null) {
			synchronized(this) {
				busies.add(resource);
			}
		}
		return resource;
	}
	
	public int getAvailSize() {
		return avails.size();
	}
	
	public int getBusySize() {
		return busies.size();
	}
	
	void releaseResource(ResourceEntry<T> resourceEntry) {
		synchronized(this) {
			busies.remove(resourceEntry);
			avails.add(resourceEntry);
		}
	}
}
