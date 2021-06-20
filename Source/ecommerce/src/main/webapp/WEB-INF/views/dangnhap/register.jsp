<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!doctype html>
<html class="no-js" lang="zxx">
    
<!-- login-register31:27-->
<head>
<jsp:include page="../header/header.jsp" />
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Register</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
    <!--[if lt IE 8]>
		<p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
	<![endif]-->
        <!-- Begin Body Wrapper -->
        <div class="body-wrapper">
            <!-- Begin Header Area -->
            <jsp:include page="../header/header_html.jsp" />
            <!-- Header Area End Here -->
            <!-- Begin Li's Breadcrumb Area -->
            <div class="breadcrumb-area">
                <div class="container">
                    <div class="breadcrumb-content">
                        <ul>
                            <li><a href="index.html">Home</a></li>
                            <li class="active">Register</li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- Li's Breadcrumb Area End Here -->
            <!-- Begin Login Content Area -->
            <div class="page-section mb-60">
                <div class="container">
                    <div class="row">
	                    <div class="col-sm-2 col-md-2 col-lg-2 col-xs-2">
	                    </div>
                         <div class="col-sm-8 col-md-8 col-lg-8 col-xs-8">
                            <form action="form-register" method="post">
                                <div class="login-form">
                                    <h4 class="login-title">Register</h4>
                                    <div class="row">
                                        <div class="col-md-6 col-12 mb-20">
                                            <label>Username</label>
                                            <input name="username" class="mb-0" type="text" placeholder="Username">
                                        </div>
                                        <div class="col-md-6 col-12 mb-20">
                                            <label>Họ Tên</label>
                                            <input name="hoten" class="mb-0" type="text" placeholder="Họ Tên">
                                        </div>
                                        <div class="col-md-12 mb-20">
                                            <label>Email Address*</label>
                                            <input name="email" class="mb-0" type="email" placeholder="Email Address">
                                        </div>
                                        <div class="col-md-6 mb-20">
                                            <label>Password</label>
                                            <input name="password" class="mb-0" type="password" placeholder="Password">
                                        </div>
                                        <div class="col-md-6 mb-20">
                                            <label>Confirm Password</label>
                                            <input name= "confirmpassword" class="mb-0" type="password" placeholder="Confirm Password">
                                        </div>
                                        <div class="error-server col-md-12">${errors }</div>
                                        <div class="col-md-6 mb-20">
                                            <p><button type = "submit" class="btn btn-primary">Registder</button></p>
                                        </div>
                                        <div class="col-md-6 mb-20">
                                           <p>Bạn đã có tài khoản ?&nbsp;&nbsp;<a href="http://localhost:8080/ecommerce/login" class="btn btn-primary">Đăng Nhập</a></p>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="col-sm-2 col-md-2 col-lg-2 col-xs-2">
	                    </div>
                    </div>
                </div>
            </div>
            <!-- Login Content Area End Here -->
            <!-- Begin Footer Area -->
            <jsp:include page="../footer/footer_html.jsp" />
            <!-- Footer Area End Here -->
        </div>
<jsp:include page="../footer/footer.jsp"/>
    </body>

<!-- login-register31:27-->
</html>
