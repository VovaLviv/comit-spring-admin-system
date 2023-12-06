package org.comit.spring.service.impl;

import java.util.List;

import org.comit.spring.entity.Employee;
import org.comit.spring.entity.StockWorker;
import org.comit.spring.repository.StockWorkerRepo;
import org.comit.spring.service.EmployeeService;
import org.comit.spring.service.StockWorkerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockWorkerServiceImpl implements StockWorkerService {
	
	private final StockWorkerRepo stockWorkerRepo;
	private final EmployeeService employeeService;

	public StockWorkerServiceImpl(StockWorkerRepo stockWorkerRepo, EmployeeService employeeService) {
		this.stockWorkerRepo = stockWorkerRepo;
		this.employeeService = employeeService;
	}

	@Override
	public StockWorker findById(int id) {
		return stockWorkerRepo.findById(id).orElseThrow(() -> new RuntimeException());
	}

	@Override
	public List<StockWorker> findAll() {
		return stockWorkerRepo.findAll();
	}

	@Override
	public StockWorker save(StockWorker stockWorker) {
		return stockWorkerRepo.save(stockWorker);
	}

	@Override
	@Transactional
	public StockWorker updateById(StockWorker stockWorker, int id) {
		
		StockWorker foundedStockWorker = findById(id);
		foundedStockWorker.setRole(stockWorker.getRole());
		foundedStockWorker.setSalary(stockWorker.getSalary());
		
		return foundedStockWorker;
	}

	@Override
	public void deleteById(int id) {
		
		StockWorker foundedStockWorker = findById(id);
		
		if(foundedStockWorker != null) {
			stockWorkerRepo.deleteById(id);;
		}
		
	}

	@Override
	public StockWorker addEmployeeToStockWorker(int stockWorkerId, int employeeId) {
		
		StockWorker foundedStockWorker = findById(stockWorkerId);
		Employee foundedEmployee = employeeService.findById(employeeId);
		
		foundedStockWorker.setEmployee(foundedEmployee);
		
		return save(foundedStockWorker);
	}

}
