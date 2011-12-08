/**
 * 
 */
package com.gluszecki.iocc;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * @author cthulhu
 * 
 */
public class FileFinder {
	
	private final Logger logger = Logger.getLogger(getClass());

	public File[] find(File dir, FileFilter filter) {
		if (!dir.exists()) {
			throw new IllegalArgumentException(dir + " doesn't exist");
		}
		if (!dir.isDirectory()) {
			throw new IllegalArgumentException(dir + " is not a directory");
		}

		List<File> found = new ArrayList<File>();

		recurse(dir, found, filter);
		return found.toArray(new File[found.size()]);
	}

	void recurse(File file, List<File> found, FileFilter filter) {
		if (!file.isDirectory()) {
			if (filter == null || filter.accept(file)) {
				logger.debug(file);
				found.add(file);
			}
		} else {
			File[] files = file.listFiles();
			for (File f : files) {
				recurse(f, found, filter);
			}
		}
	}

}
