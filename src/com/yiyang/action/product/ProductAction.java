package com.yiyang.action.product;

import java.io.UnsupportedEncodingException;
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

public class ProductAction extends Condition implements SessionAware,ServletRequestAware{
	
	private Condition condition = new Condition();
	private Page page;
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
	public ProductAction()
	{
		page = new Page();
		page.setCurrentPage(1);
	}
	
	//高级查询
	public String searchPage() throws UnsupportedEncodingException
	{
		condition = getCondition();
		String hql = hqlGenerate(condition);
		ObjectDao<Product> objectDao = new ObjectDao<Product>();
		objectDao.queryTocalCount(page, hql);
		return "success";
	}	
	
	//按ID查找
	public String searchById()
	{
		if(!"".equals(request.getParameter("id")))
		{
			ProductService productService = new ProductService();
			List<Product> productList = productService.findById(Integer.parseInt(request.getParameter("id")));
			session.put("productList", productList);
			return "success";
		}
		return "error";
	}
	
	protected Map<String, Object> session;
	protected HttpServletRequest request;
	
	@Override
	public void setSession(Map<String, Object> session) 
	{
		this.session=session;
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;		
	}	
	
	public Condition getCondition() throws UnsupportedEncodingException
	{
		if(session.get("condition")==null)
		{
			condition = new Condition();
		}
		else
		{
			condition = (Condition) session.get("condition");
		}
		if(request.getParameter("categoryId")!=null)
		{
			condition.categoryId = categoryId;
		}
		if(request.getParameter("brand")!=null)
		{
			String urlBrand = (String) request.getParameter("brand");		
			condition.brand=new String(urlBrand.getBytes("ISO-8859-1"), "UTF-8");
		}
		if(request.getParameter("specifi")!=null)
		{
			String urlSpecifi = (String) request.getParameter("specifi");		
			condition.specifi=new String(urlSpecifi.getBytes("ISO-8859-1"), "UTF-8");
		}
		if(request.getParameter("order")!=null)
		{
			condition.order=order;
		}
		else if(request.getParameter("order")!=null)
		{
			condition.order=order;
		}
		session.put("condition", condition);
		return condition;
	}
}
