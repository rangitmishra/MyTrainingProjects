package com.nagarro.inventorManagement.data;



public class RawItem extends Item {
	public RawItem(String name, float price,int quantity,String type) {
		this.name=name;
		this.price=price;
		this.quantity=quantity;
		this.type=type;
		
	}


	public void calculateTax() {
		float rate=(float) 0.125;

		this.tax=(float) ((rate)*(price)*(quantity));
		
		this.totalcost=(float) (tax + (price)*(quantity));
		
		
	}

}
