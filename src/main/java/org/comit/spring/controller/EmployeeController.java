package org.comit.spring.controller;

import org.comit.spring.entity.Employee;
import org.comit.spring.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api/employees")
public class EmployeeController {

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/list")
    public String listEmployees(Model model, String keyword) {
		
		if(keyword != null) {
			model.addAttribute("employees", employeeService.findByKeyWord(keyword));
		} else {
		model.addAttribute("employees", employeeService.findAll());
		}
		
        return "employee_templates/employees";
    }
	
	@GetMapping("/new")
	public String createEmployeeForm(Model model) {
		
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		
		return "employee_templates/create_employee";
	}
	
	@PostMapping
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		
		employeeService.save(employee);

        return "redirect:/api/employees/list";
    }
	
	@GetMapping("/edit/{id}")
	public String editEmployeeForm(@PathVariable int id, Model model) {
		model.addAttribute("employee", employeeService.findById(id));
		return "employee_templates/edit_employee";
	}
	
	@PostMapping("/{id}")
    public String updateEmployee(@PathVariable int id,
                                 @ModelAttribute("employee") Employee employee, Model model) {
		
		employeeService.updateById(employee, id);
		
		return "redirect:/api/employees/list";
    }
	
	@GetMapping("/{id}")
    public String deleteVehicle(@PathVariable int id) {
		employeeService.deleteById(id);

        return "redirect:/api/employees/list";
    }
	
}
