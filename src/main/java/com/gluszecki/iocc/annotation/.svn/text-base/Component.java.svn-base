/**
 * 
 */
package com.gluszecki.iocc.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @author cthulhu
 *
 */
@Target(ElementType.TYPE)
@Retention(RUNTIME)
public @interface Component {
	
	boolean dynamic() default true;

	String name() default "";
	
	// String namespace() default Context.DEFAULT_NAMESPACE;
	
	Scope scope() default @Scope();

}
