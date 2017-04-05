<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
								<input type="text" placeholder="김동혁" class="form-control form-control-line">
							</div>
						</div>
						<div class="form-group modal-table">
							<label class="col-md-12">검색 결과</label>
							<div class="table-responsive col-sm-12"> 
                                <table class="table"> 
                                    <thead>   
                                        <tr>
                                            <th>#</th>
                                            <th>파트</th>
                                            <th>담당자</th>
                                        </tr>
                                    </thead>
                                    <tbody class="work-table">
                                        <tr>  
                                            <td>1</td>
                                            <td>영업</td>
                                            <td>김진우</td>
                                    	</tr>
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