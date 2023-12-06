package org.comit.spring.controller;

import java.util.List;

import org.comit.spring.entity.StockWorker;
import org.comit.spring.service.StockWorkerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/stock_workers")
public class StockWorkerController {

	private final StockWorkerService stockWorkerService;

	public StockWorkerController(StockWorkerService stockWorkerService) {
		this.stockWorkerService = stockWorkerService;
	}
	
	@GetMapping
    public List<StockWorker> findAll() {
        return stockWorkerService.findAll();
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<StockWorker> findById(@PathVariable("id") int id) {
		StockWorker foundedStockWorker = stockWorkerService.findById(id);
        return new ResponseEntity<>(foundedStockWorker, HttpStatus.OK);
    }
	
	@PostMapping
    public ResponseEntity<StockWorker> save(@RequestBody StockWorker stockWorker) {
		StockWorker stockWorkerSaved = stockWorkerService.save(stockWorker);

        return new ResponseEntity<>(stockWorkerSaved, HttpStatus.CREATED);
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<StockWorker> updateById(@PathVariable("id") int id,
                                                   @RequestBody StockWorker stockWorker) {
		
		StockWorker stockWorkerUpdated = stockWorkerService.updateById(stockWorker, id);
		
		return new ResponseEntity<>(stockWorkerUpdated, HttpStatus.OK);
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") int id) {
		stockWorkerService.deleteById(id);

        return new ResponseEntity<>("The stock worker information has been deleted", HttpStatus.OK);
    }
	
	@PostMapping(value = "{stockWorkerId}/employee/{employeeId}/add")
    public ResponseEntity<StockWorker> addEmployeeToCourier(@PathVariable("stockWorkerId") int stockWorkerId,
                                                        @PathVariable("employeeId") int employeeId){
		StockWorker stockWorker = stockWorkerService.addEmployeeToStockWorker(stockWorkerId, employeeId);
        return new ResponseEntity<>(stockWorker, HttpStatus.OK);
    }
	
}
