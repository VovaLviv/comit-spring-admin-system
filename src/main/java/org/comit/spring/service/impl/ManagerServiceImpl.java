package org.comit.spring.service.impl;

import java.util.List;

import org.comit.spring.entity.Employee;
import org.comit.spring.entity.Manager;
import org.comit.spring.repository.ManagerRepo;
import org.comit.spring.service.EmployeeService;
import org.comit.spring.service.ManagerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManagerServiceImpl implements ManagerService {
	
	private final ManagerRepo managerRepo;
	private final EmployeeService employeeService;

	public ManagerServiceImpl(ManagerRepo managerRepo, EmployeeService employeeService) {
		this.managerRepo = managerRepo;
		this.employeeService = employeeService;
	}

	@Override
	public Manager findById(int id) {
		return managerRepo.findById(id).orElseThrow(() -> new RuntimeException());
	}

	@Override
	public List<Manager> findAll() {
		return managerRepo.findAll();
	}

	@Override
	public Manager save(Manager manager) {
        return managerRepo.save(manager);
	}

	@Override
	@Transactional
	public Manager updateById(Manager manager, int id) {
		
		Manager foundedManager = findById(id);
		foundedManager.setRole(manager.getRole());
		foundedManager.setSalary(manager.getSalary());
		
		return foundedManager;
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		
        Manager foundedManager = findById(id);
		
		if(foundedManager != null) {
			managerRepo.deleteById(id);;
		}
		
	}

	@Override
	@Transactional
	public Manager addEmployeeToManager(int managerId, int employeeId) {
		
		Manager foundedManager = findById(managerId);
		Employee foundedEmployee = employeeService.findById(employeeId);
		
		foundedManager.setEmployee(foundedEmployee);
		
		return save(foundedManager);
	}

}
