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
	<h3>欢迎Admin${username}</h3>

	<br />
	<br />
	<table border="1" cellpadding="10" cellspacing="0">    
           <tr>    
               <th>会员账号</th>    
               <th>金币</th>    
               <th>代理</th>    
               <th>注册时间</th>    
           </tr>    
               
           <c:forEach items="${members}" var="member">    
               <tr>    
                   <td>${member.username }</td>    
                   <td>${member.gold }</td>    
                   <td>${member.agent.aid }</td>    
                   <td>${member.create_time }</td>    
               </tr>    
           </c:forEach>    
       </table>    
</body>
</html>