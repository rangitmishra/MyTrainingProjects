package com.nagarro.FlightManagement.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class FileValidator {
	public boolean validateFile(String[] string) throws ParseException {
		boolean isValid = false;
		int counter = 0;
		if (!Pattern.matches("[a-zA-Z]+", string[5])) {
			counter++;
		}
		if (!Pattern.matches("[a-zA-Z]+", string[6])) {
			counter++;
		}

		if ((!Pattern.matches("[A-Za-z]+", string[3]))) {
			Date currDate = new Date(System.currentTimeMillis());

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Date date1 = sdf.parse(string[3]);
			if (date1.after(currDate)) {
				counter++;
			}

		}
		if (counter == 3) {
			isValid = true;
		}

		return isValid;

	}

}
