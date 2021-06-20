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
						<li class="active">Shopping Cart</li>
					</ul>
				</div>
			</div>
		</div>
		<!-- Li's Breadcrumb Area End Here -->
		<!--Shopping Cart Area Strat-->
		<div class="Shopping-cart-area pt-60 pb-60">
			<div class="container">
				<div class="row">
					<div class="col-12">
						<form action="" id="table-giohang">
							<div class="table-content table-responsive">
								<table class="table" id="table-cart">
									<thead>
										<tr>
											<th class="li-product-remove">remove</th>
											<th class="li-product-thumbnail">images</th>
											<th class="cart-product-name">Product</th>
											<th class="li-product-price">Unit Price</th>
											<th class="li-product-quantity">Quantity</th>
											<th class="li-product-subtotal">Total</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="value" items="${giohangs }">
											<tr data-machitiet="${value.getMachitiet() }">
												<td class="li-product-remove remove-cart"><a href="#"><i
													class="fa fa-times"></i></a></td>
												<td class="li-product-thumbnail"><a class="li-img-product" href="#"><img
													src='<c:url value="/resources/images/product/large-size/${value.getHinhsanpham()}" />'
													alt="Li's Product Image"></a></td>
												<td class="li-product-name" data-masp="${value.getMasp()}"><a class="li-product-namesp" href="chitiet/${value.getMasp()}">${value.getTensp()}</a></td>
												<td class="li-product-price" data-price="${value.getGiatien()}">${value.getGiatien()}$</td>
												<td class="quantity"><label>Quantity</label>
												<div class="cart-plus-minus">
													<input id="myMessage" class="cart-plus-minus-box" min='1' value="${value.getSoluong()}" type="text">
													 <div class="dec qtybutton">
														<i class="fa fa-angle-down"></i>
													</div>
														<div class="inc qtybutton">
															<i class="fa fa-angle-up"></i>
														</div>
													</div></td>
												<td class="product-subtotal"><span class="amount-total">${value.getGiatien()}$</span></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<div class="row">
								<div class="col-md-5 ml-auto">
									<div class="cart-page-total">
										<h2>Cart totals</h2>
										<ul>
											<li>Total <span class = "total"></span></li>
										</ul>
										<a href="http://localhost:8080/ecommerce/thanhtoan">Thanh Toán</a>
									</div>
								</div>
							</div>
						</form>
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
