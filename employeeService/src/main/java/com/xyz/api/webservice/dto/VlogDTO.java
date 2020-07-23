package com.xyz.api.webservice.dto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "vlog")
public class VlogDTO {

	@Id @GeneratedValue
	private int vlogId;
	private String vlogTitle;
	private String vlogBody;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private EmployeeDTO employee;
	
	public VlogDTO() {}
	
	public VlogDTO(int vlogId, String vlogTitle, String vlogBody) {
		super();
		this.vlogId = vlogId;
		this.vlogTitle = vlogTitle;
		this.vlogBody = vlogBody;
	}

	public int getVlogId() {
		return vlogId;
	}

	public void setVlogId(int vlogId) {
		this.vlogId = vlogId;
	}

	public String getVlogTitle() {
		return vlogTitle;
	}

	public void setVlogTitle(String vlogTitle) {
		this.vlogTitle = vlogTitle;
	}

	public String getVlogBody() {
		return vlogBody;
	}

	public void setVlogBody(String vlogBody) {
		this.vlogBody = vlogBody;
	}

	public EmployeeDTO getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeDTO employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "VlogDTO [vlogId=" + vlogId + ", vlogTitle=" + vlogTitle + ", vlogBody=" + vlogBody + "]";
	}
	
}
