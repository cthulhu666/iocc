/**
 * 
 */
package com.gluszecki.iocc;

import java.lang.reflect.InvocationTargetException;

import com.gluszecki.iocc.annotation.Constructor;
import com.gluszecki.iocc.annotation.In;

/**
 * Fabryka konstruująca obiekty za pomocą parametryzowanego konstruktora.
 * 
 * Każdy parametr konstruktora musi posiadać adnotację {@link In}.
 * Klasa musi posiadać dokładnie jeden konstruktor opatrzony adnotacją {@link Constructor}.
 * 
 * @author cthulhu
 *
 */
public class ConstructorInjectionComponentInstanceFactoryImpl<T> implements
		ComponentInstanceFactory<T> {
	
	private final Class<T> clazz;
	
	private final java.lang.reflect.Constructor<?> constructor;
	
	public ConstructorInjectionComponentInstanceFactoryImpl(Class<T> clazz) {
		this.clazz = clazz;
		this.constructor = getConstructor(clazz);
		foo(constructor);
	}
	
	private void foo(java.lang.reflect.Constructor<?> constructor) {
		Class<?>[] parameterTypes = constructor.getParameterTypes();
		// TODO
	}
	
	private java.lang.reflect.Constructor<?> getConstructor(Class<T> clazz) {
		java.lang.reflect.Constructor<?> constructor = null;
		for (java.lang.reflect.Constructor<?> c : clazz.getDeclaredConstructors()) {
			Constructor ann = c.getAnnotation(Constructor.class);
			if (ann != null) {
				if (constructor != null) {
					throw new IllegalArgumentException("Klasa ma więcej niż jeden konstruktor z adnotacją @Constructor");
				}
				constructor = c;
			}			
		}
		if (constructor == null) {
			throw new IllegalArgumentException("Klasa nie ma konstruktora z adnotacją @Constructor");
		}
		return constructor;
	}

	private Object[] getInitArgs() {
		// TODO Auto-generated method stub
		return new Object[0];
	}

	@Override
	public T newInstance() {
		Object[] initArgs = getInitArgs();
		T instance;
		try {
			instance = (T) constructor.newInstance(initArgs);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return instance;
	}
}