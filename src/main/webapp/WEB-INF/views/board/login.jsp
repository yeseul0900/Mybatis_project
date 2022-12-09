<%--
  Created by IntelliJ IDEA.
  User: yeseul
  Date: 2022/12/09
  Time: 12:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
  <meta charset="UTF-8">
    <title>Login page</title>
  <style>
    img, label { display: inline-block; margin: 0.5rem;}
    label {width: 80px}
    button{background-color: lightsteelblue; color: #002F63; font-size: 15px}
    form{text-align: center;}
  </style>
</head>
<body>
<div style="width:100%; text-align: center; padding-top:100px">
  <img src='../img/smilecat.png' height="250">
  <form method="post" action="loginOK">
    <div><label>User ID: </label><input type='text' name='userid' /></div>
    <div><label>Password: </label><input type='password' name='password' /></div>
    <button type='submit'>login</button>
  </form>
</div>
</body>
</html>
