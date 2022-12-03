<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yeseul
  Date: 2022/11/25
  Time: 10:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false"%>
<html>
<head>
    <title>List</title>
</head>
<body>
<h1>${title}</h1>
<c:forEach var="name" items="${classlist}" varStatus="status">
    <p>${status.count} : ${name}</p>
</c:forEach>
</body>
</html>
