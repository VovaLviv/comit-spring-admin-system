package org.comit.spring.controller;

import org.comit.spring.entity.Courier;
import org.comit.spring.service.CourierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api/couriers")
public class CourierController {

	private final CourierService courierService;

	public CourierController(CourierService courierService) {
		this.courierService = courierService;
	}
	
	@GetMapping("/list")
    public String listCouriers(Model model) {
		model.addAttribute("couriers", courierService.findAll());
		
        return  "courier_templates/couriers";
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<Courier> findById(@PathVariable("id") int id) {
		Courier foundedCourier = courierService.findById(id);
        return new ResponseEntity<>(foundedCourier, HttpStatus.OK);
    }

	
	@PostMapping
    public ResponseEntity<Courier> save(@RequestBody Courier courier) {
        Courier courierSaved = courierService.save(courier);

        return new ResponseEntity<>(courierSaved, HttpStatus.CREATED);
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<Courier> updateById(@PathVariable("id") int id,
                                              @RequestBody Courier courier) {
		
		Courier courierUpdated = courierService.updateById(courier, id);
		
		return new ResponseEntity<>(courierUpdated, HttpStatus.OK);
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") int id) {
		courierService.deleteById(id);

        return new ResponseEntity<>("The employee information has been deleted", HttpStatus.OK);
    }
	
	@PatchMapping("/add_parcels/{id}/{number_of_parcels}")
	public ResponseEntity<Courier> addParcels(@PathVariable("id") int id, 
			                                  @PathVariable("number_of_parcels") int numberOfParcels) {
 
		Courier parcelsDeliveredUpdated = courierService.addParcels(id, numberOfParcels);
		
        return new ResponseEntity<>(parcelsDeliveredUpdated, HttpStatus.OK);
    }
	
	@GetMapping("/show_bonus/{id}")
    public ResponseEntity<Double> show_bonus(@PathVariable("id") int id) {
		
        return new ResponseEntity<>(courierService.showBonus(id), HttpStatus.OK);
    }

	
	@PostMapping(value = "{courier_id}/employee/{employee_id}/add")
    public ResponseEntity<Courier> addEmployeeToCourier(@PathVariable("courier_id") int courierId,
                                                        @PathVariable("employee_id") int employeeId){
        Courier courier = courierService.addEmployeeToCourier(courierId, employeeId);
        return new ResponseEntity<>(courier, HttpStatus.OK);
    }
	
	@PostMapping(value = "{courier_id}/vehicle/{vehicle_id}/add")
    public ResponseEntity<Courier> addVehicleToCourier(@PathVariable("courier_id") int courierId,
                                                       @PathVariable("vehicle_id") int vehicleId){
        Courier courier = courierService.addVehicleToCourier(courierId, vehicleId);
        return new ResponseEntity<>(courier, HttpStatus.OK);
    }
}
