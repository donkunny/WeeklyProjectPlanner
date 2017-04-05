<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<!-- Modal -->
<div class="modal fade" id="writeModal" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<form method="post" action="">
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
								<select class="form-control form-control-line">
									<c:forEach var="project"  items="${dto}">
										<option>${project.pName}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group modal-table">
							<label class="col-md-4">파트</label>
							<label class="col-md-4">책임자</label>
							<label class="col-md-4">담당자</label>
							<div class="col-sm-4">
								<select class="form-control form-control-line">
									<option>영업</option>
									<option>지원</option>
									<option>점포</option>
								</select>
							</div>
							<div class="col-md-4">
								<input type="text" placeholder="000" class="form-control form-control-line">
							</div>
							<div class="col-md-4">
								<input type="text" placeholder="000" class="form-control form-control-line">
							</div>
						</div>						
						<div class="form-group modal-table">
							<label class="col-md-12">업무 상세</label>
							<div class="col-md-12">
								<input type="text" placeholder="ex) 모듈 개발" class="form-control form-control-line">
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
								<input type="text" placeholder="0" class="form-control form-control-line"  readonly="readonly">
							</div>
						</div>
					</form>
				</div>
			</div>
			</form>
					<div class="modal-footer">
						<button class="btn btn-success">수정</button>
						<button class="btn btn-success">삭제</button>
						<button type="button" class="btn btn-success" data-dismiss="modal">취소</button>
					</div>
		</div>
	</div>
</div>	