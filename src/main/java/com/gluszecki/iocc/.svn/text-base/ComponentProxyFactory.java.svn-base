/**
 * 
 */
package com.gluszecki.iocc;

import java.lang.reflect.InvocationHandler;

import com.gluszecki.iocc.component.Component;

/**
 * @author cthulhu
 * 
 */
public class ComponentProxyFactory extends AbstractProxyFactory {

	private final Component<?> component;

	public ComponentProxyFactory(Component<?> component) {
		super();
		this.component = component;
	}

	@Override
	protected ClassLoader getClassLoader() {
		return getClass().getClassLoader();
	}

	@Override
	protected Class<?>[] getInterfaces(Object obj) {
		return component.getInterfaces();
	}

	@Override
	protected InvocationHandler getInvocationHandler(Object obj) {
		@SuppressWarnings("unchecked")
		InvocationHandler ih = new ComponentInvocationHandler(obj, component);
		return ih;
	}

}
