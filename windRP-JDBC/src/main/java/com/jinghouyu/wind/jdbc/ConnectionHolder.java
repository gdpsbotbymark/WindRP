package com.jinghouyu.wind.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jinghouyu.windRP.Partition;
import org.jinghouyu.windRP.ResourceEntry;
import org.jinghouyu.windRP.ResourceHolder;
import org.jinghouyu.windRP.exception.ResourceBuildException;

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
public class ConnectionHolder implements ResourceHolder<Connection> {

	private String url;
	
	private String user;
	
	private String password;
	
	public static void setDriver(String driver) {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public ResourceEntry<Connection> buildResource(Partition<Connection> partition) throws ResourceBuildException {
		try {
			Connection conn = createConnection();
//			return new ConnectionProxier(conn, partition).getResourceEntry();
			return new ConnectionProxy(conn, partition).getResourceEntry();
		} catch (SQLException e) {
			throw new ResourceBuildException(e);
		}
	}

	private Connection createConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
}
