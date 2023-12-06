package org.comit.spring.service;

import org.comit.spring.entity.StockWorker;

public interface StockWorkerService extends GenericService<StockWorker>{

	StockWorker addEmployeeToStockWorker(int stockWorkerId, int employeeId);
}
