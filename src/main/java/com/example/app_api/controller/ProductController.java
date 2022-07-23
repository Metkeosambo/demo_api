package com.example.app_api.controller;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.app_api.dto.Product;
import com.example.app_api.dto.User;
import com.example.app_api.mapper.ProductMapper;
import com.example.app_api.service.ProductService;
import com.example.app_api.util.LoggerConfig;
import com.example.app_api.util.Validation;

@MapperScan(basePackages = "com.example.app_api.mapper")
@RestController
@RequestMapping("/pro")
public class ProductController {
	
	@Autowired
	ProductService proService;
	
	@Autowired
	ProductMapper proMapper;
	
	@RequestMapping(value="/create",headers = {
    "content-type=application/json" }, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public Product createProduct(@RequestBody Product pro){
		try {
			if(Validation.Isempty(pro.getProName())==false) {//Example for check empty paramater
				
				return proService.createProduct(pro);
				
			}else {
				
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Paramater");
			}
		}catch(Exception ex) {
			
			LoggerConfig.setError(ProductController.class.toString(), ex.getMessage());
			throw new ResponseStatusException(
			           HttpStatus.BAD_REQUEST, ex.getMessage());
			
		}
		
	}	
	
	@RequestMapping(value="/get/{proId}",method = RequestMethod.GET)
	public Product getProduct(@PathVariable Long proId){
		
		LoggerConfig.setInfo(ProductController.class.toString(), "Call Service Product");
		
		return proService.getProduct(proId);
		
	}
	
	@RequestMapping(value="/update",headers = {
    "content-type=application/json" }, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public Product updateProduct(@RequestBody Product pro){
		try {
			if(Validation.Isempty(pro.getProName())==false||Validation.Isempty(pro.getProId().toString())==false) {//Example for check empty paramater
				
				return proService.updateProduct(pro);
				
			}else {
				
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Paramater");
				
			}
		}catch(Exception ex) {
			
			LoggerConfig.setError(ProductController.class.toString(), ex.getMessage());
			throw new ResponseStatusException(
			           HttpStatus.BAD_REQUEST, ex.getMessage());
			
		}
		
	}
	@RequestMapping(value="/getall",method = RequestMethod.GET)
	public List<Product> getAllProduct(){
		//List<User> userWithLinks= new ArrayList<>();
		List<Product> pro = proService.getAllProduct();
		return pro;
	}
}
