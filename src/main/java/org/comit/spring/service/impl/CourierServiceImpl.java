package org.comit.spring.service.impl;

import java.util.List;

import org.comit.spring.entity.Courier;
import org.comit.spring.entity.Employee;
import org.comit.spring.entity.Vehicle;
import org.comit.spring.repository.CourierRepo;
import org.comit.spring.service.CourierService;
import org.comit.spring.service.EmployeeService;
import org.comit.spring.service.VehicleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CourierServiceImpl implements CourierService {

	private final CourierRepo courierRepo;
	private final EmployeeService employeeService;
	private final VehicleService vehicleService;

	public CourierServiceImpl(CourierRepo courierRepo, EmployeeService employeeService,
			                  VehicleService vehicleService) {
		this.courierRepo = courierRepo;
		this.employeeService = employeeService;
		this.vehicleService = vehicleService;
	}
	
	public Courier findById(int courierId) {
		return courierRepo.findById(courierId).orElseThrow(() -> new RuntimeException());
		
	}
	
	public List<Courier> findAll() {
		return courierRepo.findAll();
	}
	
	
	public Courier save(Courier courier) {
		return courierRepo.save(courier);
	}

	@Override
	@Transactional
	public Courier updateById(Courier courier, int id) {
		
		Courier foundedCourier = findById(id);
		
		foundedCourier.setRole(courier.getRole());
		foundedCourier.setSalary(courier.getSalary());
		foundedCourier.setParcelsDelivered(courier.getParcelsDelivered());
		
		return foundedCourier;
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		
        Courier foundedCourier = findById(id);
		
		if(foundedCourier != null) {
			courierRepo.deleteById(id);
		}
	}

	@Override
	@Transactional
	public Courier addParcels(int courierId, int numberOfParcels) {
		
		Courier foundedCourier = findById(courierId);
		
		foundedCourier.AddParcels(numberOfParcels);
		
		return save(foundedCourier);
	}

	@Override
	@Transactional
	public double showBonus(int courierId) {
		
		Courier foundedCourier = findById(courierId);
		
		double bonus = foundedCourier.calculateBonus(foundedCourier.getParcelsDelivered());
		
		return bonus;
	}
	
	@Override
	@Transactional
	public Courier addEmployeeToCourier(int courierId, int employeeId) {
		
		Courier foundedCourier = findById(courierId);
		Employee foundedEmployee = employeeService.findById(employeeId);
		
		foundedCourier.setEmployee(foundedEmployee);
		
		return save(foundedCourier);
		
	}

	@Override
	@Transactional
	public Courier addVehicleToCourier(int courierId, int vehicleId) {
		
		Courier foundedCourier = findById(courierId);
		Vehicle foundedVehicle = vehicleService.findById(vehicleId);
		
		foundedCourier.setVehicle(foundedVehicle);
		
		return save(foundedCourier);

	}

}
