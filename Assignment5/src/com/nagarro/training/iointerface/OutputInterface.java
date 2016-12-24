package com.nagarro.training.iointerface;

import com.nagarro.training.model.Consumer;

public class OutputInterface {
	public void print(Consumer consumer) {
		System.out.println("--------------------Bill------------------");
		System.out.println("Total Discount received : " + consumer.calcDiscount());
		System.out.println("Total Amount to be paid : " + consumer.calcTotalBill());
	}

}
