package com.example.app_api.controller;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.app_api.dto.User;

import com.example.app_api.mapper.UserMapper;
import com.example.app_api.service.UserService;
import com.example.app_api.util.LoggerConfig;
import com.example.app_api.util.Validation;

@MapperScan(basePackages = "com.example.app_api.mapper")
@RestController
@RequestMapping("/user")
public class UserController {
	//private static Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserService userService;
	
	@Autowired
	UserMapper userMapper;
	
	@RequestMapping(value="/createuser",headers = {
    "content-type=application/json" }, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public User createUser(@RequestBody User user){
		try {
			if(Validation.Isempty(user.getUserName())==false) {//Example for check empty paramater
				
				return userService.createUser(user);
				
			}else {
				
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Paramater");
			}
		}catch(Exception ex) {
			
			LoggerConfig.setError(UserController.class.toString(), ex.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
		
	}	
	
	@RequestMapping(value="/getuser/{userId}",method = RequestMethod.GET)
	public User getUser(@PathVariable Long userId){
		
		LoggerConfig.setInfo(UserController.class.toString(), "Call Service User");
		return userService.getUser(userId);
	}
	@RequestMapping(value="/getall",method = RequestMethod.GET)
	public List<User> getAllUser(){
		
		//List<User> userWithLinks= new ArrayList<>();
		List<User> user = userService.getAllUser();
//		if(!CollectionUtils.isEmpty(user) ){
//			for(User u : user){
//				
//				Link getEmplink = ControllerLinkBuilder.linkTo(EmployeeController.class).slash("getEmp").slash(emp.getEmpId()).withSelfRel();
//				Link delEmplink = ControllerLinkBuilder.linkTo(EmployeeController.class).slash("delEmp")
//						.slash(u.).withRel("delete employee").withMedia("PUT").withTitle("delete employee");
//				
//				u.add(getEmplink);
//				u.add(delEmplink);
//				userWithLinks.add(u);
//			}
//		}
		return user;
	}
}
