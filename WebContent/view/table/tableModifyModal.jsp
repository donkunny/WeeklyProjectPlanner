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
					<form class="form-horizontal form-material">
						<div class="form-group modal-table">							
							<label class="col-sm-12">프로젝트 명</label>							
							<div class="col-sm-12">
								<select class="form-control form-control-line">
									<option>프로젝트1</option>
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
								</select>
							</div>
							<div class="col-md-4">
								<input type="text" placeholder="김동혁" class="form-control form-control-line">
							</div>
							<div class="col-md-4">
								<input type="text" placeholder="김진우" class="form-control form-control-line">
							</div>
						</div>						
						<div class="form-group modal-table">
							<label class="col-md-12">업무 상세</label>
							<div class="col-md-12">
								<input type="text" placeholder="모듈 개발" class="form-control form-control-line">
							</div>
						</div>
						<div class="form-group modal-table">
							<label class="col-md-4">시작일</label>
							<label class="col-md-4">종료일</label>
							<label class="col-md-4">진행률</label>
							<div class="col-md-4">
								<input type="text" placeholder="김동혁" class="form-control form-control-line">
							</div>
							<div class="col-md-4">
								<input type="text" placeholder="김진우" class="form-control form-control-line">
							</div>
							<div class="col-md-4">
								<input type="text" placeholder="김동혁" class="form-control form-control-line">
							</div>
						</div>
					</form>
				</div>

			</div>
					<div class="modal-footer">
						<button class="btn btn-success">수정</button>
						<button class="btn btn-success">삭제</button>
						<button type="button" class="btn btn-success" data-dismiss="modal">취소</button>
					</div>
		</div>
	</div>
</div>