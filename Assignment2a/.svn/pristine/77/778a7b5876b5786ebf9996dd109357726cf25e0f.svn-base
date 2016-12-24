package com.nagarro.FlightManagement.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

import com.nagarro.FlightManagement.data.ApplicationContext;


public class CheckDirectory implements Runnable {
	public void run() {

		HashMap<String, Long> hashmap = new HashMap<String, Long>();
		File folder = new File(ConstantData.getPath());

		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			if (file.isFile()) {

				hashmap.put(file.getName(), file.lastModified());

			}
		}

		/**
		 * Addition of new file
		 */
		checkAddition(hashmap);

		/**
		 * Deletion of new file
		 */
		boolean isNotDeleted = checkDeletion(hashmap);

		/**
		 * modification in file
		 */
		checkModification(hashmap, isNotDeleted);

		ApplicationContext.getHashmap().clear();

		for (String f : hashmap.keySet()) {
			ApplicationContext.getHashmap().put(f, hashmap.get(f));
		}
		hashmap.clear();

	}
	
	public void checkAddition(HashMap<String, Long> hashmap) {
		for (String f1 : hashmap.keySet()) {

			if (!ApplicationContext.getHashmap().keySet().contains(f1)) {
				File fi = new File(ConstantData.getPath() + "/" + f1);
				ApplicationContext.getHashmap().put(f1, fi.lastModified());
				ReadFile readFile = new ReadFile();
				try {
					readFile.readFile(fi);
				} catch (FileNotFoundException e) {
					System.out.println("File not found");
				}
			}
		}
	}
	public boolean checkDeletion(HashMap<String, Long> hashmap) {
		boolean isValid = true;
		for (String f1 : ApplicationContext.getHashmap().keySet()) {

			if (!hashmap.keySet().contains(f1)) {

				DeleteFile deleteFile = new DeleteFile();

				boolean isvalid = deleteFile.deleteFile(ApplicationContext.getStorageHashmap().get(f1));
				if (isvalid) {
					System.out.println("Deleted successfully");
				}
				ApplicationContext.getStorageHashmap().remove(f1);
				isValid = false;
			}

		}
		return isValid;
	}
	public void checkModification(HashMap<String, Long> hashmap, boolean isNotDeleted) {
		if ((!hashmap.equals(ApplicationContext.getHashmap())) && (isNotDeleted)) {
			for (String f1 : ApplicationContext.getHashmap().keySet()) {
				if (!ApplicationContext.getHashmap().get(f1).equals(hashmap.get(f1))) {
					DeleteFile deleteFile = new DeleteFile();

					boolean isvalid = deleteFile.deleteFile(ApplicationContext.getStorageHashmap().get(f1));
					if (isvalid) {
						System.out.println("modification in progress");
					}
					ApplicationContext.getStorageHashmap().remove(f1);
					File fi = new File(ConstantData.getPath() + "/" + f1);
					ApplicationContext.getHashmap().put(f1, fi.lastModified());
					ReadFile readFile = new ReadFile();
					try {
						readFile.readFile(fi);
					} catch (FileNotFoundException e) {
						System.out.println("File not found exception");
					}

				}

			}
		}
	}
}
