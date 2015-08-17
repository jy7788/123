package com.yiyang.service.order;

import java.util.List;
import java.util.Set;

import com.yiyang.dao.ObjectDao;
import com.yiyang.model.product.Product;
import com.yiyang.model.order.Order;
import com.yiyang.model.order.OrderItem;

public class OrderService {

	protected ObjectDao<Product> productdao=new ObjectDao<Product>();
	protected ObjectDao<Order> orderdao=new ObjectDao<Order>();
	
	
	public void save(Order order) throws Exception {
			// 依次将更新订单项中的商品的销售数量
			for(OrderItem item : order.getOrderItems()){//遍历购物车中的订单条目信息
				//Integer productId = item.getProductId();//获取商品ID
				System.out.println("商品id"+item.getProductId());
				Product product = productdao.queryFrom("from Product where id='" + item.getProductId() + "'");//装载商品对象
				product.setSellCount(product.getSellCount() + item.getAmount());//更新商品销售数量
				productdao.updateT(product);//修改商品信息
					}
				orderdao.saveT(order);//保存订单信息
			}
	
	public List<Order> findByCustomer(Integer id) throws Exception {
		String hql = "from Order where customer.id = '"+id+"'";//将用户id设置为查询条件
		List<Order> orderlist = orderdao.queryListObject(hql);
		if(orderlist==null){
			System.out.println("为空");
		}
		return orderlist;
	}
}
