package org.jinghouyu.wind.ftp;

import org.jinghouyu.windRP.Partition;
import org.jinghouyu.windRP.ResourceEntry;
import org.jinghouyu.windRP.ResourceHolder;
import org.jinghouyu.windRP.exception.ResourceBuildException;

public abstract class FtpClientResourceHolder implements ResourceHolder<FtpClient> {

	public ResourceEntry<FtpClient> buildResource(Partition<FtpClient> partition)
			throws ResourceBuildException {
		return FtpProxy.proxy(buildResource(), partition);
	}

	protected abstract FtpClient buildResource() throws ResourceBuildException;
}
