package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import DTO.accountDTO;

	
	



public interface accountsRepository extends JpaRepository<accountDTO, Integer>{
	
	accountDTO findByUsername(String Username);

}
