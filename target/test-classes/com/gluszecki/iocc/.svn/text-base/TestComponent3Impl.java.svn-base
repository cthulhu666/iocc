/**
 * 
 */
package com.gluszecki.iocc;

import java.util.ArrayList;
import java.util.List;

import com.gluszecki.iocc.annotation.Component;
import com.gluszecki.iocc.annotation.Scope;
import com.gluszecki.iocc.context.BasicScope;

/**
 * @author cthulhu
 * 
 */
@Component(name = "testComponent3", scope = @Scope(value = BasicScope.GLOBAL))
public class TestComponent3Impl implements TestComponent3 {
	
	public List<Object> find(String arg) {
		List<Object> l = new ArrayList<Object>();
		l.add(arg);
		return l;		
	}

}
