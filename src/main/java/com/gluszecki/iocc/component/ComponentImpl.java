/**
 * 
 */
package com.gluszecki.iocc.component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.gluszecki.iocc.ComponentInstanceFactory;
import com.gluszecki.iocc.ComponentInstanceFactoryImpl;
import com.gluszecki.iocc.ComponentProxyFactory;
import com.gluszecki.iocc.ConstructorInjectionComponentInstanceFactoryImpl;
import com.gluszecki.iocc.FactoryMethod;
import com.gluszecki.iocc.FactoryMethodImpl;
import com.gluszecki.iocc.ProxyFactory;
import com.gluszecki.iocc.annotation.Create;
import com.gluszecki.iocc.annotation.Factory;
import com.gluszecki.iocc.annotation.In;
import com.gluszecki.iocc.annotation.Out;
import com.gluszecki.iocc.bijection.DirectFieldAccessPropertySetter;
import com.gluszecki.iocc.bijection.NameResolverImpl;
import com.gluszecki.iocc.bijection.PropertySetter;
import com.gluszecki.iocc.bijection.ScopeResolverImpl;
import com.gluszecki.iocc.bijection.handler.InjectionHandler;
import com.gluszecki.iocc.bijection.handler.InjectionHandlerImpl;
import com.gluszecki.iocc.bijection.handler.OutjectionHandler;
import com.gluszecki.iocc.context.BasicScope;
import com.gluszecki.iocc.context.Scope;
import com.gluszecki.iocc.lookup.ContextLookup;
import com.gluszecki.iocc.lookup.ContextLookupFactory;
import com.gluszecki.iocc.utils.ReflectionUtils;

/**
 * @author cthulhu
 * 
 */
final class ComponentImpl<T> implements Component<T>, TwoStageInit {

	private final Class<T> clazz;
	
	private final String name;
	
	private Method createMethod;

	private Method destroyMethod;

	private List<InjectionHandler> injectionHandlers;

	private ComponentInstanceFactory<T> instanceFactory;

	private Class<?>[] interfaces;

	private List<OutjectionHandler> outjectionHandlers;
	
	private List<FactoryMethod> factoryMethods;

	/**
	 * Konstruktor tylko dla testów jednostkowych.
	 * 
	 * @param clazz
	 */
	ComponentImpl(Class<T> clazz) {
		com.gluszecki.iocc.annotation.Component componentAnnotation = clazz.getAnnotation(com.gluszecki.iocc.annotation.Component.class);
		if (componentAnnotation == null) {
			throw new IllegalArgumentException("Class: " + clazz + " doesn't have @Component annotation");
		}
		this.clazz = clazz;
		this.name = new NameResolverImpl(clazz).getName();
	}

	List<InjectionHandler> createInjectionHandlers() {
		List<InjectionHandler> injectionHandlers = new ArrayList<InjectionHandler>();
		for (Field field : getFields(clazz)) {
			In in = field.getAnnotation(In.class);
			if (in != null) {
				InjectionHandler injectionHandler = createFieldInjectionHandler(field, in);
				injectionHandlers.add(injectionHandler);
			}
		}
		return injectionHandlers;
	}

	private InjectionHandler createFieldInjectionHandler(Field field, In in) {
		PropertySetter propertySetter = new DirectFieldAccessPropertySetter(field);
		ContextLookup contextLookup = ContextLookupFactory.instance().getInstance(this, field, in);
		return new InjectionHandlerImpl(propertySetter, contextLookup);
	}

	List<OutjectionHandler> createOutjectionHandlers() {
		List<OutjectionHandler> outjectionHandlers = new ArrayList<OutjectionHandler>();
		for (Field field : getFields(clazz)) {
			Out outAnnotation = field.getAnnotation(Out.class);
			if (outAnnotation != null) {
				OutjectionHandler outjectionHandler = createFieldOutjectionHandler(field);
				outjectionHandlers.add(outjectionHandler);
			}
		}
		for (Method method : getMethods(clazz)) {
			Out outAnnotation = method.getAnnotation(Out.class);
			if (outAnnotation != null) {
				OutjectionHandler outjectionHandler = createMethodOutjectionHandler(method);
				outjectionHandlers.add(outjectionHandler);
			}
		}
		return outjectionHandlers;
	}

	private OutjectionHandler createMethodOutjectionHandler(Method method) {
		// TODO Auto-generated method stub
		return null;
	}

