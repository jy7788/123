package com.yiyang.action.product;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.yiyang.dao.ObjectDao;
import com.yiyang.model.product.Product;
import com.yiyang.service.product.ProductService;
import com.yiyang.util.Condition;
import com.yiyang.util.Page;

public class ShopAction extends Condition implements SessionAware,ServletRequestAware{

	protected Map<String, Object> session;
	protected HttpServletRequest request;
	private Condition condition = new Condition();
	private Page page;

	public ShopAction()
	{
		page = new Page();
		page.setCurrentPage(1);
	}

	public String shopInit()
	{
		ProductService productService = new ProductService();
		if(categoryId>0)
		{
			condition.categoryId = categoryId;
		}
		List<Object> brandList = productService.getBrand(condition.categoryId);
		List<Object> specifiList = productService.getSpecifi(condition.categoryId);
		String hql = hqlGenerate(condition);
		ObjectDao<Product> objectDao = new ObjectDao<Product>();
		objectDao.queryTocalCount(page, hql);
		session.put("condition", condition);		
		session.put("brandList", brandList);
		session.put("specifiList", specifiList);
		return "success";		
	}	
	
	@Override
	public void setSession(Map<String, Object> session) 
	{
		this.session=session;
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;		
	}	
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
}
