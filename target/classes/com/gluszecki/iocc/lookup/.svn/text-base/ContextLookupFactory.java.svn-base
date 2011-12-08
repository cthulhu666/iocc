/**
 * 
 */
package com.gluszecki.iocc.lookup;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.gluszecki.iocc.FactoryMethod;
import com.gluszecki.iocc.FactoryMethodStore;
import com.gluszecki.iocc.annotation.In;
import com.gluszecki.iocc.bijection.NameResolverImpl;
import com.gluszecki.iocc.bijection.ScopeResolverImpl;
import com.gluszecki.iocc.component.Component;
import com.gluszecki.iocc.component.Components;
import com.gluszecki.iocc.context.BasicScope;
import com.gluszecki.iocc.context.Context;
import com.gluszecki.iocc.context.Scope;

/**
 * @author cthulhu
 * 
 */
public class ContextLookupFactory {
	
	public static ContextLookupFactory instance() {
		return new ContextLookupFactory();
	}
	
	private ContextLookupFactory() {
		
	}
	
	public ContextLookup getInstance(final Component<?> component, final Field field, final In in) {
		
		Scope scope = new ScopeResolverImpl(in).getScope();	
		if (scope == BasicScope.UNSPECIFIED && in.clazz() != Object.class) {
			scope = Components.instance().getInstance(in.clazz()).getScope();
		}
		final Scope theScope = scope;
		final String name = new NameResolverImpl(in).getName();
		
		FactoryMethod factoryMethod = FactoryMethodStore.getInstance().get(name);
		if (factoryMethod != null) {
			return new FactoryMethodContextLookup(factoryMethod, in, field, component);
		}
			
		return new ContextLookup() {
			
			@Override
			public Object lookup() {
				Context context = theScope.getContextInstance();
				Object obj = context.get(name);
				if (obj == null) {
					obj = create(in);
					context.set(name, obj);
				}
				return obj;
			}
			
			Object create(In in) {
				FactoryMethod factoryMethod = FactoryMethodStore.getInstance().get(name);
				if (factoryMethod != null) {
					return executeFactoryMethod(factoryMethod);
				}				
				return Components.instance().createInstance(in.clazz());
			}

			Object executeFactoryMethod(FactoryMethod factoryMethod) {
				return factoryMethod.execute();
			}
		};
	}
	

	public ContextLookup getInstance(Method method, In in) {
		
		return null;
	}
}