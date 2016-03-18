package com.boodman.mvntest.io.test;

import java.io.File;
import java.io.IOException;

public class CreateFile {
  
	public static void main(String[] args) {
		String fileName = "m1/m2/persist.xml";
		  
		File file = new File(fileName);
		System.out.println(file);
/*		file.mkdirs();
		System.out.println(file.getParentFile());*/

		System.out.println(file.getParentFile().mkdirs());
		try {
			System.out.println(file.createNewFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(file.getPath());
		System.out.println(file.getParentFile());
		
	
	}
}
