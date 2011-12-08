package com.gluszecki.iocc;

import java.lang.reflect.Proxy;

import junit.framework.Assert;

import org.testng.annotations.Test;

import com.gluszecki.iocc.component.Component;
import com.gluszecki.iocc.component.Components;
import com.gluszecki.iocc.component.TwoStageInit;

public class ComponentProxyFactoryTest {

	@Test
	public void test() {
		Component<TestComponent1Impl> component = Components.instance()
				.newInstance(TestComponent1Impl.class);
		((TwoStageInit) component).firstStageInit();
		ComponentProxyFactory proxyFactory = new ComponentProxyFactory(
				component);
		TestComponent1 obj = proxyFactory.createProxy(new TestComponent1Impl());
		Assert.assertTrue(obj instanceof TestComponent1);
		Assert.assertTrue(obj instanceof Proxy);		
	}

	@Test
	public void testSubclassedComponent() {
		Component<TestComponent1SubclassImpl> component = Components.instance()
				.newInstance(TestComponent1SubclassImpl.class);
		((TwoStageInit) component).firstStageInit();
		ComponentProxyFactory proxyFactory = new ComponentProxyFactory(
				component);
		TestComponent1 obj = proxyFactory
				.createProxy(new TestComponent1SubclassImpl());
		Assert.assertTrue(obj instanceof TestComponent1);
		Assert.assertTrue(obj instanceof Proxy);
	}
}
