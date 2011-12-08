/**
 * 
 */
package com.gluszecki.iocc.factory;

import org.testng.annotations.Test;

import com.gluszecki.iocc.component.Components;
import com.gluszecki.iocc.test.AbstractContainerTest;

/**
 * @author cthulhu
 *
 */
public class FactoryMethodTest extends AbstractContainerTest {
	
	@Test
	public void testFactoryMethod() {
		SampleDao dao = Components.instance().createInstance(SampleDaoImpl.class);
		dao.doSomething();
	}

}
