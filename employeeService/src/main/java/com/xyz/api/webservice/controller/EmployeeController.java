package com.xyz.api.webservice.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.xyz.api.webservice.dto.EmployeeDTO;
import com.xyz.api.webservice.exception.EmployeeNotFound;
import com.xyz.api.webservice.repository.EmployeeRepo;
import com.xyz.api.webservice.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	@Autowired
	EmployeeRepo employeeRepo;

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	
  	@GetMapping("/employees")
	public List<EmployeeDTO> getAllEmployee() {
		return employeeService.findAllEmployee();
	}
	
	@GetMapping("/employees/{id}")
	public EmployeeDTO getEmployee(@PathVariable int id) {
		EmployeeDTO emp = employeeService.findEmployeeById(id);
		if(emp == null)
			throw new EmployeeNotFound("emp id: "+id+" not exists");
		return emp;
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Object> addEmployee(@RequestBody EmployeeDTO employee) {
		EmployeeDTO emp = employeeService.addEmployee(employee);
		URI loc = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(emp.getEmpId()).toUri();
		return ResponseEntity.created(loc).build();
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable int id) {
		EmployeeDTO emp = employeeService.deleteEmployee(id);
		if(emp == null)
			throw new EmployeeNotFound("Emp id - "+id+" not exists");
		ResponseEntity.notFound();
	}
	
	@PutMapping("/employees/{id}")
	public void updateEmployee(@PathVariable int id, @RequestBody EmployeeDTO employee) {
		EmployeeDTO emp = employeeService.updateEmployee(id, employee);
		if(emp == null)
			throw new EmployeeNotFound("Emp id - "+id+" not exists");
		//ResponseEntity.notFound();
	}
	
	/********* JPA Changes ***********/
	
	@GetMapping("/jpa/employees")
	public List<EmployeeDTO> getAllEmployeeJPA() {
		logger.info("Inside JPA Get request");
		return employeeRepo.findAll();
	}
	
	@GetMapping("/jpa/employees/{id}")
	public EmployeeDTO getEmployeeJPA(@PathVariable int id) {
		Optional<EmployeeDTO> emp = employeeRepo.findById(id);
		if(!emp.isPresent())
			throw new EmployeeNotFound("emp id: "+id+" not exists");
		return emp.get();
	}
	
	@PostMapping("/jpa/employees")
	public ResponseEntity<Object> addEmployeeJPA(@RequestBody EmployeeDTO employee) {
		EmployeeDTO emp = employeeRepo.save(employee);
		URI loc = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(emp.getEmpId()).toUri();
		return ResponseEntity.created(loc).build();
	}
	
	@DeleteMapping("/jpa/employees/{id}")
	public void deleteEmployeeJPA(@PathVariable int id) {
		employeeRepo.deleteById(id);
	}
	
	@PutMapping("/jpa/employees/{id}")
	public void updateEmployeeJPA(@PathVariable int id, @RequestBody EmployeeDTO employee) {
		Optional<EmployeeDTO> emp1 = employeeRepo.findById(id);
		if(!emp1.isPresent())
			throw new EmployeeNotFound("Emp id - "+id+" not exists");
		EmployeeDTO emp = emp1.get();
		if(emp.getDateOfJoining().compareTo(employee.getDateOfJoining()) != 0)
			emp.setDateOfJoining(employee.getDateOfJoining());
		if(!emp.getEmpAdd().equals(employee.getEmpAdd()))
			emp.setEmpAdd(employee.getEmpAdd());
		if(!emp.getEmpName().equals(employee.getEmpName()))
			emp.setEmpName(employee.getEmpName());
		employeeRepo.save(emp);
	}
}
