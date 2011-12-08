/**
 * 
 */
package com.gluszecki.iocc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author cthulhu
 * 
 */
public abstract class AbstractProxyFactory implements ProxyFactory {

	public final <T> T createProxy(T obj) {
		ClassLoader classLoader = getClassLoader();
		Class<?>[] interfaces = getInterfaces(obj);
		InvocationHandler invocationHandler = getInvocationHandler(obj);
		@SuppressWarnings("unchecked")
		T proxy = (T) Proxy.newProxyInstance(classLoader, interfaces,
				invocationHandler);
		return proxy;
	}

	protected abstract ClassLoader getClassLoader();

	protected abstract Class<?>[] getInterfaces(Object obj);

	protected abstract InvocationHandler getInvocationHandler(Object obj);

}
