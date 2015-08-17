package com.yiyang.action.order;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.yiyang.model.order.OrderItem;
import com.yiyang.service.order.CartService;

public class CartAction extends OrderItem implements ServletRequestAware{

    protected HttpServletRequest request;

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	
	// 清空购物车
	public String clear() throws Exception {
			request.getSession().removeAttribute("cart");
			return "list";
			}
	
	// 从session中取出购物车
		@SuppressWarnings("unchecked")
		protected Set<OrderItem> getCart(){
			Object obj = request.getSession().getAttribute("cart");
			if(obj == null){
				return new HashSet<OrderItem>();
			}else{
				return (Set<OrderItem>) obj;
			}
		}

		//从购物车中删除商品
		public String delete() throws Exception {
			Set<OrderItem> cart = getCart();// 获取购物车
			// 此处使用Iterator，否则出现java.util.ConcurrentModificationException
			CartService cartservice =new CartService();
			cart=cartservice.delete(cart, productId);
			Iterator<OrderItem> it = cart.iterator();
			if(it.hasNext()){
				request.getSession().setAttribute("cart", cart);//将清空后的信息重新放入Session中
			}else{
				request.getSession().removeAttribute("cart");
			}		
			return "list";//返回购物车页面
		}
		
		// 查看购物车
		public String list() throws Exception {
			Set<OrderItem> cart = getCart();// 获取购物车
			Iterator<OrderItem> it = cart.iterator();
			if(it.hasNext()){
				request.getSession().setAttribute("cart", cart);//将清空后的信息重新放入Session中
			}else{
				request.getSession().removeAttribute("cart");
			}		
			System.out.println(request.getSession().getAttribute("userName"));
			return "list";//返回购物车页面
		}
		
		// 向购物车中添加商品
		public String add() throws Exception {
			System.out.println(productId);
			 System.out.println("productid:"+request.getParameter("id"));
			 System.out.println("num:"+request.getParameter("num"));
			productId= Integer.parseInt(request.getParameter("id"));
			amount =Integer.parseInt(request.getParameter("num"));
			if(productId != null && productId > 0){
				// 获取购物车
			    Set<OrderItem> cart = getCart();
				// 标记添加的商品是否是同一件商品
			    CartService cartservice =new CartService();
			   
			    cart=cartservice.add(cart, productId,amount);
				request.getSession().setAttribute("cart", cart);
					}
				return "add";
				}
		
		
}
