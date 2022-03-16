<%--
  Created by IntelliJ IDEA.
  User: lizixu
  Date: 2022/3/16
  Time: 12:00
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
<form method="post" action="register">                 <!--默认为get，better to use post-->
    <input type="text" name="username"  placeholder="Username"><br/>
    <input type="text" name="passward" placeholder="passward"><br/>
    <input type="text" name="email" placeholder="Email"><br/>
    Gender<input type="radio" name="gender" value="male" checked>Male
          <input type="radio" name="gender" value="female">Female<br/>
    <input type="text" name="birthdate" placeholder="Data of Birth(yyyy-mm-dd)"><br/>
    <input style="background-color: #ffc000; color: #FFFFFF" type="submit" value="Register" onclick="addUser()">
</form>



</body>
</html>

