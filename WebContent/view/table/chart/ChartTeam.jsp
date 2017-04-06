<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/view/common/common_header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
        <!-- ============================================================== -->
        <!-- Page Content -->
        <!-- ============================================================== -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h3 class="box-title" style="font-weight: bold;">전체 프로젝트 일정</h3></div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /row -->
	                <div id="makeChart" class="row" id="tableViewTest">                 
	                   <div class="col-sm-12 white-box">
	                   	<h3 style="font-weight: bold;">영업</h3>  
	                        <div class="white-box">
	                        	<ul class="list-inline text-right">
	                                <li>
	                                    <h5><i class="fa fa-circle m-r-5 text-info"></i>프로젝트</h5> </li>	                               
	                            </ul>
	                        	<div class="col-sm-12">
	                        		<div id="visualization0" class="col-sm-12" ></div>		                            
	                        	</div>
	                        </div>
	                    </div>  
	                </div>
	                
	                <div id="makeChart" class="row" id="tableViewTest">                 
	                   <div class="col-sm-12 white-box">
	                   	<h3 style="font-weight: bold;">지원</h3>  
	                        <div class="white-box">
	                        	<ul class="list-inline text-right">
	                                <li>
	                                    <h5><i class="fa fa-circle m-r-5 text-info"></i>프로젝트</h5> </li>	                               
	                            </ul>
	                        	<div class="col-sm-12">
	                        		<div id="visualization1" class="col-sm-12" ></div>		                            
	                        	</div>
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
var plist = '${pmdlistProgress}';
plist = eval("(" + plist + ")");

var groups;
var items;

//alert(plist.pArray[0].pName);
groups = new vis.DataSet();
items = new vis.DataSet();
for(var i in plist.pArray ){
	if(plist.pArray[i].dPart=='영업'){			
		groups.add([
			{id: i, content: '<div class="chartTableMain col-sm-12"><div class="col-sm-8 chartTable">'+plist.pArray[i].pName+'</div><div class="col-sm-4 chartTable chartTable-name">책임자 : '+plist.pArray[i].eName+'</div></div>', value: i}
		]);
		
		var psyear = plist.pArray[i].pStartDate.substr(0, 4);
		var psmonth =plist.pArray[i].pStartDate.substr(5, 2);
		var psday =plist.pArray[i].pStartDate.substr(8, 2);
		
		var peyear = plist.pArray[i].pEndDate.substr(0, 4);
		var pemonth =plist.pArray[i].pEndDate.substr(5, 2);
		var peday =plist.pArray[i].pEndDate.substr(8, 2);
		
		items.add([
			{id: i, group: i, value: plist.pArray[i].pProgress, content: 'item 0', start: new Date(psyear, psmonth-1, psday), end: new Date(peyear, pemonth-1, peday)}
		]);
	}
}
makeChart(0);
groups = new vis.DataSet();
items = new vis.DataSet();
for(var i in plist.pArray ){
	if(plist.pArray[i].dPart=='지원'){			
		groups.add([
			{id: i, content: '<div class="chartTableMain col-sm-12"><div class="col-sm-8 chartTable">'+plist.pArray[i].pName+'</div><div class="col-sm-4 chartTable chartTable-name">책임자 : '+plist.pArray[i].eName+'</div></div>', value: i}
		]);
		
		var psyear = plist.pArray[i].pStartDate.substr(0, 4);
		var psmonth =plist.pArray[i].pStartDate.substr(5, 2);
		var psday =plist.pArray[i].pStartDate.substr(8, 2);
		
		var peyear = plist.pArray[i].pEndDate.substr(0, 4);
		var pemonth =plist.pArray[i].pEndDate.substr(5, 2);
		var peday =plist.pArray[i].pEndDate.substr(8, 2);
		
		items.add([
			{id: i, group: i, value: plist.pArray[i].pProgress, content: 'item 0', start: new Date(psyear, psmonth-1, psday), end: new Date(peyear, pemonth-1, peday)}
		]);
	}
}
makeChart(1);

function makeChart(v) {	
	/*var groups = new vis.DataSet([
	    {id: 0, content: '<div class="chartTableMain"><div class="col-sm-8 chartTable">'+pName+'</div><div class="col-sm-4 chartTable chartTable-name">김진우</div></div>', value: 1},
	    {id: 1, content: '<div class="chartTableMain"><div class="col-sm-8 chartTable">세부업무 이름1</div><div class="col-sm-4 chartTable chartTable-name">김용현</div></div>', value: 2},
	    {id: 2, content: '<div class="chartTableMain"><div class="col-sm-8 chartTable">세부업무 이름2</div><div class="col-sm-4 chartTable chartTable-name">김동혁</div></div>', value: 3},
	  ]);
	
	  // create a dataset with items
	  // note that months are zero-based in the JavaScript Date object, so month 3 is April
	  var items = new vis.DataSet([
	    {id: 0, group: 0, value: 0.2, content: 'item 0', start: new Date(2014, 3, 17), end: new Date(2014, 3, 21)},
	    {id: 1, group: 1, value: 0.2, content: 'item 1', start: new Date(2014, 3, 16), end: new Date(2014, 3, 24)},
	    {id: 2, group: 2, value: 0.2, content: 'item 2', start: new Date(2014, 3, 24), end: new Date(2014, 3, 27)}
	  ]);*/
	
	  // create visualization
	  var container = document.getElementById('visualization'+v);
	  var options = {
			  visibleFrameTemplate: function(item) {
			      if (item.visibleFrameTemplate) {
			        return item.visibleFrameTemplate;
			      } 
			      var percentage = item.value + '%';
			      return '<div class="progress-wrapper"><div class="progress-mainProject" style="width:' + percentage + '"></div><label class="progress-label">' + percentage + '<label></div>';			      			     
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
}

</script>
		<%@include file="/view/table/projectWriteModal.jsp" %> 
		<%@include file="/view/table/projectModifyModal.jsp" %> 
		<%@include file="/view/table/findEmpModal.jsp" %> 
		<%@include file="/view/common/common_footer.jsp" %>		