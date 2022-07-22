package com.example.app_api.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.app_api.dto.Product;
import com.example.app_api.mapper.ProductMapper;

@Repository
public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	ProductMapper promapper;
	
	@Override
	public Product createProduct(Product pro) {
		Long newProId = promapper.createProduct(pro);
		return getProduct(pro.getProId());
	}
	@Override
	public Product getProduct(Long proId) {
		return promapper.getProduct(proId);
	}
	@Override
	public Product updateProduct(Product pro) {
		promapper.updateProduct(pro);
		return getProduct(pro.getProId());
	}
	@Override
	public void updateProductQty(Product pro) {
		promapper.updateProductQty(pro);
		//return getProduct(pro.getProId());
	}
	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return promapper.getAllProduct();
	}
}
