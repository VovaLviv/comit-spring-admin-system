package org.comit.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Vehicles")
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vehicle_id")
    private Integer vehicleId;
	
	@Column(name = "plate_number", nullable = false)
	private String plateNumber;
	
	@Column(nullable = false)
	private String model;
	
	@Column(nullable = false)
	private Integer year;
	
	@Column(nullable = false)
	private String district;
	
	@Column(nullable = false)
	private Integer kilometers;
	
	@Column(name = "last_inspection")
	private Integer lastInspection;
	
	@OneToOne(mappedBy = "vehicle")
	private OrderDetail orderDetail;
	
	public Vehicle() {
		
	}

	public Vehicle(String plateNumber, String model, Integer year, String district, Integer kilometers,
			Integer lastInspection) {
		this.plateNumber = plateNumber;
		this.model = model;
		this.year = year;
		this.district = district;
		this.kilometers = kilometers;
		this.lastInspection = lastInspection;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Integer getKilometers() {
		return kilometers;
	}

	public void setKilometers(int kilometers) {
		this.kilometers = kilometers;
	}

	public Integer getLastInspection() {
		return lastInspection;
	}

	public void setLastInspection(int lastInspection) {
		this.lastInspection = lastInspection;
	}
	
	public String checkForInspection() {
		
		if(kilometers - lastInspection >= 15000) {
			return "Inspection for this vehicle is required";
		} else 
		return "Inspection for this vehicle is not required";
	}
}
