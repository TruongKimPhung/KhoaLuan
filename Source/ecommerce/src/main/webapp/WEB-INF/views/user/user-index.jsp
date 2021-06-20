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
<title>User</title>
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
						<li class="active">User</li>
					</ul>
				</div>
			</div>
		</div>
		<!-- Li's Breadcrumb Area End Here -->
		<!-- Begin Login Content Area -->
		<div class="page-section mb-60">
			<div class="container">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-xs-12 col-lg-12 mb-30">
						<table id="customerInfo">
							<thead>
								<tr>
									<th>Username</th>
									<th>Họ Tên</th>
									<th>Địa chỉ</th>
									<th>Giới Tính</th>
									<th>CMND</th>
									<th>Email</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>${ user.getUsername() }</td>
									<td>${ user.getHoten() }</td>
									<td>${ user.getDiachi() }</td>
									<td>${ user.getGioitinh() }</td>
									<td>${ user.getCmnd() }</td>
									<td>${ user.getEmail() }</td>
									<td>
										<a href="user/${ user.getUsername() }" class="btn btn-warning fa fa-edit" ></a>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
					<div class="col-sm-12 col-md-12 col-lg-12 col-xs-12">
						<a href="user/lichsumuahang">Lịch sử mua hàng</a><br />
						<a href="user/doimatkhau">Đổi mật khẩu</a>
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
	<script src='<c:url value="/resources/js/user.js" />'></script>
</body>

<!-- login-register31:27-->
</html>
