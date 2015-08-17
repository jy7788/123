package com.yiyang.model.appointment;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class Appointment extends ActionSupport {

	protected Integer id;// �û����
	protected Date createTime = new Date();// ����ʱ��
	protected String realName;// ��ʵ����
	protected String address;// סַ
	protected String occupy;//���
	protected String mobile;// �ֻ�
	protected String sex;
	protected String requirement;
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOccupy() {
		return occupy;
	}
	public void setOccupy(String occupy) {
		this.occupy = occupy;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getRequirement() {
		return requirement;
	}
	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}
}
