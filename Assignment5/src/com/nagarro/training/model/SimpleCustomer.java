package com.nagarro.training.model;

import java.util.Calendar;
import java.util.Date;

public class SimpleCustomer extends Customer{
	public SimpleCustomer(Date memberSince, float totalPrice) {
		super(memberSince, totalPrice);
	}

	@Override
	public double calcDiscount() {
		if(isOldEnoughMemberSince(2,Calendar.YEAR)) {
			return totalPrice * 0.05;
		}
		return 0;
		
	}
}
