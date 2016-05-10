<%@page import="service.LoginService"%>
<%@page import="java.util.List"%>
<%@page import="model.User"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <link rel="stylesheet" type="text/css" href="css/style.css"/>
     <title>Result Page</title>
</head>
<body>
<div id="container">
<h1>Result Page</h1>
<b>This is Simple Page</b><br>
<%=new Date()%>
<%
User user =(User)session.getAttribute("user");
%>
<b> Welcome <%=user.getFirstName() + " " + user.getLastName()%> </b>
<a href="logout.jsp">logout</a>
<br>
<table>
	<thead>
		<tr>
			<th> User ID</th>
			<th> First Name</th>
			<th> Last Name</th>
			<th> Middle Name</th>
			<th> Email </th>
		</tr>
	</thead>
		<%
			LoginService loginService = new LoginService();
			List<User> list = loginService.getAllUsers();
			for (User u : list) {
                %>
                <tr>
                    <td><%=u.getUserId()%></td>
                    <td><%=u.getFirstName()%></td>
                    <td><%=u.getMiddleName()%></td>
                    <td><%=u.getLastName()%></td>
                    <td><%=u.getEmail()%></td>
                </tr>
                <%}%>
	 <tbody>
	 </tbody>
</table>
</div>

</body>
</html>