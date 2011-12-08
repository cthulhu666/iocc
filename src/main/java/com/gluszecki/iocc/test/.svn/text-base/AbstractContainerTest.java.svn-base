/**
 * 
 */
package com.gluszecki.iocc.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.gluszecki.iocc.Container;
import com.gluszecki.iocc.ContainerImpl;

/**
 * @author cthulhu
 * 
 */
public class AbstractContainerTest {

	private Container container;

	@BeforeClass
	public void startContainer() {
		container = new ContainerImpl();
		container.start();
	}

	@AfterClass
	public void stopContainer() {
		container.stop();
	}

}
