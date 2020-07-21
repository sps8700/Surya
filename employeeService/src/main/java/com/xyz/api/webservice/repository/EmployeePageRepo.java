package com.xyz.api.webservice.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.xyz.api.webservice.dto.EmployeeDTO;

@Repository
public interface EmployeePageRepo extends PagingAndSortingRepository<EmployeeDTO, Integer>{

}
