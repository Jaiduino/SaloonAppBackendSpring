package com.jayesh.daos;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jayesh.entites.Customers;

@Repository
public interface CustomerDao extends JpaRepository<Customers,Integer> {

	Customers findByEmail(String email);
	//Customers findById(int id);

	

	

	



}

