package org.jinghouyu.windRP;

import org.jinghouyu.windRP.exception.ResourceReleaseException;

public interface Resource {

	void releaseRealResource() throws ResourceReleaseException;
	
}
