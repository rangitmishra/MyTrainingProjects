package com.nagarro.FlightManagement.utility;

import java.util.Comparator;

import com.nagarro.FlightManagement.data.Flight;

public class FlightDurationComparator implements Comparator<Object> {
	public int compare(Object flight, Object anotherFlight) {
		Float duration1 = ((Flight) flight).getFlightDuration();
		Float duration2 = ((Flight) anotherFlight).getFlightDuration();

		return duration1.compareTo(duration2);

	}

}
