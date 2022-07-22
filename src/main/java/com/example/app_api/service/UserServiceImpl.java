package com.example.app_api.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.example.app_api.controller.UserController;
import com.example.app_api.dto.User;

import com.example.app_api.repository.UserDao;
import com.example.app_api.util.LoggerConfig;

@Service
public class UserServiceImpl implements UserService {
	private final PlatformTransactionManager transactionManager;
	public UserServiceImpl(PlatformTransactionManager transactionManager) {
	    this.transactionManager = transactionManager;
	  }
	@Autowired
	UserDao userDao;
	
	@Override
	public User createUser(User user) {
		TransactionStatus txStatus =
		        transactionManager.getTransaction(new DefaultTransactionDefinition());
		//return userDao.createUser(user);
		User u = new User();
		try {
			  u = userDao.createUser(user);
		    } catch (Exception e) {
		      LoggerConfig.setError(UserServiceImpl.class.toString(), e.getMessage());
		      transactionManager.rollback(txStatus);
		      throw e;
		    }
		    transactionManager.commit(txStatus);
		    return u;	    
	}

	@Override
	public User getUser(Long userId) {
		return userDao.getUser(userId);
	}

	@Override
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}
}
