package com.deepak.pma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.deepak.pma.dao.EmployeeRepository;
import com.deepak.pma.dao.ProjectRepository;
import com.deepak.pma.dto.ChartData;
import com.deepak.pma.dto.EmployeeProject;
import com.deepak.pma.entities.Employee;
import com.deepak.pma.entities.Project;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class HomeController {
	@Value("${version}")
	private String ver;
	@Autowired
	ProjectRepository proRepo;
	@Autowired
	EmployeeRepository empRepo;
	
	
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		model.addAttribute("version", ver);
		Project project = new Project();
		List<Project> projectList =  proRepo.findAll();
		List<ChartData> chartdata = proRepo.getProjectStatus();
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(chartdata);
		System.out.println(jsonString);
		List<EmployeeProject> employeeProjectCount = empRepo.employeeProject();
		
		//model.addAttribute("projectStatusCount", chartdata);
		model.addAttribute("projects", projectList);
		model.addAttribute("employees", employeeProjectCount);
		return "home/home";
	}
}
