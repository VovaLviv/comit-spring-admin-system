package org.comit.spring.repository;

import java.util.List;

import org.comit.spring.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	@Query("FROM Employee e where e.fullName like %:keyword%")
	public List<Employee> findByKeyWord(@Param("keyword") String keyword);
}
