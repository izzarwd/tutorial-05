package com.apap.tu05.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tu05.model.FlightModel;
import com.apap.tu05.repository.FlightDb;

/**
 * @author ASUS
 *
 */
@Service
@Transactional
public class FlightServiceImpl implements FlightService{
	@Autowired
	private FlightDb flightDb;
	
	@Override
	public void addFlight(FlightModel flight) {
		flightDb.save(flight);
	}
	
	@Override
	public void deleteFlightById(long id) {
		flightDb.deleteById(id);
	}
	
	@Override
	public FlightModel getFlightDetailByflightNumber(String flightNumber) {
		return flightDb.findByFlightNumber(flightNumber);
	}
	
	@Override
	public List <FlightModel> listAll() {
        return flightDb.findAll();
    }
}
