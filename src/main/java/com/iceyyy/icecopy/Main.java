package com.iceyyy.icecopy;

/**
 * Hello world!
 *
 */
public class Main {
	public static void main(String[] args) {
		String oldFolder = "E:\\abc";
		String newFolder = "E:\\abc_";
		Service.copy(oldFolder, newFolder);
	}
}
