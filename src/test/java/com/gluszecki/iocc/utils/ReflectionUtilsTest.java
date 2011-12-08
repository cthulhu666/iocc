package com.gluszecki.iocc.utils;

import java.lang.reflect.Constructor;
import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.testng.annotations.Test;

import com.gluszecki.iocc.TestComponent1;
import com.gluszecki.iocc.TestComponent2;
import com.gluszecki.iocc.TestComponent4Impl;
import com.gluszecki.iocc.annotation.In;

public class ReflectionUtilsTest {

	@Test
	public void testGetInheritanceList() {
		List<Class<?>> l = ReflectionUtils.getInheritanceList(ArrayList.class);
		Assert.assertEquals(4, l.size());
		Assert.assertEquals(ArrayList.class, l.get(0));
		Assert.assertEquals(AbstractList.class, l.get(1));
		Assert.assertEquals(AbstractCollection.class, l.get(2));
		Assert.assertEquals(Object.class, l.get(3));
	}

	@Test
	public void testGetConstructorParametersAnnotations() throws Exception {
		Constructor<?> constructor = TestComponent4Impl.class
				.getDeclaredConstructor(TestComponent1.class,
						TestComponent2.class);
		List<In> inAnnotations = ReflectionUtils.getAnnotations(constructor,
				In.class);
		System.out.println( inAnnotations );
	}
	
	@Test
	public void testGetConstructorParametersAnnotations2() throws Exception {
		Constructor<?> constructor = TestComponent4Impl.class
				.getDeclaredConstructor(Boolean.class, Integer.class, String.class);
		List<In> inAnnotations = ReflectionUtils.getAnnotations(constructor,
				In.class);
		Assert.assertEquals(3, inAnnotations.size());
		Assert.assertNull(inAnnotations.get(0));
		Assert.assertNotNull(inAnnotations.get(1));
		Assert.assertNull(inAnnotations.get(2));
	}

}
