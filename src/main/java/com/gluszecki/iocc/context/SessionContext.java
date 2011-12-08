package com.gluszecki.iocc.context;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class SessionContext implements Context, Serializable {

	private static ThreadLocal<SessionContext> INSTANCES = new ThreadLocal<SessionContext>();

	public final static SessionContext getInstance() {
		return INSTANCES.get();
	}

	private final Map<String, Object> store;

	public SessionContext() {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getKeys() {
		// TODO Auto-generated method stub
		return null;
	}

	public void set(String key, Object value) {
	};
}