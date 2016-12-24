package com.nagarro.training.driver;

import java.text.ParseException;

import com.nagarro.training.iointerface.InputInterface;
import com.nagarro.training.iointerface.OutputInterface;

public class MainApp {

	public static void main(String[] args) throws ParseException {
		InputInterface input = new InputInterface();
		input.takeInputs();
		OutputInterface output = new OutputInterface();
		output.print(input.getConsumerWithExtraDiscountConstraint());
	}
}
