package com.yiyang.service.product;

import java.util.List;

import com.yiyang.dao.ObjectDao;
import com.yiyang.model.product.Product;

public class ProductService {
	
	//������ѯ��Ʒ
	public List<Product> findByType(int categoryId){
		ObjectDao<Product> objectDao = new ObjectDao<Product>();
		String hql = "from Product where category.id ="+categoryId;
		List<Product> products = objectDao.queryListObject(hql);
		return products;
	}
	
	//�������Ҳ�Ʒ
	public List<Product> findBySpecifi(String specifi){
		ObjectDao<Product> objectDao = new ObjectDao<Product>();
		String hql = "from Product where specifi ="+specifi;
		List<Product> products = objectDao.queryListObject(hql);
		return products;
	}
	
	//��Id���Ҳ�Ʒ
	public List<Product> findById(int id){
		ObjectDao<Product> objectDao = new ObjectDao<Product>();
		String hql = "from Product where id ="+id;
		List<Product> products = objectDao.queryListObject(hql);
		return products;
	}
	
	//��ID����Ʒ��
	public <T> List<T> getBrand(int categoryId)
	{
		ObjectDao<T> objectDao = new ObjectDao<T>();
		String hql = "select distinct s.brand from Product s where category.id ='"+categoryId+"'";
		List<T> list = objectDao.queryListObject(hql);
		return list;
	}
	
	//��ID���ҹ��
	public <T> List<T> getSpecifi(int categoryId)
	{
		ObjectDao<T> objectDao = new ObjectDao<T>();
		String hql = "select distinct s.specifi from Product s where category.id ='"+categoryId+"'";
		List<T> list = objectDao.queryListObject(hql);
		return list;
	}
}
