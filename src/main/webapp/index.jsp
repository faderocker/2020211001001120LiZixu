
<%@include file="header.jsp" %>


<h1>Welcome to my page.
</h1>
<br/>
<form method="get" target="_blank" action="search">
    <input type="text" name="txt" size=30 />
    <select name="search">
        <option value="baidu">Baidu</option>
        <option value="bing">Bing</option>
        <option value="google">Google</option>
    </select>
    <input type="submit" value="Search"/>
</form>

<a href="hello-servlet"> Hello Servlet-week1</a><br>
<a href="hello">         HelloWorldServlet-week2</a><br>
<a href="life">          LifeCycleServlet-week3</a><br>
<a href="register.jsp">  RegisterServlet-week3</a><br>
<a href="config">        ConfigDemoServlet-week4</a><br>
<a href="jdbc">          JDBCServlet-week4</a><br>
<a href="login.jsp">         LoginServlet-week5</a><br>
<%@include file="footer.jsp"%>