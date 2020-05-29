package com.xyz.api.webservice.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "employee")
public class EmployeeDTO {

	@Id @GeneratedValue
	private Integer empId;
	private String empName;
	private String empAdd;
	@Temporal(TemporalType.DATE)
	private Date dateOfJoining;
	@OneToMany(mappedBy = "employee")
	private List<VlogDTO> vlogList;

	public EmployeeDTO() {}
	
	public EmployeeDTO(Integer empId, String empName, String empAdd, Date dateOfJoining) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAdd = empAdd;
		this.dateOfJoining = dateOfJoining;
	}


	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAdd() {
		return empAdd;
	}

	public void setEmpAdd(String empAdd) {
		this.empAdd = empAdd;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public List<VlogDTO> getVlogList() {
		return vlogList;
	}

	public void setVlogList(List<VlogDTO> vlogList) {
		this.vlogList = vlogList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeDTO other = (EmployeeDTO) obj;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [empId=" + empId + ", empName=" + empName + ", empAdd=" + empAdd + ", dateOfJoining="
				+ dateOfJoining + "]";
	}
	
}
