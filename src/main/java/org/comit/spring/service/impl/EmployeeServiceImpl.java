package org.comit.spring.service.impl;

import java.util.List;

import org.comit.spring.entity.Employee;
import org.comit.spring.repository.EmployeeRepo;
import org.comit.spring.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private final EmployeeRepo employeeRepo;

	public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}
	
	@Override
	public Employee findById(int id) {
		return employeeRepo.findById(id).orElseThrow(() -> new RuntimeException());
	}
	
	@Override
	public List<Employee> findAll() {
		return employeeRepo.findAll();
	}
	
	@Override
	public Employee save(Employee employee) {
		return employeeRepo.save(employee);
	}
	

	@Override
	@Transactional
	public Employee updateById(Employee employee, int id) {
		
		Employee foundedEmployee = findById(id);
		
		foundedEmployee.setFullName(employee.getFullName());
		foundedEmployee.setAdress(employee.getAdress());
		foundedEmployee.setCity(employee.getCity());
		foundedEmployee.setPostalCode(employee.getPostalCode());
		foundedEmployee.setCellPhone(employee.getCellPhone());
        return foundedEmployee;
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		
		Employee savedEmployee = findById(id);
		
		if(savedEmployee != null) {
			employeeRepo.deleteById(id);;
		}
	}

	@Override
	public List<Employee> findByKeyWord(String keyword) {
		
		return employeeRepo.findByKeyWord(keyword);
		
	}
}
