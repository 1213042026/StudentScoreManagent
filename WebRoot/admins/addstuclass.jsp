
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->

<head>
    <meta charset="utf-8" />
    <base href="<%=basePath%>">
    <title>添加班级 - 学生信息管理系统</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <meta content="Preview page of Metronic Admin Theme #1 for color variants for metronic and bootstrap custom elements and components" name="description" />
    <meta content="" name="author" />
    <link href="assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link href="assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
    <link href="assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css" />
    <link href="assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
    <link href="assets/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
    <link href="assets/layouts/layout/css/layout.min.css" rel="stylesheet" type="text/css" />
    <link href="assets/layouts/layout/css/themes/darkblue.min.css" rel="stylesheet" type="text/css" id="style_color" />
    <link rel="shortcut icon" href="favicon.ico" /> </head>
<!-- END HEAD -->

<body class="page-header-fixed page-sidebar-closed-hide-logo page-content-white">
<div class="page-wrapper">
    <!-- BEGIN HEADER -->
    <jsp:include page="../common/header.jsp"></jsp:include>
    <!-- END HEADER -->
    <!-- BEGIN HEADER & CONTENT DIVIDER -->
    <div class="clearfix"> </div>
    <!-- END HEADER & CONTENT DIVIDER -->
    <!-- BEGIN CONTAINER -->
    <div class="page-container">
        <!-- BEGIN SIDEBAR -->
        <div class="page-sidebar-wrapper">
            <div class="page-sidebar navbar-collapse collapse">
                <ul class="page-sidebar-menu  page-header-fixed " data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200" style="padding-top: 20px">
                    <li class="sidebar-toggler-wrapper hide">
                        <div class="sidebar-toggler">
                            <span></span>
                        </div>
                    </li>
                    <!-- END SIDEBAR TOGGLER BUTTON -->
                    <li class="nav-item start">
                        <a href="index.jsp" class="nav-link nav-toggle">
                            <i class="icon-home"></i>
                            <span class="title">首页</span>
                            <span class="selected"></span>
                        </a>
                    </li>
                    <s:if test="#session.role!=2">
                    <li class="nav-item">
                        <a href="javascript:;" class="nav-link nav-toggle">
                            <i class="fa fa-users"></i>
                            <span class="title">学生管理</span>
                            <span class="selected"></span>
                            <span class="arrow"></span>
                        </a>
                        <ul class="sub-menu">
                        	<s:if test="#session.role==1">
                            <li class="nav-item">
                                <a href="stufindAll" class="nav-link ">
                                    <span class="title">学生列表</span>
                                    <span class="selected"></span>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="admins/addstu.jsp" class="nav-link ">
                                    <span class="title">添加学生</span>
                                    <span class="selected"></span>
                                </a>
                            </li>
                            </s:if>
                            <s:if test="#session.role==3">
                            <li class="nav-item">
                                <a href="student/stuInfo.jsp" class="nav-link ">
                                    <span class="title">学生信息</span>
                                    <span class="selected"></span>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="stuScore" class="nav-link ">
                                    <span class="title">查询成绩</span>
                                    <span class="selected"></span>
                                </a>
                            </li>
                            </s:if>
                        </ul>
                    </li>
                    </s:if>
                    <s:if test="#session.role!=3">
                    <li class="nav-item">
                        <a href="javascript:;" class="nav-link nav-toggle">
                            <i class="fa fa-user-o"></i>
                            <span class="title">教师管理</span>
                            <span class="selected"></span>
                            <span class="arrow"></span>
                        </a>
                        <ul class="sub-menu">
                       		 <s:if test="#session.role==1">
                            <li class="nav-item">
                                <a href="findAllteachers" class="nav-link ">
                                    <span class="title">教师列表</span>
                                    <span class="selected"></span>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="admins/addteac.jsp" class="nav-link ">
                                    <span class="title">添加教师</span>
                                    <span class="selected"></span>
                                </a>
                            </li>
                            </s:if>
                            <s:if test="#session.role==2">
                             <li class="nav-item">
                                <a href="teacher/teacherinfo.jsp" class="nav-link ">
                                    <span class="title">教师信息</span>
                                    <span class="selected"></span>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="courseListteachers" class="nav-link ">
                                    <span class="title">查询课程</span>
                                    <span class="selected"></span>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="scoreListteachers" class="nav-link ">
                                    <span class="title">查询成绩</span>
                                    <span class="selected"></span>
                                </a>
                            </li>
                            </s:if>
                        </ul>
                    </li>
                    </s:if>
                    <s:if test="#session.role==1">
                    <li class="nav-item">
                        <a href="javascript:;" class="nav-link nav-toggle">
                            <i class="fa fa-book"></i>
                            <span class="title">课程管理</span>
                            <span class="selected"></span>
                            <span class="arrow"></span>
                        </a>
                        <ul class="sub-menu">
                            <li class="nav-item">
                                <a href="courfindAll" class="nav-link ">
                                    <span class="title">课程列表</span>
                                    <span class="selected"></span>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="admins/addcour.jsp" class="nav-link ">
                                    <span class="title">添加课程</span>
                                    <span class="selected"></span>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item active open">
                        <a href="javascript:;" class="nav-link nav-toggle">
                            <i class="fa fa-calendar"></i>
                            <span class="title">班级管理</span>
                            <span class="selected"></span>
                            <span class="arrow open"></span>
                        </a>
                        <ul class="sub-menu">
                            <li class="nav-item">
                                <a href="findAllstuclass" class="nav-link ">
                                    <span class="title">班级列表</span>
                                    <span class="selected"></span>
                                </a>
                            </li>
                            <li class="nav-item active">
                                <a href="admins/addstuclass.jsp" class="nav-link ">
                                    <span class="title">添加班级</span>
                                    <span class="selected"></span>
                                </a>
                            </li>
                        </ul>
                    </li>
                    </s:if>
                    <li class="nav-item start">
                        <a href="logoutaction" class="nav-link nav-toggle">
                            <i class="fa fa-sign-out"></i>
                            <span class="title">安全退出</span>
                            <span class="selected"></span>
                        </a>
                    </li>
                </ul>
                <!-- END SIDEBAR MENU -->
                <!-- END SIDEBAR MENU -->
            </div>
            <!-- END SIDEBAR -->
        </div>
        <!-- END SIDEBAR -->
        <!-- BEGIN CONTENT -->
        <div class="page-content-wrapper">
            <!-- BEGIN CONTENT BODY -->
            <div class="page-content">
                <!-- BEGIN PAGE HEADER-->
                <!-- BEGIN PAGE BAR -->
                <div class="page-bar">
                    <ul class="page-breadcrumb">
                        <li>
                            <a href="index.jsp">首页</a>
                            <i class="fa fa-circle"></i>
                        </li>
                        <li>
                            <span>班级管理</span>
                        </li>
                    </ul>
                </div>
                <h1 class="page-title"> 添加班级
                    <small>在这里可以添加班级</small>
                </h1>
                <!-- END PAGE BAR -->
                <!-- END PAGE HEADER-->
                <div class="row">
                	     <%-- <s:form action="insertstuclass">
       <s:textfield label="班级编号" name="stuClass.class_id"/>
        <s:textfield label="班级名称" name="stuClass.class_name"/>
     <s:submit value="添加"/> <s:reset value="重置"/>
     </s:form> --%>
     				<div class="col-md-6 col-md-offset-3">
                		<div class="portlet light bordered">
                               <div class="portlet-title">
                                   <div class="caption font-red-sunglo">
                                       <i class="icon-settings font-red-sunglo"></i>
                                       <span class="caption-subject bold uppercase"> 添加班级</span>
                                   </div>
                               </div>
                               <div class="portlet-body form">
                                   <form action="insertstuclass" method="post">
                                       <div class="form-body">
                                           <div class="form-group form-md-line-input has-info">
                                               <input type="text" name="stuClass.class_id" class="form-control" id="form_control_1" placeholder="班级编号" value="">
                                               <label for="form_control_1">班级编号</label>
                                           </div>
                                           <div class="form-group form-md-line-input has-info">
                                               <input type="text" name="stuClass.class_name" class="form-control" id="form_control_1" placeholder="班级名称" value="">
                                               <label for="form_control_1">班级名称</label>
                                           </div>
                                       </div>
                                       <div class="form-actions noborder">
                                           <button type="submit" class="btn blue">提交</button>
                                           <button type="reset" class="btn default">重置</button>
                                       </div>
                                   </form>
                               </div>
                           </div>
                	</div>
                </div>
            </div>
            <!-- END CONTENT BODY -->
        </div>
        <!-- END CONTENT -->
    </div>
    <!-- END CONTAINER -->
    <!-- BEGIN FOOTER -->
    <div class="page-footer">
        <div class="page-footer-inner"> 2016 &copy; Metronic Theme By
            <a target="_blank" href="http://apkcourse.com">apkcourse</a>
        </div>
        <div class="scroll-to-top">
            <i class="icon-arrow-up"></i>
        </div>
    </div>
    <!-- END FOOTER -->
</div>
<!--[if lt IE 9]>
<script src="assets/global/plugins/respond.min.js"></script>
<script src="assets/global/plugins/excanvas.min.js"></script>
<script src="assets/global/plugins/ie8.fix.min.js"></script>
<![endif]-->
<script src="assets/global/plugins/jquery.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/js.cookie.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
<script src="assets/global/scripts/app.min.js" type="text/javascript"></script>
<script src="assets/layouts/layout/scripts/layout.min.js" type="text/javascript"></script>
<script src="assets/layouts/layout/scripts/demo.min.js" type="text/javascript"></script>
<script src="assets/layouts/global/scripts/quick-sidebar.min.js" type="text/javascript"></script>
<script src="assets/layouts/global/scripts/quick-nav.min.js" type="text/javascript"></script>
</body>

</html>
