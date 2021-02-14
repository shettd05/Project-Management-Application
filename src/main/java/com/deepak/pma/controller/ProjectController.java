package com.deepak.pma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.deepak.pma.dao.EmployeeRepository;
import com.deepak.pma.dao.ProjectRepository;
import com.deepak.pma.entities.Employee;
import com.deepak.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectRepository proRepo;
	@Autowired
	EmployeeRepository empRepo;
	
	@RequestMapping("")
	public String getProjects(Model model) {
		System.out.println("Inside the project");
		List<Project> projectList = proRepo.findAll();
		model.addAttribute("projects", projectList);
		return "project/project-list";
	}
	
	@RequestMapping("/new")
	public String displayProjectForm(Model model) {
		Project aProject = new Project();
		List<Employee> employeeList = empRepo.findAll();
		model.addAttribute("project", aProject);
		model.addAttribute("allEmployees", employeeList);
		return "project/new-project";
	}
	
	@PostMapping("/save")
	public String saveProject(Project aProject,@RequestParam List<Long> employees, Model model) {
		proRepo.save(aProject);
		
		
		return "redirect:/projects/new";
	}
}
