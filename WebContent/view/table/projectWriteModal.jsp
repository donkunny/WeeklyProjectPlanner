<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
								<a href="emp?command=userList">
								<input type="button" class="btn" value="추가" data-toggle="modal" data-target="#findEmpModal">
								</a>
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
<script>
	
</script>