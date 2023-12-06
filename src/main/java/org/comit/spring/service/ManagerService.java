package org.comit.spring.service;

import org.comit.spring.entity.Manager;

public interface ManagerService extends GenericService<Manager> {

	Manager addEmployeeToManager(int managerId, int employeeId);
}
