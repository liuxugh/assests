<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    String path = request.getContextPath();
%>
<title>中国农大工会会员管理系统</title>
<script type="text/javascript" src="<%=path %>/extends/register/jqueryValidator/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=path %>/extends/register/jqueryValidator/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="<%=path %>/extends/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=path %>/extends/register/jqueryValidator/js/jquery-ui.js" ></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>

<script src="https://cdn.bootcss.com/moment.js/2.18.1/moment-with-locales.min.js"></script>  
<link href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css" rel="stylesheet">  
<script src="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script> 

<script type="text/javascript" src="<%=path %>/extends/grid/dlshouwen.grid.min.js"></script>
<script type="text/javascript" src="<%=path %>/extends/grid/i18n/zh-cn.js"></script>




<link rel="stylesheet" type="text/css" href="<%=path %>/extends/bootstrap-3.3.7/css/bootstrap-theme.min.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/extends/bootstrap-3.3.7/css/bootstrap.min.css" /> 
<%-- <link rel="stylesheet" type="text/css" href="<%=path %>/extends/bootstrap-3.3.7/css/bootstrap.css"/> --%>
<link rel="stylesheet" type="text/css" href="<%=path %>/extends/register/jqueryValidator/css/jquery-ui.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/extends/fontAwesome/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/extends/grid/dlshouwen.grid.min.css" media="all"  />
<link rel="stylesheet" type="text/css" href="<%=path %>/css/pagebar.css" />

<link rel="stylesheet" type="text/css" href="<%=path %>/css/sodb.css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/css/state.css" />
<%@ include file="/pages/inc/modalDialog.jsp" %>
<script type="text/javascript" src="<%=path %>/js/time.js"></script>

