package com.nagarro.FlightManagement.log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.nagarro.FlightManagement.data.ApplicationContext;

import com.nagarro.FlightManagement.data.Flight;
import com.nagarro.FlightManagement.utility.FlightDurationComparator;
import com.nagarro.FlightManagement.utility.FlightFareComparator;

public class ShowOutput {
	public void showOutput(InputDTO input) {
		StringBuilder stringBuilder;
		List<Flight> flightList = new ArrayList<Flight>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		float incrementer=(float) 1.4;

		StringBuilder key = new StringBuilder(input.getDeparture().toUpperCase());
		key.append("_");
		key.append(input.getArrival().toUpperCase());
		key.append("_");
		key.append(input.getClasse().toUpperCase());

		stringBuilder = new StringBuilder("FLIGHT_NO");
		stringBuilder.append("      ");
		stringBuilder.append("DEPARTURE_LOC");
		stringBuilder.append("      ");
		stringBuilder.append("ARRIVAL_LOC");
		stringBuilder.append("      ");
		stringBuilder.append("VALID_TILL");
		stringBuilder.append("      ");
		stringBuilder.append("FLIGHT_TIME");
		stringBuilder.append("      ");
		stringBuilder.append("FLIGHT_DURATION");
		stringBuilder.append("      ");
		stringBuilder.append("FARE");
		stringBuilder.append("      ");
		stringBuilder.append("SEAT");
		stringBuilder.append("      ");
		stringBuilder.append("CLASS");
		
		System.out.println(stringBuilder);
		if (ApplicationContext.getHm().keySet().contains(key.toString())) {

			for (Flight flight : ApplicationContext.getHm().get(key.toString())) {

				Date date2 = null;
				try {

					date2 = dateFormat.parse(input.getDate());
				} catch (ParseException e) {
					System.out.println("Please enter correct date");
				}
				if ((date2.before(flight.getValidTill())) && (input.getClasse().equalsIgnoreCase("EB"))) {
					float increasedFare = (float) (incrementer * flight.getFare());
					flight.setFare(increasedFare);
					flightList.add(flight);

				} else if ((date2.before(flight.getValidTill())) && (input.getClasse().equalsIgnoreCase("E"))) {
					flightList.add(flight);
				} else {
					System.out.println("Flight detail is not matching");
				}
			}

		}

		else {
			System.out.println("There is no such details");
		}

		/**
		 * displaying sorted data
		 */
		if (input.getSortingChoice().equalsIgnoreCase("fare")) {
			Collections.sort(flightList, new FlightFareComparator());
		} else {
			Collections.sort(flightList, new FlightDurationComparator());
		}
		for (int i = 0; i < flightList.size(); i++) {
			Flight fli = flightList.get(i);
			stringBuilder = new StringBuilder(fli.getFlightNo());
			stringBuilder.append("             ");
			stringBuilder.append(fli.getDepLoc());
			stringBuilder.append("               ");
			stringBuilder.append(fli.getArrLoc());
			stringBuilder.append("            ");
			stringBuilder.append(dateFormat.format(fli.getValidTill()));
			stringBuilder.append("         ");
			stringBuilder.append(fli.getFlightTime());
			stringBuilder.append("               ");
			stringBuilder.append(fli.getFlightDuration());
			stringBuilder.append("            ");
			stringBuilder.append(fli.getFare());
			stringBuilder.append("         ");
			stringBuilder.append(fli.getSeatAvailability());
			stringBuilder.append("         ");
			stringBuilder.append(fli.getClas());
			System.out.println(stringBuilder);

		}
	}
}
