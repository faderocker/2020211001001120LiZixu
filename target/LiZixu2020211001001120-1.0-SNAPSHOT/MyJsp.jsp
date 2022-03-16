<%--
  Created by IntelliJ IDEA.
  User: lizixu
  Date: 2022/3/16
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp_week2</title>
    <script type="text/javascript">
        function addUser(){
            alert("Login was successful!");
        }

    </script>
</head>
<body>
New User Registration!
<form method="post">                 <!--默认为get，better to use post-->
    <input type="text" name="name"  placeholder="Username"><br/>
    <input type="text" name="id" placeholder="passward"><br/>
    <input type="text" name="id" placeholder="Email"><br/>
    Gender<input type="radio" name="gender" checked>Male
          <input type="radio" name="gender">Female<br/>
    <input type="text" name="id" placeholder="Data of Birth(yyyy-mm-dd)"><br/>
    <input style="background-color: #ffc000; color: #FFFFFF" type="submit" value="Register">
</form>



</body>
</html>
