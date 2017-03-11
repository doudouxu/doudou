package com.qingke.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Valistr
 */
@WebServlet("/Valistr")
public class Valistr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Valistr() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			//设置验证码图片不缓存
			response.setHeader("Cache", "no-cache");
			response.setDateHeader("Expires", -1);
			response.setHeader("Pragma", "no-cache");
			
			int width=100;
			int height=30;
			//创建一个图片缓冲区
			BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
			//设置背景色
			Graphics  graphics=image.getGraphics();
			graphics.setColor(Color.YELLOW);
			//设置字体大小
			graphics.setFont(new Font("宋体",Font.BOLD,20));
			
			//将背景色填充进去
			graphics.fillRect(0, 0, width, height);
	       //边框
			graphics.setColor(Color.RED);
			graphics.drawRect(0, 0, width-1, height-1) ;
	        //往图片中添加字母和数字,写字
			Graphics2D graphics2d=( Graphics2D)graphics;
	        String  content="ABCDEFGHIGKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwsyz0123456789";
	        int x=10;
	    	int y=20;
	    	Random  random=new Random();
	    	StringBuffer buffer=new StringBuffer();
	        for(int i=0;i<4;i++){
	         //为字设置旋转效果
	        	double jiaodu=random.nextInt(60)-30;
	            double theta=jiaodu/180 *Math.PI;	
	        	int index=random.nextInt(content.length());
	        	char c=content.charAt(index);
	        	graphics2d.rotate(theta,x,y);
	        	//写到图片中
	        	graphics2d.drawString(c+"", x, y);
	        	graphics2d.rotate(-theta,x,y);
	        	x=x+20;
	        	//将角度还原
	        	buffer.append(c);
	        }
	        
	        String code=buffer.toString();
	        //保存到session中
	        request.getSession().setAttribute("code", code);
	        System.out.println(code);
	        //绘制随机的干扰线
	        int x1;
	        int y1;
	        int x2;
	        int y2;
	        //设置线的颜色
	        graphics.setColor(Color.gray);
	        for(int i=0;i<10;i++){
	        	x1=random.nextInt(width);
	        	y1=random.nextInt(height);
	        	x2=random.nextInt(width);
	        	y2=random.nextInt(height);
	        	graphics.drawLine(x1, y1, x2, y2);
	        }
	                                                              
	        //内存中释放一下资源
	        graphics.dispose();
	        //将图片输出到浏览器
	        ImageIO.write(image, "jpg", response.getOutputStream());
	     }

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
