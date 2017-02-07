<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>

<style type="text/css">
body {
	color: $=#000 font-size: 14px;
	margin: 200px auto;
}
</style>

<script type="text/javascript">
	function check(form) {
		if (document.forms.loginForm.uname.value == "") {
			alert("Plaz input username");
			document.forms.loginForm.uname.focus();
			return false;
		} else if (document.forms.loginForm.pwd.value == "") {
			alert("Plaz input passwprd");
			document.forms.loginForm.pwd.focus();
			return false;
		}
	}
</script>
</head>
<body>

	<form action="<%=request.getContextPath()%>/checkServlet" method="post"
		name="loginForm">
		<%if(request.getAttribute("return_uri") !=null) {%>
			<input type="hidden" name="return_uri" value="<%request.getAttribute("return_uri"); %>">
		<%} %>
		
		<table border="1" cellspacing="0" cellpadding="5" bgcolor="silver"
			align="center">
			<tr>
				<td colspan="2" align="center" bgcolor="E8E8E8">Login</td>
			</tr>
			<tr>
				<td>username</td>
				<td><input type="text" name="uname"></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					name="submit" onclick="return check(this)"> <input
					type="reset" name="reset"></td>

			</tr>
		</table>
	</form>

</body>
</html>