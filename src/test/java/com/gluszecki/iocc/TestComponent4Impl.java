package com.gluszecki.iocc;

import com.gluszecki.iocc.annotation.Component;
import com.gluszecki.iocc.annotation.Constructor;
import com.gluszecki.iocc.annotation.In;

@Component
public class TestComponent4Impl implements TestComponent4 {

	private final TestComponent1 tc1;

	private final TestComponent2 tc2;

	@Constructor
	TestComponent4Impl(@In TestComponent1 tc1, @In TestComponent2 tc2) {
		super();
		this.tc1 = tc1;
		this.tc2 = tc2;
	}
	
	TestComponent4Impl(Boolean foo, @In Integer integer, String bar) {
		super();
		this.tc1 = null;
		this.tc2 = null;
	}

	@Override
	public boolean foo() {
		// TODO Auto-generated method stub
		return false;
	}

}
