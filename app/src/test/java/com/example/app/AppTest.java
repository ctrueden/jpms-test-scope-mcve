package com.example.app;

import com.example.lib.Loader;

import org.junit.Test;

public class AppTest {

	@Test
	public void AppLoadTest() throws ClassNotFoundException {
		Loader.loadApp();
	}
}
