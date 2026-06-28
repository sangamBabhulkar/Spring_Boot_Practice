<%@ page import="java.util.*" %>
<%@ page import="com.sp.vo.ActorVo" %>

<h1 style="color:red;text-align:center">Report Page</h1>

<%
    List<ActorVo> listVo = (List<ActorVo>) request.getAttribute("listVo");

    if (listVo != null && listVo.size() > 0) {
%>

<table border="1" bgcolor="yellow" align="center">
    <tr bgcolor="cyan">
        <th>id</th>
        <th>name</th>
   
        <th>category</th>
        <th>fee</th>
        <th>operations</th>
    </tr>

<%
    for (ActorVo vo : listVo) {
%>
    <tr>
        <td><%= vo.getid() %></td>
        <td><%= vo.getname() %></td>
        
        <td><%= vo.getCat() %></td>
        <td><%= vo.getFees() %></td>
        <td>
            <a href="edit?no=<%= vo.getid() %>">
                <img src="images/edit.jpg" width="30" height="30">
            </a>
            &nbsp;&nbsp;&nbsp;
            <a href="remove?no=<%= vo.getid() %>" 
               onclick="return confirm('Are you sure?')">
                <img src="images/delete.png" width="30" height="30">
            </a>
        </td>
    </tr>
<%
    }
%>

</table>

<%
    } else {
%>
    <h1 style="color:red;text-align:center">Records not found</h1>
<%
    }
    
%>
<h1 style="text-align:center"><a href="register"><img src="images/add.png" width="40" height="60"/> Add Actor</a></h1>

<br><br>
Message: ${resultMsg}
<h1 style="text-align:center"><a href="./"><img src="images/home.jpg"></a></h1>