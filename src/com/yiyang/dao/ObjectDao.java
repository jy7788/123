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
	private static Session session = null;//����Session����
	Transaction  tx = null;//��������������
	//�������ݿ�
	static {
		try {
			// ����Hibernate�����ļ�
			Configuration cfg = new Configuration().configure();
			ServiceRegistry sr= new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry(); 
			sessionFactory = cfg.buildSessionFactory(sr);
		} catch (Exception e) {
			System.err.println("�����Ự����ʧ��");
			e.printStackTrace();
		}
	}
	/**
	 * ɾ������
	 * @param t
	 * @return
	 */
	public boolean deleteT(T t) {
		Session session = sessionFactory.openSession();//����Session
		try {
			tx = session.beginTransaction();//��������
			session.delete(t);//ִ������ɾ������
			tx.commit();//�����ύ
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();//�ر�Session
		}
		return true;
	}
	/**
	 * ��������
	 * @param t
	 * @return
	 */
	public boolean saveT(T t) {
		Session session = sessionFactory.openSession();//����Session
		try {
			tx = session.beginTransaction();//��������
			session.save(t);//ִ��������Ӳ���
			tx.commit();//�����ύ
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();//�ر�Session
		}
		return true;
	}
	/**
	 * �޸�����
	 * @param t
	 * @return
	 */
	public boolean updateT(T t) {
		Session session = sessionFactory.openSession();//����Session
		try {
			tx = session.beginTransaction();//��������
			session.update(t);//ִ�������޸Ĳ���
			tx.commit();//�����ύ
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();//�ر�Session
		}
		return true;
	}

	
	/**
	 * ��ѯ������Ϣ
	 * @param hql
	 * @return
	 */
	public T queryFrom(String hql) {
		T t = null;//����ʵ�����
		session = sessionFactory.openSession();//����Session
	    tx = session.beginTransaction();//��������
		try {
			Query query = session.createQuery(hql);//����hql�����в�ѯ
			t = (T) query.uniqueResult();//����ѯ���ת��Ϊʵ�����
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();//�����ύ
		session.close();//Session�ر�
		return t;//���ض���
	}
	/**
	 * ��ѯ������Ϣ
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
	 * ��ҳ��ѯ
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
	 * ���������ҳ��ѯ
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
			session = sessionFactory.openSession();//����Session
		    tx = session.beginTransaction();//��������
			try {
				Query query = session.createQuery(hql);//����hql�����в�ѯ
				Query queryRows = session.createQuery("select count(*)"+hql);
				page.initPage(query, queryRows);
			} catch (Exception e) {
				e.printStackTrace();
			}
			tx.commit();//�����ύ
			session.close();//Session�ر�
			return true;//���ض���		
		}
}
