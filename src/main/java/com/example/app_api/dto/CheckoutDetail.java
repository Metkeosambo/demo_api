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
	@JsonProperty("createby")
	private String createBy;
	@JsonProperty("createdate")
	private String createDate;
	@JsonProperty("updateBy")
	private String updateBy;
	@JsonProperty("updateDate")
	private String updateDate;
	public CheckoutDetail() {
		super();
	}
	public CheckoutDetail(Long chkDetailId,Long chkId,Long proId,Integer quantity,String createBy,String updateBy) {
		super();
		this.chkDetailId = chkDetailId;
		this.chkId = chkId;
		this.proId = proId;
		this.quantity = quantity;
		this.createBy = createBy;
		this.updateBy = updateBy;
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
}