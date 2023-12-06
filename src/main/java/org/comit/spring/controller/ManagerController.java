package org.comit.spring.controller;

import java.util.List;

import org.comit.spring.entity.Manager;
import org.comit.spring.service.ManagerService;
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
@RequestMapping(value = "/api/managers")
public class ManagerController {
	
	private final ManagerService managerService;

	public ManagerController(ManagerService managerService) {
		this.managerService = managerService;
	}
	
	@GetMapping
    public List<Manager> findAll() {
        return managerService.findAll();
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<Manager> findById(@PathVariable("id") int id) {
		Manager foundedManager = managerService.findById(id);
        return new ResponseEntity<>(foundedManager, HttpStatus.OK);
    }
	
	@PostMapping
    public ResponseEntity<Manager> save(@RequestBody Manager manager) {
		Manager managerSaved = managerService.save(manager);

        return new ResponseEntity<>(managerSaved, HttpStatus.CREATED);
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<Manager> updateById(@PathVariable("id") int id,
                                                   @RequestBody Manager manager) {
		
		Manager managerUpdated = managerService.updateById(manager, id);
		
		return new ResponseEntity<>(managerUpdated, HttpStatus.OK);
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") int id) {
		managerService.deleteById(id);

        return new ResponseEntity<>("The manager information has been deleted", HttpStatus.OK);
    }
	
	@PostMapping(value = "{managerId}/employee/{employeeId}/add")
    public ResponseEntity<Manager> addEmployeeToCourier(@PathVariable("managerId") int managerId,
                                                        @PathVariable("employeeId") int employeeId){
        Manager manager = managerService.addEmployeeToManager(managerId, employeeId);
        return new ResponseEntity<>(manager, HttpStatus.OK);
    }

}
