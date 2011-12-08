package com.gluszecki.iocc.component;

import java.lang.reflect.Field;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.gluszecki.iocc.TestComponent1;
import com.gluszecki.iocc.TestComponent1Impl;
import com.gluszecki.iocc.TestComponent1SubclassImpl;
import com.gluszecki.iocc.bijection.handler.InjectionHandler;
import com.gluszecki.iocc.component.Component;
import com.gluszecki.iocc.component.ComponentImpl;
import com.gluszecki.iocc.component.Components;

public class ComponentImplTest {

	@Test
	public void testNewInstance() {
		Component<TestComponent1Impl> component = Components.instance().newInstance(TestComponent1Impl.class);
		((TwoStageInit) component).firstStageInit();
		TestComponent1 tc1 = component.newInstance();
		Assert.assertNotNull(tc1);
	}
	
	@Test
	public void testGetFields() throws Exception {
		ComponentImpl<TestComponent1SubclassImpl> component = new ComponentImpl<TestComponent1SubclassImpl>(TestComponent1SubclassImpl.class);
		List<Field> fields = component.getFields(TestComponent1SubclassImpl.class);
		Assert.assertEquals(2, fields.size());
		Field f1 = TestComponent1Impl.class.getDeclaredField("testComponent2");
		Field f2 = TestComponent1SubclassImpl.class.getDeclaredField("intField");
		Assert.assertTrue(fields.contains(f1));
		Assert.assertTrue(fields.contains(f2));
	}
	
	@Test
	public void testCreateInjectionHandlers() {
		ComponentImpl<TestComponent1Impl> component = new ComponentImpl<TestComponent1Impl>(TestComponent1Impl.class);
		List<InjectionHandler> ih = component.createInjectionHandlers();
		Assert.assertEquals(1, ih.size());
	}
	
	@Test
	public void testCreateInjectionHandlersForSubclassedComponent() {
		ComponentImpl<TestComponent1SubclassImpl> component = new ComponentImpl<TestComponent1SubclassImpl>(TestComponent1SubclassImpl.class);
		List<InjectionHandler> ih = component.createInjectionHandlers();
		Assert.assertEquals(2, ih.size());
	}
}