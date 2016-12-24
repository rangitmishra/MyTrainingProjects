package com.nagarro.spring.dao;

import java.util.List;

import com.nagarro.spring.model.Flight;
import com.nagarro.spring.model.SearchingDetails;

public interface FlightDao {
	public void save(Flight  flight);
	
	public List<Flight> search(SearchingDetails search);
	

}
