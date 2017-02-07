<%@page import="com.ozh.identity.service.UserInfoOperations"%>
<%@page import="com.ozh.identity.datamodel.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>deleting...</title>
</head>
<body>

<%
	Integer id = Integer.parseInt(request.getParameter("id"));
	User user = new User();
	UserInfoOperations uo = new UserInfoOperations();
	user.setId(id);
	
	uo.userInfoDelete(user);
	uo.conClose();
%>
<script type="text/javascript">
	window.location.href="manager.jsp"
</script>

</body>
</html>