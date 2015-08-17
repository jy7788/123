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
	
	// ��չ��ﳵ
	public String clear() throws Exception {
			request.getSession().removeAttribute("cart");
			return "list";
			}
	
	// ��session��ȡ�����ﳵ
		@SuppressWarnings("unchecked")
		protected Set<OrderItem> getCart(){
			Object obj = request.getSession().getAttribute("cart");
			if(obj == null){
				return new HashSet<OrderItem>();
			}else{
				return (Set<OrderItem>) obj;
			}
		}

		//�ӹ��ﳵ��ɾ����Ʒ
		public String delete() throws Exception {
			Set<OrderItem> cart = getCart();// ��ȡ���ﳵ
			// �˴�ʹ��Iterator���������java.util.ConcurrentModificationException
			CartService cartservice =new CartService();
			cart=cartservice.delete(cart, productId);
			Iterator<OrderItem> it = cart.iterator();
			if(it.hasNext()){
				request.getSession().setAttribute("cart", cart);//����պ����Ϣ���·���Session��
			}else{
				request.getSession().removeAttribute("cart");
			}		
			return "list";//���ع��ﳵҳ��
		}
		
		// �鿴���ﳵ
		public String list() throws Exception {
			Set<OrderItem> cart = getCart();// ��ȡ���ﳵ
			Iterator<OrderItem> it = cart.iterator();
			if(it.hasNext()){
				request.getSession().setAttribute("cart", cart);//����պ����Ϣ���·���Session��
			}else{
				request.getSession().removeAttribute("cart");
			}		
			System.out.println(request.getSession().getAttribute("userName"));
			return "list";//���ع��ﳵҳ��
		}
		
		// ���ﳵ�������Ʒ
		public String add() throws Exception {
			System.out.println(productId);
			 System.out.println("productid:"+request.getParameter("id"));
			 System.out.println("num:"+request.getParameter("num"));
			productId= Integer.parseInt(request.getParameter("id"));
			amount =Integer.parseInt(request.getParameter("num"));
			if(productId != null && productId > 0){
				// ��ȡ���ﳵ
			    Set<OrderItem> cart = getCart();
				// �����ӵ���Ʒ�Ƿ���ͬһ����Ʒ
			    CartService cartservice =new CartService();
			   
			    cart=cartservice.add(cart, productId,amount);
				request.getSession().setAttribute("cart", cart);
					}
				return "add";
				}
		
		
}
