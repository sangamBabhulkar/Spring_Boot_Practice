<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ page import="java.util.*" %>
<%@ page import="com.app.model.Student" %>

<h2>Student List</h2>

<table border="1">

<tr>
<th>ID</th>
<th>Name</th>
<th>Email</th>
<th>Phone</th>
<th>Course</th>
</tr>

<%
List<Student> list = (List<Student>) request.getAttribute("students");

for(Student s : list){
%>

<tr>
<td><%= s.getId() %></td>
<td><%= s.getName() %></td>
<td><%= s.getEmail() %></td>
<td><%= s.getPhone() %></td>
<td><%= s.getCourse() %></td>
</tr>

<% } %>

</table>

<a href="register.jsp">Add Student</a>
</body>
</html>