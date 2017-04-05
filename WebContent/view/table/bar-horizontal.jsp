<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String root = request.getContextPath();
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Timeline | Groups ordering</title>

<style type="text/css">
    .progress-wrapper {
      background: white;
      width: 100%;
      height: 18px;
      text-align: center;
      position: relative;
      overflow: hidden;
    }

    .progress {
      height: 100%;
      width: 60%;
      position: absolute;
      left: 0px;
      top: 0px;
      background: #63ed63;
    }

    .progress-label {
      position: absolute;
      z-index: 1;
    }

  </style>

</head>
<body>
<p>
  This example demonstrates custom ordering of groups.
</p>
<div id="visualization"></div>
 <script src="<%=root %>/resources/js/vis.js"></script>
 <script src="http://cdnjs.cloudflare.com/ajax/libs/moment.js/2.13.0/moment.min.js"></script>
<script>
  var groups = new vis.DataSet([
    {id: 0, content: '프로젝트1 [책임자 : 김동혁] ', value: 1},
    {id: 1, content: '세부업무1 [담당자 : 김진우]', value: 2},
    {id: 2, content: '세부업무2 [담당자 : 김용현]', value: 3}
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
</body>

</html>
