package org.jinghouyu.windRP;

import org.jinghouyu.windRP.exception.ResourceBuildException;

/**
 * @author Simsir.L
 * modified by <person></person> on <data></date>
 *
 * |  created date  | modified date  |  modified person |
 * |         |           |        |
 * @description
 * provide a way for the implementations to create a resource.
 * @since 1.0.0
 */
public interface ResourceHolder<T> {
	
	public ResourceEntry<T> buildResource(Partition<T> partition) throws ResourceBuildException;
	
}
