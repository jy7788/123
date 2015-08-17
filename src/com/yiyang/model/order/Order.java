package com.yiyang.model.order;

import java.util.Date;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;
import com.yiyang.model.order.OrderItem;
import com.yiyang.model.user.Customer;

public class Order extends ActionSupport{
	protected String orderId;// 订单编号(手动分配)
	protected Customer customer;// 所属用户
	protected String name;// 收货人姓名
	protected String address;// 收货人住址
	protected String mobile;// 收货人手机
	protected Set<OrderItem> orderItems;// 所买商品
	protected Float totalPrice;// 总额
	protected String paymentWay;// 支付方式
	protected String orderState;// 订单状态
	protected Date createTime = new Date();// 创建时间
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
