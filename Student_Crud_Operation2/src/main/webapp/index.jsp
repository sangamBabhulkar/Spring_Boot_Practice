<%@ page import="java.util.*" %>
<%@ page import="dao.StudentDAO" %>
<%@ page import="model.Student" %>

<html>
<head>
    <title>Student Management System</title>
</head>

<body>

<h2>Student List</h2>

<!-- Add Button -->
<a href="add-student.jsp">➕ Add Student</a>

<br><br>

<table border="1" cellpadding="10">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Course</th>
        <th>Action</th>
    </tr>

<%
    List<Student> list = StudentDAO.getAllStudents();

    for(Student s : list) {
%>

    <tr>
        <td><%= s.getId() %></td>
        <td><%= s.getName() %></td>
        <td><%= s.getEmail() %></td>
        <td><%= s.getCourse() %></td>

        <td>
            <form action="StudentServlet" method="post">
                <input type="hidden" name="id" value="<%= s.getId() %>"/>

                <button type="submit" name="action" value="delete">
                    Delete
                </button>
            </form>
        </td>
    </tr>

<%
    }
%>

</table>

</body>
</html>