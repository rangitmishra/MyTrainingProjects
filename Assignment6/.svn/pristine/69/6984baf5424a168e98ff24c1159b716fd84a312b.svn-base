package com.nagarro.training.model;

public class Trouser implements Garments{
	private double size = -1;
	private double price = -1;
	private String name;
	private String location = null;
	
	public Trouser() {
		name = "TROUSER";
	}
	
	public Trouser(double size, double price, String location) {
		super();
		this.size = size;
		this.price = price;
		this.location = location;
	}


	@Override
	public double getSize() {
		return size;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getLocation() {
		return location;
	}
	
	@Override
	public void setSize(double size) {
		this.size = size;
	}

	@Override
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public void print() {
		System.out.println("Name : "+ name);
		System.out.println("Location : "+ location);
		System.out.println("Price : "+ price);
		System.out.println("Size : "+ size);
	}
}
