package org.comit.spring.service.impl;

import java.util.List;

import org.comit.spring.entity.Vehicle;
import org.comit.spring.repository.VehicleRepo;
import org.comit.spring.service.VehicleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VehicleServiceImpl implements VehicleService {
	
	private final VehicleRepo vehicleRepo;
	
	public VehicleServiceImpl(VehicleRepo vehicleRepo) {
		this.vehicleRepo = vehicleRepo;
	}

	@Override
	public Vehicle findById(int id) {
		return vehicleRepo.findById(id).orElseThrow(() -> new RuntimeException());
	}

	@Override
	public List<Vehicle> findAll() {
		return vehicleRepo.findAll();
	}

	@Override
	public Vehicle save(Vehicle vehicle) {
		return vehicleRepo.save(vehicle);
	}

	@Override
	@Transactional
	public Vehicle updateById(Vehicle vehicle, int id) {
		
		Vehicle foundedVehicle = findById(id);
		
		foundedVehicle.setPlateNumber(vehicle.getPlateNumber());
		foundedVehicle.setModel(vehicle.getModel());
		foundedVehicle.setYear(vehicle.getYear());
		foundedVehicle.setKilometers(vehicle.getKilometers());
		foundedVehicle.setDistrict(vehicle.getDistrict());
		foundedVehicle.setLastInspection(vehicle.getLastInspection());
		
		return foundedVehicle;
	}

	@Override
	@Transactional
	public void deleteById(int id) {
	
        Vehicle foundedVehicle = findById(id);
		
		if(foundedVehicle != null) {
			vehicleRepo.deleteById(id);;
		}
	}

	@Override
	public String checkForInspection(int id) {
		
		Vehicle vehicle = findById(id);
		
		return vehicle.checkForInspection();
	}

	@Override
	public List<Vehicle> findByKeyWord(String keyword) {
		
		return vehicleRepo.findByKeyWord(keyword);
	}

}
