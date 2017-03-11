<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ page import="com.qingke.service.ProductService" %>
 <%@ page import="com.qingke.service.ProductServiceImpl" %>
 <%@ page import="com.qingke.pojo.Product" %>
 <%@ page import="java.util.*" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" >
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script> 
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="js/index.js"></script>
<script src="js/jquery.js?_=201703042022"></script>
<script src="js/jquery-1.7.2.js"></script>
</head>
<body>


<%
//获得所有的商品
 List<Product> p= new ProductServiceImpl().findAllProduct();
 String username=(String)request.getSession().getAttribute("username");
%>
<div class="container">
<jsp:include page="head.jsp"></jsp:include>
<p style="height:80px;">&nbsp;</p>
<div class="row">
  <div class="col-md-4"><img src="img/iPhone.jpg"></div>
  <div class="col-md-4"><img src="img/xiaomi.jpg"></div>
  <div class="col-md-4"><img src="img/oppo.jpg"></div>
</div>
  <div class="row" >
    <%  for(int i=0;i<p.size();i++){%>
  
    <div class="col-md-4" >
         <p>价格：<%=p.get(i).getPrice()%></p>
         <p>描述：<%=p.get(i).getDescription()%></p>
          <% if(username!=null) {%>
            <a href="#" onclick="addcar(<%=p.get(i).getId()%>);">加入购物车</a>
          <%} %> 
          
         </div> 
  <%}%>
 
</div>

</div>

</body>
</html>