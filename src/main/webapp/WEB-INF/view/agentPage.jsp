<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	<h3>欢迎${username}</h3>

	<br />
	<br />
	<form id="saveForm" action="${pageContext.request.contextPath}/admin/addAgent" method="post">
		<table style="font-size: :16px">
			<tr>
				<td>账户名：</td>
				<td><input type="text" value="${agent.username }" name="username" /></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="text" value="${agent.password }" name="password" /></td>
			</tr>
			<tr>
			<tr>
				<td>姓名：</td>
				<td><input type="text" value="${agent.name }" name="name" /></td>
			</tr>
			<tr>
				<td>注册码：</td>
				<td><input type="text" value="${agent.register_code}" name="register_code" /></td>
			</tr>
			<tr>
			
				<td align="right">
				<input type="submit" value="添加" />
				<!-- &nbsp;&nbsp;<a href="javascript:history.go(-1)">退回 </a>-->
			</tr>
		</table>
		<br />
	    <br />
		<table border="1" cellpadding="10" cellspacing="0">    
            <tr>    
                <th>代理</th>    
                <th>姓名</th>    
                <th>注册码</th>    
                <th>注册时间</th>    
            </tr>    
                
            <c:forEach items="${agents}" var="agent">    
                <tr>    
                    <td>${agent.username }</td>    
                    <td>${agent.name }</td>    
                    <td>${agent.register_code }</td>    
                    <td>${agent.create_time }</td>    
                </tr>    
            </c:forEach>    
        </table>    
	</form>
</body>
</html>