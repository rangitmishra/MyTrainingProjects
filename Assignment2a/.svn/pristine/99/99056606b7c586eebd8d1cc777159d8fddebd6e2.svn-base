package com.nagarro.FlightManagement.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class InputValidator {
	public boolean validateInput(String string) throws ParseException {
		String[] storage = string.split(" ");

		boolean isValid = false;
		if (storage.length == 5) {

			if ((!Pattern.matches("[A-Za-z]+", storage[2]))) {
				Date currDate = new Date(System.currentTimeMillis());

				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				Date date1 = sdf.parse(storage[2]);
				if (date1.after(currDate)) {
					isValid = true;
				}

			} else {
				isValid = false;
			}
		} else {
			isValid = false;
		}
		return isValid;
	}
}
