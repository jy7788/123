package com.yiyang.action.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.yiyang.model.user.Customer;
import com.yiyang.service.user.UserService;

public class UserAction extends ActionSupport implements ServletRequestAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Customer customer;
	protected HttpServletRequest request;
	
	public String login()
	{
		UserService userService = new UserService();		
		if(userService.login(customer.getUserName(),customer.getPassword()))
		{
			request.getSession().setAttribute("userName",customer.getUserName());
			return "success";
		}
		else
		{
			return "input";
		}
	}
	
	public String register()
	{
		UserService userService = new UserService();
		if(!userService.exist(customer))
		{
			userService.register(customer);
			return "success";
		}
		else
		{
			this.addFieldError("customer.userName", "用户名已存在");
			return "input";
		}
	}
	
	public String safeQuit()
	{
		request.getSession().removeAttribute("userName");
		request.getSession().removeAttribute("condition");
		return "success";
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
}
