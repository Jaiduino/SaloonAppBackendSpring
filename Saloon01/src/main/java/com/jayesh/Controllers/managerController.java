package com.jayesh.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jayesh.daos.ManagerDao;
import com.jayesh.dtos.CustomerDto;
import com.jayesh.entites.Customers;
import com.jayesh.entites.Manager;
@CrossOrigin
@RestController
public class managerController {
    
	@Autowired
	private ManagerDao managerDao;
	
	@GetMapping("/manager/{email}/{pass}")
	public Map<String,Object> getCustomerByEmail(@PathVariable("email")String email,@PathVariable("pass") String pass) {
		Map<String,Object> res = new HashMap<>();
		try{Manager mgr = managerDao.findByEmail(email);
		System.out.println(mgr.toString());
		System.out.println(email);
		//CustomerDto tcus = new CustomerDto(cus.getCustomer_Id(),cus.getFullName(),cus.getEmail(),cus.getMobileNo(),cus.getGender(),cus.getBuilding_No(),cus.getArea_Name(),cus.getPincode());
		//System.out.println(tcus.toString());
		if(mgr.getManager_Password().equals(pass)) {
			//System.out.println(tcus.toString());
			System.out.println("Login Successful!!!");
			
			res.put("status", "success");
		    res.put("data",mgr);		
		}
		else
		{
			System.out.println("Invalid User!!!");
			res.put("status","error");
		    res.put("message","Invalid Password" );		
		
		}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Empty");
		}
		return res;
	}
	@GetMapping("/manager")
	public Map<String,Object> getmanager() {
		Map<String,Object> res = new HashMap<>();
		try{
			List<Manager>mlist = managerDao.findAll();
		    res.put("data", mlist);
		    res.put("status", "success");
		}catch (Exception e) {
			res.put("status","error");
			res.put("message",e.getMessage());
		}
		return res;
		
	}

}
