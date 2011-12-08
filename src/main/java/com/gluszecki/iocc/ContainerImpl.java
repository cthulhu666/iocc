/**
 * 
 */
package com.gluszecki.iocc;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.gluszecki.iocc.component.Component;
import com.gluszecki.iocc.component.TwoStageInit;

/**
 * @author cthulhu
 * 
 */
public class ContainerImpl implements Container {

	private Logger logger = Logger.getLogger(getClass());

	private ClassLoader getClassLoader() {
		return getClass().getClassLoader();
	}

	private ClassLoaderScanner getClassLoaderScanner() {
		return new UrlClassLoaderScanner();
	}

	@Override
	public void start() {
		ClassLoaderScanner classLoaderScanner = getClassLoaderScanner();
		ClassHandle[] classHandles = classLoaderScanner
				.findClassFiles(getClassLoader());
		List<Component<?>> components = new ArrayList<Component<?>>();
		for (ClassHandle classHandle : classHandles) {
			Component<?> component = classHandle.createComponent();
			if (component != null) {
				logger.info("found component: " + component);
				components.add(component);
			}
		}
		firstStageInit(components);
		secondStageInit(components);
	}

	void firstStageInit(List<Component<?>> components) {
		logger.info("entering first stage init");
		for (Component<?> component : components) {
			((TwoStageInit) component).firstStageInit();
		}
	}

	void secondStageInit(List<Component<?>> components) {
		logger.info("entering second stage init");
		for (Component<?> component : components) {
			((TwoStageInit) component).secondStageInit();
		}
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}
}