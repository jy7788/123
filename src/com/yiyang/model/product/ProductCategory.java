package com.yiyang.model.product;

import java.util.Set;
import java.util.TreeSet;

import com.opensymphony.xwork2.ActionSupport;

public class ProductCategory extends ActionSupport {

	private static final long serialVersionUID = 1L;
	protected int id;
	protected String name;
	protected int level;
	protected int pid;
	protected Set<Product> products = new TreeSet<Product>();// °üº¬ÉÌÆ·	
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
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}	
}
