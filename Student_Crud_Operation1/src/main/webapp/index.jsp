<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page
    import="java.util.List" %>

<%@ page
    import="com.sangam.model.Student" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>
Student Management System
</title>

<style>

table {
    width: 80%;
    border-collapse: collapse;
    margin: auto;
}

th, td {
    border: 1px solid black;
    padding: 10px;
    text-align: center;
}

h2 {
    text-align: center;
}

.btn {
    padding: 8px 15px;
    text-decoration: none;
    background-color: blue;
    color: white;
    border-radius: 5px;
}

</style>

</head>
<body>

<h2>
Student Management System
</h2>

<div style="text-align:center;
margin-bottom:20px;">

<a href="addStudent.jsp"
class="btn">

Add Student

</a>

</div>

<table>

<tr>
    <th>ID</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Email</th>
</tr>

<%

List<Student> students =
(List<Student>)
request.getAttribute(
    "students"
);

if (students != null) {

    for (Student s :
        students) {

%>

<tr>

<td>
<%= s.getId() %>
</td>

<td>
<%= s.getFirstName() %>
</td>

<td>
<%= s.getLastName() %>
</td>

<td>
<%= s.getEmail() %>
</td>

</tr>

<%
    }
}
%>

</table>

</body>
</html>