/**
 * 
 */
package com.gluszecki.iocc.context;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author cthulhu
 * 
 */
public final class GlobalContext implements Context {

	private static final GlobalContext INSTANCE = new GlobalContext();

	public static GlobalContext getInstance() {
		return INSTANCE;
	}

	private final Map<String, Object> store;

	private GlobalContext() {
		store = new ConcurrentHashMap<String, Object>();
	}

	@Override
	public <T> T get(String key) {
		return (T) store.get(key);
	}

	@Override
	public Set<String> getKeys() {
		return store.keySet();
	}

	@Override
	public void set(String key, Object value) {
		store.put(key, value);
	}
}