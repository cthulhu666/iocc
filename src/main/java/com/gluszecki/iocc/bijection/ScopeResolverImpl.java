package com.gluszecki.iocc.bijection;

import org.apache.commons.lang.StringUtils;

import com.gluszecki.iocc.annotation.Component;
import com.gluszecki.iocc.annotation.In;
import com.gluszecki.iocc.annotation.Out;
import com.gluszecki.iocc.context.BasicScope;
import com.gluszecki.iocc.context.Scope;

public class ScopeResolverImpl implements ScopeResolver {

	private final com.gluszecki.iocc.annotation.Scope scopeAnnotation;

	public ScopeResolverImpl(Component component) {
		super();
		this.scopeAnnotation = component.scope();
	}
	
	public ScopeResolverImpl(In in) {
		super();
		this.scopeAnnotation = in.scope();
	}
	
	public ScopeResolverImpl(Out out) {
		super();
		this.scopeAnnotation = out.scope();
	}

	@Override
	public Scope getScope() {
		if (scopeAnnotation.value() != BasicScope.UNSPECIFIED) {
			return scopeAnnotation.value();
		}
		if (Object.class != scopeAnnotation.scopeClass()) {
			return getScope(scopeAnnotation.scopeClass());
		}
		if (StringUtils.isNotBlank(scopeAnnotation.scopeName())) {
			return getScope(scopeAnnotation.scopeName());
		}
		return BasicScope.UNSPECIFIED;
	}

	private Scope getScope(Class<?> scopeClass) {
		// TODO Auto-generated method stub
		return null;
	}

	private Scope getScope(String scopeName) {
		// TODO Auto-generated method stub
		return null;
	}
}