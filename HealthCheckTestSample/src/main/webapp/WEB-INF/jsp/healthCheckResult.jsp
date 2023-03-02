<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="model.HealthData" %>
<% HealthData hd = (HealthData)request.getAttribute("health");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ健康診断</title>
</head>
<body>
<h1>スッキリ健康診断の結果</h1>
<p>
身長：<%= hd.getHeight()   %><br>
体重：<%= hd.getWeight()   %><br>
BMI ：<%= hd.getBmi()      %><br>
体型：<%= hd.getBodyType() %><br>
</p>
<a href="HealthCheck">戻る</a>
</body>
</html>