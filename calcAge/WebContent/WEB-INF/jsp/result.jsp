<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.UserInfo"%>
    <%
    UserInfo userInfo =(UserInfo)request.getAttribute("UserInfo");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>年齢計算アプリ</title>
</head>
<body>
<p><%=userInfo.getMsg()%></p>
</body>
</html>