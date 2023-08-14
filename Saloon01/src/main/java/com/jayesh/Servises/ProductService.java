package com.jayesh.Servises;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.jayesh.daos.ProductDao;
import com.jayesh.entites.Products;
@Transactional
@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;
	
 
}
