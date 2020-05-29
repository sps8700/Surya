package com.xyz.api.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xyz.api.webservice.dto.EmployeeDTO;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeDTO, Integer> {
	//List<EmployeeDTO> findAllEmployee();
}
