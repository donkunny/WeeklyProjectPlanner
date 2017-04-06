<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Modal -->
<div class="modal fade" id="writeModal" role="dialog">
   <div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header modal-table-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">PROJECT-작성</h4>
			</div>
			<div class="modal-body">
				<div class="tab-pane" id="settings">
					<form class="form-horizontal form-material"  id="put_id"  name="put" role="form" method="post">
						<input type="hidden" name="pIndex"  id="pIndex_id" value="">
						<input type="hidden" name="eIndex" value="${msg.eIndex}">
						<input type="hidden" name="command" id="command_id" value="insertDtlPrj">
						<div class="form-group modal-table">
							<label class="col-sm-12">프로젝트 명</label>
							<div class="col-sm-12">
								<select class="form-control form-control-line" id="changeHead">
									<option value="책임자">선택</option>
									<c:forEach var="project" items="${dto}">
										<option id="${project.pIndex}" value="${project.eHeadName}">${project.pName}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group modal-table">
							<label class="col-md-4">파트</label> 
							<label class="col-md-4">책임자</label>
							<label class="col-md-4">담당자</label>
							<div class="col-sm-4">
								<input type="text" placeholder="" class="form-control form-control-line" value="${dPart}" readonly="readonly">
							</div>
							<div id="hdName" class="col-md-4">
								<input type="text" placeholder="책임자"
									class="form-control form-control-line">
							</div>
							<div class="col-md-4">
								<input type="text" placeholder="" class="form-control form-control-line" value="${msg.eName}" readonly="readonly">
							</div>
						</div>
						<div class="form-group modal-table">
							<label class="col-md-12">업무 상세</label>
							<div class="col-md-12">
								<input type="text" placeholder="ex) 모듈 개발" class="form-control form-control-line" id="pdName" name="pdName">
							</div>
						</div>
						<div class="form-group modal-table">
							<label class="col-md-4">시작일</label> <label class="col-md-4">종료일</label>
							<label class="col-md-4">진행률</label>
							<div class="col-md-4">
								<div class='input-group date' id='datetimepicker2'>
									<input class="form-control" id="start_date" name="pdStartDate" placeholder="YYYY-MM-DD" type="text" />
								</div>
							</div>
							<div class="col-md-4">
								<div class='input-group date' id='datetimepicker2'>
									<input class="form-control" id="end_date" name="pdEndDate" placeholder="YYYY-MM-DD" type="text" />
								</div>
							</div>
							<div class="col-md-4">
								<input type="text" placeholder=""
									class="form-control form-control-line" value="0" 	readonly="readonly">
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn btn-success" onclick="insertDtlPrj()">입력</button>
				<button type="button" class="btn btn-success" data-dismiss="modal">취소</button>
			</div>
		</div>
	</div>
</div>
	<script src="${pageContext.request.contextPath}/script/jquery-3.2.0.js"></script>
<script>
	$('#changeHead').change(function(){
	    var optId = $(this).find('option:selected').attr('id');
	    var optValue =$(this).find('option:selected').attr('value');
	    $('#put_id input').first().val(optId);
	    $('#hdName input').val(optValue);
	});

	function insertDtlPrj() {
		var formObj = $("form[role='form']");
		var chosen = $("#changeHead").find('option:selected').attr('value');
		var pdName = document.getElementById("pdName").value;
		var pdStartDate =  document.getElementById("start_date").value;
		var pdEndDate = document.getElementById("end_date").value;
		var command = document.getElementById("command_id").value;
		// alert(command);
		//document.forms["put"]["command"].value = 'insertDtlPrj' ;
		if (chosen == '책임자' || pdName =='' || pdStartDate=='' || pdEndDate=='' || pdStartDate>pdEndDate) {
			if(chosen == '책임자' || pdName =='' || pdStartDate=='' || pdEndDate==''){
				alert('내용을 입력해주세요.');
			}
			if(pdStartDate>pdEndDate) {
				alert('시작일이 종료일보다 빨라야 합니다.');
			}
		} else {
			document.put.action="${pageContext.request.contextPath}/project";
			document.put.submit();
		}
	};
</script>