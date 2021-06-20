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
<title>Lịch sử mua hàng</title>
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
						<li class="active">Lịch sử mua hàng</li>
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
						<table id = "customers">
							<thead>
								<tr>
									<th>Tên khách hàng</th>
									<th>Số điện thoại</th>
									<th>Địa chỉ giao hàng</th>
									<th>Ngày lập hóa đơn</th>
									<th>Ghi chú</th>
									<th>Số lượng</th>
									<th>Tổng tiền</th>
									<th>Tên sản phẩm</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="hoadon" items="${user.getHoadon() }">
									<c:forEach var="cthoadon" items="${hoadon.getChitiethoadon() }">
										<tr>
											<td class="tenkhachhang">${hoadon.getTenkhachhang() }</td>
											<td class="sodt">${hoadon.getSodt() }</td>
											<td class="diachigiaohang">${hoadon.getDiachigiaohang() }</td>
											<td class="ngaylap">${hoadon.getNgaylap() }</td>
											<td class="ghichu">${hoadon.getGhichu() }</td>
											<td>${cthoadon.getSoluong() }</td>
											<td>${cthoadon.getTongtien() }</td>
											<td>${cthoadon.getSanpham().getTensanpham() }</td>
										</tr>
									</c:forEach>
								</c:forEach>
							</tbody>
						</table>

					</div>

				</div>
				<div class="row">
					<div class="col-sm-12 col-md-12 col-xs-12 col-lg-12 mb-30">
						
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
