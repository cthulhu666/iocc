package com.gluszecki.iocc.context;

import java.util.Set;

import junit.framework.Assert;

import org.testng.annotations.Test;

public class GlobalContextTest {
	
//	@Test
//	public void testGetKeys() {
//		GlobalContext context = GlobalContext.getInstance();
//		context.set("xxx", "k1", "v1");
//		context.set("xxx", "k2", "v2");
//		context.set("k3", "v3");
//		Set<String> keys = context.getKeys("xxx");
//		Assert.assertTrue(keys.contains("k1"));
//		Assert.assertTrue(keys.contains("k2"));
//		Assert.assertFalse(keys.contains("k3"));
//	}
//	
//	@Test
//	public void testGetKeys2() {
//		GlobalContext context = GlobalContext.getInstance();
//		context.set("", "k1", "v1");	
//		Set<String> keys = context.getKeys("");
//		Assert.assertTrue(keys.contains("k1"));
//	}
	
	@Test
	public void testGetKeysDefaultNamespace() {
		GlobalContext context = GlobalContext.getInstance();
		context.set("k1", "v1");
		Set<String> keys = context.getKeys();
		Assert.assertTrue(keys.contains("k1"));
	}

}
