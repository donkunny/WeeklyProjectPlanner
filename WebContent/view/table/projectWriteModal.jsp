<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Modal -->
<div class="modal fade" id="projectWriteModal" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header modal-table-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">PROJECT-작성</h4>
			</div>
			<div class="modal-body">
				<div class="tab-pane" id="settings">
					<form class="form-horizontal form-material">
						<div class="form-group modal-table">							
							<label class="col-sm-12">프로젝트 명</label>							
							<div class="col-sm-12">
								<input type="text" placeholder="프로젝트 이름" class="form-control form-control-line">
							</div>
						</div>
						<div class="form-group modal-table">
							<label class="col-md-4">파트</label>
							<label class="col-md-8">책임자</label>
							<div class="col-sm-4">
								<select class="form-control form-control-line">
									<option>영업</option>
									<option>지원</option>
								</select>
							</div>
							<div class="col-md-8">
								<input type="text" placeholder="책임자" class="form-control form-control-line">
							</div>
						</div>						
						<div class="form-group modal-table">
							<label class="col-sm-2">팀원</label>
							<div class="col-sm-2">
								<input type="button" class="btn" value="추가" onclick="printList()">
							</div>
							<div class="table-responsive col-sm-12"> 
                                <table class="table"> 
                                    <thead>   
                                        <tr>
                                            <th>#</th>
                                            <th>부서</th>
                                            <th>파트</th>
                                            <th>이름</th>
                                        </tr>
                                    </thead>
                                    <div id="test"></div>
                                    <%--<c:forEach var="mDetail"  items="${memList}" varStatus="dStatus">
                                    <tbody class="work-table">
                                        <tr> 
                                            <td>${dStatus.count}</td>
                                            <td>${mDetail.dName}</td>
                                            <td>${mDetail.dPart}</td>
                                            <td>${mDetail.eName}</td>  
                                    	</tr>
                                    </tbody>
                                    </c:forEach>
                                      <tbody id="viewMember" class="work-table">
                                        <tr>  
                                            <td>1</td>
                                            <td>영업</td>
                                            <td>김용현</td>
                                            <td>업무 내용 작성</td> 
                                            <td>
                                            	<input type="button" class="btn" value="삭제">
                                            </td>
                                    	</tr>
                                    	<tr>  
                                            <td>2</td>
                                            <td>영업</td>
                                            <td>박소은</td>
                                            <td>업무 내용 작성</td>
                                            <td>
                                            	<input type="button" class="btn" value="삭제">
                                            </td>  
                                    	</tr>
                                    </tbody>--%>
                                </table>
                            </div>
						</div>
						<div class="form-group modal-table">
							<label class="col-md-4">시작일</label>
							<label class="col-md-4">종료일</label>
							<label class="col-md-4">진행률</label>
							<div class="col-md-4">
								<div class='input-group date' id='datetimepicker2'>
        							<input class="form-control" id="start_date" name="start_date" placeholder="MM/DD/YYY" type="text"/>
				                </div>
							</div>
							<div class="col-md-4">
								<div class='input-group date' id='datetimepicker2'>
        							<input class="form-control" id="end_date" name="end_date" placeholder="MM/DD/YYY" type="text"/>
				                </div>
							</div>
							<div class="col-md-4">
								<input type="text" placeholder="0%" class="form-control form-control-line">
							</div>
						</div>
					</form>
				</div>

			</div>
					<div class="modal-footer">
						<button class="btn btn-success" >저장</button>
						<%-- <button class="btn btn-success" >삭제</button>--%>
						<button type="button" class="btn btn-success" data-dismiss="modal">취소</button>
					</div>
		</div>
	</div>
</div>

<script>
	function printList() {
		$.ajax({
			url:"${pageContext.request.contextPath}/emp",
			data : {command : "userList"},
			type : "post",
			success : function(data) {
				$('#findEmpModal').modal(); 
				$("#viewEmp").html(data);
			},
			error:function(s) {
				console.log(s);
			}
        });
	} 
	
</script>

<!-- Modal -->
<div class="modal fade" id="findEmpModal" role="dialog" style="z-index : 2000;">
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
								<input type="text" 
								id='txtFilter' onkeyup='{filter();return false}' 
								onkeypress='javascript:if(event.keyCode==13){ filter(); return false;}' 
								placeholder="" class="form-control form-control-line">
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
                                    <tbody id="viewEmp" class="work-table">
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
<script type="text/javascript" src="script/jquery-3.2.0.js"></script>
<script type='text/javascript'>
	$("#viewEmp").hide();
	function filter(){
		if($('#txtFilter').val()=="") {
			$("#viewEmp").hide();
			$("#viewEmp tr").css('display','');		
		}
		else{
			$("#viewEmp").show();
			$("#viewEmp tr").css('display','none');
			$("#viewEmp tr[name*='"+$('#txtFilter').val()+"']").css('display','');
		}
		return false;
	}
	function selectEmp(v) {
		$.ajax({
			url:"${pageContext.request.contextPath}/emp",
			data : {command : "insertTeamMember",
					eIndex : v,
					pIndex : v}, //프로젝트 코드 출력 요망
			type : "post",
			success : function() {
				
			},
			error:function(s) {
				console.log(s);
			}
        });
	}
	
</script>