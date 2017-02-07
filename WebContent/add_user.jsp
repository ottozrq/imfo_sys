<%@page import="com.ozh.identity.datamodel.User"%>
<%@page import="com.ozh.identity.service.UserInfoOperations"%>
<%@page import="javax.naming.spi.DirStateFactory.Result"%>
<%@page import="java.sql.ResultSet"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit</title>

<script type="text/javascript">
	function check(form) {
		if (document.forms.addForm.email.value == "") {
			alert("Plz input email");
			document.forms.addForm.email.focus();
			return false;
		} else if (document.forms.addForm.address.value == "") {
			alert("Plz input address");
			document.forms.addForm.address.focus();
			return false;
		}else if (document.forms.addForm.name.value == "") {
			alert("Plz input name");
			document.forms.addForm.name.focus();
			return false;
		}else if (document.forms.addForm.displayname.value == "") {
			alert("Plz input displayname");
			document.forms.addForm.displayname.focus();
			return false;
		}
	}
</script>

</head>
<body>
	<div id="userinfo">
		<form action="<%=request.getContextPath()%>/addInfoServlet" method="post" name="addForm">
			<table border="1" cellspacing="0" cellpadding="5" bgcolor="silver" align="center">
				<tr>
					<td colspan="2" align="center" bgcolor="E8E8E8">Editor</td>
				</tr>
				<tr>
					<td>Username*</td><td><input name="name"></td>
				</tr>
				<tr>
					<td>Password</td><td><input name="password"></td>
				</tr>
				<tr>
					<td>Displayname*</td><td><input name="displayname"></td>
				</tr>
				<tr>
					<td>Email*</td><td><input name="email"></td>
				</tr>
				<tr>
					<td>Address*</td><td><input name="address"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" name="submit" onclick="return check(this)"></td>
				</tr>
				
			</table>
		</form>
		
	</div>
</body>
</html>