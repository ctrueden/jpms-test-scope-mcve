
package com.example.lib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Enumeration;

public class Loader {

	public static void load() throws IOException {
		System.out.println("Class path:");
		final String classPath = System.getProperty("java.class.path");
		if (classPath.isEmpty()) {
			System.out.println("<NOTHING>");
		}
		else {
			for (final String element : classPath.split(":", -1)) {
				System.out.println("- " + element);
			}
		}
		final ClassLoader cl = ClassLoader.getSystemClassLoader();
		System.out.println("Class loader = " + cl);
		final Enumeration<URL> pluginEntries = cl.getResources("META-INF/stuff/plugins");
		int count = 0;
		while (pluginEntries.hasMoreElements()) {
			final URL pluginEntry = pluginEntries.nextElement();
			System.out.println("[" + pluginEntry + "]");
			try (BufferedReader r = new BufferedReader(new InputStreamReader( pluginEntry.openStream()))) {
				while (true) {
					final String line = r.readLine();
					if (line == null) break;
					System.out.println(line);
				}
			}
			count++;
		}
		System.out.println("Done processing " + count + " plugin entry files");
	}
	
	public static void loadApp() throws ClassNotFoundException {
		final ClassLoader cl = ClassLoader.getSystemClassLoader();
		cl.loadClass("com.example.app.App");
	}
}
