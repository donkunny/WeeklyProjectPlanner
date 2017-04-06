<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- Modal -->
<div class="modal fade" id="projectModifyModal" role="dialog">
	<div class="modal-dialog">
		<div id="pIndexSave"><input type="hidden" id="pIndex"></div>
		<div id="eHeadIndexSave"><input type="hidden" id="eHeadIndex"></div>
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header modal-table-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">PROJECT-수정</h4>
			</div>
			<div class="modal-body">
				<div class="tab-pane" id="settings">
					<form name="projectModifyForm" mehtod="post" class="form-horizontal form-material">
						<div class="form-group modal-table">							
							<label class="col-sm-12">프로젝트 명</label>							
							<div id="pjtName" class="col-sm-12">
								<input type="text" id="pName" placeholder="프로젝트 이름" class="form-control form-control-line">
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
								<input type="text" id="eHeadName" placeholder="책임자" class="form-control form-control-line">
							</div>
						</div>						
						<div class="form-group modal-table">
							<label class="col-sm-2">담당자</label>
							<div class="col-sm-2">
								<input type="button" class="btn" value="추가" onclick="printList()"> 
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
							<div class="col-md-4">
								<div id="stDate" class='input-group date' id='datetimepicker2'>
        							<input class="form-control" id="start_date" name="start_date" placeholder="MM/DD/YYY" type="text"/>
				                </div>
							</div>
							<div class="col-md-4">
								<div id="edDate" class='input-group date' id='datetimepicker2'>
        							<input class="form-control" id="end_date" name="end_date" placeholder="MM/DD/YYY" type="text"/>
				                </div>
							</div>
							<div id="progress" class="col-md-4">
								<input type="text" id="pProgress" placeholder="0%" class="form-control form-control-line">
							</div>
						</div>
					</form>
				</div>

			</div>
					<div class="modal-footer">
						<button class="btn btn-success" value="save" onclick="submit(this.value); javascript:window.location.reload();" data-dismiss="modal">저장</button>
						<button class="btn btn-success" value="delete" onclick="submit(this.value); javascript:window.location.reload();" data-dismiss="modal">삭제</button>
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
function submit(v) {
	if(v == 'save') {
		var date_start_input = document.projectModifyForm.start_date.value;
		var date_end_input = document.projectModifyForm.end_date.value;
		$.ajax({
			url:"${pageContext.request.contextPath}/project",
			data : {command : "updateProject",
					pIndex : pIndex.value,
					pName : pName.value,
					eHeadIndex : eHeadIndex.value,
					pStartDate : date_start_input,
					pEndDate : date_end_input,
					pProgress : pProgress.value
					},			
			type : "post",
			error:function(s) {
				console.log(s);
			}
		})
	} else if(v == 'delete') {
		$.ajax({
			url:"${pageContext.request.contextPath}/project",
			data : {command : "deleteProject",
					pIndex : pIndex.value
					},			
			type : "post",
			error:function(s) {
				console.log(s);
			}
		})
	}
};
</script>