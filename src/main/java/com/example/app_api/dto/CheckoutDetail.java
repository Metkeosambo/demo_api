package com.example.app_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

//====================== class checkout detail
public class CheckoutDetail{
	
	@JsonProperty("chkdetailid")
	private Long chkDetailId;
	
	@JsonProperty("chkid")
	private Long chkId;
	
	@JsonProperty("proid")
	private Long proId;
	
	@JsonProperty("quantity")
	private Integer quantity;
	
	public CheckoutDetail() {
		super();
	}
	public CheckoutDetail(Long chkDetailId,Long chkId,Long proId,Integer quantity) {
		super();
		this.chkDetailId = chkDetailId;
		this.chkId = chkId;
		this.proId = proId;
		this.quantity = quantity;
	}
	public Long getChkDetailId() {
		return chkDetailId;
	}

	public void setChkDetailId(Long chkDetailId) {
		this.chkDetailId = chkDetailId;
	}
	public Long getChkId() {
		return chkId;
	}

	public void setChkId(Long chkId) {
		this.chkId = chkId;
	}
	public Long getProId() {
		return proId;
	}

	public void setProId(Long proId) {
		this.proId = proId;
	}
	
	public Integer getQty() {
		return quantity;
	}

	public void setQty(Integer quantity) {
		this.quantity = quantity;
	}
}
