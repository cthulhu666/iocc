package com.gluszecki.iocc.bijection;

import org.apache.commons.lang.StringUtils;

import com.gluszecki.iocc.annotation.In;

public class NameResolverImpl implements NameResolver {
	
	private final String name;
	
	public NameResolverImpl(In in) {
		this.name = getName(in);
	}
	
	public NameResolverImpl(Class clazz) {
		this.name = clazz.getName();
	}
	
	@Override
	public String getName() {
		return name;
	}

	private String getName(In in) {
		if (StringUtils.isNotBlank(in.name())) {
			return in.name();
		}
		if (in.clazz() != Object.class) {
			return in.clazz().getName();
		}
		return null;
	}

}
