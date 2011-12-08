/**
 * 
 */
package com.gluszecki.iocc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.gluszecki.iocc.component.Component;

/**
 * @author cthulhu
 * 
 */
public class ComponentInvocationHandler<T> implements InvocationHandler {

	private final Component<T> component;

	private final T obj;

	// private static final Logger logger = Logger.getLogger(ComponentInvocationHandler.class);

	public ComponentInvocationHandler(T obj, Component<T> component) {
		super();
		this.obj = obj;
		this.component = component;
	}

	void after(T obj) {
		component.outject(obj);
		component.disinject(obj);
	}

	void before(T obj, Method method, Object[] args) {
		component.inject(obj);
	}

	private void handleException(Exception e) {
		throw new RuntimeException(e);

	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		before(obj, method, args);
		Object retVal = null;
		try {
			retVal = method.invoke(obj, args);
		} catch (Exception e) {
			handleException(e);
		} finally {
			after(obj);
		}
		return retVal;
	}
}