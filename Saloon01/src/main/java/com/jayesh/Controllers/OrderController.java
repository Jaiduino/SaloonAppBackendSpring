package com.jayesh.Controllers;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jayesh.daos.BranchDao;
import com.jayesh.daos.CustomerDao;
import com.jayesh.daos.DateDao;
import com.jayesh.daos.OrderDao;
import com.jayesh.daos.Order_Products;
import com.jayesh.dtos.CustomRequest;
import com.jayesh.dtos.EditCustomerDto;
import com.jayesh.dtos.approvepaidDto;
import com.jayesh.dtos.approvestatus;
import com.jayesh.dtos.paidDto;
import com.jayesh.entites.Branch;
import com.jayesh.entites.Customers;
import com.jayesh.entites.Date;
import com.jayesh.entites.Orders;
import com.jayesh.entites.Orders_Products;
@RestController
@CrossOrigin
public class OrderController {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private Order_Products opdao;
	@Autowired
	private BranchDao branchdao;
	@Autowired
	private DateDao datedao;
	@GetMapping("/orders")
	public Map<String,Object> getAllOrders() {
		Map<String,Object> result = new HashMap<>();
	    List<Orders>olist = orderDao.findAll();
	  
	    result.put("status", "success");
	    result.put("data", olist);
	    System.out.println(result);
		return result;
		}
	
	@PostMapping("/addorder/{cid}/{bid}")
	public Orders addOrder(@PathVariable("cid")int id,@PathVariable("bid")int bid, @RequestBody CustomRequest request) {
		Map<String,Object> result = new HashMap<>();
//		try {
//		System.out.println(ord.toString());
//		
//	   // ord = new Orders();
//	 // int cid = ord.getCustomers().getCustomer_Id();
//	     Optional<Customers> ocus = customerDao.findById(id);
//	     if(ocus.isPresent())
//	     {
//	    	  Customers customer = ocus.get();
//	    	  Orders nord = new Orders(ord.getOrder_Id(),customer,ord.getSlot_Date(),ord.getSlot_Time(),ord.getAmount());
//	    	  
//	    	  
//	    	  
//	    	  
//	    	  
//	    	  
//	    	  Orders o = orderDao.save(nord);
//	     
//		result.put("status", "success");
//		result.put("data", o);
//		}
//		}catch(Exception e)
//		{
//			e.printStackTrace();
//			result.put("status","error");
//			result.put("message",e.getMessage());
//		}
		
		
		 Customers ocus = customerDao.findById(id).orElseThrow();
		request.getOrders().setCustomers(ocus);
		Branch branch = branchdao.findById(bid).orElseThrow();
	    request.getOrders().setBranch(branch);
	    request.getOrders().setDate(request.getDate());
	    Date date = datedao.save(request.getDate());
		Orders persistedorder=orderDao.save((request.getOrders()));
		
		
		request.getProducts().forEach(i->{
			Orders_Products op=new Orders_Products();
			op.setOrder(persistedorder);
			op.setProduct(i);
			opdao.save(op);
			
		});

		
		return persistedorder;
		
	}
	
	 @DeleteMapping("/order/{ordid}")
	 public Map<String,Object> deleteCustomer(@PathVariable("ordid")int id)
	 {
		 Map<String,Object> result= new HashMap<>();
		 try {
			 orderDao.deleteById(id);
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
	 @GetMapping("/getbyidorder/{ordid}")
	 public Map<String,Object> getOrderById(@PathVariable("ordid")int id){
		 Map<String,Object> result= new HashMap<>();
		 try {
			  Orders ord = orderDao.findById(id).orElseThrow();
			  System.out.println(ord.toString());
			 result.put("Status", "success");
			 result.put("data", ord);
		 }catch (Exception e)
		 {
			 e.printStackTrace();
				result.put("Status", "error");
				result.put("message", e.getMessage()); 
		 }
		return result; 
	 }
	 @GetMapping("/getorderbybranch/{brid}")
	 public Map<String,Object> getOrderBybranchId(@PathVariable("brid")int id){
		 Map<String,Object> result= new HashMap<>();
		 try {
			 Branch br = branchdao.findById(id).orElseThrow();
			  List<Orders> ord = orderDao.findByBranch(br);
			  System.out.println(ord.toString());
			 result.put("Status", "success");
			 result.put("data", ord);
		 }catch (Exception e)
		 {
			 e.printStackTrace();
				result.put("Status", "error");
				result.put("message", e.getMessage()); 
		 }
		return result; 
	 }
	 
	 @PutMapping("/approved/{orderid}")
	   public Map<String, Object> updateuser(@PathVariable("orderid")int id,@RequestBody approvepaidDto apd){
		   //System.out.println("controller:"+u.toString());
		   System.out.println("CID:"+apd);
		   
	 	   Map<String ,Object> result= new HashMap<>();
	 	   try {
	 		    Orders ord = orderDao.findById(id).orElseThrow();
	 		    
	 		    ord.setApproved(apd.getApprove());
	 		    ord.setPaid(apd.getPaid());
	 		    
	 		   
	 		  System.out.println("us: "+ord);
	 		   orderDao.save(ord);
	 		   result.put("Status", "success");
	 		   result.put("data", ord);
	 		 
	 		   }catch(Exception e) {
	 			  e.printStackTrace();
					result.put("Status", "error");
					result.put("message", e.getMessage());   
	 		   }
	 	     return result;
	   	}
	 @PutMapping("/paid/{orderid}")
	   public Map<String, Object> updateuser(@PathVariable("orderid")int id,@RequestBody paidDto paid){
		   //System.out.println("controller:"+u.toString());
		   System.out.println("CID:"+paid.toString());
		   
	 	   Map<String ,Object> result= new HashMap<>();
	 	   try {
	 		    Orders ord = orderDao.findById(id).orElseThrow();
	 		    
	 		    ord.setPaid(paid.getPaidstatus());
	 		  System.out.println("us: "+ord);
	 		   orderDao.save(ord);
	 		   result.put("Status", "success");
	 		   result.put("data", ord);
	 		 
	 		   }catch(Exception e) {
	 			  e.printStackTrace();
					result.put("Status", "error");
					result.put("message", e.getMessage());   
	 		   }
	 	     return result;
	   	}
}
