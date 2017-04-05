<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<div>
		<div>
            <!-- /.container-fluid -->
            <footer class="footer text-center"> 2017 &copy; Ample Admin brought to you by themedesigner.in </footer>
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->
    <!-- jQuery -->
    <script src="<%=root %>/resources/plugins/bower_components/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="<%=root %>/resources/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="<%=root %>/resources/bootstrap/js/bootstrap-datepicker.js"></script>
    <!-- Menu Plugin JavaScript -->
    <script src="<%=root %>/resources/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js"></script>
    <!--slimscroll JavaScript -->
    <script src="<%=root %>/resources/js/jquery.slimscroll.js"></script>
    <!--Wave Effects -->
    <script src="<%=root %>/resources/js/waves.js"></script>
    <!-- Custom Theme JavaScript -->
    <script src="<%=root %>/resources/js/custom.min.js"></script>
    <!-- jQuery peity -->
    
    <script>
		var date_start_input = $('input[name="start_date"]'); //our date input has the name "date"
		var date_end_input = $('input[name="end_date"]'); //our date input has the name "date"
		var container = $('.bootstrap-iso form').length > 0 ? $(
				'.bootstrap-iso form').parent() : "body";
		var options = {
			format : 'yy/mm/dd',
			container : container,
			todayHighlight : true,
			autoclose : true,
		};
		date_start_input.datepicker(options); //initial i110/26/2015 8:20:59 PM ze plugin
		date_end_input.datepicker(options); //initial i110/26/2015 8:20:59 PM ze plugin
						
	</script>

</body>
</html>