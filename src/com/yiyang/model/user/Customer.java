package com.yiyang.model.user;

import com.opensymphony.xwork2.ActionSupport;

public class Customer extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Integer id;// �û����
	protected String userName;// �û���
	protected String password;// ����
	protected String rePassword;
	protected String realName;// ��ʵ����
	protected String email;// ����
	protected String address;// סַ
	protected String mobile;// �ֻ�
	protected String code;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRePassword() {
		return rePassword;
	}
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}	
}
