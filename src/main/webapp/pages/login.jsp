<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/pages/inc/header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>资产管理系统</title>
</head>
<body>
<!-- <div style="position: absolute; left: 150px; top: 50px;">
        <span style="font-size: 38px; color: black; font-weight: 500">资产管理系统</span>
    </div> -->
	<div class="container">
		<div id="login-wraper">
		    <div class="title" style="width: 100px;">
                <span>用户登录</span>
            </div>
            <hr>
			<form class="form login-form" action="<%=path %>/userLogin" method="post" style="padding-right: 5px;">
				<div class="login-content-info">
					<input class="login-content-info-text login-content-info-u"  placeholder="请输入账号" type="text"  name="userName" id="name"/>
				</div>
				<div class="login-content-info">
					<input class="login-content-info-text login-content-info-p" placeholder="请输入密码" type="password" name="userPass" id="password"/>
				</div>
				<div class="login-content-info">
				</div>
				<div class="login-button-area">
					<button class="login-button-text" type="submit" id="loginbtn">登录</button>
				</div>
			</form>
			<div class="login-error-info">
                <span>${userLoginError }</span>
            </div>
			<hr>
		</div>
	</div>
	<footer class="white navbar-fixed-bottom">
		资产管理系统系统
	</footer>
	
</body>
<script type="text/javascript">
	
</script>
</html>