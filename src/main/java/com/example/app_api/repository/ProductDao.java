package com.example.app_api.repository;

import java.util.List;

import com.example.app_api.dto.Product;


public interface ProductDao {
	public Product createProduct( Product pro);
	
	public Product getProduct(Long userId);
	
	public Product updateProduct(Product pro);
	
	public void updateProductQty(Product pro);
	
	public List<Product> getAllProduct();
}
