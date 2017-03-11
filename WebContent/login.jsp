<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>

</head>
<body >
 <div align="center" >
<h2>Estore登录</h2>
<hr/>
  <form action="LoginServlet" method="POST">
  <tr>
    <td>用户名：</td>
    <td> <input type="text" name="username"/></td>
  </tr>
  <tr>
     <td>密码:</td>
     <td><input type="password" name="password"/></td>
  </tr>  
    <tr>
    <td><input type="submit" value="提交"/></td>
    </tr>
    </form>
  </div>
</body>
</html>