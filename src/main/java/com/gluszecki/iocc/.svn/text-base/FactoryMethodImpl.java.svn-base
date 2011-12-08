/**
 * 
 */
package com.gluszecki.iocc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.gluszecki.iocc.annotation.Factory;
import com.gluszecki.iocc.component.Component;

/**
 * @author cthulhu
 * 
 */
public final class FactoryMethodImpl implements FactoryMethod {

	public static FactoryMethod getInstance(Class clazz, Component component, Method method) {
		Factory factoryAnnotation = method.getAnnotation(Factory.class);
		if (factoryAnnotation == null) {
			throw new IllegalArgumentException("TODO"); // TODO
		}

		String key = factoryAnnotation.name();
		
		FactoryMethodImpl factoryMethod = new FactoryMethodImpl(method.getName(), component);
		FactoryMethodStore.getInstance().set(key, factoryMethod);
		return factoryMethod;
	}

	private final String methodName;
	
	private final Component<?> component;
	
	// private final ContextLookup contextLookup;	

	FactoryMethodImpl(String methodName, Component<?> component) {
		super();
		this.methodName = methodName;
		this.component = component;
		
	}
	
	@Override
	public Object execute() {
		Object obj = getComponentInstance();
		return execute(obj);		
	}

	
	private Object getComponentInstance() {
		return component.newInstance();
	}

	public Object execute(Object obj) {	
		try {
			Method method = obj.getClass().getMethod(methodName, null);
			return method.invoke(obj, null);
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}
}