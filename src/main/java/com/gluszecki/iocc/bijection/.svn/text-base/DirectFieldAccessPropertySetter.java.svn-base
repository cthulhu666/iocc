/**
 * 
 */
package com.gluszecki.iocc.bijection;

import java.lang.reflect.Field;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.log4j.Logger;


/**
 * @author cthulhu
 *
 */
public class DirectFieldAccessPropertySetter implements PropertySetter {
	
	private static final Logger logger = Logger.getLogger(DirectFieldAccessPropertySetter.class);
	
	private final Field field;
	
	public DirectFieldAccessPropertySetter(Field field) {
		this.field = field;
	}

	/* (non-Javadoc)
	 * @see myorm.PropertySetter#setProperty(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void setProperty(Object obj, Object value) {
		if (logger.isDebugEnabled()) {
			logger.debug("setting property " + field + " of component " + obj + ": " + value);
		}
		if (! field.isAccessible()) {
			try {
				field.setAccessible(true);
			} catch (SecurityException e) {
				throw new PropertyAccessException(e);
			}
		}
		try {
			field.set(obj, value);
		} catch (IllegalArgumentException e) {
			throw new PropertyAccessException(e);
		} catch (IllegalAccessException e) {
			throw new PropertyAccessException(e);
		}
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).append(field.getName()).toString();
	}
}
