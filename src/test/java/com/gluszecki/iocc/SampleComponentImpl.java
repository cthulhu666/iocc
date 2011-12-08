/**
 * 
 */
package com.gluszecki.iocc;

import com.gluszecki.iocc.annotation.Component;
import com.gluszecki.iocc.annotation.In;
import com.gluszecki.iocc.annotation.Scope;

/**
 * @author user
 * 
 */
@Component
public class SampleComponentImpl implements SampleComponent {

	@In(clazz = SampleServiceImpl.class, create = true, scope=@Scope)
	private SampleService service;

	public SampleService getService() {
		return service;
	}

	public void setService(SampleService service) {
		this.service = service;
	}

	public void foo(String str) {
		System.out.println(service);
	}
}
