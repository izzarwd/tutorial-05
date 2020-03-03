package com.apap.tu05.service;

import com.apap.tu05.model.PilotModel;

/**
 * PilotService
 */
public interface PilotService {
	PilotModel getPilotDetailByLicenseNumber(String licenseNumber);
	void addPilot(PilotModel pilot);
	void deletePilot(String licenseNumber);
}
