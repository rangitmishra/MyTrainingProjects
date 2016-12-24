package com.nagarro.spring.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;


@Entity
public class Flight {
   
	@Id
	private int id;
	
	@NotEmpty
	private String flightNo;
	
	@NotEmpty
	@Size(min = 3, max = 3)
	private String depLoc;
	
	@NotEmpty
	@Size(min = 3, max = 3)
	private String arrLoc;

    @NotNull 
	private Date validTill;
	
	@NotEmpty
	private String flightTime;
	
	 @Range(min = (long) 0.1, max = (long) 20.0)
	private float flightDuration;
	
	 @Range(min = (long) 1000.0, max = (long) 50000.0)
	private float fare;
	
	@NotEmpty
	private String seatAvailability;
	
	@NotEmpty
	private String clas;

	public Flight() {

	}

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
