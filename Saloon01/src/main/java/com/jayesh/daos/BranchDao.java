package com.jayesh.daos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jayesh.entites.Branch;
@Repository
public interface BranchDao extends JpaRepository<Branch,Integer>{

	//Optional<Branch> findById(int b);

}
