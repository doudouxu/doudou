<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<script src="js/index.js"></script>
<script src="js/jquery.js"></script>
</head>
<script type="text/javascript">
   
</script>
<body>
<%
  String username=(String)request.getSession().getAttribute("username");
%>
<div class="head">
<ul class="nav nav-pills pull-right">
<%if(username==null){%>
  <li><a href="login.jsp">登录</a></li>
<li><a href="regist.jsp">注册 </a></li>
<%} else{%>
 <li><a href="#">欢迎你：<%=username%></a></li>
 <li><a href="car.jsp">我的购物车(<span id="number"></span>)</a></li>
 <li><a href="order.jsp">我的订单</a></li>
 <li><a href="LogoutServlet">退出</a></li>
<% }%>
</ul>
</div>
</body>
</html>