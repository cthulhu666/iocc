/**
 * 
 */
package com.gluszecki.iocc.context;

import java.util.Set;

/**
 * @author cthulhu
 *
 */
public interface Context {
	
	String DEFAULT_NAMESPACE = "<DEFAULT>";
	
	<T> T get(String key);
	
	// <T> T get(String namespace, String key);
	
	Set<String> getKeys();
	
	// Set<String> getKeys(String namespace);
		
	void set(String key, Object value);
	
	// void set(String namespace, String key, Object value);

}
