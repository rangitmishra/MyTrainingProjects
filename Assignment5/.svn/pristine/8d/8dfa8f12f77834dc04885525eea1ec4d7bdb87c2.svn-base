package com.nagarro.training.iointerface;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.nagarro.training.model.AffiliateCustomer;
import com.nagarro.training.model.Consumer;
import com.nagarro.training.model.ConsumerDecorator;
import com.nagarro.training.model.Employee;
import com.nagarro.training.model.GroceryConstraintConsumerDecorator;
import com.nagarro.training.model.SimpleCustomer;

public class InputInterface {

	private Consumer consumer = null;
	private ConsumerDecorator consumerWithExtraDiscountConstraint = null;


	private Scanner sc;

	public InputInterface() {
		sc = new Scanner(System.in);
	}
	
	public void takeInputs() {
		boolean valid = false;
		Date memberSince = null;
		float totalPrice = 0;
		float totalGroceryPrice = 0;
		do{
			System.out.println("Since how long are you member with us ?(dd-MM-yyyy)");
			try {
				memberSince = new SimpleDateFormat("dd-MM-yyyy").parse(sc.nextLine());
				valid = true;
			} catch (ParseException e) {
				valid = false;
				System.out.println("Date Parsing error");
			}
		} while (!valid);
		
		do {
			System.out.println("Total price of non-grocery items");
			try {
				totalPrice = Float.parseFloat(sc.nextLine());
				if(totalPrice < 0) {
					throw new NumberFormatException();
				}
				valid = true;
			} catch (NumberFormatException e) {
				valid = false;
				System.out.println("Price Parsing error, enter correct value");
			}
		} while(!valid);
		
		do {
			System.out.println("Enter the type of customer - normal|employee|affliate");
			String type = sc.nextLine().toLowerCase();
			switch (type) {
				case "normal" :
					consumer = new SimpleCustomer(memberSince, totalPrice);
					valid = true;
					break;
				case "employee" :
					consumer = new Employee(memberSince, totalPrice);
					valid = true;
					break;
				case "affliate" :
					consumer = new AffiliateCustomer(memberSince, totalPrice);
					valid = true;
					break;
				default :
					valid = false;
					System.out.println("invalid type");
			}
		} while(!valid);
		
		do {
			System.out.println("Enter total amount of grocery items");
			try {
				totalGroceryPrice = Float.parseFloat(sc.nextLine());
				if(totalGroceryPrice < 0) {
					throw new NumberFormatException();
				}
				valid = true;
			} catch (NumberFormatException e) {
				valid = false;
				System.out.println("Price Parsing error, enter correct value");
			}
		} while (!valid);
		consumerWithExtraDiscountConstraint = new GroceryConstraintConsumerDecorator(consumer,totalGroceryPrice);
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		sc.close();
	}

	public Consumer getConsumer() {
		return consumer;
	}
	
	public ConsumerDecorator getConsumerWithExtraDiscountConstraint() {
		return consumerWithExtraDiscountConstraint;
	}
}
