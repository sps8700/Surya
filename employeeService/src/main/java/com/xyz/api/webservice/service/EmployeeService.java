package com.xyz.api.webservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.xyz.api.webservice.dto.EmployeeDTO;
import com.xyz.api.webservice.exception.EmployeeNotFound;

@SuppressWarnings("deprecation")
@Service
public class EmployeeService {

	private static List<EmployeeDTO> list = new ArrayList<>();
	private static int count = 1;
	static {
		list.add(new EmployeeDTO(count++, "Ramesh", "Bengaluru", new Date("30/12/2019")));
		list.add(new EmployeeDTO(count++, "Paresh", "Bengaluru", new Date("30/12/2019")));
		list.add(new EmployeeDTO(count++, "Suresh", "Bengaluru", new Date("30/12/2019")));
	}
	
	public List<EmployeeDTO> findAllEmployee(){
		return list;
	}
	
	public EmployeeDTO findEmployeeById(int id) {
		for(EmployeeDTO emp : list)
			if(emp.getEmpId() == id)
				return emp;
		return null;
	}
	
	public EmployeeDTO addEmployee(EmployeeDTO emp) {
		if(emp.getEmpId() == null) 
			list.add(new EmployeeDTO(count++, emp.getEmpName(), emp.getEmpAdd(), emp.getDateOfJoining()));
		else if(list.stream().anyMatch(emp1 -> emp1.getEmpId() == emp.getEmpId()))
			throw new EmployeeNotFound("Duplicate id. Emp id-"+emp.getEmpId()+" already exists");
		else	
			list.add(emp);
		return emp;
	}
	
	public EmployeeDTO updateEmployee(int id, EmployeeDTO emp) {
		for(EmployeeDTO emp1 : list) {
			if(emp1.getEmpId() == id) {
				emp1.setDateOfJoining(emp.getDateOfJoining());
				emp1.setEmpAdd(emp.getEmpAdd());
				emp1.setEmpName(emp.getEmpName());
				return emp1;
			}
		}
		return null;
	}
	
	public EmployeeDTO deleteEmployee(int id) {
		EmployeeDTO emp;
		Iterator<EmployeeDTO> itr = list.iterator();
		while(itr.hasNext()) {
			emp = itr.next();
			if(emp.getEmpId() == id) {
				itr.remove();
				return emp;
			}
		}
		return null;
	}
	
	
}
