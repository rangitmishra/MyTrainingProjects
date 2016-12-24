package com.nagarro.FlightManagement.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.nagarro.FlightManagement.data.ApplicationContext;

import com.nagarro.FlightManagement.data.Flight;

public class ReadFile {

	public void readFile(File file) throws FileNotFoundException {
		Set<Flight> flightSet = new HashSet<Flight>();

		try (BufferedReader bufferReader = new BufferedReader(new FileReader(file))) {
			FileValidator validateFile = new FileValidator();
			String line = bufferReader.readLine();
			Boolean isValid = false;
			line = bufferReader.readLine();
			while (line != null) {

				String[] string = line.split("\\|");
				if (string.length == 9) {

					StringBuffer key = new StringBuffer(string[1]);
					key.append("_");
					key.append(string[2]);
					key.append("_");
					key.append(string[8]);

					try {
						isValid = validateFile.validateFile(string);
					} catch (ParseException e1) {

						System.out.println("Trying to parse unparseable data");
					}
					if (isValid) {
						DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
						Date date = null;
						try {
							date = dateFormat.parse(string[3]);
						} catch (ParseException e) {
							System.out.println("Incorrect date");
							
						}
						float duration = Float.parseFloat(string[5]);
						float fare = Float.parseFloat(string[6]);
						Flight flight = new Flight(string[0], string[1], string[2], date, string[4], duration, fare,
								string[7], string[8]);

						flightSet.add(flight);

						if (ApplicationContext.getHm().keySet().contains(key.toString())) {
							ApplicationContext.getHm().get(key.toString()).add(flight);

						} else {
							Set<Flight> hset2 = new HashSet<Flight>();
							hset2.add(flight);
							ApplicationContext.getHm().put(key.toString(), hset2);
						}
					} else {
						throw new RuntimeException("There is some invalid data in file");
						
					}
				} else {
					continue;
				}

				line = bufferReader.readLine();
			}

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		
		} catch (IOException e1) {
			System.out.println("Trying to access inavailable data");
		}
		ApplicationContext.getStorageHashmap().put(file.getName(), flightSet);
	}

}
