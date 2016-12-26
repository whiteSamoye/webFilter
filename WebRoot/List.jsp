<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- http://java.sun.com/jsp/jstl/core -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List.jsp</title>
</head>
<body>
	<h4>欢迎你：${sessionScope.loginInfo.userName }</h4>
	<table>
		<tr align="center" border="1" width="80%" cellpadding="3" cellspacing="0">
			<td>序号</td>
			<td>用户名</td>
			<td>密码</td>
			<td>年龄</td>
		</tr>
		<c:if test="not empty requestScope.userList">
			<c:forEach items="requestScope.userList" var="user">
				<tr>
					<td>${user.id }</td>
					<td>${user.name }</td>
					<td>${user.passwd }</td>
					<td>${user.age }</td>
				</tr>			
			</c:forEach>
		</c:if>
	</table>
</body>
</html>