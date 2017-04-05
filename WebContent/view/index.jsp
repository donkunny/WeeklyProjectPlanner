<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% String url = application.getContextPath() + "/"; %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>로그인 화면</title>
</head>
<body>
	<h2>로그인 화면</h2>
	<a href="<%=url %>project?command=listAll">리스트 화면으로 가기</a>
</body>
</html>