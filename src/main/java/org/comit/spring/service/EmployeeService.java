package org.comit.spring.service;

import java.util.List;

import org.comit.spring.entity.Employee;

public interface EmployeeService extends GenericService<Employee> {

	List<Employee> findByKeyWord(String keyword);
}