	private OutjectionHandler createFieldOutjectionHandler(Field field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void disinject(T target) {
		for (InjectionHandler injectionHandler : injectionHandlers) {
			injectionHandler.disinject(target);
		}

	}

	private ComponentInstanceFactory<T> getFactory() {
		return instanceFactory;
	}

	/**
	 * Zwraca listę wszystkich niestatycznych pól danej klasy.
	 * 
	 * @param clazz
	 * @return
	 */
	List<Field> getFields(Class<T> clazz) {
		List<Field> fields = new ArrayList<Field>();
		for (Class<?> c : ReflectionUtils.getInheritanceList(clazz)) {
			for (Field f : c.getDeclaredFields()) {
				if (!Modifier.isStatic(f.getModifiers())) {
					fields.add(f);
				}
			}
		}
		return fields;
	}

	@Override
	public Class<?>[] getInterfaces() {
		return interfaces;
	}

	Method[] getMethods(Class<T> clazz) {
		Method[] methods = clazz.getMethods();
		return methods;
	}

	ProxyFactory getProxyFactory() {
		return new ComponentProxyFactory(this);
	}

//	void init() {
//		this.injectionHandlers = Collections.unmodifiableList(createInjectionHandlers());
//		this.outjectionHandlers = Collections.unmodifiableList(createOutjectionHandlers());
//		this.interfaces = initInterfaces();
//		this.createMethod = initCreateMethod();
//		this.destroyMethod = null; // TODO
//		this.instanceFactory = initInstanceFactory();
//		this.factoryMethods = createFactoryMethods();
//	}

	private List<FactoryMethod> createFactoryMethods() {
		List<FactoryMethod> factoryMethods = new ArrayList<FactoryMethod>();
		for (Method m : ReflectionUtils.getAnnotatedMethods(clazz, Factory.class)) {
			FactoryMethod fm = FactoryMethodImpl.getInstance(clazz, this, m);
			factoryMethods.add(fm);			
		}
		return factoryMethods;
	}

	Method initCreateMethod() {
		List<Method> l = ReflectionUtils.getAnnotatedMethods(clazz,
				Create.class);
		if (l.size() > 1) {
			throw new IllegalStateException(
					"Component can have only one @Create method");
		} else if (l.size() == 1) {
			return l.get(0);
		}

		return null;
	}

	private ComponentInstanceFactory<T> initInstanceFactory() {
		com.gluszecki.iocc.annotation.Component componentAnnotation = clazz
				.getAnnotation(com.gluszecki.iocc.annotation.Component.class);
		if (componentAnnotation == null) {
			throw new RuntimeException("No @Component annotation for class " +  clazz);
		}
		if (componentAnnotation.dynamic()) {
			return new ComponentInstanceFactoryImpl<T>(clazz);
		}
		return new ConstructorInjectionComponentInstanceFactoryImpl<T>(clazz);
	}

	private Class<?>[] initInterfaces() {
		Set<Class<?>> interfaces = new LinkedHashSet<Class<?>>();
		for (Class<?> c : ReflectionUtils.getInheritanceList(clazz)) {
			interfaces.addAll(Arrays.asList(c.getInterfaces()));
		}
		return interfaces.toArray(new Class[interfaces.size()]);
	}

	@Override
	public void inject(T target) {
		for (InjectionHandler injectionHandler : injectionHandlers) {
			injectionHandler.inject(target);
		}
		// TODO factory methods
	}

	void invokeCreateMethod(Object instance) {
		// TODO
	}

	private boolean isCreate() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public T newInstance() {
		ComponentInstanceFactory<T> factory = getFactory();
		T instance;
		instance = (T) factory.newInstance();
		invokeCreateMethod(instance);
		Object obj = getProxyFactory().createProxy(instance);
		return (T) obj;
	}

//	@Override
//	public T newInstanceIfNecessary() {
//		return isCreate() ? newInstance() : null;
//	}

	@Override
	public Scope getScope() {
		com.gluszecki.iocc.annotation.Component component = clazz
				.getAnnotation(com.gluszecki.iocc.annotation.Component.class);
		Scope scope = new ScopeResolverImpl(component).getScope();
		if (scope == BasicScope.UNSPECIFIED) {
			scope = BasicScope.STATELESS;
		}
		return scope;
	}

	@Override
	public void outject(T target) {
		for (OutjectionHandler outjectionHandler : outjectionHandlers) {
			outjectionHandler.outject(target);
		}
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append(clazz.getSimpleName()).toString();
	}
	
	@Override
	public void firstStageInit() {
		this.interfaces = initInterfaces();
		this.instanceFactory = initInstanceFactory();
		this.createMethod = initCreateMethod();		
		this.factoryMethods = createFactoryMethods();		
	}
	
	@Override
	public void secondStageInit() {
		this.injectionHandlers = Collections.unmodifiableList(createInjectionHandlers());
		this.outjectionHandlers = Collections.unmodifiableList(createOutjectionHandlers());
	}
}