/**
 * 
 */
package com.gluszecki.iocc;


/**
 * Podstawowa implementacja {@link ComponentInstanceFactory} tworząca obiekty za pomocą {@link Class#newInstance()}.
 *  
 * @author cthulhu
 *
 */
public class ComponentInstanceFactoryImpl<T>  implements ComponentInstanceFactory<T> {
	
	private final Class<T> clazz;
	
	public ComponentInstanceFactoryImpl(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	@Override
	public T newInstance() {
		T obj = null;
		try {
			obj = clazz.newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
		return obj;
	}
}