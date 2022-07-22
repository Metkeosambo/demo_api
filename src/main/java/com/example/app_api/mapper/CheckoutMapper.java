package com.example.app_api.mapper;


import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.example.app_api.dto.Checkout;


@Mapper
public interface CheckoutMapper {

	@Insert("insert into checkout (user_id,created_by,create_date) values (#{userId},#{createBy},CURRENT_TIMESTAMP())")
	@SelectKey(statement="select max(checkout_id) from checkout", keyProperty="chkId", before=false, resultType=long.class)
	public Long createCheckout(Checkout chk);
	
	@Insert("insert into checkout_detail (checkout_id,product_id,quantity,created_by,create_date) values (#{chkId},#{proId},#{quantity},#{createBy},CURRENT_TIMESTAMP())")
	public <CheckoutDetail> void createCheckoutDetail(CheckoutDetail chkDetail);
	
}
