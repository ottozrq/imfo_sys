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
    	
/*     	System.out.print(request.getParameter("id")); */
    	Integer id = Integer.parseInt(request.getParameter("id"));
    	user.setId(id);
    	
    	ResultSet rs = uo.userInfoRead(user);
    	
/*     	System.out.println(acc.getOwner());
    	System.out.println(rsa);
    	System.out.println(rsa.getInt("balance")); */
    	String username = rs.getString("name");
    	String password = rs.getString("password");
    	String displayname = rs.getString("displayname");
    	String email = rs.getString("email");
    	String address = rs.getString("address");
    	
    	
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function check(form) {
		if (document.forms.editForm.email.value == "") {
			alert("Plz input email");
			document.forms.editForm.email.focus();
			return false;
		} else if (document.forms.editForm.address.value == "") {
			alert("Plz input address");
			document.forms.editForm.address.focus();
			return false;
		}else if (document.forms.editForm.name.value == "") {
			alert("Plz input name");
			document.forms.editForm.name.focus();
			return false;
		}else if (document.forms.editForm.displayname.value == "") {
			alert("Plz input displayname");
			document.forms.editForm.displayname.focus();
			return false;
		}
	}
</script>
</head>
<body>

		<form action="<%=request.getContextPath()%>/editInfoServlet?id=<%=id %>" method="post" name="editForm">
			<table border="1" cellspacing="0" cellpadding="5" bgcolor="silver" align="center">
				<tr>
					<td colspan="2" align="center" bgcolor="E8E8E8">Editor</td>
				</tr>
				<tr>
					<td>Username*</td><td><input name="name" value="<%=username %>"></td>
				</tr>
				<tr>
					<td>Password</td><td><input name="password" value="<%=password %>"></td>
				</tr>
				<tr>
					<td>Displayname*</td><td><input name="displayname" value="<%=displayname %>"></td>
				</tr>
				<tr>
					<td>Email*</td><td><input name="email" value="<%=email %>"></td>
				</tr>
				<tr>
					<td>Address*</td><td><input name="address" value="<%=address %>"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" name="submit" onclick="return check(this)"></td>
				</tr>
				
			</table>
		</form>
	<% uo.conClose(); %>
</body>
</html>