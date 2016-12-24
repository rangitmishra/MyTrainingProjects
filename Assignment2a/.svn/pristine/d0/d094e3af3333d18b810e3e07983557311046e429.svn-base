package com.nagarro.FlightManagement.data;

import java.io.File;
import java.io.FileNotFoundException;
//import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import com.nagarro.FlightManagement.utility.ConstantData;
import com.nagarro.FlightManagement.utility.ReadFile;

public class ApplicationContext {
	private static HashMap<String, Set<Flight>> keyHashMap = new HashMap<String, Set<Flight>>();
	private static HashMap<String, Set<Flight>> fileHashMap = new HashMap<String, Set<Flight>>();
	private static HashMap<String, Long> modificationTimeHashMap = new HashMap<String, Long>();

	public void createDatabase(){

		File folder = new File(ConstantData.getPath());
		ReadFile readFile = new ReadFile();

		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {

			modificationTimeHashMap.put(file.getName(), file.lastModified());
			try {
				readFile.readFile(file);
			} catch (FileNotFoundException e) {
			    
				System.out.println("File is not available");
			}

		}

	}

	public static HashMap<String, Set<Flight>> getHm() {
		return keyHashMap;
	}

	public static HashMap<String, Set<Flight>> getStorageHashmap() {
		return fileHashMap;
	}

	public static HashMap<String, Long> getHashmap() {
		return modificationTimeHashMap;
	}

}
