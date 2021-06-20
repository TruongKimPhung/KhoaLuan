<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!doctype html>
<html class="no-js" lang="zxx">

<!-- shopping-cart31:32-->
<head>
<jsp:include page="../header/header.jsp" />
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Wishlist || limupa - Digital Products Store eCommerce
	Bootstrap 4 Template</title>
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
						<li class="active">Thanh Toán</li>
					</ul>
				</div>
			</div>
		</div>
		<!-- Li's Breadcrumb Area End Here -->
		<!--Shopping Cart Area Strat-->
		<div class="Shopping-cart-area pt-60 pb-60">
			<div class="container">
				<div class="row">
					<div class="col-md-6 col-sm-12">
						<h3>ĐẶT HÀNG THÀNH CÔNG</h3>
						<a href="http://localhost:8080/ecommerce">Nhấn vào đây để trở về trang chủ</a>
					</div>
				</div>
			</div>
		</div>
		<!--Shopping Cart Area End-->
		<!-- Begin Footer Area -->
		<jsp:include page="../footer/footer_html.jsp" />
		<!-- Footer Area End Here -->
	</div>

</body>
<jsp:include page="../footer/footer.jsp" />
<!-- wishlist31:30-->
</html>
