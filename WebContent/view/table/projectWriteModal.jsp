<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String url = application.getContextPath() + "/"; %>
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
								<input type="text" placeholder="김진우" class="form-control form-control-line">
							</div>
						</div>						
						<div class="form-group modal-table">
							<label class="col-sm-2">담당자</label>
							<div class="col-sm-2">
								<!-- <추가 <a href="=pageContext.getServletContext().getContextPath()%>/emp?command=userList">-->
								<input type="button" class="btn" value="추가" onclick="printList()">
								<!-- <input type="button" class="btn" value="추가" data-toggle="modal" data-target="#findEmpModal" onclick="printList()"> -->
								<!-- </a>  -->
							</div>
							<div class="table-responsive col-sm-12"> 
                                <table class="table"> 
                                    <thead>   
                                        <tr>
                                            <th>#</th>
                                            <th>파트</th>
                                            <th>담당자</th>
                                            <th>업무 상세</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody class="work-table">
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
                                    </tbody>
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
								<input type="text" placeholder="50%" class="form-control form-control-line">
							</div>
						</div>
					</form>
				</div>

			</div>
					<div class="modal-footer">
						<button class="btn btn-success">저장</button>
						<button class="btn btn-success">삭제</button>
						<button type="button" class="btn btn-success" data-dismiss="modal">취소</button>
					</div>
		</div>
	</div>
</div>

<script type="text/javascript" src="script/jquery-3.2.0.js"></script>
<script>
	function printList() {
		$.ajax({
			url:"${pageContext.request.contextPath}/emp",
			data : {command : "userList"},
			type : "post",
			success : function(data) {
				$('#findEmpModal').modal(); 
				$("#viewTest").html(data);
			},
			error:function(s) {
				console.log(s);
			}
        });
	} 
</script>

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
								<input type="text" 
								id='txtFilter' onkeyup='{filter();return false}' 
								onkeypress='javascript:if(event.keyCode==13){ filter(); return false;}' 
								placeholder="김동혁" class="form-control form-control-line">
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
                                    <tbody id="viewTest" class="work-table">
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
	
	function filter(){
		if($('#txtFilter').val()=="")
			$("#viewTest tr").css('display','');			
		else{
			$("#viewTest tr").css('display','none');
			$("#viewTest tr[name*='"+$('#txtFilter').val()+"']").css('display','');
		}
		return false;
	}
</script>