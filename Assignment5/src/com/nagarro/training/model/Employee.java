package com.nagarro.training.model;

import java.util.Date;

public class Employee extends Customer {
	public Employee(Date memberSince, float totalPrice) {
		super(memberSince, totalPrice);
	}

	@Override
	public double calcDiscount() {
		return totalPrice * 0.30;
	}
}
