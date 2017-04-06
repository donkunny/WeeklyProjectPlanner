<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${dtoList}" var="dataList" varStatus="status">
	<tr name="${dataList.eName}" onclick="addMember('${dataList.dName}','${dataList.dPart}','${dataList.eName}'); selectEmp('${dataList.eIndex}');" 
			data-dismiss="modal">
		<td>${status.count}</td>
		<td>${dataList.dName}</td>
		<td>${dataList.dPart}</td>
		<td>${dataList.eName}</td>
	</tr>
</c:forEach>


<c:forEach items="${memList}" var="member" varStatus="status">
	<tr>
		<td>${status.count}</td>
		<td>${member.dName}</td>
		<td>${member.dPart}</td>
		<td>${member.eName}</td>
        <td>
        	<input type="button" class="btn" value="삭제">
        </td>
	</tr>
</c:forEach>

<script type="text/javascript">
function addMember(d,p,e) {
	document.getElementById('addPrintMember').innerHTML = '<tr><td>+</td><td>' + d + '</td>'+
		'<td>' + p + '</td><td>' + e + '</td><td><input type="button" class="btn" value="삭제">' +
        '</td></tr>';
};
</script>