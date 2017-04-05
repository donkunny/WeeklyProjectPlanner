<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/view/common/common_header.jsp" %>
<%-- <% ArrayList<SuperDTO> obj= (ArrayList)request.getAttribute("dto"); %> --%>
<%-- <% Map<String, ArrayList<SuperDTO>> dtlPrj = (HashMap)request.getAttribute("dtlPrj");  %> --%>
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
                <div class="col-sm-12" >
                   		<button class="btn btn-write" data-toggle="modal"  data-target="#writeModal">작성</button>
                 </div>    
                <!-- /row -->
                <c:forEach var="project" items="${dto}" varStatus="status">
                <div class="row">
                    <div class="col-sm-12 white-box">  
                        <div class="white-box">
                        	<div class="col-sm-10">
	                             <h3 class="box-title">${project.pName} / ${project.eName }</h3>
                        	</div>
                        	                    
                            <div class="table-responsive col-sm-12"> 
                                <table class="table"> 
                                    <thead>  
                                        <tr>
                                            <th>#</th>
                                            <th>파트</th>
                                            <th style="width: 400px">업무 상세</th>
                                            <th>담당자</th>
                                            <th>시작일</th>
                                            <th>종료일</th> 
                                            <th>기간</th>  
                                            <th>진행률</th>
                                        </tr>
                                    </thead>
                                    <c:forEach var="detail"  items="${dtlPrj[status.index]}" varStatus="dStatus">
                                    <tbody class="work-table">
                                        <tr data-toggle="modal" data-target="#modifyModal"> 
                                            <td>${dStatus.count}</td>
                                            <td>${detail.dPart}</td>
                                            <td>${detail.pdName }</td>
                                            <td>${detail.eName }</td>  
                                            <td>${detail.pdStartDate }</td>
                                            <td>${detail.pdEndDate }</td>
                                            <fmt:parseNumber var="period"  integerOnly="true" value="${(detail.pdEndDate.getTime()-detail.pdStartDate.getTime()) / (24 * 60 * 60 * 1000)}"/>
                                            <td>${period}</td>
                                            <td>${detail.pdProgress }%</td>
                                    	</tr>
                                    </tbody>
                                    </c:forEach>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.row -->
                </c:forEach>              
            </div>
		</div>
		<%@include file="/view/table/tableWriteModal.jsp" %>
		<%@include file="/view/table/tableModifyModal.jsp" %>
		<%@include file="/view/common/common_footer.jsp" %>		