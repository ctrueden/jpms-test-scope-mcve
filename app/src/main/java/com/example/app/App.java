package com.example.app;

import com.example.lib.Loader;

import java.io.IOException;

public class App {
	
	public static void main(String[] args) throws IOException {
		System.out.println("Invoking plugin loader...");
		Loader.load();
		System.out.println("Plugin loading complete!");
	}
}