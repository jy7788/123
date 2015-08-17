package com.yiyang.service.order;

import java.util.Iterator;
import java.util.Set;

import com.yiyang.dao.ObjectDao;
import com.yiyang.model.order.OrderItem;
import com.yiyang.model.product.Product;

public class CartService {

    protected ObjectDao<Product> productdao=new ObjectDao<Product>();
	public Set<OrderItem> delete(Set<OrderItem> cart,Integer productId) throws Exception {
		// �˴�ʹ��Iterator���������java.util.ConcurrentModificationException
		Iterator<OrderItem> it = cart.iterator();
		while(it.hasNext()){//ʹ�õ�����������Ʒ������Ŀ��Ϣ
			OrderItem item = it.next();
			if(item.getProductId().equals(productId)){
				it.remove();//�Ƴ���Ʒ������Ŀ��Ϣ
			}
		}
		return cart;
	}
	
	// ���ﳵ�������Ʒ
	public Set<OrderItem> add(Set<OrderItem> cart,Integer productId,Integer amount) throws Exception {
			// �����ӵ���Ʒ�Ƿ���ͬһ����Ʒ
			boolean same = false;
			for (OrderItem item : cart) {
					if(item.getProductId() == productId){
					// ������ͬ����Ʒ����������
					item.setAmount(item.getAmount() + amount);
					same = true;
					}
				}
					// ����ͬһ����Ʒ
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
						System.out.println("��Ʒ����"+item.getAmount());
					}
				return cart;
			}
}
