package com.yiyang.model.order;

import java.util.Date;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;
import com.yiyang.model.order.OrderItem;
import com.yiyang.model.user.Customer;

public class Order extends ActionSupport{
	protected String orderId;// �������(�ֶ�����)
	protected Customer customer;// �����û�
	protected String name;// �ջ�������
	protected String address;// �ջ���סַ
	protected String mobile;// �ջ����ֻ�
	protected Set<OrderItem> orderItems;// ������Ʒ
	protected Float totalPrice;// �ܶ�
	protected String paymentWay;// ֧����ʽ
	protected String orderState;// ����״̬
	protected Date createTime = new Date();// ����ʱ��
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public Float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getPaymentWay() {
		return paymentWay;
	}
	public void setPaymentWay(String paymentWay) {
		this.paymentWay = paymentWay;
	}
	public String getOrderState() {
		return orderState;
	}
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
