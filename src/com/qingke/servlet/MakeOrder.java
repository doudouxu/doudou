package com.qingke.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qingke.service.ProductService;
import com.qingke.service.ProductServiceImpl;

/**
 * Servlet implementation class MakeOrder
 */
@WebServlet("/MakeOrder")
public class MakeOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   //获得下单的商品
	 Map<String,Integer> map=(Map<String, Integer>) request.getSession().getAttribute("cart");
	 String username=(String)request.getSession().getAttribute("username");
	  //把商品存入到订单中去
	  ProductService pro=new ProductServiceImpl();
	  pro.insertOrder(map,username);
	  //把购物车清空，跳转到订单列表
	   request.getSession().removeAttribute("cart");
	   request.getRequestDispatcher("order.jsp").forward(request, response);
	   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
