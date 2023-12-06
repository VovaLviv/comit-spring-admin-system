package org.comit.spring.repository;

import org.comit.spring.entity.Courier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourierRepo extends JpaRepository<Courier, Integer> {
	
}
