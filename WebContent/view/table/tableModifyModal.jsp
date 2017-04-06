<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<!-- Modal -->
<div class="modal fade" id="modifyModal" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header modal-table-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">PROJECT-수정</h4>
			</div>
			<div class="modal-body">
				<div class="tab-pane" id="settings">
					<form class="form-horizontal form-material" id="modify_id"  name="modify" role="form">
						<input type="hidden" name="pdIndex"  id="pdIndex_id" value="">
						<input type="hidden" name="eIndex"  value="${msg.eIndex}">
						<input type="hidden" name="command" value="">
						<div class="form-group modal-table">							
							<label class="col-sm-12">프로젝트 명</label>							
							<div class="col-sm-12" id ="div_pName">
								<input type="text"  class="form-control form-control-line" name="pName" value="" readonly="readonly">
							</div>
						</div>
						<div class="form-group modal-table">
							<label class="col-md-4">파트</label>
							<label class="col-md-4">책임자</label>
							<label class="col-md-4">담당자</label>
							<div class="col-sm-4" id="div_dPart">
								<input type="text"  class="form-control form-control-line" name="dPart" value="">
							</div>
							<div class="col-md-4" id="div_eHeadName">
								<input type="text" placeholder="" class="form-control form-control-line" name="eHeadName" value="" readonly="readonly">
							</div>
							<div class="col-md-4" id="div_eName">
								<input type="text" placeholder="" class="form-control form-control-line" name="eName" value="">
							</div>
						</div>						
						<div class="form-group modal-table" >
							<label class="col-md-12">업무 상세</label>
							<div class="col-md-12" id="div_pdName">
								<input type="text" placeholder="모듈 개발" class="form-control form-control-line" name="pdName"  id="pdName_id" >
							</div>
						</div>
						<div class="form-group modal-table">
							<label class="col-md-4">시작일</label>
							<label class="col-md-4">종료일</label>
							<label class="col-md-4">진행률</label>
							<div class="col-md-4" id="div_pdStartDate">
								<input type="text" placeholder="yyyy-mm-dd" class="form-control form-control-line" name="pdStartDate" id="startDate" >
							</div>
							<div class="col-md-4" id="div_pdEndDate">
								<input type="text" placeholder="yyyy-mm-dd" class="form-control form-control-line" name="pdEndDate" id="endDate" > 
							</div>
							<div class="col-md-4" id="div_pdProgress">
								<input type="text" placeholder="" class="form-control form-control-line" name="pdProgress" id="pdProgress_id" value="">
							</div>
						</div>
					</form>
				</div>

			</div>
					<div class="modal-footer">
						<button class="btn btn-success" onclick="btn_modifyDtlPrj()">수정</button>
						<button class="btn btn-success">삭제</button>
						<button type="button" class="btn btn-success" data-dismiss="modal">취소</button>
					</div>
		</div>
	</div>
</div>
<script src="${pageContext.request.contextPath}/script/jquery-3.2.0.js"></script>
<script>
function modifyDtlPrj(a, b, c, d, e, f, g, h, i) {
	 	 $('#div_pName input').val(a);
         $("#div_dPart input").val(b);
      	 $("#div_eHeadName input").val(c);
       	 $("#div_eName input").val(d);
         $("#div_pdName input").val(e);
  	     $("#div_pdStartDate input").val(f);
         $("#div_pdEndDate input").val(g);
         $("#div_pdProgress input").val(h);
         $("#modify_id input").first().val(i);
 };
 
 function btn_modifyDtlPrj(){
	 var pdIndex = pdIndex_id.value;
	var formObj = $("form[role='form']");
	var pdName = pdName_id.value;
	var pdStartDate = startDate.value;
	var pdEndDate = endDate.value;
	var pdProgress = document.getElementById("pdProgress_id").value;
	document.forms["modify"]["command"].value = 'updateDtlPrj' ;
// 	alert('pdName: ' + pdName + ' pdStartDate: ' + pdStartDate + ' pdEndDate: ' +pdEndDate + 'pdProgress: ' + pdProgress + ' pdIndex: ' + pdIndex);
		if (pdName =='' || pdStartDate=='' || pdEndDate=='' || pdStartDate>pdEndDate || pdProgress=='') {
			if(pdName =='' || pdStartDate=='' || pdEndDate=='' || pdProgress == ''){
				alert('내용을 입력해주세요.');
// 				alert('pdName: ' + pdName + ' pdStartDate: ' + pdStartDate + ' pdEndDate: ' +pdEndDate + 'pdProgress: ' + pdProgress);
			}
			if(pdStartDate>pdEndDate) {
				alert('시작일이 종료일보다 빨라야 합니다.');
			}
		} else {
			formObj.attr("action", "<%=pageContext.getServletContext().getContextPath()%>/project");
			formObj.attr("method", "post");
			formObj.submit();
		}
 };
</script>