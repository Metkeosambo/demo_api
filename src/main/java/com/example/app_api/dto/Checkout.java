package com.example.app_api.dto;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Checkout {
	private Long chkId;

	private Long userId;
	
	private String createBy;

	private String createDate;

	private String updateBy;

	private String updateDate;
	
	@JsonProperty("chkdetail")
	private ArrayList<CheckoutDetail> chkDetail ;
	
	public Checkout() {
		super();
	}
	public Checkout(Long chkId,Long userId,String createBy,String updateBy,ArrayList<CheckoutDetail> chkDetail) {
		super();
		this.chkId = chkId;
		this.userId = userId;
		this.createBy = createBy;
		this.updateBy = updateBy;
		this.chkDetail = chkDetail;
	}
	public Long getChkId() {
		return chkId;
	}

	public void setChkId(Long chkId) {
		this.chkId = chkId;
	}
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
	public ArrayList<CheckoutDetail> getCheckoutDetail(){
	    return this.chkDetail;
	}

	public void setCheckoutDetail(ArrayList<CheckoutDetail> chkDetail){
	    this.chkDetail = chkDetail;
	}
//	@Override
//	public String toString() {
//		return "Product [proName=" + proName +",proCode="+proCode+",qty="+quantity+ ", createBy=" + createBy + ", updateBy=" + updateBy + "]";
//	}
}

