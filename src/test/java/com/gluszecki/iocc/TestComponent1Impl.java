/**
 * 
 */
package com.gluszecki.iocc;

import org.apache.log4j.Logger;

import com.gluszecki.iocc.annotation.Component;
import com.gluszecki.iocc.annotation.Create;
import com.gluszecki.iocc.annotation.In;
import com.gluszecki.iocc.annotation.Scope;
import com.gluszecki.iocc.context.BasicScope;

/**
 * @author cthulhu
 * 
 */
@Component(name = "testComponent1", scope = @Scope(BasicScope.STATELESS))
public class TestComponent1Impl implements TestComponent1 {

	@In(clazz = TestComponent2Impl.class)
	private TestComponent2 testComponent2;

	private static final Logger logger = Logger.getLogger(TestComponent1Impl.class);

	public TestComponent2 getTestComponent2() {
		return testComponent2;
	}

	public void setTestComponent2(TestComponent2 testComponent2) {
		this.testComponent2 = testComponent2;
	}

	@Override
	public void foo() {
		logger.debug("this=" + this + "; testComponent2=" + testComponent2);
		testComponent2.bar();
	}

	@Create
	public void create() {
		System.out.println("-=-CrEaTe-=-");
	}
}
