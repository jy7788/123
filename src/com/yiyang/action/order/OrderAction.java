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
		
		// ��ȡ�û�id
		// ��ȡ�û�����
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
		 * �������
		*/
		public String add() throws Exception {
			//order.setName("����˿");
			//order.setAddress("��ģ����·66��");
			//order.setMobile("123456");
			//System.out.println(order.getAddress());
				order.setName(getLoginCustomer().getRealName());
				order.setAddress(getLoginCustomer().getAddress());
				order.setMobile(getLoginCustomer().getMobile());
				return "add";
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
		
				
		/**
		* ���������浽���ݿ�
		* @return String
		* @throws Exception
		*/
		public String save() throws Exception {
			if(getLoginCustomer() != null){//����û��ѵ�¼
			    order.setCustomer(getLoginCustomer());// ���������û�
				OrderService orderservice =new OrderService();
				Set<OrderItem> cart = getCart();// ��ȡ���ﳵ
				order.setOrderItems(cart);// ���ö�����
				float totalPrice = 0f;// �����ܶ�ı���
				for (OrderItem orderItem : cart) {//�������ﳵ�еĶ�����Ŀ��Ϣ
					totalPrice += orderItem.getProductPrice() * orderItem.getAmount();//��Ʒ����*��Ʒ����
				}
				System.out.println("totalprice:"+totalPrice);
				order.setTotalPrice(totalPrice);//���ö������ܼ۸�
				order.setOrderState("�ѷ���");// ���ö���״̬
				if(order.getOrderItems().isEmpty()){//�ж���Ŀ��Ϣ�Ƿ�Ϊ��
					return "error";//���ض�����Ϣ������ʾҳ��
				}

				System.out.println(order.getAddress());
				orderservice.save(order);
				request.getSession().removeAttribute("cart");// ��չ��ﳵ
			}
			return findByCustomer();//���������߶�����ѯ�ķ���
		}
		
		/**
		 * ȷ�϶�����Ϣ
		 */
		public String check() throws Exception {
			if(getLoginCustomer() != null){//����û��ѵ�¼
				System.out.println("mobile:"+order.getMobile());
			order.setCustomer(getLoginCustomer());// ���������û�
			order.setOrderId(StringUitl.createOrderId());// ���ö�����
			Set<OrderItem> cart = getCart();// ��ȡ���ﳵ
			
			float totalPrice = 0f;// �����ܶ�ı���
			for (OrderItem orderItem : cart) {//�������ﳵ�еĶ�����Ŀ��Ϣ
				totalPrice += orderItem.getProductPrice() * orderItem.getAmount();//��Ʒ����*��Ʒ����
			}
			System.out.println("totalprice:"+totalPrice);
			order.setTotalPrice(totalPrice);//���ö������ܼ۸�
			order.setOrderState("��ȷ��");// ���ö���״̬
			order.setCreateTime(new Date());
			Iterator<OrderItem> it = cart.iterator();
			while(it.hasNext())
			{
				it.next().setOrder(order);
			}
			order.setOrderItems(cart);// ���ö�����
			//request.getSession().setAttribute("order", order);	
			}
			return "check";//���������߶�����ѯ�ķ���
		}
				
		/**
		 * ��ѯ�����߶���
		 * @return String
		 * @throws Exception
		*/
		public String findByCustomer() throws Exception {
			if(getLoginCustomer() != null){//����û��ѵ�¼				
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
			return "list";//���ض����б�ҳ��
		}
		
		/**
		 * �鿴��������
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
