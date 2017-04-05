<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/view/common/common_header.jsp" %>
        <!-- ============================================================== -->
        <!-- Page Content -->
        <!-- ============================================================== -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">Basic Table</h4> </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /row -->
                <div class="row">
                    <div class="col-sm-12 white-box">  
                        <div class="white-box">
                        	<div class="col-sm-10">
	                            <h3 class="box-title">프로젝트 리스트</h3> 
                        	</div>
                        	<div class="col-sm-2">
                        		<button class="btn btn-write" data-toggle="modal" data-target="#projectWriteModal">작성</button>
                        	</div>                        
                            <div class="table-responsive col-sm-12"> 
                                <table class="table">
                                    <thead>   
                                        <tr>
                                            <th>#</th>
                                            <th>파트</th>
                                            <th>프로젝트 명</th>
                                            <th>책임자</th>
                                            <th>시작일</th>
                                            <th>종료일</th> 
                                            <th>기간</th>  
                                            <th>진행률</th>
                                        </tr>
                                    </thead>
                                    <tbody class="work-table">
                                        <tr data-toggle="modal" data-target="#projectModifyModal">
                                            <td>1</td>
                                            <td>영업</td>
                                            <td>모듈 개발</td>
                                            <td>김진우</td>  
                                            <td>17-02-14</td>
                                            <td>17-03-22</td>
                                            <td>45</td>
                                            <td>55%</td>
                                    	</tr>
                                    	<tr>
                                            <td>2</td>
                                            <td>영업</td>
                                            <td>상품 지원</td>
                                            <td>김진우</td>
                                            <td>17-03-14</td>
                                            <td>17-04-12</td>
                                            <td>49</td>
                                            <td>76%</td>
                                    	</tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.row -->              
            </div>
		</div>
		<%@include file="/view/table/projectWriteModal.jsp" %> 
		<%@include file="/view/table/projectModifyModal.jsp" %> 
		<%@include file="/view/table/findEmpModal.jsp" %> 
		<%@include file="/view/common/common_footer.jsp" %>		