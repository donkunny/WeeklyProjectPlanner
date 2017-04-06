<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.lotte.emp.model.dto.SuperDTO, java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" type="image/png" sizes="16x16" href="${pageContext.request.contextPath}/resources/plugins/images/favicon.png">
    <title>Ample Admin Template - The Ultimate Multipurpose admin template</title>
    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resources/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Menu CSS -->
    <link href="${pageContext.request.contextPath}/resources/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css" rel="stylesheet">
    <!-- animation CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/animate.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/style.css?v=1" rel="stylesheet"> 
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-datepicker3.css" rel="stylesheet"> 
    <link href="${pageContext.request.contextPath}/resources/css/table.css?v=2" rel="stylesheet">    
    <!-- color CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/colors/default.css" id="theme" rel="stylesheet">
    <!-- Chart CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/vis.min.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/resources/css/vischart.css?v=1" rel="stylesheet">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>

<body class="fix-header">
<!-- ============================================================== -->
    <!-- Preloader -->
    <!-- ============================================================== -->
    <div class="preloader">
        <svg class="circular" viewBox="25 25 50 50">
            <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="2" stroke-miterlimit="10" />
        </svg>
    </div>
    <!-- ============================================================== -->
    <!-- Wrapper -->
    <!-- ============================================================== -->
    <div id="wrapper">
        <!-- ============================================================== -->
        <!-- Topbar header - style you can find in pages.scss -->
        <!-- ============================================================== -->
        <nav class="navbar navbar-default navbar-static-top m-b-0">
            <div class="navbar-header">
                <div class="top-left-part" style=" text-align: center;">
                    <!-- Logo -->
                    <a class="logo" href="#" style="font-weight: 600; line-height: 30px; font-size: 20px;">WEEKLY PROJECT PLANNER</a>
                </div>
                <!-- /Logo -->
                <ul class="nav navbar-top-links navbar-right pull-right">
                    <li class="dropdown">

                        <a class="dropdown-toggle profile-pic" data-toggle="dropdown" href="#"> <img src="${pageContext.request.contextPath}/resources/plugins/images/profile.png" alt="user-img" width="36" class="img-circle"><b class="hidden-xs">${msg.eName}</b><span class="caret"></span> </a>


                        <ul class="dropdown-menu dropdown-user animated flipInY">
                            <li>
                                <div class="dw-user-box">
                                    <div class="u-img"><img src="${pageContext.request.contextPath}/resources/plugins/images/profile.png" alt="user" /></div>
                                    <div class="u-text">
                                        <h4>${msg.eName}</h4>
                                </div>
                            </li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#"><i class="ti-user"></i> My Profile</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="return pageMove('logout');"><i class="fa fa-power-off"></i> Logout</a></li>
                        </ul>
                        <!-- /.dropdown-user -->
                    </li>
                    <!-- /.dropdown -->
                </ul>
            </div>
            <!-- /.navbar-header -->
            <!-- /.navbar-top-links -->
            <!-- /.navbar-static-side -->
        </nav>
        <!-- End Top Navigation -->
        <!-- ============================================================== -->
        <!-- Left Sidebar - style you can find in sidebar.scss  -->
        <!-- ============================================================== -->
        <form name="common" method="post">
        	<input type="hidden" name="command" value="">
        	<input type="hidden" name="eIndex" value="">        	
        </form>
                
        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav slimscrollsidebar">
                <div class="sidebar-head">
                    <h3><span class="fa-fw open-close"><i class="ti-close ti-menu"></i></span> <span class="hide-menu">Navigation</span></h3>
                </div>
                <ul class="nav" id="side-menu">
                    <li style="padding: 70px 0 0;"></li> 
                    <li><a href="#" class="waves-effect"><i class="fa fa-table fa-fw" aria-hidden="true"></i>개인<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="javascript:void(0);" onclick="return pageMove('personalProgress');"><i class="fa fa-hourglass-start fa-fw" aria-hidden="true"></i>진행 업무</a></li>
                            <li><a href="javascript:void(0)" onclick="return pageMove('personalCompletedProgress');"><i class="fa fa-columns fa-fw" aria-hidden="true"></i>완료 업무</a></li>
                        </ul>
                    </li>
                    
                    <li><a href="#" class="waves-effect"><i class="fa fa-table fa-fw" aria-hidden="true"></i>프로젝트<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <!-- <li><a href="${pageContext.request.contextPath}/view/table/tableProjectTeam.jsp" onclick="return projectPageMove('projectTaemManagement');">
                            	<i class="fa fa-hourglass-start fa-fw" aria-hidden="true"></i>프로젝트 팀 관리</a></li> -->
                            <li><a href="javascript:void(0)" class="waves-effect">영업<span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                
                                
                                    <li><a href="javascript:void(0);" onclick="return projectPageMove('slistProgress');">진행</a></li>
                                    
                                    
                                    <li><a href="javascript:void(0);" onclick="return projectPageMove('slistComplete');">완료</a></li>
                                </ul>
                            </li>
                            <li><a href="javascript:void(0)" class="waves-effect">지원<span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li><a href="javascript:void(0);" onclick="return projectPageMove('mlistProgress');">진행</a></li>
                                    <li><a href="javascript:void(0);" onclick="return projectPageMove('mlistComplete');">완료</a></li>
                                </ul>
                            </li>
                            <li><a href="javascript:void(0)" onclick="return projectPageMove('projectTaemManagement');">
                            	<i class="fa fa-hourglass-start fa-fw" aria-hidden="true"></i>프로젝트 팀 관리</a></li>
                        </ul>
                    </li>
                    
                    <li><a href="#" class="waves-effect"><i class="fa fa-table fa-fw" aria-hidden="true"></i>팀<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="javascript:void(0);" onclick="return projectPageMove('teamlistProgress');"><i class="fa fa-hourglass-start fa-fw" aria-hidden="true"></i>진행 업무</a></li>
                            <li><a href="javascript:void(0);" onclick="return projectPageMove('teamlistComplete');"><i class="fa fa-columns fa-fw" aria-hidden="true"></i>완료 업무</a></li>
                        </ul>
                    </li>
                    
                </ul>
            </div>
        </div>
        
<!-- jQuery -->
<script src="${pageContext.request.contextPath}/resources/plugins/bower_components/jquery/dist/jquery.min.js"></script>        
        
<script type="text/javascript">
function pageMove(v){
	document.forms["common"]["command"].value = v;
	document.forms["common"]["eIndex"].value = ${msg.eIndex};
	document.common.action = "${pageContext.request.contextPath}/emp"; //서브밋
	document.common.submit();
}

function projectPageMove(v){
	document.forms["common"]["command"].value = v;
	document.forms["common"]["eIndex"].value = ${msg.eIndex};
	document.common.action = "${pageContext.request.contextPath}/project"; //서브밋
	document.common.submit();
}
function joinmove(){
	document.location.href = "${pageContext.request.contextPath}/member?act=mvjoin"; // 단순이동
}
</script>