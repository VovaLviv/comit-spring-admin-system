package org.comit.spring.service;

import java.util.List;

import org.comit.spring.entity.Vehicle;

public interface VehicleService extends GenericService<Vehicle> {

	String checkForInspection(int id);
	
	List<Vehicle> findByKeyWord(String keyword);
}
