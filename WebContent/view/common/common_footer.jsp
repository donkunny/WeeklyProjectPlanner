<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  
	<div>
		<div>
            <!-- /.container-fluid -->
            <footer class="footer text-center"> 2017 &copy; LDCC HIT, 김동혁 김용현 김진우 박소은 </footer>
        </div>
        <!-- /#page-wrapper -->
    </div>
    
    <!-- /#wrapper -->

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap-datepicker.js"></script>
    <!-- Menu Plugin JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js"></script>
    <!--slimscroll JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.slimscroll.js"></script>
    <!--Wave Effects -->
    <script src="${pageContext.request.contextPath}/resources/js/waves.js"></script>
    <!-- Custom Theme JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/js/custom.min.js"></script>
    <!-- jQuery peity -->

    
    <script>
		var date_start_input = $('input[name="pdStartDate"]'); //our date input has the name "date"
		var date_end_input = $('input[name="pdEndDate"]'); //our date input has the name "date"
		var container = $('.bootstrap-iso form').length > 0 ? $(
				'.bootstrap-iso form').parent() : "body";
		var options = {
			format : 'yyyy-mm-dd',
			container : container,
			todayHighlight : true,
			autoclose : true,
		};
		date_start_input.datepicker(options); //initial i110/26/2015 8:20:59 PM ze plugin
		date_end_input.datepicker(options); //initial i110/26/2015 8:20:59 PM ze plugin
						
	</script>
</body>
</html>