<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${dtoList}" var="dataList" varStatus="status">
	<tr name="${dataList.eName}" onclick="selectEmp('${dataList.eIndex}')">
		<td>${status.count}</td>
		<td>${dataList.dName}</td>
		<td>${dataList.dPart}</td>
		<td>${dataList.eName}</td>
	</tr>
</c:forEach>
