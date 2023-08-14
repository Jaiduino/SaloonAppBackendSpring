package com.jayesh.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jayesh.entites.Customers;
import com.jayesh.entites.Review;
@Repository
public interface ReviewDao extends JpaRepository<Review, Integer> {
	@Query(value ="SELECT * FROM Review r WHERE r.branch_Id in ?1",nativeQuery = true)
	List <Review> findBybranchId(int id);

	List<Review> findByCustomer(Customers cus);

	

}
