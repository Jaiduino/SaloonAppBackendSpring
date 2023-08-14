package com.jayesh.Servises;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.jayesh.Credentials.Credentials;
import com.jayesh.daos.CustomerDao;
import com.jayesh.entites.Customers;
@Transactional
@Service
public class CustomerService {
	
	private CustomerDao customerDao;
	
	

}
