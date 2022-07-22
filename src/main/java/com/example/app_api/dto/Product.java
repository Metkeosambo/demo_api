package com.example.app_api.dto;

public class Product {
	private Long proId;

	private String proName;
	
	private String proCode;
	
	private Integer quantity;
	
	private String createBy;

	private String createDate;

	private String updateBy;

	private String updateDate;
	
	public Product() {
		super();
	}
	public Product(Long proId,String proName,String proCode, Integer quantity,String createBy,String updateBy) {
		super();
		this.proId = proId;
		this.proName = proName;
		this.proCode = proCode;
		this.quantity = quantity;
		this.createBy = createBy;
		this.updateBy = updateBy;
	}
	public Long getProId() {
		return proId;
	}

	public void setProId(Long proId) {
		this.proId = proId;
	}
	
	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getProCode() {
		return proCode;
	}

	public void setProCode(String proCode) {
		this.proCode = proCode;
	}
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
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
	
	
	
	@Override
	public String toString() {
		return "Product [proName=" + proName +",proCode="+proCode+",qty="+quantity+ ", createBy=" + createBy + ", updateBy=" + updateBy + "]";
	}
}
