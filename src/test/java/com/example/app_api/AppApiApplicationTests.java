package com.example.app_api;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.app_api.mapper.ProductMapper;
import com.example.app_api.mapper.UserMapper;
import com.example.app_api.service.CheckoutService;
import com.example.app_api.service.ProductService;
import com.example.app_api.service.UserService;
import com.example.app_api.dto.Checkout;
import com.example.app_api.dto.CheckoutDetail;
import com.example.app_api.dto.Product;
import com.example.app_api.dto.User;
import com.example.app_api.mapper.CheckoutMapper;
@SpringBootTest
class AppApiApplicationTests {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	UserService userService;
	
	@Autowired
	UserMapper userMapper;
	
	void RunTestUser() {
		
		logger.info("Inserting -> {}", userService.createUser(new User( null, "Sopheak", "M", "21-01-1998", "Junit", null)));
		
		logger.info("Fine ID 1-> {}", userService.getUser((long)1));
		
		logger.info("all user-> {}", userService.getAllUser());
	}
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ProductMapper productMapper;
	@Test
	void RunTestProdcut() {
		
		logger.info("Inserting -> {}", productService.createProduct(new Product(null, "Pepsi", "QQAA111", 200, "Junit", null)));
		
		logger.info("Fine ID 1-> {}", productService.getProduct((long) 1));
		
		logger.info("all product-> {}", productService.getAllProduct());
		
		logger.info("Update by 1 -> {}", productService.updateProduct(new Product((long)1, "Pepsi", "QQAA222", 20, null, "System")));
	}
	
	@Autowired
	CheckoutService checkoutService;
	
	@Autowired
	CheckoutMapper CheckoutMapper;
	@Test
	void RunTestCheckout() {
		CheckoutDetail chkd1 = new CheckoutDetail();
		chkd1.setProId((long) 1);
		chkd1.setQty(2);
		chkd1.setCreateBy("Junit");
		
		CheckoutDetail chkd2 = new CheckoutDetail();
		chkd2.setProId((long) 1);
		chkd2.setQty(5);
		chkd2.setCreateBy("Junit");
		ArrayList<CheckoutDetail> detail = new ArrayList<>();
		detail.add(chkd1);
		detail.add(chkd2);
		checkoutService.createCheckout(new Checkout(null,(long) 1, "Sopheak", null, detail));
	}

}
