package com.gluszecki.iocc;

import java.io.File;
import java.util.List;

import junit.framework.Assert;

import org.testng.annotations.Test;

public class UrlClassLoaderScannerTest {

	private static final String SEPARATOR = System
			.getProperty("file.separator");

	@Test
	public void test2() {
		UrlClassLoaderScanner scanner = new UrlClassLoaderScanner();
		File f = new File("./target/test-classes");
		List<String> fileNames = scanner.scanDirectory(f);
		Assert.assertTrue(fileNames.contains("com" + SEPARATOR + "gluszecki"
				+ SEPARATOR + "iocc" + SEPARATOR + "TestComponent1.class"));
	}

	@Test
	public void test() {
		ClassLoader classLoader = getClass().getClassLoader();
		UrlClassLoaderScanner scanner = new UrlClassLoaderScanner();
		ClassHandle[] classHandles = scanner.findClassFiles(classLoader);

	}

}
