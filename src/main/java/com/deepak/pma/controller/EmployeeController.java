package com.deepak.pma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.deepak.pma.dao.EmployeeRepository;
import com.deepak.pma.entities.Employee;

@Controller
@RequestMapping("employee")
public class EmployeeController {
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("")
	public String showEmployees(Model model) {
		List<Employee> employeeList = empRepo.findAll();
		model.addAttribute("employees", employeeList);
		return "employee/employee-list";
	}
	@GetMapping("/new")
	public String addNewEmployee(Model model) {
		Employee aEmployee = new Employee();
		model.addAttribute("employee", aEmployee);
		return "employee/new-employee";
		
	}
	
	@PostMapping("/save")
	public String saveEmployee(Employee aEmployee, Model model) {
		empRepo.save(aEmployee);
		return "redirect:/employee/new";
	}
}
