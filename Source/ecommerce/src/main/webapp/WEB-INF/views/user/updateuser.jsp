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
<title>Update User</title>
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
						<li><a href="/ecommerce">Home</a></li>
						<li class="active"><a href="/ecommerce/user">User</a></li>
						<li class="active">Update User</li>
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
						<form id="form-updateuser" action="updateuser" method="POST">
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
										<td>
											<span id="username">${ user.getUsername() }</span>
										</td>
										<td>
											<input type="text" name="hoten" id="hoten"
												class="form-control" value="${ user.getHoten() }" />
										</td>
										<td>
											<input type="text" name="diachi" id="diachi"
												class="form-control" value="${ user.getDiachi() }" />
										</td>
										<td>
											<input type="text" name="gioitinh" id="gioitinh"
												class="form-control" value="${ user.getGioitinh() }" />
										</td>
										<td>
											<input type="text" name="cmnd" id="cmnd"
												class="form-control" value="${ user.getCmnd() }" />
										</td>
										<td>
											<input type="text" name="email" id="email"
												class="form-control" value="${ user.getEmail() }" />
										</td>
										<td><a href="#" id="btnUpdateUser"
											class="btnUpdateUser btn btn-success fa fa-check"></a></td>
									</tr>
								</tbody>
							</table>
						</form>
					</div>
				</div>
				<div>
					<div class="col-sm-12 col-md-12 col-lg-6 col-xs-12">
						
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
	<script src='<c:url value="/resources/js/user.js" />'></script>
</body>

<!-- login-register31:27-->
</html>
