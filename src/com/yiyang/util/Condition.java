package com.yiyang.util;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public class Condition{
	
	public int categoryId;
	public String brand;
	public String specifi;
	public String order;
	protected Map<String, Object> session;
	protected HttpServletRequest request;
	Condition condition;
	
	public Condition()
	{
		this.categoryId=1;
		this.brand="all";
		this.specifi="all";
		this.order="all";
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSpecifi() {
		return specifi;
	}

	public void setSpecifi(String specifi) {
		this.specifi = specifi;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}	
	
	public String hqlGenerate(Condition condition)
	{
		String hql = "from Product";
		if(condition.getCategoryId()>0)
		{
			hql = hql + " where category.id = '"+condition.getCategoryId()+"'";
		}
		if(!condition.getBrand().equals("all"))
		{
			hql = hql + " and brand = '"+condition.getBrand()+"'";
		}
		if(!condition.getSpecifi().equals("all"))
		{
			hql = hql + " and specifi = '"+condition.getSpecifi()+"'";
		}
		if(condition.getOrder().equals("price"))
		{
			hql = hql + " order by sellPrice asc";
		}
		else if(condition.getOrder().equals("sellCount"))
		{
			hql = hql + " order by sellCount desc";
		}
		return hql;
	}
}
