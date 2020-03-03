package com.apap.tu05.service;

import java.util.List;

import com.apap.tu05.model.FlightModel;

/**
 * FlightService
 */
public interface FlightService {
	void addFlight(FlightModel flight);
	void deleteFlightById(long id);
	FlightModel getFlightDetailByflightNumber(String flightNumber);
	List <FlightModel> listAll();
}
