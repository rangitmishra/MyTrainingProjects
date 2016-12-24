package com.nagarro.training.model;

public interface Consumer {

	double calcDiscount();
	double calcTotalBill();
	boolean isOldEnoughMemberSince(int duration, int unit);

}
