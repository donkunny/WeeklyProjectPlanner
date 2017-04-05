<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String root = request.getContextPath();
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" type="image/png" sizes="16x16" href="../plugins/images/favicon.png">
    <title>Ample Admin Template - The Ultimate Multipurpose admin template</title>
    <!-- Bootstrap Core CSS -->
    <link href="<%=root %>/resources/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- animation CSS -->
    <link href="<%=root %>/resources/css/animate.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="<%=root %>/resources/css/style.css" rel="stylesheet">
    <!-- color CSS -->
    <link href="<%=root %>/resources/css/colors/default.css" id="theme" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>

<body>
    <!-- Preloader -->
    <section id="wrapper" class="error-page">
        <div class="error-box">
            <div class="error-body text-center">
                <h3 class="text-danger"><b>아이디 또는 비밀번호를 다시 확인하세요.</b></h3>
                <h3 class="text-uppercase">등록되지 않은 아이디이거나, 아이디 또는 비밀번호를 잘못 입력하셨습니다.</h3>
                <p class="text-muted m-t-30 m-b-30">앗, 로그인이 안 되나요?</p>
                <a href="<%=root %>/view/login/login.jsp" class="btn btn-danger btn-rounded waves-effect waves-light m-b-40">Back to home</a> </div>
            <footer class="footer text-center">2017 © Ample Admin.</footer>
        </div>
    </section>
    <!-- jQuery -->
    <script src="<%=root %>/resources/plugins/bower_components/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="<%=root %>/resources/bootstrap/dist/js/bootstrap.min.js"></script>
</body>

</html>
