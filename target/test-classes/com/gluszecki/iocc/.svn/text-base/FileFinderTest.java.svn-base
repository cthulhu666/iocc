/**
 * 
 */
package com.gluszecki.iocc;

import java.io.File;
import java.io.FileFilter;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author cthulhu
 * 
 */
public class FileFinderTest {

	@Test
	public void test() {
		FileFinder finder = new FileFinder();
		File[] files = finder.find(new File(
				"./target/test-classes/fileFinderTest"), null);
		Assert.assertEquals(files.length, 5);
	}

	@Test
	public void test2() {
		FileFinder finder = new FileFinder();
		FileFilter filter = new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.getName().equals("file1");
			}
		};
		File[] files = finder.find(new File(
				"./target/test-classes/fileFinderTest"), filter);
		Assert.assertEquals(files.length, 3);
	}

}
