/**
 * 
 */
package com.gluszecki.iocc.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.gluszecki.iocc.context.Context;

/**
 * @author cthulhu
 * 
 */
@Target( { ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RUNTIME)
public @interface In {

	Class<?> clazz() default Object.class;
	
	String clazzName() default "";

	boolean create() default false;

	String name() default "";	
		
	// String namespace() default Context.DEFAULT_NAMESPACE;

	Scope scope() default @Scope();

}
