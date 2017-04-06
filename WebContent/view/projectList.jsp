<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>projectAll</title>
</head>
<body>
<center>
<h3>재능 기부 프로젝트 list</h3>
<hr><p>

<table border="1">
	<tr>
		<th>프로젝트 코드</th><th>프로젝트명</th><th>사원코드</th>
	</tr>
	
	<c:forEach items="${requestScope.projectAll}" var="dataAll"> 
 		<tr>
 			<td>${dataAll.pIndex}</td>
 			<td>${dataAll.pName}</td>
 			<td>${dataAll.eIndex}</td>
 		</tr>
 	</c:forEach> 
</table>
</center>
</body>
</html>