package org.comit.spring.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "StockWorkers")
public class StockWorker {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stock_worker_id")
	private int stockWorkerId;
	
	@Column(nullable = false)
	private String role;
	
	@Column(nullable = false)
	private double salary;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
	private Employee employee;
	
	public StockWorker() {
		
	}
	
	public StockWorker(String role, double salary) {
		this.role = role;
		this.salary = salary;
	}

	public int getStockWorkerId() {
		return stockWorkerId;
	}

	public void setStockWorkerId(int stockWorkerId) {
		this.stockWorkerId = stockWorkerId;
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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	
}
