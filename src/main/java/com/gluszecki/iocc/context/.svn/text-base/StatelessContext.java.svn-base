package com.gluszecki.iocc.context;

import java.util.Collections;
import java.util.Set;

public class StatelessContext implements Context {
	
	public static StatelessContext getInstance() {
		return new StatelessContext();
	}
	
	private StatelessContext() {
		// bez instancji
	}

	@Override
	public <T> T get(String key) {		
		return null;
	}

//	@Override
//	public <T> T get(String namespace, String key) {		
//		return null;
//	}

	@Override
	public Set<String> getKeys() {		
		return Collections.emptySet();
	}

//	@Override
//	public Set<String> getKeys(String namespace) {
//		return Collections.emptySet();
//	}

	@Override
	public void set(String key, Object value) {
		// do nothing
	}

//	@Override
//	public void set(String namespace, String key, Object value) {
//		// do nothing
//	}
}
