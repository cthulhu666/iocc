/**
 * 
 */
package com.gluszecki.iocc;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author cthulhu
 * 
 */
public class ComponentInstanceFactoryTest {

	@Test
	public void test() {
		ComponentInstanceFactoryImpl<SampleComponentImpl> componentFactory = new ComponentInstanceFactoryImpl(
				SampleComponentImpl.class);
		Object obj = componentFactory.newInstance();
		Assert.assertNotNull(obj);
		Assert.assertTrue(obj instanceof SampleComponent);
	}
}
