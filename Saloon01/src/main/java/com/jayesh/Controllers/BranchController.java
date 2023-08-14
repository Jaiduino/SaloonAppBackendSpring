package com.jayesh.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jayesh.daos.BranchDao;
import com.jayesh.daos.OrderDao;
import com.jayesh.entites.Branch;
import com.jayesh.entites.Orders;
import com.jayesh.entites.Review;
@CrossOrigin
@RestController
public class BranchController {

	@Autowired()
	private BranchDao branchDao;
	
	@Autowired
	private OrderDao orderdao;
	
	@GetMapping("/branch")
	private Map<String,Object> getAllBranch() {
		Map<String,Object> result = new HashMap<>();
	    List<Branch>blist = branchDao.findAll();
	    System.out.println(blist);
	    result.put("status", "success");
	    result.put("data", blist);
		return result;
		
	}
	@GetMapping("/branch/{branch_Id}")
	private Map<String, Object> getOrders(@PathVariable("branch_Id") int id){
		Map<String,Object> result = new HashMap<String, Object>();
	   try{
		   System.out.println(id);
		   Branch b = branchDao.findById(id).orElseThrow();
		result.put("Status", "success");
		result.put("data", b);
	   }catch(Exception e) {
		   System.out.println("BranchController");
		   
	   }
		return result;
		
	}
	@GetMapping("viewreviewbybranch/{bid}")
	public Map<String,Object> getReviewBybranch(@PathVariable("bid")int bid){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Branch b = branchDao.findById(bid).orElseThrow();
			
			System.out.println(b);
			result.put("data", b);
			result.put("status", "success");
		}catch (Exception e) {
			result.put("Status", "error");
			result.put("message", e.getMessage()); 
		}
		return result;
	}
	
}