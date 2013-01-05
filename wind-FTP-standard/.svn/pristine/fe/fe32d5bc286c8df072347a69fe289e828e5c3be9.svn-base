package org.jinghouyu.wind.ftp;

import org.jinghouyu.windRP.RPConfig;
import org.jinghouyu.windRP.WindRPool;
import org.jinghouyu.windRP.exception.ResourceBuildException;
import org.jinghouyu.windRP.interf.NumberChooser;

public class FtpClientPool {

	private WindRPool<FtpClient> windRPool = null;
	
	public void setNumberChooser(NumberChooser numberChooser) {
		windRPool.setNumberChooser(numberChooser);
	}
	
	public FtpClientPool(RPConfig config, FtpClientResourceHolder resourceHolder) throws ResourceBuildException {
		windRPool = new WindRPool<FtpClient>(resourceHolder);
		windRPool.setConfig(config);
	}
	
	public FtpClient getFtpClient() throws ResourceBuildException {
		return windRPool.getResourceEntry().getResource();
	}
}
