package com.jinghouyu.wind.jdbc;

import java.sql.Connection;

import org.jinghouyu.windRP.RPConfig;
import org.jinghouyu.windRP.ResourceHolder;
import org.jinghouyu.windRP.WindRPool;
import org.jinghouyu.windRP.exception.ResourceBuildException;
import org.jinghouyu.windRP.interf.NumberChooser;

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
public class JDBCConnectionPool {

	private WindRPool<Connection> windRPool = null;
	
	public void setNumberChooser(NumberChooser numberChooser) {
		windRPool.setNumberChooser(numberChooser);
	}
	
	public void setConnectionHolder(ConnectionHolder connectionHolder) {
		windRPool.setResourceHolder(connectionHolder);
	}
	
	public JDBCConnectionPool(RPConfig config, ResourceHolder<Connection> resourceHolder) throws ResourceBuildException {
		windRPool = new WindRPool<Connection>(resourceHolder);
		windRPool.setConfig(config);
	}
	
	public Connection getConnection() throws ResourceBuildException {
		return windRPool.getResourceEntry().getResource();
	}
}