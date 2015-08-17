package com.yiyang.model.product;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import com.opensymphony.xwork2.ActionSupport;

public class Product extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	protected int id;
	protected String name;
	protected String description;
	protected Date createTime = new Date();
	protected Float basePrice;
	protected Float marketPrice;
	protected Float sellPrice;
	protected boolean commend = false;
	protected int clickCount;
	protected int sellCount;
	protected String specifi;
	protected String brand;
	protected String modelNum;
	protected String unit;
	protected String primPic;
	public String getPrimPic() {
		return primPic;
	}
	public void setPrimPic(String primPic) {
		this.primPic = primPic;
	}
	protected Set<UploadFile> uploadfiles = new TreeSet<UploadFile>();
	protected ProductCategory category;
	public ProductCategory getCategory() {
		return category;
	}
	public void setCategory(ProductCategory category) {
		this.category = category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Float getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(Float basePrice) {
		this.basePrice = basePrice;
	}
	public Float getMarketPrice() {
		return marketPrice;
	}
	public void setMarketPrice(Float marketPrice) {
		this.marketPrice = marketPrice;
	}
	public Float getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(Float sellPrice) {
		this.sellPrice = sellPrice;
	}
	public boolean isCommend() {
		return commend;
	}
	public void setCommend(boolean commend) {
		this.commend = commend;
	}
	public int getClickCount() {
		return clickCount;
	}
	public void setClickCount(int clickCount) {
		this.clickCount = clickCount;
	}
	public int getSellCount() {
		return sellCount;
	}
	public void setSellCount(int sellCount) {
		this.sellCount = sellCount;
	}
	public String getSpecifi() {
		return specifi;
	}
	public void setSpecifi(String specifi) {
		this.specifi = specifi;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModelNum() {
		return modelNum;
	}
	public void setModelNum(String modelNum) {
		this.modelNum = modelNum;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Set<UploadFile> getUploadfiles() {
		return uploadfiles;
	}
	public void setUploadfiles(Set<UploadFile> uploadfiles) {
		this.uploadfiles = uploadfiles;
	}	
}
