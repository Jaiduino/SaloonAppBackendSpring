package com.jayesh.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jayesh.entites.Branch;
import com.jayesh.entites.Customers;
import com.jayesh.entites.Orders;
@Repository
public interface OrderDao extends JpaRepository<Orders, Integer> {

//	@Query(value ="SELECT * FROM Orders o WHERE o.branch_Id = %1%",nativeQuery = true)
	//List<Orders> findBranch(int id);

	List<Orders> findByBranch(Branch br);

	void deleteByCustomers(Customers cus);
	
	//@Query(value ="SELECT * FROM Orders o WHERE o.branch_Id = %id%",nativeQuery = true)
	// findBranch_Id(int id);

//Optional<Orders> olist = findAll(Orders o);
//	@Query("SELECT o FROM Orders o WHERE o.branch_Id=?1")
//	List<Orders> findOrderedMobiles(int id);
	//@Modifying
//    @Query(value="Select * from Orders where") 
//	List<Orders> findBranches(int id);


	

}
