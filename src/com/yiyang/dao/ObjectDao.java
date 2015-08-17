package com.yiyang.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.yiyang.model.order.OrderItem;
import com.yiyang.model.product.Product;
import com.yiyang.util.Page;


public class ObjectDao<T> {

	private static SessionFactory sessionFactory = null;
	private static Session session = null;//创建Session对象
	Transaction  tx = null;//创建事务管理对象
	//连接数据库
	static {
		try {
			// 加载Hibernate配置文件
			Configuration cfg = new Configuration().configure();
			ServiceRegistry sr= new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry(); 
			sessionFactory = cfg.buildSessionFactory(sr);
		} catch (Exception e) {
			System.err.println("创建会话工厂失败");
			e.printStackTrace();
		}
	}
	/**
	 * 删除数据
	 * @param t
	 * @return
	 */
	public boolean deleteT(T t) {
		Session session = sessionFactory.openSession();//开启Session
		try {
			tx = session.beginTransaction();//开启事务
			session.delete(t);//执行数据删除操作
			tx.commit();//事务提交
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();//关闭Session
		}
		return true;
	}
	/**
	 * 保存数据
	 * @param t
	 * @return
	 */
	public boolean saveT(T t) {
		Session session = sessionFactory.openSession();//开启Session
		try {
			tx = session.beginTransaction();//开启事务
			session.save(t);//执行数据添加操作
			tx.commit();//事务提交
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();//关闭Session
		}
		return true;
	}
	/**
	 * 修改数据
	 * @param t
	 * @return
	 */
	public boolean updateT(T t) {
		Session session = sessionFactory.openSession();//开启Session
		try {
			tx = session.beginTransaction();//开启事务
			session.update(t);//执行数据修改操作
			tx.commit();//事务提交
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();//关闭Session
		}
		return true;
	}

	
	/**
	 * 查询单条信息
	 * @param hql
	 * @return
	 */
	public T queryFrom(String hql) {
		T t = null;//引用实体对象
		session = sessionFactory.openSession();//开启Session
	    tx = session.beginTransaction();//开启事务
		try {
			Query query = session.createQuery(hql);//利用hql语句进行查询
			t = (T) query.uniqueResult();//将查询结果转换为实体对象
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();//事务提交
		session.close();//Session关闭
		return t;//返回对象
	}
	/**
	 * 查询多条信息
	 * @param hql
	 * @return
	 */
	public List<T> queryListObject(String hql) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<T> list = null;
		try {
			Query query = session.createQuery(hql);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		session.close();
		return list;
	}
	
	/**
	 * 分页查询
	 */
	public boolean search(Page page,String hql){
		session =sessionFactory.openSession();
		tx = session.beginTransaction();
		try{
			Query query = session.createQuery(hql);
			Query queryRows = session.createQuery("select count(*) " + hql);
			page.initPage(query, queryRows);
		}catch(Exception e){
			e.printStackTrace();
		}
		tx.commit();
		session.close();
		return true;
	}
	
	/**
	 * 订单详情分页查询
	 */
	public boolean search_detail(Page page,String hql){
		session =sessionFactory.openSession();
		tx = session.beginTransaction();
		try{
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<OrderItem> list=query.list();
			for(OrderItem orderitem :list){
				String _hql="from Product where id='"+ orderitem.getProductId() +"'";
				Query _query = session.createQuery(_hql);			
				Product product = (Product)_query.uniqueResult();
				orderitem.setPrimPic(product.getPrimPic());
				System.out.println(product.getPrimPic());
			}
			query.list().clear();
			query.list().addAll(list);
			Query queryRows = session.createQuery("select count(*) " + hql);
			page.initPage(query, queryRows);
		}catch(Exception e){
			e.printStackTrace();
		}
		tx.commit();
		session.close();
		return true;
	}
	
	//test
		public boolean queryTocalCount(Page page,String hql)
		{
			session = sessionFactory.openSession();//开启Session
		    tx = session.beginTransaction();//开启事务
			try {
				Query query = session.createQuery(hql);//利用hql语句进行查询
				Query queryRows = session.createQuery("select count(*)"+hql);
				page.initPage(query, queryRows);
			} catch (Exception e) {
				e.printStackTrace();
			}
			tx.commit();//事务提交
			session.close();//Session关闭
			return true;//返回对象		
		}
}
