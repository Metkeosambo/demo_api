package com.example.app_api.service;

import java.util.List;

import com.example.app_api.dto.Product;

public interface ProductService {

	public Product createProduct( Product pro);
	
	public Product getProduct(Long proId);
	
	public Product updateProduct( Product pro);
	
	public void updateProductQty( Product pro);
	
	public List<Product> getAllProduct();
}
