package com.nagarro.inventorManagement.data;



abstract public class Item {
	protected String name;
	protected float price;
	protected int quantity;
	protected String type;

	protected float tax;
	protected float totalcost;
	public String getIname() {
		return name;
	}
	public void setIname(String iname) {
	    this.name = iname;
	}
	public float getIprice() {
		return price;
	}
	public void setIprice(float iprice) {
		price = iprice;
	}
	public int getIquantity() {
		return quantity;
	}
	public void setIquantity(int iquantity) {
		quantity = iquantity;
	}
	public String getItype() {
		return type;
	}
	public void setItype(String itype) {
		type = itype;
	}

	public float getTax() {
		return tax;
	}
	public void setTax(float tax) {
		this.tax = tax;
	}
	public float getTcost() {
		return totalcost;
	}
	public void setTcost(float tcost) {
		totalcost = tcost;
	}

   public abstract void calculateTax() ;
   
   
	   
   

}
