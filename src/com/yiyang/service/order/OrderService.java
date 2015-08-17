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
			// ���ν����¶������е���Ʒ����������
			for(OrderItem item : order.getOrderItems()){//�������ﳵ�еĶ�����Ŀ��Ϣ
				//Integer productId = item.getProductId();//��ȡ��ƷID
				System.out.println("��Ʒid"+item.getProductId());
				Product product = productdao.queryFrom("from Product where id='" + item.getProductId() + "'");//װ����Ʒ����
				product.setSellCount(product.getSellCount() + item.getAmount());//������Ʒ��������
				productdao.updateT(product);//�޸���Ʒ��Ϣ
					}
				orderdao.saveT(order);//���涩����Ϣ
			}
	
	public List<Order> findByCustomer(Integer id) throws Exception {
		String hql = "from Order where customer.id = '"+id+"'";//���û�id����Ϊ��ѯ����
		List<Order> orderlist = orderdao.queryListObject(hql);
		if(orderlist==null){
			System.out.println("Ϊ��");
		}
		return orderlist;
	}
}
