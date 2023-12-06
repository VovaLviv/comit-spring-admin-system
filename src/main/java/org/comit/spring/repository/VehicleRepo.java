package org.comit.spring.repository;

import java.util.List;

import org.comit.spring.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VehicleRepo extends JpaRepository<Vehicle, Integer> {

	@Query("FROM Vehicle v where v.plateNumber like %:keyword%")
	public List<Vehicle> findByKeyWord(@Param("keyword") String keyword);
	
}
