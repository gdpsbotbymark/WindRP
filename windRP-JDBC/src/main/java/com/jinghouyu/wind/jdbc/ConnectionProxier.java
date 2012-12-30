package com.jinghouyu.wind.jdbc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

import org.jinghouyu.windRP.Partition;
import org.jinghouyu.windRP.ResourceEntry;

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
public class ConnectionProxier implements InvocationHandler {
	
	private Connection conn = null;
	
	private ResourceEntry<Connection> resourceEntry = null;
	
	public ResourceEntry<Connection> getResourceEntry() {
		return this.resourceEntry;
	}
	
	public ConnectionProxier(Connection conn, Partition<Connection> partition) {
		this.conn = conn;
		Connection proxy = (Connection)Proxy.newProxyInstance(conn.getClass().getClassLoader(), conn.getClass().getSuperclass().getInterfaces(), this);
		resourceEntry = new ResourceEntry<Connection>(partition, proxy);
	}
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		String name = method.getName();
		if("close".equals(name)) {
			resourceEntry.release();
			return null;
		}
		return method.invoke(conn, args);
	}
}
