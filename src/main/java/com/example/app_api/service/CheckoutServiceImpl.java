package com.example.app_api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.server.ResponseStatusException;

import com.example.app_api.dto.Checkout;
import com.example.app_api.dto.CheckoutDetail;
import com.example.app_api.dto.Product;
import com.example.app_api.repository.CheckoutDao;
import com.example.app_api.repository.ProductDao;
import com.example.app_api.util.LoggerConfig;
import com.example.app_api.util.Validation;

@Service
public class CheckoutServiceImpl implements CheckoutService {

	private final PlatformTransactionManager transactionManager;
	public CheckoutServiceImpl(PlatformTransactionManager transactionManager) {
	    this.transactionManager = transactionManager;
	  }
	@Autowired
	CheckoutDao chkDao;
	@Autowired
	ProductDao proDao;
	@Override
	public void createCheckout(Checkout chk) {
		TransactionStatus txStatus =
		        transactionManager.getTransaction(new DefaultTransactionDefinition());
		try {
			Long id =chkDao.createCheckout(chk);
			
			chk.getCheckoutDetail().forEach((temp) -> {
				if(Validation.Isempty(temp.getProId()==null?"":temp.getProId().toString())==false && Validation.Isempty(temp.getQty()==null?"":temp.getQty().toString())==false) {
					chkDao.createCheckoutDetail(new CheckoutDetail(temp.getChkDetailId(), id, temp.getProId(), temp.getQty(), temp.getCreateBy(), null)); 
					// cut Qty
					proDao.updateProductQty(new Product(temp.getProId(), null, null, temp.getQty(), null, null) );
				}else {
					throw new ResponseStatusException(
					   HttpStatus.BAD_REQUEST, "Invalid Paramater");
				}		
	        });
		    } catch (Exception e) {
		      LoggerConfig.setError(CheckoutServiceImpl.class.toString(), e.getMessage());
		      transactionManager.rollback(txStatus);
		      throw e;
		    }
		    transactionManager.commit(txStatus);	
	}

//	@Override
//	public <CheckoutDetail> void createCheckoutDetail(CheckoutDetail chkDetail) {
//		TransactionStatus txStatus =
//		        transactionManager.getTransaction(new DefaultTransactionDefinition());
//		try {
//			chkDao.createCheckoutDetail(chkDetail);
//		    } catch (Exception e) {
//		      LoggerConfig.setError(ProductServiceImpl.class.toString(), e.getMessage());
//		      transactionManager.rollback(txStatus);
//		      throw e;
//		    }
//		    transactionManager.commit(txStatus);
//
//	}

}
