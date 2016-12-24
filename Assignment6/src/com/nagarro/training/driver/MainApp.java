package com.nagarro.training.driver;

import java.util.Scanner;

import com.nagarro.training.model.Garments;
import com.nagarro.training.model.GarmentsFactory;

public class MainApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Selection");
		String selection = sc.nextLine();
		GarmentsFactory factory = new GarmentsFactory();
		Garments garments = factory.getGarments(selection);
		if (garments !=null) {
			garments.print();
		}
		else 
			System.out.println("Your selection didnt matched");
		
		sc.close();
	}
}
