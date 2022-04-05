<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: lizixu
  Date: 2022/3/30
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>User List</title>
</head>
<body>
<h1>User List</h1>
<%

%>
<table border=\"1px\" bordercolor=\"#000000\">
    <tr>
        <td>ID</td>
        <td>UserName</td>
        <td>Password</td>
        <td>Email</td>
        <td>Gender</td>
        <td>Birthdate</td>
    </tr>
    <%
        ResultSet rs = (ResultSet) request.getAttribute("rsname");
        if(rs==null){
    %>
    <tr>
        <td> No Data!</td>
    </tr>
    <%}else {
        while (rs.next()) {
            out.println("<tr>");
            out.println("<td>" + rs.getInt("id") + "</td>");
            out.println("<td>" + rs.getString("username") + "</td>");
            out.println("<td>" + rs.getString("password") + "</td>");
            out.println("<td>" + rs.getString("email") + "</td>");
            out.println("<td>" + rs.getString("gender") + "</td>");
            out.println("<td>" + rs.getString("birthdate") + "</td>");
            out.println("</td>");
        }

    }
    %>
</table>
</body>
</html>
<%@include file="footer.jsp"%>