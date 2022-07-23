package com.example.app_api.repository;

import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.app_api.dto.User;
import com.example.app_api.mapper.UserMapper;

@Repository
public class UserDaoImpl implements UserDao {
	//private static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	@Autowired
	UserMapper usermapper;
	
	@Override
	public User createUser(User user) {
		
		Long newUserId = usermapper.createUser(user);
		return getUser(user.getUserId());
		
	}
	@Override
	public User getUser(Long userId) {
		
		return usermapper.getUser(userId);
		
	}
	@Override
	public List<User> getAllUser() {
		
		return usermapper.getAllUser();
		
	}
}
