package com.nagarro.training.model;

public class GarmentsFactory {
	public Garments getGarments(String garments) {
		switch (garments.toLowerCase()) {
		case "": return null;
		case "jacket" : return new Jacket();
		case "kurti" : return new Kurti();
		case "shirt" : return new Shirt();
		case "trouser" : return new Trouser();
		}
		return null;
	}
}
