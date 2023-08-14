package com.jayesh.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jayesh.daos.BranchDao;
import com.jayesh.daos.CustomerDao;
import com.jayesh.daos.ReviewDao;
import com.jayesh.entites.Branch;
import com.jayesh.entites.Customers;
import com.jayesh.entites.Review;
@CrossOrigin
@RestController
public class ReviewController {
	@Autowired
	private ReviewDao reviewdao;
	@Autowired
	private CustomerDao customerdao;
	@Autowired
	private BranchDao branchdao;
	@GetMapping("/review")
	public Map<String,Object> getAllReview() {
		Map<String,Object> result = new HashMap<>();
	    List<Review>rlist = reviewdao.findAll();
	    result.put("status", "success");
	    result.put("data", rlist);
		return result;
		}
	
	@PostMapping("addreview/{cid}/{bid}")
	public Map<String,Object> addReviewByCustomerId(@PathVariable("cid")int cid,@PathVariable("bid")int bid, @RequestBody Review rev){
		Map<String, Object> result = new HashMap<String, Object>();
		 try {
			
			Customers cus =customerdao.findById(cid).orElseThrow();
			Branch br = branchdao.findById(bid).orElseThrow();
			System.out.println(cus);
			System.out.println(br);
			Review r = new Review(rev.getrId(),rev.getReview(),cus,br);
			Review review = reviewdao.save(r); 
			result.put("data", review);
			result.put("status", "success");
			
		 }catch (Exception e) {
			 result.put("Status", "error");
				result.put("message", e.getMessage()); 
		}
		return result;
		
	}

	
}
