<%--
  Created by IntelliJ IDEA.
  User: lizixu
  Date: 2022/3/28
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Login</h1>
    <br>
<%
if(!(request.getAttribute("message")==null)){
    out.println(request.getAttribute("message"));
}
%>
    <form method="post" action="login">
    UserName:<input name="username" type="text"><br>
    Password:<input name="password" type="text"><br>
             <input type="submit" value="Login" >
    </form>
</body>
</html>
<%@include file="footer.jsp"%>
