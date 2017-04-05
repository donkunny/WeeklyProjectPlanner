<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String url = application.getContextPath() + "/"; %>
	<!-- Modal -->
<div class="modal fade" id="findEmpModal" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header modal-table-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">담당자 찾기</h4>
			</div>
			<div class="modal-body">
				<div class="tab-pane" id="settings">
					<form class="form-horizontal form-material">
						<div class="form-group modal-table">							
							<label class="col-sm-12">이름</label>							
							<div class="col-sm-12">
								<a href="<%=pageContext.getServletContext().getContextPath()%>/emp?command=userList">
								<input type="text" 
								id='txtFilter' onkeyup='{filter();return false}' 
								onkeypress='javascript:if(event.keyCode==13){ filter(); return false;}' 
								placeholder="김동혁" class="form-control form-control-line">
								</a>
							</div>
						</div>
						<div class="form-group modal-table">
							<label class="col-md-12">검색 결과</label>
							<div class="table-responsive col-sm-12"> 
                                <table class="table"> 
                                    <thead>   
                                        <tr>
                                            <th>#</th>
                                            <th>부서</th>
                                            <th>담당</th>
                                            <th>이름</th>
                                        </tr>
                                    </thead>
                                    <tbody id="empList" class="work-table">
                                    <c:forEach items="${requestScope.dtoList}" var="dataList"> 
								 		<tr name='${dataList.geteName}'>
								 			<td>${status.count}</td>
								 			<td>${dataList.getdName}</td>
                                            <td>${dataList.getdPart}</td>
                                            <td>${dataList.geteName}</td>
								 		</tr>
								 	</c:forEach> 
                                    </tbody>
                                </table>
                            </div>							
						</div>												
					</form>
				</div>

			</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-success" data-dismiss="modal">취소</button>
					</div>
		</div>
	</div>
</div>

<script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js'></script>
<script type='text/javascript'>
	function filter(){
		if($('#txtFilter').val()=="")
			$("#empList tr").css('display','');			
		else{
			$("#empList tr").css('display','none');
			$("#empList tr[name*='"+$('#txtFilter').val()+"']").css('display','');
		}
		return false;
	}
</script>