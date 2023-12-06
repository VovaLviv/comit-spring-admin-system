package org.comit.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employees")
public class Employee {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Integer employeeId;
	
	@Column(name = "full_name", nullable = false)
	private String fullName;
	
	@Column(nullable = false)
	private String adress;
	
	@Column(nullable = false)
	private String city;
	
	@Column(name = "postal_code", nullable = false)
	private String postalCode;
	
	@Column(name = "cell_phone", nullable = false)
	private String cellPhone;
	
	@OneToOne(mappedBy = "employee")
	private Courier courier;
	
	@OneToOne(mappedBy = "employee")
	private Manager manager;
	
	@OneToOne(mappedBy = "employee")
	private StockWorker stockWorker;
	
	public Employee() {
		
	}

	public Employee(String fullName, String adress, String city, String postalCode, String cellPhone) {
		this.fullName = fullName;
		this.adress = adress;
		this.city = city;
		this.postalCode = postalCode;
		this.cellPhone = cellPhone;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	
	
}
