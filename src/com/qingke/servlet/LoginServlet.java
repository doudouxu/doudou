package com.qingke.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qingke.pojo.User;
import com.qingke.service.ProductService;
import com.qingke.service.ProductServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
	     request.setCharacterEncoding("utf-8");
	     String username=request.getParameter("username");
	     String password=request.getParameter("password");
	     //�ύ��service
	     ProductService pro=new ProductServiceImpl();
	     User user=pro.loginUser(username,password);
	     if(user!=null){
	    	 //��¼�ɹ�
	    	 request.getSession().setAttribute("username", username);
	    	 response.getWriter().println("��ϲ���¼�ɹ���3���ص���ҳ");
	    	 //3�����ת����ҳ
	    	 response.setHeader("Refresh", "3;url=index.jsp");
	     }else{
	    	 //ʧ��
	    	 request.getRequestDispatcher("/login.jsp").forward(request, response);
	     }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
