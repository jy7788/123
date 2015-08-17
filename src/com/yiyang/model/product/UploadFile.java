package com.yiyang.model.product;

import com.opensymphony.xwork2.ActionSupport;

public class UploadFile extends ActionSupport {

	private static final long serialVersionUID = 1L;
	protected int id;
	protected String path;
	protected Product product;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}
