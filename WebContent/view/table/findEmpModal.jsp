<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${requestScope.dtoList}" var="dataList" varStatus="status">
	<tr name='${dataList.geteName()}'>
		<td>${status.count}</td>
		<td>${dataList.getdName()}</td>
		<td>${dataList.getdPart()}</td>
		<td>${dataList.geteName()}</td>
	</tr>
</c:forEach>
