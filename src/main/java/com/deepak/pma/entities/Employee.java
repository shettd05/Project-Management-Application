package com.deepak.pma.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.deepak.pma.validation.UniqueValue;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "employee_generator")
	@SequenceGenerator(name = "employee_generator", sequenceName = "employee_seq", allocationSize = 1)
	private long employeeId;
	
	@NotNull
	@Size(min = 2,max = 50)
	private String firstName;
	@NotNull
	@Size(min = 1,max = 50)
	private String lastName;
	
	@Email
	@UniqueValue
	private String email;
	
	@ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.LAZY)
	@JoinTable(name = "project_employee",joinColumns = @JoinColumn(name = "employee_id"),inverseJoinColumns = @JoinColumn(name = "project_id"))
	@JsonIgnore
	private List<Project> projects;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	
	
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
}
