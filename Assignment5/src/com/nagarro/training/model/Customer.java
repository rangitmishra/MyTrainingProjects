/**
 * 
 */
package com.nagarro.training.model;

import java.util.Calendar;
import java.util.Date;

/**
 * @author ranjeetmishra
 *
 */
public abstract class Customer implements Consumer {
	protected Date memberSince;
	protected float totalPrice = 0;
	
	@Override
	public double calcTotalBill() {
		return totalPrice - calcDiscount();
	}

	@Override
	public boolean isOldEnoughMemberSince(int duration, int unit) {
		Calendar oldDate = Calendar.getInstance();
		oldDate.setTime(memberSince);
		oldDate.add(unit, duration);
		if(oldDate.getTimeInMillis() <= System.currentTimeMillis())
		{
			return true;
		}
		else
			return false;
	}
	public Customer(Date memberSince, float totalPrice) {
		this.memberSince = memberSince;
		this.totalPrice = totalPrice;
	}

	public Date getMemberSince() {
		return memberSince;
	}

	public void setMemberSince(Date memberSince) {
		this.memberSince = memberSince;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
}
