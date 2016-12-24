package com.nagarro.FlightManagement.utility;

import java.util.Comparator;

import com.nagarro.FlightManagement.data.Flight;

public class FlightFareComparator implements Comparator<Object> {
	public int compare(Object flight, Object anotherFlight) {
		Float fare1 = ((Flight) flight).getFare();
		Float fare2 = ((Flight) anotherFlight).getFare();

		return fare1.compareTo(fare2);

	}

}
