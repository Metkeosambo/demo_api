package com.example.app_api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.app_api.dto.Checkout;
import com.example.app_api.dto.Product;
import com.example.app_api.dto.User;
import com.example.app_api.mapper.CheckoutMapper;

import com.example.app_api.service.CheckoutService;
import com.example.app_api.util.LoggerConfig;
import com.example.app_api.util.Validation;
import com.fasterxml.jackson.databind.ObjectMapper;


@MapperScan(basePackages = "com.example.app_api.mapper")
@RestController
@RequestMapping("/checkout")
public class CheckoutController {

	@Autowired
	CheckoutService chkService;
	
	@Autowired
	CheckoutMapper chkMapper;
	@RequestMapping(value="/add",headers = {
    "content-type=application/json" }, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> CreateCheckout(@RequestBody Checkout chk){
		try {
			if(Validation.Isempty(chk.getUserId().toString())==false) {//Example for check empty paramater
				chkService.createCheckout(chk);
				return new ResponseEntity<>(HttpStatus.OK);
			}else {
				throw new ResponseStatusException(
				           HttpStatus.BAD_REQUEST, "Invalid Paramater");
			}
//		String body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
//		ObjectMapper mapper = new ObjectMapper();
//		Checkout myObjects = mapper.readValue(body, Checkout.class);
//		System.out.println(myObjects);
		//return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception ex) {
			LoggerConfig.setError(ProductController.class.toString(), ex.getMessage());
			throw new ResponseStatusException(
			           HttpStatus.BAD_REQUEST, ex.getMessage());
		}
		
	}	

}
