package com.jayesh.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jayesh.entites.Orders_Products;

@Repository
public interface Order_Products extends JpaRepository<Orders_Products, Integer> {

}
