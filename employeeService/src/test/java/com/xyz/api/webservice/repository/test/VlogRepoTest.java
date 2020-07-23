package com.xyz.api.webservice.repository.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xyz.api.webservice.dto.VlogDTO;
import com.xyz.api.webservice.repository.VlogRepo;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VlogRepoTest {

	@Autowired
	VlogRepo vrepo;
	
	@Test
	public void saveTest() {
		VlogDTO vlog = new VlogDTO(1001, "abc", "abc");
		VlogDTO actual = vrepo.save(vlog);
		System.out.println(actual.toString());
	}
}
