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
                        <h4 class="page-title">Basic Table</h4> </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /row -->
	            <c:forEach var="sdto" items="${mlistProgress}" varStatus="no">
	                <div id="makeChart" class="row" id="tableViewTest">                 
	                   <div class="col-sm-12 white-box">  
	                        <div class="white-box">
	                        	<div class="col-sm-12">  
	                        		<div id="visualization${no.count-1}" class="col-sm-12" ></div>		                            
	                        	</div>
	                        </div>
	                    </div>  
	                </div> 
	            </c:forEach>  
                <!-- /.row -->              
            </div>
		</div>
		
<!-- Chart -->
<script src="${pageContext.request.contextPath}/resources/js/vis.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/moment.js/2.13.0/moment.min.js"></script>
<!-- Chart -->
<script type="text/javascript">
var v = '${fn:length(mlistProgress)}';
var plist = '${pmdlistProgress}';
var pdlist = '${mdlistProgress}';
plist = eval("(" + plist + ")");
pdlist = eval("(" + pdlist + ")");

var groups;
var items;

//alert(plist.pArray[0].pName);
//alert(pdlist.pdArray[0].pdName);
for(var i in plist.pArray ){
	groups = new vis.DataSet();
	items = new vis.DataSet();
	groups.add([
		{id: 0, content: '<div class="chartTableMain project col-sm-12"><div class="col-sm-8 chartTable">'+plist.pArray[i].pName+'</div><div class="col-sm-4 chartTable chartTable-name">책임자 : '+plist.pArray[i].eName+'</div></div>', value: 0}
	]);
	
	var psyear = plist.pArray[i].pStartDate.substr(0, 4);
	var psmonth =plist.pArray[i].pStartDate.substr(5, 2);
	var psday =plist.pArray[i].pStartDate.substr(8, 2);
	
	var peyear = plist.pArray[i].pEndDate.substr(0, 4);
	var pemonth =plist.pArray[i].pEndDate.substr(5, 2);
	var peday =plist.pArray[i].pEndDate.substr(8, 2);
	
	items.add([
		{id: 0, group: 0, value: plist.pArray[i].pProgress, content: 'item 0', start: new Date(psyear, psmonth-1, psday), end: new Date(peyear, pemonth-1, peday)}
	]);
	for(var j in pdlist.pdArray){
		if(plist.pArray[i].pIndex== pdlist.pdArray[j].pIndex) {
			
			groups.add([
				{id: j+1, content: '<div class="chartTableMain col-sm-12"><div class="col-sm-8 chartTable">'+pdlist.pdArray[j].pdName+'</div><div class="col-sm-4 chartTable chartTable-name">'+pdlist.pdArray[j].eName+'</div><hr>', value: j+1}
			]);
			
			var syear = pdlist.pdArray[j].pdStartDate.substr(0, 4);
			var smonth =pdlist.pdArray[j].pdStartDate.substr(5, 2);
			var sday =pdlist.pdArray[j].pdStartDate.substr(8, 2);
			
			var eyear = pdlist.pdArray[j].pdEndDate.substr(0, 4);
			var emonth =pdlist.pdArray[j].pdEndDate.substr(5, 2);
			var eday =pdlist.pdArray[j].pdEndDate.substr(8, 2);
						
			items.add([
				{id: j+1, group: j+1, value: pdlist.pdArray[j].pdProgress, content: 'item 0', start: new Date(syear, smonth-1, sday), end: new Date(eyear, emonth-1, eday)}
			]);

		}		
	}
	makeChart(i);
}
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
}

</script>
		<%@include file="/view/table/projectWriteModal.jsp" %> 
		<%@include file="/view/table/projectModifyModal.jsp" %> 
		<%@include file="/view/table/findEmpModal.jsp" %> 
		<%@include file="/view/common/common_footer.jsp" %>		