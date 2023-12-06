package org.comit.spring.repository;

import org.comit.spring.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepo extends JpaRepository<Manager, Integer> {

}
