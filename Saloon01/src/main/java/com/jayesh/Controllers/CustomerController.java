package com.jayesh.Controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jayesh.Servises.CustomerService;
import com.jayesh.daos.CustomerDao;
import com.jayesh.daos.OrderDao;
import com.jayesh.daos.ReviewDao;
import com.jayesh.dtos.CustomerDto;
import com.jayesh.dtos.EditCustomerDto;
import com.jayesh.entites.Customers;
import com.jayesh.entites.Review;
@CrossOrigin
@RestController

public class CustomerController {
	
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private CustomerService customerservice;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private ReviewDao reviewDao;
    
	@GetMapping("/customer")
	public Map<String,Object> getAllUser() {
		Map<String,Object> result = new HashMap<>();
	    List<Customers>clist = customerDao.findAll();
	    result.put("status", "success");
	    result.put("data", clist);
		return result;
		}
	@GetMapping("/customer/{email}/{pass}")
public Map<String,Object> getCustomerByEmail(@PathVariable("email")String email,@PathVariable("pass") String pass) {
	Map<String,Object> res = new HashMap<>();
	try{Customers cus = customerDao.findByEmail(email);
	System.out.println(cus.toString());
	System.out.println(email);
	CustomerDto tcus = new CustomerDto(cus.getCustomer_Id(),cus.getFullName(),cus.getEmail(),cus.getMobileNo(),cus.getGender(),cus.getBuilding_No(),cus.getArea_Name(),cus.getPincode());
	System.out.println(tcus.toString());
	if(cus.getPassword().equals(pass)) {
		System.out.println(tcus.toString());
		System.out.println("Login Successful!!!");
		
		res.put("status", "success");
	    res.put("data",tcus);		
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
	
	
	
	
	@PostMapping("/register")
	public Map<String,Object> registerCus(@RequestBody Customers cus) {
		Map<String,Object> result = new HashMap<>();
		try {
		System.out.println(cus.toString());
		Customers c = new Customers(cus.getCustomer_Id(),cus.getFullName(),cus.getEmail(),cus.getMobileNo(),cus.getGender(),cus.getBuilding_No(),
				                     cus.getArea_Name(),cus.getPincode(),cus.getPassword(),"Customer");
		Customers cusdb = customerDao.save(c);
		result.put("status", "success");
		result.put("data", cusdb);
		} catch(Exception e)
		{
			e.printStackTrace();
			result.put("status","error");
			result.put("message",e.getMessage());
		}
		return result;
		
	}
	
//	@PutMapping("/customer/{cusid}")
//	public Map<String,Object> updateMobile(@PathVariable("cusid") int id,@RequestBody EditCustomerDto cus) throws Exception {
//		Map<String,Object> result = new HashMap<>();
//		System.out.println(cus.toString());
//		Customers c = new Customers(id,cus.getMobile(),cus.getPassword(),cus.getArea_Name(),cus.getBuilding_Name(),cus.getPincode());
//    customerDao.save(c);
//   result.put("status", "success");
//   result.put("data",c);
//   
//		return result;
//	}
	 @PutMapping("/customer/{cusid}")
	   public Map<String, Object> updateuser(@PathVariable("cusid")int id, @RequestBody EditCustomerDto cus){
		   //System.out.println("controller:"+u.toString());
		   System.out.println("CID:"+id);
		   
	 	   Map<String ,Object> result= new HashMap<>();
	 	   try {
	 		   Optional<Customers> customer = customerDao.findById(id);
	 		   if(customer.isPresent())
	 		   {
	 			   Customers cs = customer.get();
	 		   
	 		Customers c= new Customers(id,cs.getFullName(),cs.getEmail(),cus.getMobileNo(),cs.getGender(),cus.getBuilding_No(),cus.getArea_Name(),cus.getPincode(),cus.getPassword());
	 		  System.out.println("us: "+cus);
	 		   customerDao.save(c);
	 		   result.put("Status", "success");
	 		   result.put("data", c);
	 		 
	 		   }
	 	   }catch (Exception e) {
			e.printStackTrace();
			result.put("Status", "error");
			result.put("message", e.getMessage());
		}
	 	   
	 	   return result;
	    }
	 @DeleteMapping("/customer/{cusid}")
	 public Map<String,Object> deleteCustomer(@PathVariable("cusid")int id)
	 {
		 Map<String,Object> result= new HashMap<>();
		 try {
			// Customers cus = customerDao.findById(id).orElseThrow();
		 //  List<Review> rev = reviewDao.findByCustomer(cus);
			
			// reviewDao.deleteByCustomer(cus);
			// orderDao.deleteByCustomers(cus);
		     customerDao.deleteById(id);
			 
			 result.put("Status", "success");
			 result.put("message","Delete");
		 }catch (Exception e)
		 {
			 e.printStackTrace();
				result.put("Status", "error");
				result.put("message", e.getMessage()); 
		 }
		return result;
	 }
	 
	 @GetMapping("/customer/{cusid}")
	 public Map<String,Object> getCustomerById(@PathVariable("cusid")int id)
	 {
		 Map<String,Object> result= new HashMap<>();
		 try {
			Customers cus = customerDao.findById(id).orElseThrow();
			 result.put("Status", "success");
			 result.put("data",cus);
		 }catch (Exception e)
		 {
			 e.printStackTrace();
				result.put("Status", "error");
				result.put("message", e.getMessage()); 
		 }
		return result;
	 }
	 
	  
	 
	 
}

