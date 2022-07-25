package com.simplilearn.project3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Iterator;


public class readWriteAppendFile {
	

	public static void createFileUsingNIO() throws IOException
	{
		
		Path path=Paths.get("D:\\files\\testFileNIO.txt");
		//write data using file class
		String input="Welcome  to NIO";
		byte array[]=input.getBytes();
		
		Files.write(path, array, StandardOpenOption.CREATE,StandardOpenOption.APPEND);
		System.out.println("Data Written Successfully");
		
		
		//if you want to write data of list to  files directly
		Path path1=Paths.get("D:\\files\\testFileNIO1.txt");
		//write data  using Files class
		
		List<String> list=Arrays.asList("This  is my first line","This is my secondLine");
		Files.write(path1, list, StandardOpenOption.CREATE,StandardOpenOption.APPEND);
		System.out.println("Lines Written Successfully");
		
	}
	
	
	public static void main1(String[] args) {
		try {
			 //createFileUsingFileClass();
			 //createFileUsingOutputStream();
			 createFileUsingNIO();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/////////////////////////////////////// READ THE FILE ////////////////////////////////////////////
	
	public static void readDataUsingNIO()  throws IOException
	{
		List<String> list=Collections.emptyList();
		Path path=  Paths.get("D:\\files\\testFileNIO1.txt");
		list= Files.readAllLines(path,StandardCharsets.UTF_8);
		
		Iterator<String> it= list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	public static void main(String[] args) {
		
		
		try {
			readDataUsingNIO();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("File not available");
		}
	}


}
