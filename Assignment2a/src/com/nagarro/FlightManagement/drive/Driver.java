package com.nagarro.FlightManagement.drive;

//import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.nagarro.FlightManagement.data.ApplicationContext;
import com.nagarro.FlightManagement.log.InputDTO;
import com.nagarro.FlightManagement.log.ShowOutput;
import com.nagarro.FlightManagement.log.TakeInput;
import com.nagarro.FlightManagement.utility.CheckDirectory;
import com.nagarro.FlightManagement.utility.InputValidator;


public class Driver {

	public static void main(String[] args) {

		String choice = "n";
		TakeInput takeInput = new TakeInput();
		InputDTO InputStorage = new InputDTO();
		InputValidator validator = new InputValidator();
		ShowOutput output = new ShowOutput();
		ApplicationContext database = new ApplicationContext();

		database.createDatabase();

		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

		service.scheduleAtFixedRate(new CheckDirectory(), 0, 3, TimeUnit.SECONDS);

		try (Scanner scanner = new Scanner(System.in)) {

			do {

				String string = takeInput.takeInput(scanner);

				boolean isValid = validator.validateInput(string);
				if (isValid) {
					InputStorage.storeInput(string);
					output.showOutput(InputStorage);
				} else {
					System.out.println("Please enter correct input");
				}
				System.out.println("Do u want to search more(y\\n)");
				choice = scanner.nextLine();
			} while (choice.equalsIgnoreCase("y"));

		} catch (Exception e) {
			System.out.println("There is some error in message");
		}
		service.shutdown();

	}

}
