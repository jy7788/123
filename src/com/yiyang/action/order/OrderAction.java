package com.yiyang.action.order;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ModelDriven;
import com.yiyang.dao.ObjectDao;
import com.yiyang.model.user.Customer;
import com.yiyang.model.order.OrderItem;
import com.yiyang.model.order.Order;
import com.yiyang.service.order.OrderService;
import com.yiyang.util.Page;
import com.yiyang.util.StringUitl;

public class OrderAction extends OrderItem implements ModelDriven<Order>,ServletRequestAware{

	 protected HttpServletRequest request;

	 private Order order = new Order();

		@Override
		public void setServletRequest(HttpServletRequest request) {
			// TODO Auto-generated method stub
			this.request=request;
		}
		
		public OrderAction(){
			page=new Page();
			page.setCurrentPage(1);
		}
		
		// 获取用户id
		// 获取用户对象
		public Customer getLoginCustomer(){
					if(request.getSession().getAttribute("userName") != null){
						String hql="from Customer where userName='"+ request.getSession().getAttribute("userName") +"'";
						ObjectDao<Customer> customerdao=new ObjectDao<Customer>();
						Customer customer = customerdao.queryFrom(hql);
						return customer;
					}
					return null;
				}
			
		/**
		 * 点击购买
		*/
		public String add() throws Exception {
			//order.setName("拉克丝");
			//order.setAddress("新模范马路66号");
			//order.setMobile("123456");
			//System.out.println(order.getAddress());
				order.setName(getLoginCustomer().getRealName());
				order.setAddress(getLoginCustomer().getAddress());
				order.setMobile(getLoginCustomer().getMobile());
				return "add";
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
		
				
		/**
		* 将订单保存到数据库
		* @return String
		* @throws Exception
		*/
		public String save() throws Exception {
			if(getLoginCustomer() != null){//如果用户已登录
			    order.setCustomer(getLoginCustomer());// 设置所属用户
				OrderService orderservice =new OrderService();
				Set<OrderItem> cart = getCart();// 获取购物车
				order.setOrderItems(cart);// 设置订单项
				float totalPrice = 0f;// 计算总额的变量
				for (OrderItem orderItem : cart) {//遍历购物车中的订单条目信息
					totalPrice += orderItem.getProductPrice() * orderItem.getAmount();//商品单价*商品数量
				}
				System.out.println("totalprice:"+totalPrice);
				order.setTotalPrice(totalPrice);//设置订单的总价格
				order.setOrderState("已发货");// 设置订单状态
				if(order.getOrderItems().isEmpty()){//判断条目信息是否为空
					return "error";//返回订单信息错误提示页面
				}

				System.out.println(order.getAddress());
				orderservice.save(order);
				request.getSession().removeAttribute("cart");// 清空购物车
			}
			return findByCustomer();//返回消费者订单查询的方法
		}
		
		/**
		 * 确认订单信息
		 */
		public String check() throws Exception {
			if(getLoginCustomer() != null){//如果用户已登录
				System.out.println("mobile:"+order.getMobile());
			order.setCustomer(getLoginCustomer());// 设置所属用户
			order.setOrderId(StringUitl.createOrderId());// 设置订单号
			Set<OrderItem> cart = getCart();// 获取购物车
			
			float totalPrice = 0f;// 计算总额的变量
			for (OrderItem orderItem : cart) {//遍历购物车中的订单条目信息
				totalPrice += orderItem.getProductPrice() * orderItem.getAmount();//商品单价*商品数量
			}
			System.out.println("totalprice:"+totalPrice);
			order.setTotalPrice(totalPrice);//设置订单的总价格
			order.setOrderState("待确定");// 设置订单状态
			order.setCreateTime(new Date());
			Iterator<OrderItem> it = cart.iterator();
			while(it.hasNext())
			{
				it.next().setOrder(order);
			}
			order.setOrderItems(cart);// 设置订单项
			//request.getSession().setAttribute("order", order);	
			}
			return "check";//返回消费者订单查询的方法
		}
				
		/**
		 * 查询消费者订单
		 * @return String
		 * @throws Exception
		*/
		public String findByCustomer() throws Exception {
			if(getLoginCustomer() != null){//如果用户已登录				
				//OrderService orderservice =new OrderService();
			    // List<Order> orders;
				//orders=orderservice.findByCustomer(getLoginCustomer().getId());
			     //orders=orderservice.findByCustomer(1);
				//request.setAttribute("orders", orders);		
			String hql="from Order where customer.id='"+ getLoginCustomer().getId() +"'";
			hql += page.getOrderByString();
			ObjectDao<Order> orderdao=new ObjectDao<Order>();
			orderdao.search(page, hql);
			}
			return "list";//返回订单列表页面
		}
		
		/**
		 * 查看订单详情
		 */
		public String detail() throws Exception{
			String hql="from OrderItem where order.id = '"+ order.getOrderId() +"'";
			hql +=page.getOrderByString();
			ObjectDao<OrderItem> orderitemdao=new ObjectDao<OrderItem>();
			orderitemdao.search_detail(page, hql);
			return "detail";
		}
		
		
		@Override
		public Order getModel() {
			// TODO Auto-generated method stub
			return order;
		}
		
		private Page page;

		public Page getPage() {
			return page;
		}

		public void setPage(Page page) {
			this.page = page;
		}
		
}
