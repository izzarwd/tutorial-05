package com.apap.tu05.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.tu05.model.FlightModel;

/**
 * FlightDb
 */
@Repository
public interface FlightDb extends JpaRepository<FlightModel, Long>{
	void deleteByFlightNumber(String flightNumber);
	FlightModel findByFlightNumber(String flightNumber);
}
