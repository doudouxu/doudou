<%@page import="com.qingke.pojo.Product"%>
<%@page import="com.qingke.pojo.Order"%>
<%@page import="java.util.List"%>
<%@page import="com.qingke.service.ProductServiceImpl"%>
<%@page import="com.qingke.service.ProductService"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" >
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script> 
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>我的订单</title>
</head>
<body>
<%
//查询订单，根据用户名
String username=(String)request.getSession().getAttribute("username");
ProductService pro=new ProductServiceImpl();
List<Order> list =pro.findOrder(username);
%>
<p style="height:80px;">&nbsp;</p>
<div class="container">
<div class="row">
   <div class="col-md-2">订单编号</div>
   <div class="col-md-2">商品名称</div>
   <div class="col-md-2">下单时间</div>
   <div class="col-md-2">商品数量</div>
   <div class="col-md-2">总价</div>
   <div class="col-md-2"></div>
</div>
<%!double sum=0; %>
<%for(Order o:list){%>
<%sum=sum+o.getTolprice();%>
<%Product pros=pro.findProductById(o.getProduct_id());%>
<div class="row">
 <div class="col-md-2"><%=o.getOrdercode()%></div>
 <div class="col-md-2"><%=pros.getName()%></div>
 <div class="col-md-2"><%=o.getLasttime()%></div>
 <div class="col-md-2"><%=o.getNumber()%></div>
 <%if(list.lastIndexOf(o)==(list.size())-1) {%>
    <div class="col-md-2"><%=sum%></div>
 <%} %>
 <div class="col-md-2">&nbsp;</div>
</div>
<% }%>
</div>
</body>
</html>