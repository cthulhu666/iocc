/**
 * 
 */
package com.gluszecki.iocc;

import org.apache.log4j.Logger;

import com.gluszecki.iocc.component.Component;
import com.gluszecki.iocc.component.Components;

/**
 * @author cthulhu
 *
 */
public class ClassHandle {
	
	private static final String SEPARATOR = System.getProperty("file.separator");
	
	private final String className;
		
	private Logger logger = Logger.getLogger(getClass());

	public ClassHandle(String fileName) {
		super();
		int indexOfClassSufix = fileName.indexOf(".class");
		if (indexOfClassSufix < 0) {
			throw new IllegalArgumentException(fileName);
		}
		fileName = fileName.substring(0, indexOfClassSufix);
		fileName = fileName.replace(SEPARATOR, ".");
		className = fileName;
	}
	
	public Component<?> createComponent() {
		Class<?> clazz = getClazz();
		if (clazz == null) {
			return null;
		}
		com.gluszecki.iocc.annotation.Component componentAnnotation = (com.gluszecki.iocc.annotation.Component) clazz.getAnnotation(com.gluszecki.iocc.annotation.Component.class);
		if (componentAnnotation == null) {
			return null;
		}
		Component<?> component = Components.instance().newInstance(clazz);
		return component;
	}
	
	Class<?> getClazz() {
		try {
			return Class.forName(className);
		} catch (ClassNotFoundException e) {
			logger.warn(e);
		} catch (NoClassDefFoundError e) {
			logger.warn(e);
		}
		return null;
	}
	
	@Override
	public String toString() {
		return className;
	}

}
