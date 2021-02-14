package com.deepak.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.deepak.pma.dto.EmployeeProject;
import com.deepak.pma.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
	List<Employee> findAll();
	
	@Query(nativeQuery = true, value = "SELECT e.first_name as firstName,e.last_name as lastName,COUNT(e.employee_id) as projectCount"
			+ " FROM employee e LEFT OUTER JOIN project_employee pe ON e.employee_id = pe.employee_id"
			+ " GROUP BY e.first_name,e.last_name"
			+ " ORDER BY 3 desc;")
	List<EmployeeProject> employeeProject();


	Employee findByEmail(String value);
}
