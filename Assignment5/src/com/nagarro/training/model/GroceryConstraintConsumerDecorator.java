package com.nagarro.training.model;

public class GroceryConstraintConsumerDecorator extends ConsumerDecorator{
	private double groceryTotal;
	
	public GroceryConstraintConsumerDecorator(Consumer consumer, double groceryTotal) {
		super(consumer);
		this.groceryTotal = groceryTotal;
	}

	@Override
	public double calcDiscount() {
		int multipleOf100 = (int) ((groceryTotal + super.calcTotalBill())/100); 
		return super.calcDiscount() + multipleOf100*5;
	}

	@Override
	public double calcTotalBill() {
		return groceryTotal + super.calcTotalBill() - calcDiscount();
	}
	
}
