package com.yiyang.service.order;

import java.util.Iterator;
import java.util.Set;

import com.yiyang.dao.ObjectDao;
import com.yiyang.model.order.OrderItem;
import com.yiyang.model.product.Product;

public class CartService {

    protected ObjectDao<Product> productdao=new ObjectDao<Product>();
	public Set<OrderItem> delete(Set<OrderItem> cart,Integer productId) throws Exception {
		// 此处使用Iterator，否则出现java.util.ConcurrentModificationException
		Iterator<OrderItem> it = cart.iterator();
		while(it.hasNext()){//使用迭代器遍历商品订单条目信息
			OrderItem item = it.next();
			if(item.getProductId().equals(productId)){
				it.remove();//移除商品订单条目信息
			}
		}
		return cart;
	}
	
	// 向购物车中添加商品
	public Set<OrderItem> add(Set<OrderItem> cart,Integer productId,Integer amount) throws Exception {
			// 标记添加的商品是否是同一件商品
			boolean same = false;
			for (OrderItem item : cart) {
					if(item.getProductId() == productId){
					// 购买相同的商品，更新数量
					item.setAmount(item.getAmount() + amount);
					same = true;
					}
				}
					// 不是同一件商品
					if(!same){
						OrderItem item = new OrderItem();
						String hql="from Product where id='"+productId+"'";
						Product pro = productdao.queryFrom(hql);
						item.setProductId(pro.getId());
						item.setProductName(pro.getName());
						item.setProductPrice(pro.getSellPrice());
						item.setProductMarketprice(pro.getMarketPrice());
						item.setAmount(amount);
						cart.add(item);
						System.out.println("商品数量"+item.getAmount());
					}
				return cart;
			}
}
