package com.example.app_api.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.app_api.dto.Checkout;
import com.example.app_api.mapper.CheckoutMapper;

@Repository
public class CheckoutDaoImpl implements CheckoutDao {

	@Autowired
	CheckoutMapper chkmapper;
	
	@Override
	public Long createCheckout(Checkout chk) {
		
		chkmapper.createCheckout(chk);
		
		return chk.getChkId();
		
	}

	@Override
	public <CheckoutDetail> void createCheckoutDetail(CheckoutDetail chkDetail) {
		
		chkmapper.createCheckoutDetail(chkDetail);
	}


}
