package com.yiyang.service.user;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import com.yiyang.dao.ObjectDao;
import com.yiyang.model.user.Customer;
import com.yiyang.util.MD5;

public class UserService {	
	public boolean login(String userName,String password)
	{
		String hql = "select password from Customer where userName = '"+userName+"'";
		System.out.println(userName);
		ObjectDao<Object> objectDao = new ObjectDao<Object>();
		String pwdInDb = (String) objectDao.queryFrom(hql);
		System.out.println(pwdInDb);  
        if(null!=pwdInDb)
        { // 该用户存在  
                try 
                {
					return MD5.validPassword(password, pwdInDb);
				} 
                catch (NoSuchAlgorithmException e) 
				{
					e.printStackTrace();
					return false;
				}
                catch (UnsupportedEncodingException e) 
				{
					e.printStackTrace();
					return false;
				}  
        }
        else
        {  
            System.out.println("不存在该用户！！！");  
            return false;  
        }  
	}
	
	public boolean exist(Customer customer)
	{
		String hql = "from Customer where userName = '"+customer.getUserName()+"'";
        ObjectDao<Object> objectDao = new ObjectDao<Object>();
        if(objectDao.queryFrom(hql)!=null)
        {
        	return true;
        }
        else
        {
        	return false;
        }
	}
	
	public boolean register(Customer customer)
	{
		String encryptedPwd = null;  
        try 
        {  
        	encryptedPwd = MD5.getEncryptedPwd(customer.getPassword());
        	System.out.println(encryptedPwd);
        	customer.setPassword(encryptedPwd);
        	ObjectDao<Customer> objectDao = new ObjectDao<Customer>();
        	objectDao.saveT(customer);
        	return true;
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();
            return false;
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
            return false;
        }  
	}
	
	/*public static void main(String args[])
	{
		Customer customer = new Customer();
		customer.setUserName("leo");
		customer.setPassWord("19870808");
		customer.setRealName("fdg");
		customer.setMobile("198343534");
		customer.setAddress("NJ");
		customer.setEmail("2743234@qq.com");
		
		if(!exist(customer))
		{
			register(customer);
		}
		else
		{
			System.out.println("用户名字已经存在");
		}
		if(login("leo","19870808"))
		{
			System.out.println("登录成功");
		}
		else
		{
			System.out.println("登录失败");
		}
	}*/
}
