package org.jinghouyu.windRP;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author Simsir.L
 * modified by <person></person> on <data></date>
 * 
 * |  created date  | modified date  |  modified person |
 * |  2012-12-28      |           |        |
 * @description
 * the configuration of Wind Resource Pool.
 * it defines the partitionCount, initResourceCountPerPartition
 * and maxResourceCountPerPartition.
 * when pool cannot find the resource in all Partitions, it will 
 * wait for waitTime timeUnit until resource is found
 * If waitTime is less than 0, it will wait until someone releases.
 * 
 * @since 1.0.0
 */
public class RPConfig {

	private int partitionCount = 1;
	
	private int initResourceCountPerPartition = 0;
	
	private int maxResourceCountPerPartition = 1;
	
	private long idleMaxTime = -1;
	
	private TimeUnit idleMaxTimeUnit = TimeUnit.SECONDS;
	
	private long waitTime = 10;
	
	private TimeUnit timeUnit = TimeUnit.SECONDS;
	
	private int retryTime = 0;
	
	public long getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(long waitTime) {
		this.waitTime = waitTime;
	}

	public TimeUnit getTimeUnit() {
		return timeUnit;
	}

	public void setTimeUnit(TimeUnit timeUnit) {
		this.timeUnit = timeUnit;
	}

	public int getRetryTime() {
		return retryTime;
	}

	public void setRetryTime(int retryTime) {
		this.retryTime = retryTime;
	}

	public int getPartitionCount() {
		return partitionCount;
	}

	public void setPartitionCount(int partitionCount) {
		this.partitionCount = partitionCount;
	}

	public int getInitResourceCountPerPartition() {
		return initResourceCountPerPartition;
	}

	public void setInitResourceCountPerPartition(int initResourceCountPerPartition) {
		this.initResourceCountPerPartition = initResourceCountPerPartition;
	}

	public int getMaxResourceCountPerPartition() {
		return maxResourceCountPerPartition;
	}

	public void setMaxResourceCountPerPartition(int maxResourceCountPerPartition) {
		this.maxResourceCountPerPartition = maxResourceCountPerPartition;
	}

	public long getIdleMaxTime() {
		return idleMaxTime;
	}

	public void setIdleMaxTime(long idleMaxTime) {
		this.idleMaxTime = idleMaxTime;
	}

	public TimeUnit getIdleMaxTimeUnit() {
		return idleMaxTimeUnit;
	}

	public void setIdleMaxTimeUnit(TimeUnit idleMaxTimeUnit) {
		this.idleMaxTimeUnit = idleMaxTimeUnit;
	}
}
