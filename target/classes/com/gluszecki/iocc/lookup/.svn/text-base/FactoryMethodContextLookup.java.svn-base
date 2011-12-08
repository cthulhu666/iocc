package com.gluszecki.iocc.lookup;

import java.lang.reflect.Field;

import com.gluszecki.iocc.FactoryMethod;
import com.gluszecki.iocc.annotation.In;
import com.gluszecki.iocc.bijection.NameResolverImpl;
import com.gluszecki.iocc.bijection.ScopeResolverImpl;
import com.gluszecki.iocc.component.Component;
import com.gluszecki.iocc.context.BasicScope;
import com.gluszecki.iocc.context.Context;
import com.gluszecki.iocc.context.Scope;

class FactoryMethodContextLookup extends AbstractContextLookup {
	
	private final FactoryMethod factoryMethod;
	
	public FactoryMethodContextLookup(FactoryMethod factoryMethod, In in, Field field, Component<?> component) {
		super(in, field, component);
		this.factoryMethod = factoryMethod;
	}

	@Override
	protected Object createInstance() {
		Object obj = factoryMethod.execute();
		return obj;
	}

	@Override
	protected Object lookupInContexts() {
		String name = in.name();
		Context context = getContextInstance();
		Object obj = context.get(name);
		return obj;
	}

	private Context getContextInstance() {
		Scope scope = new ScopeResolverImpl(in).getScope();
		if (scope == BasicScope.UNSPECIFIED) {
			scope = component.getScope();
		}
		Context context = scope.getContextInstance();
		return context;
	}

	@Override
	protected void putInContext(Object obj) {
		String name = new NameResolverImpl(in).getName();
		Context context = getContextInstance();
		context.set(name, obj);		
	}
}