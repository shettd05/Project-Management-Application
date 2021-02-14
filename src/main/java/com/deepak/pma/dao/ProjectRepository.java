package com.deepak.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.deepak.pma.dto.ChartData;
import com.deepak.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
	
	List<Project> findAll();
	
	@Query(nativeQuery = true,value = "SELECT stage as Label, COUNT(stage) as value FROM PROJECT GROUP BY stage ORDER BY 2 desc;")
	List<ChartData> getProjectStatus();
}
