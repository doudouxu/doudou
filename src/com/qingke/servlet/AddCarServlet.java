package com.qingke.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qingke.pojo.Product;
import com.qingke.service.ProductService;
import com.qingke.service.ProductServiceImpl;

/**
 * Servlet implementation class AddCarServlet
 */
@WebServlet("/AddCarServlet")
public class AddCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCarServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("��ӹ��ﳵ");
		String code = "";
		String message = "";
		int number = 0;
		int num=0;
		String productId=(String)request.getParameter("proId");
		number=Integer.parseInt(productId);
		//�ж��û��Ƿ����
		String username=(String)request.getSession().getAttribute("username");
		if(username==null){
			code="400";
			message="�û�δ��¼";
		}
		//�û���¼,�鿴��Ӧ����Ʒ�Ƿ����
		ProductService p=new ProductServiceImpl();
		Product pro=p.findProductById(number);
		if(pro==null){
			code="400";
			message="����Ʒ������";
		}
		
		Map<String,Integer> map=(Map<String,Integer>)request.getSession().getAttribute("cart");
		if(map==null){
			map=new HashMap<String,Integer>();
			map.put(pro.getName(), 1);
		}else{
			//����map
			if(map.containsKey(pro.getName())){
				num=map.get(pro.getName());
				map.put(pro.getName(), num+1);
			}else{
				map.put(pro.getName(), 1);
			}
			
		}
		request.getSession().setAttribute("cart", map);
	    //����map
		int numbers=0;
		for(Map.Entry<String, Integer> m:map.entrySet()){
			numbers=numbers+m.getValue();
		}
		doResponse(response, code, message, numbers);
	}

	private void doResponse(HttpServletResponse response, String code, String message, int number) throws IOException {
		response.setContentType("application/json;charset=utf-8");
		
		PrintWriter pw = response.getWriter();
		pw.print("{\"code\":\"" + code + "\",\"message\":\""
				+ message+ "\",\"number\":" + number + "}");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
