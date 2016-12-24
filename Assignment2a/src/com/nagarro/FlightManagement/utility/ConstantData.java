package com.nagarro.FlightManagement.utility;

public class ConstantData {

	static {
		path = "csv/";
	}

	private static final String path;

	private ConstantData() {
	};

	public static String getPath() {
		return path;
	}

}
