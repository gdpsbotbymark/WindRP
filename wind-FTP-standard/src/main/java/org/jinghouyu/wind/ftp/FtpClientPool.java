package org.jinghouyu.wind.ftp;

import org.jinghouyu.windRP.RPConfig;
import org.jinghouyu.windRP.WindRPool;
import org.jinghouyu.windRP.exception.ResourceException;
import org.jinghouyu.windRP.interf.NumberChooser;

public class FtpClientPool {

	private WindRPool<FtpClient> windRPool = null;
	
	public void setNumberChooser(NumberChooser numberChooser) {
		windRPool.setNumberChooser(numberChooser);
	}
	
	public FtpClientPool(RPConfig config, FtpClientResourceHolder resourceHolder) throws ResourceException {
		windRPool = new WindRPool<FtpClient>(resourceHolder);
		windRPool.setConfig(config);
	}
	
	public FtpClient getFtpClient() throws ResourceException {
		return windRPool.getResourceEntry().getResource();
	}
}
