/**
 * 
 */
package com.gluszecki.iocc;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import org.apache.log4j.Logger;

/**
 * @author cthulhu
 * 
 */
public class UrlClassLoaderScanner implements ClassLoaderScanner {

	private FileFinder fileFinder = new FileFinder();

	private Logger logger = Logger.getLogger(getClass());

	@Override
	public ClassHandle[] findClassFiles(ClassLoader classLoader) {
		if (!(classLoader instanceof URLClassLoader)) {
			throw new IllegalArgumentException(); // TODO
		}

		URL[] urls = ((URLClassLoader) classLoader).getURLs();
		List<String> fileNames = new ArrayList<String>();

		for (URL url : urls) {
			String pathname = null;
			try {
				pathname = URLDecoder.decode(url.getFile(), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File file = new File(pathname);
			fileNames.addAll(handleFile(file));
		}

		List<ClassHandle> classHandles = new ArrayList<ClassHandle>();
		for (String fileName : fileNames) {
			classHandles.add(new ClassHandle(fileName));
		}
		return classHandles.toArray(new ClassHandle[classHandles.size()]);
	}

	List<String> handleFile(File file) {
		if (file.isDirectory()) {
			return scanDirectory(file);
		} else {
			return scanJar(file);			
		}
	}

	void handleZipEntry(ZipEntry entry, List<String> fileNames) {
		if (entry.isDirectory()) {
			return;
		}
		String name = entry.getName();
		if (name.endsWith(".class")) {
			fileNames.add(name);
		}
	}

	List<String> scanDirectory(File dir) {
		logger.debug("scanning directory:" + dir);
		File[] files = fileFinder.find(dir, new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".class");
			}
		});
		if (logger.isDebugEnabled()) {
			logger.debug(Arrays.toString(files));
		}
		List<String> fileNames = new ArrayList<String>();
		for (File f : files) {
			String fileName = f.getPath().substring(dir.getPath().length() + 1);
			fileNames.add(fileName);
		}
		return fileNames;
	}

	List<String> scanJar(File file) {
		logger.debug("scanning archive:" + file);
		List<String> fileNames = new ArrayList<String>();
		try {
			ZipFile zipFile = new ZipFile(file);
			if (zipFile.getEntry("iocc.properties") == null) {
				logger.debug("iocc.properties not found, ignoring " + file);
				return fileNames;
			}
			Enumeration<? extends ZipEntry> e = zipFile.entries();
			while (e.hasMoreElements()) {
				ZipEntry entry = e.nextElement();				
				handleZipEntry(entry, fileNames);
			}
		} catch (ZipException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileNames;
	}
}
