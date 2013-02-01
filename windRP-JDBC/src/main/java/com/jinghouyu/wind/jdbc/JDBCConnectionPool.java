package com.jinghouyu.wind.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.jinghouyu.windRP.RPConfig;
import org.jinghouyu.windRP.WindRPool;
import org.jinghouyu.windRP.exception.ResourceException;
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
	
	public JDBCConnectionPool(RPConfig config, ConnectionHolder connectionHolder) throws SQLException {
		windRPool = new WindRPool<Connection>(connectionHolder);
		try {
			windRPool.setConfig(config);
		} catch (ResourceException e) {
			throw (SQLException) e.getSourceException();
		}
	}
	
	public Connection getConnection() throws SQLException {
		try {
			return windRPool.getResourceEntry().getResource();
		} catch (ResourceException e) {
			throw (SQLException) e.getSourceException();
		}
	}
}