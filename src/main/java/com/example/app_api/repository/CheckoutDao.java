package com.example.app_api.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.app_api.dto.Checkout;

public interface CheckoutDao {

	public Long createCheckout( Checkout chk);
	
	public <CheckoutDetail> void createCheckoutDetail( CheckoutDetail chkDetail);
	
}
