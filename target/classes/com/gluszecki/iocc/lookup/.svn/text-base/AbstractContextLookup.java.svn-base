/**
 * 
 */
package com.gluszecki.iocc.lookup;

import java.lang.reflect.Field;

import com.gluszecki.iocc.annotation.In;
import com.gluszecki.iocc.component.Component;

/**
 * @author cthulhu
 * 
 */
public abstract class AbstractContextLookup implements ContextLookup {

	public AbstractContextLookup(In in, Field field, Component<?> component) {
		super();
		this.in = in;
		this.field = field;
		this.component = component;
	}

	protected final In in;

	protected final Field field;

	protected final Component<?> component;

	@Override
	public final Object lookup() {
		Object obj = lookupInContexts();
		if (obj == null) {
			obj = createInstance();
			putInContext(obj);
		}
		return obj;
	}

	protected abstract void putInContext(Object obj);

	protected abstract Object createInstance();

	protected abstract Object lookupInContexts();

}
