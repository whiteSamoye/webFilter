<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login2.jsp</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/Login2" method="post">
		用户名：<input type="text" name="userName" value="请输入用户名"><br>
		密码：<input type="password" name="userPasswd" value="请输入密码"><br>
		<input type="submit" value="登录">
	</form>
</body>
</html>