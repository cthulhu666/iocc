/**
 * 
 */
package com.gluszecki.iocc.context;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author cthulhu
 * 
 */
public class ConversationContext implements Context, Serializable {

	private static ThreadLocal<ConversationContext> INSTANCES = new ThreadLocal<ConversationContext>();

	public static ConversationContext getInstance() {
		return INSTANCES.get();
	}

	private final Map<String, Object> store;

	public ConversationContext() {
		super();
		store = new ConcurrentHashMap<String, Object>();
	}

	public void attach() {
		INSTANCES.set(this);
	}

	public void detach() {
		INSTANCES.set(null);
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