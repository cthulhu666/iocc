/**
 * 
 */
package com.gluszecki.iocc;

import java.util.List;

import com.gluszecki.iocc.annotation.Component;
import com.gluszecki.iocc.annotation.In;
import com.gluszecki.iocc.annotation.Scope;
import com.gluszecki.iocc.context.BasicScope;

/**
 * @author cthulhu
 * 
 */
@Component(name = "testComponent2", scope = @Scope(BasicScope.STATELESS))
public class TestComponent2Impl implements TestComponent2 {

	@In(clazz = TestComponent3Impl.class)
	private TestComponent3 testComponent3;

	@Override
	public void bar() {
		List<Object> l = testComponent3.find("xxx");
		System.out.println("BAR: this=" + this + "; testComponent3=" + testComponent3);
	}
}
