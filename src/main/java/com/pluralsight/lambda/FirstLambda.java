package com.pluralsight.lambda;

import java.io.File;
import java.io.FileFilter;

public class FirstLambda {

	public static void main(String[] args) {
		FileFilter filter = new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".txt");
			}
		};
		
		FileFilter filterLambda = (File pathname) -> pathname.getName().endsWith(".txt");
		
		File dir = new File("D:\\tmp_file");
		//File[] files = dir.listFiles(filter); // using anonymous class instance
		File[] files = dir.listFiles(filterLambda); // using lambda instance
		
		for (File f: files) {
			System.out.println(f);
		}
	}
}
