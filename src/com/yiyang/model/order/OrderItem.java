package com.yiyang.model.order;

import com.opensymphony.xwork2.ActionSupport;
import com.yiyang.model.order.Order;

public class OrderItem extends ActionSupport{
	protected Integer id;// ��Ʒ��Ŀ���
	protected Integer productId;// ��Ʒid
	protected String productName;// ��Ʒ����
	protected Float productMarketprice;// �г��۸�
	protected Float productPrice;// ��Ʒ���ۼ۸�
	protected Integer amount=1;// ��������
	protected Order order;// ��������
	protected String primPic;
	public String getPrimPic() {
		return primPic;
	}
	public void setPrimPic(String primPic) {
		this.primPic = primPic;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Float productPrice) {
		this.productPrice = productPrice;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Float getProductMarketprice() {
		return productMarketprice;
	}
	public void setProductMarketprice(Float productMarketprice) {
		this.productMarketprice = productMarketprice;
	}
}
