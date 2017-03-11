package com.qingke.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qingke.pojo.User;
import com.qingke.service.ProductService;
import com.qingke.service.ProductServiceImpl;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//用户注册,封装数据
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		ProductService pro=new ProductServiceImpl();
		User user=new User();
		//获取当前的时间
		Date d=new Date();
		//SimpleDateFormat times=new SimpleDateFormat("yyyy年MM月dd日hh时mm分ss秒");
		//times.format(d);
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setUpdatetime(d);
		//提交到service层处理
		pro.registUser(user);
		//注册成功
		request.getSession().setAttribute("username", username);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
