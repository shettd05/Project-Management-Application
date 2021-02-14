package com.deepak.pma.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.deepak.pma.dao.EmployeeRepository;
import com.deepak.pma.entities.Employee;

@RestController
@RequestMapping("/rest-api/employee")
public class EemployeeRestController {
	
		@Autowired
		EmployeeRepository empRepo;
		
	
		@GetMapping
		@ResponseStatus(code = HttpStatus.OK)
		public List<Employee> getEmployees(){
			return empRepo.findAll();
		}
		
		@GetMapping(consumes = "application/json",value = "/{id}")
		@ResponseStatus(code = HttpStatus.OK)
		public Employee getEmployee(@PathVariable("id") long id) {
			System.out.println("****************inside get by ID *******************");
			return empRepo.findById(id).get();
		}
		
		@PostMapping
		@ResponseStatus(value = HttpStatus.CREATED)
		public Employee createEmployee(@RequestBody @Valid Employee emp) {
			System.out.println("***************I am here*************");
			return empRepo.save(emp);
			
		}
		
		@DeleteMapping(value = "/{id}")
		@ResponseStatus(value = HttpStatus.OK)
		public void deleteEmployee(@PathVariable("id") long id) {
			Employee emp;
			try {
				emp = empRepo.findById(id).get();
				empRepo.delete(emp);
			} catch (java.util.NoSuchElementException e) {
				// TODO Auto-generated catch block
				
			}
			
		}
		
		@PatchMapping(consumes = "application/json",value = "{id}")
		@ResponseStatus(value = HttpStatus.ACCEPTED)
		public Employee patchUpdate(@PathVariable("id") long id,@RequestBody Employee patchEmployee) {
			Employee employee = empRepo.findById(id).get();
			if(patchEmployee.getEmail() != null) {
				employee.setEmail(patchEmployee.getEmail());
			}
			if(patchEmployee.getFirstName() != null) {
				employee.setFirstName(patchEmployee.getFirstName());
			}
			if(patchEmployee.getLastName() != null) {
				employee.setLastName(patchEmployee.getLastName());
			}
			return empRepo.save(employee);
			
			
		}
}
