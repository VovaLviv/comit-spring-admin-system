package org.comit.spring.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Couriers")
public class Courier {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "courier_id")
	private int courierId;
	
	@Column(nullable = false)
	private String role;
	
	@Column(nullable = false)
	private Double salary;
	
	@Column(name = "parcels_delivered")
	private Integer parcelsDelivered;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
	private Employee employee;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "vehicle_id", referencedColumnName = "vehicle_id")
	private Vehicle vehicle;
	
	public Courier() {
		
	}

	public Courier(String role, double salary) {
		this.role = role;
		this.salary = salary;
	}

	public int getCourierId() {
		return courierId;
	}

	public void setCourierId(int courierId) {
		this.courierId = courierId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	
	public int getParcelsDelivered() {
		return parcelsDelivered;
	}

	public void setParcelsDelivered(int parcelsDelivered) {
		this.parcelsDelivered = parcelsDelivered;
	}

	public int AddParcels(int numberOfParcels) {
		return this.parcelsDelivered += numberOfParcels;
	}
	
	public double calculateBonus(int parcelsDelivered) {
		
		double bonus = 0;
		
		if (parcelsDelivered >= 15000 && parcelsDelivered < 17000) {
			bonus = 3000;
		} else if (parcelsDelivered > 17000 && parcelsDelivered < 20000 ) {
			bonus = 4000;
		}  else if (parcelsDelivered > 20000) {
			bonus = 5000;
		} 
		
		return bonus;
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
}

enum CourierRole {
	COURIER, HELPER
}
