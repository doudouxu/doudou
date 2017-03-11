package com.qingke.service;

import java.util.List;
import java.util.Map;

import com.qingke.dao.ProductDao;
import com.qingke.pojo.Order;
import com.qingke.pojo.Product;
import com.qingke.pojo.User;

public class ProductServiceImpl implements ProductService {
    ProductDao p=new ProductDao();
	@Override
	public List<Product> findAllProduct() {
		return p.show();
	}
	
	@Override
	public void registUser(User user) {
	  //���жϸ��û����Ƿ����
		User u=loginUser(user.getUsername(),user.getPassword());
		if(u!=null){
			//��ʾ�û����Ѿ�������
			throw new RuntimeException("�û����Ѿ�������");
		}else{
			p.regist(user);
		}
		
	}

	@Override
	public User loginUser(String username, String password) {
		 User user=p.login(username,password);
		 return user;
	}

	@Override
	public Product findProductById(int number) {
		return p.findProductInId(number);
	}

	@Override
	public Product getProductByName(String key) {
		
		return p.getProByName(key);
	}

	@Override
	public void insertOrder(Map<String, Integer> map,String username) {
		// ���붩��
		p.inOrder(map,username);
	}

	@Override
	public List<Order> findOrder(String username) {
		// TODO �Զ����ɵķ������
		return p.findOrder(username);
	}

	
	
    
}
