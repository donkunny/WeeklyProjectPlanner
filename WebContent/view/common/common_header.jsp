<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String root = request.getContextPath();
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" type="image/png" sizes="16x16" href="<%=root %>/resources/plugins/images/favicon.png">
    <title>Ample Admin Template - The Ultimate Multipurpose admin template</title>
    <!-- Bootstrap Core CSS -->
    <link href="<%=root %>/resources/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Menu CSS -->
    <link href="<%=root %>/resources/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css" rel="stylesheet">
    <!-- animation CSS -->
    <link href="<%=root %>/resources/css/animate.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="<%=root %>/resources/css/style.css?v=1" rel="stylesheet"> 
    <link href="<%=root %>/resources/css/bootstrap-datepicker3.css" rel="stylesheet"> 
    <link href="<%=root %>/resources/css/table.css?v=1" rel="stylesheet">
    <!-- color CSS -->
    <link href="<%=root %>/resources/css/colors/default.css" id="theme" rel="stylesheet">
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
                <div class="top-left-part">
                    <!-- Logo -->
                    <a class="logo" href="index.html">
                        <!-- Logo icon image, you can use font-icon also --><b>
                        <!--This is dark logo icon--><img src="<%=root %>/resources/plugins/images/admin-logo.png" alt="home" class="dark-logo" /><!--This is light logo icon--><img src="<%=root %>/resources/plugins/images/admin-logo-dark.png" alt="home" class="light-logo" />
                     </b>
                        <!-- Logo text image you can use text also --><span class="hidden-xs">
                        <!--This is dark logo text--><img src="<%=root %>/resources/plugins/images/admin-text.png" alt="home" class="dark-logo" /><!--This is light logo text--><img src="<%=root %>/resources/plugins/images/admin-text-dark.png" alt="home" class="light-logo" />
                     </span> </a>
                </div>
                <!-- /Logo -->
                <ul class="nav navbar-top-links navbar-right pull-right">
                    <li class="dropdown">
                        <a class="dropdown-toggle profile-pic" data-toggle="dropdown" href="#"> <img src="<%=root %>/resources/plugins/images/users/varun.jpg" alt="user-img" width="36" class="img-circle"><b class="hidden-xs">Steave</b><span class="caret"></span> </a>
                        <ul class="dropdown-menu dropdown-user animated flipInY">
                            <li>
                                <div class="dw-user-box">
                                    <div class="u-img"><img src="<%=root %>/resources/plugins/images/users/varun.jpg" alt="user" /></div>
                                    <div class="u-text">
                                        <h4>Steave Jobs</h4>
                                        <p class="text-muted">varun@gmail.com</p><a href="profile.html" class="btn btn-rounded btn-danger btn-sm">View Profile</a></div>
                                </div>
                            </li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#"><i class="ti-user"></i> My Profile</a></li>
                            <li><a href="#"><i class="ti-wallet"></i> My Balance</a></li>
                            <li><a href="#"><i class="ti-email"></i> Inbox</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#"><i class="ti-settings"></i> Account Setting</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#"><i class="fa fa-power-off"></i> Logout</a></li>
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
        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav slimscrollsidebar">
                <div class="sidebar-head">
                    <h3><span class="fa-fw open-close"><i class="ti-close ti-menu"></i></span> <span class="hide-menu">Navigation</span></h3>
                </div>
                <ul class="nav" id="side-menu">
                    <li style="padding: 70px 0 0;"><a href="index.html" class="waves-effect"><i class="fa fa-clock-o fa-fw" aria-hidden="true"></i>Dashboard</a> </li>
                    <li><a href="#" class="waves-effect"><i class="fa fa-table fa-fw" aria-hidden="true"></i>개인<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="starter-page.html"><i class="fa fa-hourglass-start fa-fw" aria-hidden="true"></i>진행 업무</a></li>
                            <li><a href="blank.html"><i class="fa fa-columns fa-fw" aria-hidden="true"></i>완료 업무</a></li>
                        </ul>
                    </li>
                    
                    <li><a href="#" class="waves-effect"><i class="fa fa-table fa-fw" aria-hidden="true"></i>프로젝트<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="starter-page.html"><i class="fa fa-hourglass-start fa-fw" aria-hidden="true"></i>진행 업무</a></li>
                            <li><a href="blank.html"><i class="fa fa-columns fa-fw" aria-hidden="true"></i>완료 업무</a></li>
                        </ul>
                    </li>
                    
                    <li><a href="#" class="waves-effect"><i class="fa fa-table fa-fw" aria-hidden="true"></i>팀<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="starter-page.html"><i class="fa fa-hourglass-start fa-fw" aria-hidden="true"></i>진행 업무</a></li>
                            <li><a href="blank.html"><i class="fa fa-columns fa-fw" aria-hidden="true"></i>완료 업무</a></li>
                        </ul>
                    </li>
                    
                </ul>
            </div>
        </div>