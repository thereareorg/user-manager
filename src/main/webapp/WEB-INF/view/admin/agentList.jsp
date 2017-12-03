<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
			function showDetail(oid){
				var but = document.getElementById("but"+oid);
				var div1 = document.getElementById("div"+oid);
				if(but.value == "呵呵"){
					// 1.创建异步对象
					var xhr = createXmlHttp();
					// 2.设置监听
					xhr.onreadystatechange = function(){
						if(xhr.readyState == 4){
							if(xhr.status == 200){
								div1.innerHTML = xhr.responseText;
							}
						}
					}
					// 3.打开连接
					xhr.open("GET","${pageContext.request.contextPath}/agent/memberList/1",true);
					// 4.发送
					xhr.send(null);
					but.value = "关闭";
				}else{
					div1.innerHTML = "";
					but.value="呵呵";
				}
				
			}
			function createXmlHttp(){
				   var xmlHttp;
				   try{ // Firefox, Opera 8.0+, Safari
				        xmlHttp=new XMLHttpRequest();
				    }
				    catch (e){
					   try{// Internet Explorer
					         xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
					      }
					    catch (e){
					      try{
					         xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
					      }
					      catch (e){}
					      }
				    }

					return xmlHttp;
				 }
		</script>
</HEAD>
<body>
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
	</form>
	<br/>
	<form id="Form1" name="Form1"
		action="${pageContext.request.contextPath}/user/list.jsp"
		method="post">
		<table cellSpacing="1" cellPadding="0" width="100%" align="center"
			bgColor="#f5fafe" border="0">
			<TBODY>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3">
						<strong>会员列表</strong>
					</td>
				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr
								style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
								<td align="center" width="10%">账号</td>
								<td align="center" width="10%">姓名</td>
								<td align="center" width="10%">注册时间</td>
								<td align="center" width="10%">注册码</td>
								<td align="center" width="10%">编号</td>
							</tr>
							<c:forEach var="o" items="${agents}">
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%"><c:out value="${o.username }" /></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%"><c:out value="${o.name }" /></td>										
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%"><c:out value="${o.create_time }" /></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%"><c:out value="${o.register_code }" /></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%"><c:out value="${o.aid }" /></td>
								</tr>
							</c:forEach>
						</table>
					</td>
				</tr>
				<tr align="center">
					<td colspan="7">第<c:out value="${page }" />/<c:out
							value="${count}" />页 <c:if test="${page != 1 }">
							<a href="${ pageContext.request.contextPath }/admin/agentList/1">首页</a>|
								<a
								href="${ pageContext.request.contextPath }/admin/agentList/<c:out value="${page - 1 }"/>">上一页</a>|
							</c:if> <c:if test="${page != count }">
							<a
								href="${ pageContext.request.contextPath }/admin/agentList/<c:out value="${page + 1 }"/>">下一页</a>|
								<a
								href="${ pageContext.request.contextPath }/admin/agentList/<c:out value="${count }"/>">尾页</a>|
							</c:if>
					</td>
				</tr>
			</TBODY>
		</table>
	</form>
</body>
</HTML>

