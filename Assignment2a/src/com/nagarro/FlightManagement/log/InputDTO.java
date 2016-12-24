package com.nagarro.FlightManagement.log;

public class InputDTO {
	private String departure;
	private String arrival;
	private String date;
	private String classe;
	private String sortingChoice;
	 public void storeInput(String string) {
		 String[] storage=string.split(" ");
		 departure=storage[0];
		 arrival=storage[1];
		 date=storage[2];
		 classe=storage[3];
		 sortingChoice=storage[4];
	 }
	 

		public String getDeparture() {
			return departure;
		}

		public String getArrival() {
			return arrival;
		}

		public String getDate() {
			return date;
		}

		public String getClasse() {
			return classe;
		}

		public String getSortingChoice() {
			return sortingChoice;
		}


}
