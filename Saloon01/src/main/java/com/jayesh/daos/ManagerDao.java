package com.jayesh.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jayesh.entites.Customers;
import com.jayesh.entites.Manager;
@Repository
public interface ManagerDao extends JpaRepository<Manager,Integer>{

	Manager findByEmail(String email);

	

	

}
