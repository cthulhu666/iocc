/**
 * 
 */
package com.gluszecki.iocc;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cthulhu
 * 
 */
public class FactoryMethodStore {

	private static final FactoryMethodStore INSTANCE = new FactoryMethodStore();

	public static FactoryMethodStore getInstance() {
		return INSTANCE;
	}

	private Map<String, FactoryMethod> store = new HashMap<String, FactoryMethod>();

	private FactoryMethodStore() {
		// private
	}

	public void set(String key, FactoryMethod factoryMethod) {
		store.put(key, factoryMethod);
	}

	public FactoryMethod get(String key) {
		return store.get(key);
	}

}
