package org.jinghouyu.windRP;

import org.jinghouyu.windRP.exception.ResourceException;

public interface Resource {

	void releaseRealResource() throws ResourceException;
	
	boolean testResource() throws ResourceException;
}
