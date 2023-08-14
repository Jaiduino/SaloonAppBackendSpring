package com.jayesh.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jayesh.daos.ProductDao;
import com.jayesh.dtos.ProductDto;
import com.jayesh.entites.Products;
@CrossOrigin
@RestController
public class ProductController {

	@Autowired
	private ProductDao productDao;
	
	@GetMapping("/allproducts")
	public Map<String,Object> getAllProducts() {
		Map<String,Object> presult = new HashMap<>();
		  List<Products> plist=productDao.findAll();
		  presult.put("status","success");
		  presult.put("data", plist);
		return presult;
	}
	@PostMapping("/addProduct")
	public Map<String,Object> addProduct(@RequestBody Products prod) {
		Map<String,Object> presult = new HashMap<>();
		  try {
		   Products productdb=productDao.save(prod);
		   presult.put("status","success");
		   presult.put("data", productdb);
		  }catch(Exception e)
		  {
			  e.printStackTrace();
			  presult.put("status","error");
			  presult.put("message",e.getMessage());
			  
		  }
		   return presult;
		
	}
	 @GetMapping("/maleProducts")
	 public Map<String,Object> getMaleProducts()
	 {
		 Map<String,Object> result= new HashMap<>();
		 try {
			List<Products> mlist = productDao.getBygender("Male");
			 result.put("Status", "success");
			 result.put("data",mlist);
		 }catch (Exception e)
		 {
			 e.printStackTrace();
				result.put("Status", "error");
				result.put("message", e.getMessage()); 
		 }
		return result;
	 }
	 
	 @GetMapping("/femaleProducts")
	 public Map<String,Object> getFemaleProducts()
	 {
		 Map<String,Object> result= new HashMap<>();
		 try {
			List<Products> Flist = productDao.getBygender("Female");
			 result.put("Status", "success");
			 result.put("data",Flist);
		 }catch (Exception e)
		 {
			 e.printStackTrace();
				result.put("Status", "error");
				result.put("message", e.getMessage()); 
		 }
		return result;
	 }
	 
	 @GetMapping("/Products_Category/{product_Id}")
	 public Map<String,Object> getByCategory(@PathVariable("product_Id") String pid){
		 
		 Map<String,Object> result = new HashMap<>();
		 try {
	  
		List<Products> plist= productDao.findByIdStartsWith(pid);
			 //List<Products>plist= productDao.findByproduct_IdStartsWith("P");
	System.out.println(pid);
		 result.put("Status", "success");
		 result.put("data", plist); 	
		 }catch(Exception e) {
			 result.put("Status", "error");
			 result.put("message", e.getMessage()); 
		 }
		return result;
	 }
}
