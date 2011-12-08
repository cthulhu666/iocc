package com.gluszecki.iocc.component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class Components {

	private static final Components INSTANCE = new Components();

	public static final Components instance() {
		return INSTANCE;
	}

	private Components() {
		// singleton
	}

	private final Map<Class<?>, Component<?>> components = new ConcurrentHashMap<Class<?>, Component<?>>();
	
	public <T> T createInstance(Class<T> clazz) {
		Component<?> component = getInstance(clazz);
		if (component == null) {
			throw new IllegalStateException("No component of class " + clazz);
		}
		T instance = (T) component.newInstance();
		component.getScope().getContextInstance()
				.set(clazz.getName(), instance);
		return instance;
	}

//	public Object createInstanceIfNecessary(Class<?> clazz) {
//		Component<?> component = getInstance(clazz);
//		if (component == null) {
//			return null;
//		}
//		return component.newInstanceIfNecessary();
//	}

	public synchronized <T> Component<T> getInstance(Class<T> clazz) {
		Component<?> component = components.get(clazz);
		if (component == null) {
			component = newInstance(clazz);
			components.put(clazz, component);
		}
		return (Component<T>) component;
	}

	public boolean isComponentClass(Class<?> clazz) {
		return components.containsKey(clazz);
	}

	public <T> Component<T> newInstance(Class<T> clazz) {
		ComponentImpl<T> component = new ComponentImpl<T>(clazz);
		components.put(clazz, component);
		return component;
	}

}
