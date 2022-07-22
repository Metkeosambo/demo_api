package com.example.app_api.dto;

//import javax.persistence.Column;
//
//import com.fasterxml.jackson.annotation.JsonProperty;

public class User{
	
	private Long userId;

	private String userName;

	private String gender;

	private String dob;

	private String createBy;

	private String createDate;

	private String updateBy;

	private String updateDate;
	
	public User() {
		super();
	}
	public User(Long userId,String userName, String gender, String dob, String createBy,String updateBy) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.gender = gender;
		this.dob = dob;
		this.createBy = createBy;
		this.updateBy = updateBy;
	}
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
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
		return "User [userName=" + userName +"gender="+gender+ ", dob=" + dob + ", createBy=" + createBy + ", updateBy=" + updateBy + "]";
	}
}
