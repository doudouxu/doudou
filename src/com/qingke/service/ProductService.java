package com.qingke.service;
import java.util.List;
import java.util.Map;

import com.qingke.pojo.Order;
import com.qingke.pojo.Product;
import com.qingke.pojo.User;
public interface ProductService {
	
    List<Product> findAllProduct();
	void registUser(User user);
	User loginUser(String username, String password);
	Product findProductById(int number);
	Product getProductByName(String key);
	void insertOrder(Map<String, Integer> map,String username);
	List<Order> findOrder(String username);
	
}
