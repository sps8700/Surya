package com.xyz.api.webservice.controller.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.xyz.api.webservice.controller.VlogController;
import com.xyz.api.webservice.dto.VlogDTO;
import com.xyz.api.webservice.repository.EmployeeRepo;
import com.xyz.api.webservice.repository.VlogRepo;

@RunWith(SpringRunner.class)
public class VlogControllerTest{

	@InjectMocks
	VlogController vlogController;
	@Mock
	VlogRepo vlogRepo;
	@Mock
	EmployeeRepo empRepo;
	
	@Test
	public void findAllDepartmentTest() {
		VlogDTO vlog = new VlogDTO(111, "abc", "abc");
		VlogDTO vlog1 = new VlogDTO(112, "abc", "abc");
		List<VlogDTO> list = new ArrayList<>();
		list.add(vlog);list.add(vlog1);
		Mockito.when(vlogRepo.findAll()).thenReturn(list);
		List<VlogDTO> actual = vlogController.findAllVlog();
		Assert.assertEquals(list, actual);
	}
}
