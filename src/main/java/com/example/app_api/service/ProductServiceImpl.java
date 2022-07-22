package com.example.app_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.example.app_api.dto.Product;

import com.example.app_api.repository.ProductDao;

import com.example.app_api.util.LoggerConfig;

@Service
public class ProductServiceImpl implements ProductService {

	private final PlatformTransactionManager transactionManager;
	public ProductServiceImpl(PlatformTransactionManager transactionManager) {
	    this.transactionManager = transactionManager;
	  }
	@Autowired
	ProductDao proDao;
	@Override
	public Product createProduct(Product pro) {
		TransactionStatus txStatus =
		        transactionManager.getTransaction(new DefaultTransactionDefinition());
		Product u = new Product();
		try {
			  u = proDao.createProduct(pro);
		    } catch (Exception e) {
		      LoggerConfig.setError(ProductServiceImpl.class.toString(), e.getMessage());
		      transactionManager.rollback(txStatus);
		      throw e;
		    }
		    transactionManager.commit(txStatus);
		    return u;	
	}

	@Override
	public Product getProduct(Long proId) {
		return proDao.getProduct(proId);
	}

	@Override
	public Product updateProduct(Product pro) {
		TransactionStatus txStatus =
		        transactionManager.getTransaction(new DefaultTransactionDefinition());
		//return userDao.createUser(user);
		Product u = new Product();
		try {
			  u = proDao.updateProduct(pro);
		    } catch (Exception e) {
		      LoggerConfig.setError(ProductServiceImpl.class.toString(), e.getMessage());
		      transactionManager.rollback(txStatus);
		      throw e;
		    }
		    transactionManager.commit(txStatus);
		    return u;	
	}
	@Override
	public void updateProductQty(Product pro) {
		TransactionStatus txStatus =
		        transactionManager.getTransaction(new DefaultTransactionDefinition());

		try {
			  proDao.updateProductQty(pro);
		    } catch (Exception e) {
		      LoggerConfig.setError(ProductServiceImpl.class.toString(), e.getMessage());
		      transactionManager.rollback(txStatus);
		      throw e;
		    }
		    transactionManager.commit(txStatus);
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return proDao.getAllProduct();
	}

}
