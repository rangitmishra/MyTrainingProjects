package com.nagarro.FlightManagement.utility;

import java.util.Set;

import com.nagarro.FlightManagement.data.ApplicationContext;

import com.nagarro.FlightManagement.data.Flight;

public class DeleteFile {

	public boolean deleteFile(Set<Flight> set) {
		boolean isvalid = false;
		for (Flight f : set) {

			StringBuilder key = new StringBuilder(f.getDepLoc().toUpperCase());
			key.append("_");
			key.append(f.getArrLoc().toUpperCase());
			key.append("_");
			key.append(f.getClas().toUpperCase());

			isvalid = ApplicationContext.getHm().get(key.toString()).remove(f);

		}
		return isvalid;

	}

}
