package com.gluszecki.iocc.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ReflectionUtils {

	static <T> T findAnnotation(Annotation[] array, Class<T> annotationClazz) {
		for (Annotation a : array) {
			if (a.annotationType() == annotationClazz) {
				@SuppressWarnings("unchecked")
				T retVal = (T) a;
				return retVal;
			}
		}
		return null;
	}
	
	public static <T> List<T> getAnnotations(Constructor<?> constructor, Class<T> annotationClazz) {
		List<T> list = new ArrayList<T>();
		for (Annotation[] ann : constructor.getParameterAnnotations()) {
			list.add( findAnnotation(ann, annotationClazz) );
		}
		return list;
	}
	
	public static List<Class<?>> getInheritanceList(Class<?> clazz) {
		List<Class<?>> c = new ArrayList<Class<?>>();
		getParents(clazz, c);
		return c;
	}

	static void getParents(Class<?> clazz, List<Class<?>> parents) {
		parents.add(clazz);
		Class<?> parentClass = clazz.getSuperclass();
		if (parentClass != null) {
			getParents(parentClass, parents);
		}
	}
	
	public static List<Method> getMethods(Class<?> clazz) { // TODO inheritance
		Method[] methods = clazz.getMethods();
		return Arrays.asList(methods);
	}
	
	public static List<Method> getAnnotatedMethods(Class<?> clazz, Class<? extends Annotation> annotationClazz) {
		List<Method> annotatedMethods = new ArrayList<Method>();
		for (Method m : getMethods(clazz)) {
			if (m.getAnnotation(annotationClazz) != null) {
				annotatedMethods.add(m);
			}
		}
		return annotatedMethods;
	}

	private ReflectionUtils() {
		// bez instancji
	}

}
