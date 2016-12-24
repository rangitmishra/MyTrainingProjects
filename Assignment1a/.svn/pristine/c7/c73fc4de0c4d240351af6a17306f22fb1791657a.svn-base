package com.nagarro.inventorManagement.data;

public class ImportedItem extends Item {
	public ImportedItem(String name, float price,int quantity,String type) {
		this.name=name;
		this.price=price;
		this.quantity=quantity;
		this.type=type;
		
	}

	@Override

	public void calculateTax() {
		float rate=(float) 0.125;

		this.tax=(float) ((rate)*(price)*(quantity));
	
		this.totalcost=(float) (tax + (price)*(quantity));
		
		
	}

}
