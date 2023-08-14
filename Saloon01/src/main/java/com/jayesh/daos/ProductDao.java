package com.jayesh.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jayesh.dtos.ProductDto;
import com.jayesh.entites.Products;
@Repository
public interface ProductDao extends JpaRepository<Products,String>{

	//@Query(value = "select * from products where gender = 'Male'",nativeQuery = true)
	List<Products> getBygender(String s);

//	
	
	//List<Products> findByIdStartsWith(String string);
	@Query(value ="SELECT * FROM Products p WHERE p.product_Id LIKE %:string%",nativeQuery = true)
	List<Products> findByIdStartsWith(String string);

	//List<Products> findByproduct_IdStartsWith(String s);

	//List<Products> findByproduct_IdStartsWith(String str);
	
	//List<Products> findByproduct_IdStartingWith(String prefix);
}
