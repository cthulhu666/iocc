/**
 * 
 */
package com.gluszecki.iocc.bijection.handler;

import java.lang.reflect.Field;

import junit.framework.Assert;

import org.testng.annotations.Test;

import com.gluszecki.iocc.TestComponent1Impl;
import com.gluszecki.iocc.TestComponent2Impl;
import com.gluszecki.iocc.bijection.DirectFieldAccessPropertySetter;
import com.gluszecki.iocc.lookup.ContextLookup;

/**
 * @author cthulhu
 * 
 */
public class InjectionHandlerImplTest {

	@Test
	public void testFieldInjectDisinject() throws Exception {
		Field field = TestComponent1Impl.class.getDeclaredField("testComponent2");
		ContextLookup contextLookup = new ContextLookup() {

			@Override
			public Object lookup() {
				return new TestComponent2Impl();
			}
		};
		InjectionHandler handler = new InjectionHandlerImpl(new DirectFieldAccessPropertySetter(field), contextLookup);
		TestComponent1Impl target = new TestComponent1Impl();
		handler.inject(target);
		Assert.assertNotNull(target.getTestComponent2());
		handler.disinject(target);
		Assert.assertNull(target.getTestComponent2());
	}
}
