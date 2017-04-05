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
                        	<div class="col-sm-12">  
	                            <h2 class="box-title">프로젝트 이름1</h2> 
                        	</div>     
                        	<div id="visualization" class="col-sm-12"></div>  
                        </div>
                    </div>
                </div>
                <!-- /.row -->              
            </div>
		</div>
		
<!-- Chart -->
<script src="${pageContext.request.contextPath}/resources/js/vis.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/moment.js/2.13.0/moment.min.js"></script>
<!-- Chart -->
<script type="text/javascript">
var groups = new vis.DataSet([
    {id: 0, content: '<div class="chartTableMain"><div class="col-sm-8 chartTable">프로젝트 이름</div><div class="col-sm-4 chartTable chartTable-name">김진우</div></div>', value: 1},
    {id: 1, content: '<div class="chartTableMain"><div class="col-sm-8 chartTable">세부업무 이름1</div><div class="col-sm-4 chartTable chartTable-name">김용현</div></div>', value: 2},
    {id: 2, content: '<div class="chartTableMain"><div class="col-sm-8 chartTable">세부업무 이름2</div><div class="col-sm-4 chartTable chartTable-name">김동혁</div></div>', value: 3},
  ]);

  // create a dataset with items
  // note that months are zero-based in the JavaScript Date object, so month 3 is April
  var items = new vis.DataSet([
    {id: 0, group: 0, value: 0.2, content: 'item 0', start: new Date(2014, 3, 17), end: new Date(2014, 3, 21)},
    {id: 2, group: 1, value: 0.2, content: 'item 2', start: new Date(2014, 3, 16), end: new Date(2014, 3, 24)},
    {id: 5, group: 2, value: 0.2, content: 'item 5', start: new Date(2014, 3, 24), end: new Date(2014, 3, 27)}
  ]); 

  // create visualization
  var container = document.getElementById('visualization');
  var options = {
		  visibleFrameTemplate: function(item) {
		      if (item.visibleFrameTemplate) {
		        return item.visibleFrameTemplate;
		      } 
		      var percentage = item.value * 100 + '%';
		      if(item.group == 0) {			    	  
		    	  return '<div class="progress-wrapper"><div class="progress-mainProject" style="width:' + percentage + '"></div><label class="progress-label">' + percentage + '<label></div>';
		      }
		      return '<div class="progress-wrapper"><div class="progress" style="width:' + percentage + '"></div><label class="progress-label">' + percentage + '<label></div>';			      			     
		    }, 
    // option groupOrder can be a property name or a sort function
    // the sort function must compare two groups and return a value
    //     > 0 when a > b
    //     < 0 when a < b
    //       0 when a == b
    groupOrder: function (a, b) {
      return a.value - b.value;
    }    
  };

  var timeline = new vis.Timeline(container);
  timeline.setOptions(options);
  timeline.setGroups(groups);
  timeline.setItems(items);
</script>
		<%@include file="/view/table/projectWriteModal.jsp" %> 
		<%@include file="/view/table/projectModifyModal.jsp" %> 
		<%@include file="/view/table/findEmpModal.jsp" %> 
		<%@include file="/view/common/common_footer.jsp" %>		