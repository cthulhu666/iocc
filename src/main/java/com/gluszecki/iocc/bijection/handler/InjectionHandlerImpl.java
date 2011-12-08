/**
 * 
 */
package com.gluszecki.iocc.bijection.handler;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.gluszecki.iocc.bijection.PropertySetter;
import com.gluszecki.iocc.lookup.ContextLookup;

/**
 * @author cthulhu
 *
 */
public class InjectionHandlerImpl implements InjectionHandler {
	
	private final PropertySetter propertySetter;
	
	private final ContextLookup contextLookup;
	
	public InjectionHandlerImpl(PropertySetter propertySetter, ContextLookup contextLookup) {
		this.propertySetter = propertySetter;
		this.contextLookup = contextLookup;
	}
	
	@Override
	public final void disinject(Object target) {
		getPropertySetter().setProperty(target, null);
	}

	
	@Override
	public final void inject(Object target) {
		Object value = getValueToInject();
		if (value != null) {
			getPropertySetter().setProperty(target, value);
		}
	}


	protected Object getValueToInject() {
		return contextLookup.lookup();
	}


	protected PropertySetter getPropertySetter() {
		return propertySetter;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).append(propertySetter).append(contextLookup).toString();
	}
}