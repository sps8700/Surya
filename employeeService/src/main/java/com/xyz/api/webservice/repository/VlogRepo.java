package com.xyz.api.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xyz.api.webservice.dto.VlogDTO;

@Repository
public interface VlogRepo extends JpaRepository<VlogDTO, Integer>{

}
