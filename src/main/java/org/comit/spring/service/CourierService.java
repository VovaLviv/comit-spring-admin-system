package org.comit.spring.service;

import org.comit.spring.entity.Courier;

public interface CourierService extends GenericService<Courier> {
	
	Courier addParcels(int id, int numberOfParcels);
	
	double showBonus(int id);
	
	Courier addEmployeeToCourier(int courierId, int employeeId);
	
	Courier addVehicleToCourier(int courierId, int vehicleId);

}
