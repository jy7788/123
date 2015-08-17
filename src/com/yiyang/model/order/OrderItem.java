package com.yiyang.model.order;

import com.opensymphony.xwork2.ActionSupport;
import com.yiyang.model.order.Order;

public class OrderItem extends ActionSupport{
	protected Integer id;// 商品条目编号
	protected Integer productId;// 商品id
	protected String productName;// 商品名称
	protected Float productMarketprice;// 市场价格
	protected Float productPrice;// 商品销售价格
	protected Integer amount=1;// 购买数量
	protected Order order;// 所属订单
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
