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


<c:forEach items="${memList}" var="member" varStatus="status">
	<tr><%-- name="${dataList.eName}"--%>
		<td>${status.count}</td>
		<td>${member.dName}</td>
		<td>${member.dPart}</td>
		<td>${member.eName}</td>
        <td>
        	<input type="button" class="btn" value="삭제">
        </td>
	</tr>
</c:forEach>