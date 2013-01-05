package org.jinghouyu.wind.ftp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.jinghouyu.windRP.Partition;
import org.jinghouyu.windRP.ResourceEntry;

public class FtpProxy implements InvocationHandler {

	private FtpClient client;
	
	private ResourceEntry<FtpClient> resourceEntry;
	
	private FtpProxy(FtpClient client, Partition<FtpClient> partition) {
		this.client = client;
		FtpClient proxy = (FtpClient) Proxy.newProxyInstance(client.getClass().getClassLoader(), client.getClass().getInterfaces(), this);
		resourceEntry = new ResourceEntry<FtpClient>(partition, proxy);
	}
	
	static ResourceEntry<FtpClient> proxy(FtpClient client, Partition<FtpClient> partition) {
		return new FtpProxy(client, partition).resourceEntry;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		String methodName = method.getName();
		if("close".equals(methodName)) {
			resourceEntry.release();
		}
		return method.invoke(client, args);
	}
}
