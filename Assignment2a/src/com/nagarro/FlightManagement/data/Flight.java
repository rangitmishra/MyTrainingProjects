package com.nagarro.FlightManagement.data;

import java.util.Date;

public class Flight {
	private String flightNo;
	private String depLoc;
	private String arrLoc;
	private Date validTill;
	private String flightTime;
	private float flightDuration;
	private float fare;
	private String seatAvailability;
	private String clas;

	public Flight(String flightNo, String depLoc, String arrLoc, Date validTill, String flightTime,
			float flightDuration, float fare, String seatAvailability, String clas) {
		this.flightNo = flightNo;
		this.depLoc = depLoc;
		this.arrLoc = arrLoc;
		this.validTill = validTill;
		this.flightTime = flightTime;
		this.flightDuration = flightDuration;
		this.fare = fare;
		this.seatAvailability = seatAvailability;
		this.clas = clas;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getDepLoc() {
		return depLoc;
	}

	public void setDepLoc(String depLoc) {
		this.depLoc = depLoc;
	}

	public String getArrLoc() {
		return arrLoc;
	}

	public void setArrLoc(String arrLoc) {
		this.arrLoc = arrLoc;
	}

	public Date getValidTill() {
		return validTill;
	}

	public void setValidTill(Date validTill) {
		this.validTill = validTill;
	}

	public String getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}

	public float getFlightDuration() {
		return flightDuration;
	}

	public void setFlightDuration(float flightDuration) {
		this.flightDuration = flightDuration;
	}

	public float getFare() {
		return fare;
	}

	public void setFare(float fare) {
		this.fare = fare;
	}

	public String getSeatAvailability() {
		return seatAvailability;
	}

	public void setSeatAvailability(String seatAvailability) {
		this.seatAvailability = seatAvailability;
	}

	public String getClas() {
		return clas;
	}

	public void setClas(String clas) {
		this.clas = clas;
	}

}
