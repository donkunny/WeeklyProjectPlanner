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
                                    <c:forEach var="project"  items="${pjtList}" varStatus="status">
                                        <tr onclick="sendProjectInfo('${project.pIndex}','${project.dPart}','${project.pName}',
                                        	'${project.eHeadName}','${project.pStartDate}','${project.pEndDate}','${project.pProgress}');ajaxTest('${project.pIndex}');">                                         	
                                            <td>${status.count}</td>
                                            <td>${project.dPart}</td>
                                            <td>${project.pName}</td>
                                            <td>${project.eHeadName}</td>  
                                            <td>${project.pStartDate}</td>
                                            <td>${project.pEndDate}</td>
                                            <fmt:parseNumber var="period"  integerOnly="true" value="${(project.pEndDate.getTime()-project.pStartDate.getTime()) / (24 * 60 * 60 * 1000)}"/>
                                            <td>${period}</td>
                                            <td>${project.pProgress}</td>
                                    	</tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.row -->              
            </div>
		</div>
		<script>
		
		function sendProjectInfo(i,d,p,h,s,e,g) {
			$('#pIndexSave input').val(i);
			$("#pjtName input").val(p);
			$("#partOption select").val(d);
			$("#phtHdName input").val(h);
			$("#stDate input").val(s);
			$("#edDate input").val(e);
			$("#progress input").val(g);
			printMember(i);
		} 
		

		</script>	
	
		<%@include file="/view/table/projectWriteModal.jsp" %> 
		<%@include file="/view/table/projectModifyModal.jsp" %> 
		<%@include file="/view/table/findEmpModal.jsp" %> 
		<%@include file="/view/common/common_footer.jsp" %>		