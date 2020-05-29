package com.xyz.api.webservice.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.xyz.api.webservice.dto.EmployeeDTO;
import com.xyz.api.webservice.dto.VlogDTO;
import com.xyz.api.webservice.exception.EmployeeNotFound;
import com.xyz.api.webservice.exception.VlogNotFound;
import com.xyz.api.webservice.repository.EmployeeRepo;
import com.xyz.api.webservice.repository.VlogRepo;

@RestController
public class VlogController {

	@Autowired
	VlogRepo vlogRepo;
	@Autowired
	EmployeeRepo employeeRepo;
	
	@GetMapping("/jpa/vlog")
	public List<VlogDTO> findAllDepartment() {
		return vlogRepo.findAll();
	}
	
	@GetMapping("/jpa/vlog/{id}")
	public VlogDTO findDepartmentById(@PathVariable int id) {
		Optional<VlogDTO> vlog = vlogRepo.findById(id);
		if(!vlog.isPresent())
			throw new VlogNotFound("vlog id: "+id+" not found");
		return vlog.get();	
	}

	@GetMapping("/jpa/employees/{id}/vlog")
	public List<VlogDTO> findEmployeeListByDepartment(@PathVariable int id) {
		Optional<EmployeeDTO> emp = employeeRepo.findById(id);
		if(!emp.isPresent())
			throw new EmployeeNotFound("Emp id: "+id+" not found");
		return emp.get().getVlogList();	
	}


	@PostMapping("/jpa/employees/{id}/vlog")
	public ResponseEntity<Object> createEmployee(@PathVariable int id, @RequestBody VlogDTO vlog) {
		Optional<EmployeeDTO> emp = employeeRepo.findById(id);
		if(!emp.isPresent())
			throw new EmployeeNotFound("Emp id: "+id+" not found");
		vlog.setEmployee(emp.get());
		VlogDTO vlog1 = vlogRepo.save(vlog);
		URI loc = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(vlog1.getVlogId()).toUri();
		return ResponseEntity.created(loc).build();
	}
	
	@PostMapping("/jpa/vlog")
	public ResponseEntity<Object> createDepartment(@RequestBody VlogDTO vlog) {
		VlogDTO vlog1 = vlogRepo.save(vlog);
		URI loc = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(vlog1.getVlogId()).toUri();
		return ResponseEntity.created(loc).build();
	}
	
	
	@GetMapping("/jpa/employees/{id}/vlog/{vlogId}")
	public VlogDTO findEmployeeByDepartment(@PathVariable int id,@PathVariable int vlogId) {
		Optional<EmployeeDTO> emp = employeeRepo.findById(id);
		if(!emp.isPresent())
			throw new EmployeeNotFound("Employee id: "+id+" not found");
		VlogDTO vlog = emp.get().getVlogList().stream().filter(vlog1 -> vlog1.getVlogId() == vlogId).findFirst().orElse(null);
		if(vlog == null)	
			throw new VlogNotFound("Vlog id - "+vlogId+" not exists");
		return vlog;
	}
	
}
