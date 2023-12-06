package org.comit.spring.repository;

import org.comit.spring.entity.StockWorker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockWorkerRepo extends JpaRepository<StockWorker, Integer> {

}
