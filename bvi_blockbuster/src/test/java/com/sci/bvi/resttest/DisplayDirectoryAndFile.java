package com.sci.bvi.resttest;

import java.io.File;

public class DisplayDirectoryAndFile{

	public static void main (String args[]) {

		displayIt(new File("D:\\Users\\KARNA\\git\\bb\\src\\main\\webapp\\app"));
	}

	public static void displayIt(File node){
		if(node.getName().contains("html")){
		System.out.println(node.getAbsoluteFile());
		}
		if(node.isDirectory()){
			String[] subNote = node.list();
			for(String filename : subNote){
				displayIt(new File(node, filename));
			}
		}

	}
}