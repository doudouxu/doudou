package com.qingke.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.qingke.pojo.Order;
import com.qingke.pojo.Product;
import com.qingke.pojo.User;
import com.qingke.utils.SessionUtils;

import sun.text.resources.cldr.FormatData;

public class ProductDao {
   
	public static List<Product> show(){
	  SqlSession session=SessionUtils.getInstance().getSqlSession().openSession();
	  List<Product> pro=session.selectList("com.qingke.mapping.ProductMapper.showProduct");
	  session.close();
	   return pro;
	}

	public void regist(User user) {
	  SqlSession session=SessionUtils.getInstance().getSqlSession().openSession();
	  session.insert("com.qingke.mapping.UserMapper.registUser", user);
	  session.commit();
	  session.close();
	}

	public User login(String username, String password) {
	    SqlSession session=SessionUtils.getInstance().getSqlSession().openSession();
	    User user=new User();
	    user.setUsername(username);
	    user.setPassword(password);
	    user=session.selectOne("com.qingke.mapping.UserMapper.loginUser",user);
	    session.commit();
	    session.close();
	    return user;
	  
	}

	public Product findProductInId(int number) {
		SqlSession session=SessionUtils.getInstance().getSqlSession().openSession();
		Product p=null;
		p=session.selectOne("com.qingke.mapping.ProductMapper.selectProductById",number);
		session.commit();
		session.close();
		return p;
	}

	public Product getProByName(String key) {
		SqlSession session=SessionUtils.getInstance().getSqlSession().openSession();
		Product p=session.selectOne("com.qingke.mapping.ProductMapper.selectProductByName",key);
	    session.close();
		return p;
	}
	
	public User getUserByName(String username){
		SqlSession session=SessionUtils.getInstance().getSqlSession().openSession();
		User user=session.selectOne("com.qingke.mapping.UserMapper.selectUserByName",username);
		session.close();
		return user;
	}

	public void inOrder(Map<String, Integer> map,String username) {
		SqlSession session=SessionUtils.getInstance().getSqlSession().openSession();
		Product pro=new Product();
		User user=getUserByName(username);
		int user_id=user.getId();
		
		Date d=new Date();
		//遍历这个map
		for(Map.Entry<String, Integer> m:map.entrySet()){
			Order order=new Order();
			//获得该商品的id
			Product p=getProByName(m.getKey());
			int id=p.getId();
		    SimpleDateFormat s=new SimpleDateFormat("yyyyMMdd-HHmmss");
		    s.format(new Date());
			
			order.setLasttime(d);
			order.setNumber(m.getValue());
			//定义一个随机数，产生订单号
			order.setOrdercode(System.currentTimeMillis()+"");
			order.setProduct_id(id);
			order.setUser_id(user_id);
			order.setTolprice(p.getPrice()*(m.getValue()));
			session.insert("com.qingke.mapping.OrderMapper.insertOrder",order);
		}
		session.commit();
		session.close();
	}

	public List<Order> findOrder(String username) {
		SqlSession session=SessionUtils.getInstance().getSqlSession().openSession();
		//根据名字获取用户的id
		int user_id=getUserByName(username).getId();
		List<Order> list=session.selectList("com.qingke.mapping.OrderMapper.selectOrderByUserId", user_id);
		session.close();
		return list;
	}


	
}
