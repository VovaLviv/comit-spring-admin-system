package org.comit.spring.controller;

import org.comit.spring.entity.Vehicle;
import org.comit.spring.service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api/vehicles")
public class VehicleController {
	
	private VehicleService vehicleService;
	
	public VehicleController(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}

	@GetMapping("/list")
    public String listVehicles(Model model, String keyword) {
		
		if(keyword != null) {
			model.addAttribute("vehicles", vehicleService.findByKeyWord(keyword));
		} else {
		model.addAttribute("vehicles", vehicleService.findAll());
		}
		
        return "vehicle_templates/vehicles";
    }
	
	@GetMapping("/new")
	public String createVehicleForm(Model model) {
		
		Vehicle vehicle = new Vehicle();
		model.addAttribute("vehicle", vehicle);
		
		return "vehicle_templates/create_vehicle";
	}
	
	@PostMapping
    public String saveVehicle(@ModelAttribute("vehicle") Vehicle vehicle) {
		
		vehicleService.save(vehicle);

        return "redirect:/api/vehicles/list";
    }
	
	@GetMapping("/edit/{id}")
	public String editVehicleForm(@PathVariable int id, Model model) {
		model.addAttribute("vehicle", vehicleService.findById(id));
		return "vehicle_templates/edit_vehicle";
	}
	
	@PostMapping("/{id}")
    public String updateVehicle(@PathVariable int id,
                                @ModelAttribute("vehicle") Vehicle vehicle, Model model) {
		
		vehicleService.updateById(vehicle, id);
		
		return "redirect:/api/vehicles/list";
    }
	
	@GetMapping("/{id}")
    public String deleteVehicle(@PathVariable int id) {
		vehicleService.deleteById(id);

        return "redirect:/api/vehicles/list";
    }
	
	@GetMapping("/inspection_check/{id}")
    public String checkForInspection(@PathVariable int id, Model model) {
		model.addAttribute("vehicle", vehicleService.checkForInspection(id));

        return "vehicle_templates/vehicle_inspection";
    }
}
