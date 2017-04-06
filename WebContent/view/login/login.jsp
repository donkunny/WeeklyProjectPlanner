<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Creative - Start Bootstrap Theme</title>

<!-- Bootstrap Core CSS -->
<link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom Fonts -->
<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Raleway" />
<link href="${pageContext.request.contextPath}/resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>
<link rel='stylesheet prefetch'
	href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>
<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

<!-- Plugin CSS -->
<link href="${pageContext.request.contextPath}/resources/vendor/magnific-popup/magnific-popup.css" rel="stylesheet">

<!-- Theme CSS -->
<link href="${pageContext.request.contextPath}/resources/css/wwp.css?v=2" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/creative.min.css?v=3" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/wwp2.css?v=3" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<style>
</style>

</head>
 
<body id="page-top">
	<header style="background-image: url(${pageContext.request.contextPath}/resources/plugins/images/background/login.jpg);"> 
		<div class="header-content">
			<div class="header-content-inner">
				<div class="col-sm-12 login">
					<h1 style="font-size: 42px; margin: 0px; font-family: Raleway, Helvetica Neue, Helvetica, Arial, sans-serif;">WEEKLY PROJECT</h1>
					<h1 style="font-size: 42px; margin-bottom: 20px; font-family: Raleway, Helvetica Neue, Helvetica, Arial, sans-serif;">PLANNER</h1>
					<div class="col-sm-3"></div>
					<div class="col-sm-6">
						<div class="wwp-login wwp-login-back"></div>
						<div class="wwp-login">
							<h1>LOGIN</h1>
							<form name="loginform"  method="post">
								<input type="hidden"  name="command" value="login">
								<div class="wwp-login-card">
									<div class="input-container"> 
										<input type="text" class="wwp-login-input wwp-login-input-enum" id="username"  name="id"  />
										<label for="username">Username</label>
										<div class="bar"></div>
									</div>
									<div class="input-container">
										<input type="password" class="wwp-login-input wwp-login-input-epw" id="password" name="pw"  />
										<label for="password">Password</label>
										<div class="bar"></div>
									</div>
									<div class="loginerror" id="loginerror">
										<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
										아이디 혹은 비밀번호가 잘못되었습니다.
									</div>
									<div class="button-container">
										<input type="button" id ="loginBtn" class="loginbtn2" value="Login" onclick="login();">																			
									</div>						
									</div>
								</form>	
								<div>
									<h5 style="    margin-top: 5%;    padding: 5%;    color: #cecece !important;
									    font-family: Circular,-apple-system,BlinkMacSystemFont,Roboto,Helvetica Neue,sans-serif !important; text-align: right;">
									    © 2017 LOTTE LDCC HIT
									</h5>																		
								</div>								
							</div>
						</div>
					</div>
					<div class="col-sm-3"></div>
					
				</div>
			</div>
		</div>
	</header>

	<!-- jQuery -->
	<script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Plugin JavaScript -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/vendor/scrollreveal/scrollreveal.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

	<!-- Theme JavaScript -->
	<script src="${pageContext.request.contextPath}/resources/js/creative.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/index.js"></script>

	<!-- 로그인 화면 이동 / 실패시 실패 화면으로 이동 -->
	<script src="${pageContext.request.contextPath}/script/jquery-3.2.0.js"></script>
	<script type="text/javascript">
	
		function login(){
// 			alert($("#password").val() + " " + $("#username").val());
			if($("#password").val() == "" || $("#username").val() == ""){
				$("#loginerror").addClass("loginerror-view");
			} else {
				document.loginform.action = "${pageContext.request.contextPath}/emp"; //서브밋
				document.loginform.submit();
			}
		}	
	</script>
	
</body>

</html>