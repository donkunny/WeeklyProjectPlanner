<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- Modal -->
<div class="modal fade" id="projectModifyModal" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header modal-table-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">PROJECT-수정</h4>
			</div>
			<div class="modal-body">
				<div class="tab-pane" id="settings">
					<form class="form-horizontal form-material">
						<div class="form-group modal-table">							
							<label class="col-sm-12">프로젝트 명</label>							
							<div id="pjtName" class="col-sm-12">
								<input type="text" placeholder="프로젝트 이름" class="form-control form-control-line">
							</div>
						</div>
						<div class="form-group modal-table">
							<label class="col-md-4">파트</label>
							<label class="col-md-8">책임자</label>
							<div id="partOption" class="col-sm-4">
								<select class="form-control form-control-line">
									<option value="영업">영업</option>
									<option value="지원">지원</option>
								</select>
							</div>
							<div id="phtHdName" class="col-md-8">
								<input type="text" placeholder="책임자" class="form-control form-control-line">
							</div>
						</div>						
						<div class="form-group modal-table">
							<label class="col-sm-2">담당자</label>
							<div class="col-sm-2">
								<input type="button" class="btn" value="추가" onclick="printList()"> <%--  data-toggle="modal" data-target="#findEmpModal">--%>
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
                                    <tbody id="printMember" class="work-table">
                                    </tbody>
                                </table>
                            </div>
						</div>
						<div class="form-group modal-table">
							<label class="col-md-4">시작일</label>
							<label class="col-md-4">종료일</label>
							<label class="col-md-4">진행률</label>
							<div id="stDate" class="col-md-4">
								<div class='input-group date' id='datetimepicker2'>
        							<input class="form-control" id="start_date" name="start_date" placeholder="MM/DD/YYY" type="text"/>
				                </div>
							</div>
							<div id="edDate" class="col-md-4">
								<div class='input-group date' id='datetimepicker2'>
        							<input class="form-control" id="end_date" name="end_date" placeholder="MM/DD/YYY" type="text"/>
				                </div>
							</div>
							<div id="progress" class="col-md-4">
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
<script>
function printMember(i){
	$.ajax({
		url:"${pageContext.request.contextPath}/emp",
		data : {command : "memberList",
				pIndex : i},
		
		type : "post",
		success : function(data) {
			$("#projectModifyModal").modal(); 
			$("#printMember").html(data);
		},
		error:function(s) {
			console.log(s);
		}
	})
};
</script>