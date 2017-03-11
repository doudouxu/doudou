<%@page import="com.qingke.pojo.Product"%>
<%@page import="com.qingke.service.ProductServiceImpl"%>
<%@page import="com.qingke.service.ProductService"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" >
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script> 
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="js/jquery.js?_=201703042022"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<div class="container">
 <p style="height:50px;">&nbsp;</p>
<h2>我的购物车:</h2>
<p style="height:50px">&nbsp;</p>
<div class="row">
<div class="col-md-2">Code</div>
<div class="col-md-2">Name</div>
<div class="col-md-2">Price</div>
<div class="col-md-2">Amount</div>
<div class="col-md-2">总价</div>
<div class="col-md-2"></div>
</div>
<%
  ProductService pro=new ProductServiceImpl();
 
  Map<String,Integer> map=(Map<String,Integer>)request.getSession().getAttribute("cart");
       /* 通过商品的名字去找到这个商品的详细信息，然后显示出来 */
    for(Map.Entry<String,Integer> m:map.entrySet()){%>
    <div class="row">
    <%   	
    	String key=m.getKey();
    	//调用dao层查询
    	Product p=pro.getProductByName(key);
    	%>
    	<div class="col-md-2"><%=p.getId() %></div>
    	<div class="col-md-2"><%=p.getName()%></div>
        <div class="col-md-2"><%=p.getPrice()%></div>
    	<div class="col-md-2"><%=map.get(key)%></div>
    	<div class="col-md-2"><%=(map.get(key))*p.getPrice()%></div>
        <div class="col-md-2">&nbsp;</div>
          </div>
    	<%
     }
 %>
<div class="col-md-2">&nbsp;</div>
<div class="col-md-2">&nbsp;</div>
<div class="col-md-2">&nbsp;</div>
<div class="col-md-2"><a href="index.jsp">继续购物</a></div>
<div><a href="MakeOrder">确定下单了</a></div>
<div class="col-md-2">&nbsp;</div>
</div>
</body>
</html>