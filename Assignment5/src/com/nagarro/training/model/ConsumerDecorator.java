package com.nagarro.training.model;

public class ConsumerDecorator implements Consumer {
	protected Consumer consumer;
	
	public ConsumerDecorator(Consumer consumer) {
		this.consumer = consumer;
	}

	@Override
	public double calcDiscount() {
		return consumer.calcDiscount();
	}

	@Override
	public double calcTotalBill() {
		return consumer.calcTotalBill();
	}

	@Override
	public boolean isOldEnoughMemberSince(int duration, int unit) {
		return consumer.isOldEnoughMemberSince(duration, unit);
	}
}
