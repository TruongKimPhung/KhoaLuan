<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html class="no-js" lang="zxx">

<!-- login-register31:27-->
<head>
<jsp:include page="../header/header.jsp" />
<meta charset="UTF-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Confirm User</title>
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
						<li class="active">Confirm User</li>
					</ul>
				</div>
			</div>
		</div>
		<!-- Li's Breadcrumb Area End Here -->
		<!-- Begin Login Content Area -->
		<div class="page-section mb-60">
			<div class="container">
				<div class="row">
					 <div class="col-sm-3 col-md-3 col-lg-3 col-xs-3">
	                 </div>
                     <div class="col-sm-6 col-md-6 col-lg-6 col-xs-6">
						<!-- Login Form s-->
						<form action="form-confirmuser" method="post">
							<div class="login-form">
								<h4 class="login-title">Đặt lại mật khẩu của bạn</h4>
								<div class="row">
									<div class="col-md-12 col-12 mb-20">
										<label>Bạn muốn nhận mã để đặt lại mật khẩu</label>
										<label>Gửi mã qua email: <span>${email }</span></label> 
										<label>Người dùng: <span>${username }</span></label>
									</div>
									<div class="col-md-12">
										<button class="col-md-4 register-button mt-0" type="submit">Next</button>
									</div>
								</div>
							</div>
						</form>
					</div>
					<div class="col-sm-3 col-md-3 col-lg-3 col-xs-3">
	                </div>
				</div>
			</div>
		</div>
		<!-- Login Content Area End Here -->
		<!-- Begin Footer Area -->
		<jsp:include page="../footer/footer_html.jsp" />
		<!-- Footer Area End Here -->
	</div>
	<!-- Body Wrapper End Here -->

	<jsp:include page="../footer/footer.jsp" />
</body>

<!-- login-register31:27-->
</html>
