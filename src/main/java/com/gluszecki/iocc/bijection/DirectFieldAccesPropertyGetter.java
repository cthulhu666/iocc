package com.gluszecki.iocc.bijection;

import java.lang.reflect.Field;


public class DirectFieldAccesPropertyGetter implements PropertyGetter {

	private final Field field;

	public DirectFieldAccesPropertyGetter(Field field) {
		super();
		this.field = field;
	}

	@Override
	public Object getProperty(Object object) {
		if (!field.isAccessible()) {
			try {
				field.setAccessible(true);
			} catch (SecurityException e) {
				throw new PropertyAccessException(e);
			}
		}
		try {
			return field.get(object);
		} catch (IllegalArgumentException e) {
			throw new PropertyAccessException(e);
		} catch (IllegalAccessException e) {
			throw new PropertyAccessException(e);
		}
	}
}
