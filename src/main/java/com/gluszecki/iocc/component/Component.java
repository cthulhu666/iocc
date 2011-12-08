package com.gluszecki.iocc.component;

import com.gluszecki.iocc.context.Scope;

public interface Component<T> {

	void disinject(T target);

	Class<?>[] getInterfaces();
	
	void inject(T target);
	
	T newInstance();
	
	//T newInstanceIfNecessary();

	void outject(T target);
	
	Scope getScope();
	
	
		
}