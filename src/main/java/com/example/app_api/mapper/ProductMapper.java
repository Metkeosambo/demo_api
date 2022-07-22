package com.example.app_api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.example.app_api.dto.Product;

@Mapper
public interface ProductMapper {

	@Insert("insert into product (product_name,product_code,stock_quantity,created_by,create_date) values (#{proName},#{proCode},#{quantity},#{createBy},CURRENT_TIMESTAMP())")
	//@Options(useGeneratedKeys=true, keyProperty="userId")
	@SelectKey(statement="select max(product_id) from product", keyProperty="proId", before=false, resultType=long.class)
	public Long createProduct(Product pro);
	
	@Select("SELECT * FROM product  WHERE product_id = #{proId}")
	@Results({
		@Result(property = "proId", column = "product_id"),
	    @Result(property = "proName", column = "product_name"),
	    @Result(property = "proCode", column = "product_code"),
	    @Result(property = "quantity", column = "stock_quantity"),
	    @Result(property = "createBy", column = "created_by"),
	    @Result(property = "createDate", column = "create_date"),
	    @Result(property = "updateBy", column = "updated_by"),
	    @Result(property = "updateDate", column = "update_date"),
	    })
	public Product getProduct(@Param("proId") Long proId);
	
	@Update("update product set product_name=#{proName}, product_code=#{proCode}, stock_quantity=#{quantity},updated_by=#{updateBy},update_date=CURRENT_TIMESTAMP() where product_Id=#{proId}")
	public int updateProduct(Product pro);
	
	@Update("update product set stock_quantity=((select stock_quantity from product where product_id= #{proId}) - #{quantity}),updated_by= #{updateBy},update_date= CURRENT_TIMESTAMP() where product_id= #{proId}")
	public int updateProductQty(Product pro);
	
	@Select("select * from product")
	@Results({
		@Result(property = "proId", column = "product_id"),
	    @Result(property = "proName", column = "product_name"),
	    @Result(property = "proCode", column = "product_code"),
	    @Result(property = "quantity", column = "stock_quantity"),
	    @Result(property = "createBy", column = "created_by"),
	    @Result(property = "createDate", column = "create_date"),
	    @Result(property = "updateBy", column = "updated_by"),
	    @Result(property = "updateDate", column = "update_date")})
	public List<Product> getAllProduct();
}
