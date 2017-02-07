<%@page import="com.ozh.identity.service.UserInfoOperations"%>
<%@page import="com.ozh.identity.datamodel.User"%>
<%@page import="com.ozh.identity.service.UserInfoOperations"%>
<%@page import="javax.naming.spi.DirStateFactory.Result"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	User user = new User();
    	UserInfoOperations uo = new UserInfoOperations();
    	
/*     	user.setName((String)session.getAttribute("user")); */
/*     	ResultSet rs = uo.userInfoRead(user); */
    	ResultSet rsa = uo.userInfoRead(null);
    	
/*     	System.out.println(acc.getOwner());
    	System.out.println(rsa);
    	System.out.println(rsa.getInt("balance")); */
    	
    	
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manager</title>
</head>
<body>

	<div id="identity">
		<table border="1" cellspacing="0" cellpadding="5" bgcolor="silver" align="center">
			<tr>
				<td colspan="6" align="center" bgcolor="E8E8E8">Identities</td>
			</tr>
			<tr>
				<td colspan="6" align="center" bgcolor="E8E8E8">Welcome to the identity system, <%=(String)session.getAttribute("user") %></td>
			</tr>
			<tr><th>ID</th><th>Name</th><th>Email</th><th>Address</th><th colspan="2">operations</th></tr>
			
			<%
				if(rsa != null){
					do{
			%>
			<tr>
				<td><%=rsa.getInt("id") %></td>
				<%Integer id = rsa.getInt("id"); %>
				<td><%=rsa.getString("displayname") %></td>
				<td><%=rsa.getString("email") %></td>
				<td><%=rsa.getString("address") %></td>
				<td><a href="edit_user.jsp?id=<% out.print(id);%>">edit</a></td>
				<td><a href="delete.jsp?id=<%=id %>">delete</a></td>
			</tr>
			<% 
					}while (rsa.next());
				}
			%>
			
			<tr>
				<td colspan="6" align="center"><a href="add_user.jsp">add</a>         
				<a href="<%=request.getContextPath()%>/logoutServlet">logout</a></td>
			</tr>
			
		</table>
	</div>
	
	<% uo.conClose(); %>
<%-- 	<% ao.conClose(); %> --%>
</body>
</html>