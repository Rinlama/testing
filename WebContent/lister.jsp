<%@page import="org.apache.catalina.connector.OutputBuffer"%>
<%@page import="java.util.*"%>
<%@page import="Business.User"%>
<%@page import="Business.PostAds"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<title>Listing All</title>
</head>
<body>

<div>
Welcome <% User man=(User)session.getAttribute("sessionObj");
String name=(String)session.getAttribute("name");
if(man!=null){	
	out.print(man.getFirstName());
}else if(name!=null){
	out.print(name);
}
%>


</div>

<div>

<a href="index.html"><% session.invalidate(); %>Log Out</a> 

</div>

	<table class="table">
		<thead>
			
				<th>Name</th>
				<th>Subject</th>
				<th>Email</th>
				<th>Description</th>
				
			</thead>
		<c:forEach items="${posts}" var="post">
		
			<tr>
				<td><c:out value="${post.getName()}" /></td>
				<td><c:out value="${post.getSubject()}" /></td>
				<td><c:out value="${post.getEmail()}" /></td>
				<td><c:out value="${post.getDescription()}" /></td>		
			</tr>
		</c:forEach>
		
		
		
	<table>
	<a href="http://localhost:8080/Rental/Postregister.html"><button type="button" class="btn btn-primary">New Post</button></a>
</body>
</html>