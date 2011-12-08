/**
 * 
 */
package com.gluszecki.iocc.context;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author cthulhu
 * 
 */
public final class ThreadContext implements Context {

	private static final ThreadLocal<ThreadContext> INSTANCES = new ThreadLocal<ThreadContext>();

	public static ThreadContext getInstance() {
		ThreadContext instance = INSTANCES.get();
		if (instance == null) {
			instance = new ThreadContext();
			INSTANCES.set(instance);
		}
		return instance;
	}

	private final Map<String, Object> store;

	private ThreadContext() {
		store = new HashMap<String, Object>();
	}

	@Override
	public Object get(String key) {
		return store.get(key);
	}

//	@Override
//	public Object get(String namespace, String key) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	@Override
	public Set<String> getKeys() {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Override
//	public Set<String> getKeys(String namespace) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	@Override
	public void set(String key, Object value) {
		store.put(key, value);
	}
	
//	@Override
//	public void set(String namespace, String key, Object value) {
//		// TODO Auto-generated method stub
//		
//	}
}