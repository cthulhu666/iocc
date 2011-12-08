/**
 * 
 */
package com.gluszecki.iocc;

import org.testng.annotations.Test;

import com.gluszecki.iocc.component.Components;
import com.gluszecki.iocc.test.AbstractContainerTest;

/**
 * @author cthulhu
 * 
 */
public class ContainerTest extends AbstractContainerTest {

	@Test
	public void test1() {		
		TestComponent1 component1 = Components.instance().createInstance(TestComponent1Impl.class);
		component1.foo();
		component1.foo();
	}
}