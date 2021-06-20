<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!doctype html>
<html class="no-js" lang="zxx">

<!-- index28:48-->
<head>
<jsp:include page="../header/header.jsp" />
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Home Version One || limupa - Digital Products Store
	eCommerce Bootstrap 4 Template</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	
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
						<li class="active">${tendanhmuc }</li>
					</ul>
				</div>
			</div>
		</div>
		<!-- Li's Breadcrumb Area End Here -->
		<!-- Begin Li's Content Wraper Area -->
		<div class="content-wraper pt-60 pb-60 pt-sm-30">
			<div class="container">
				<div class="row">
					<div class="col-lg-9 order-1 order-lg-2">
						<!-- Begin Li's Banner Area -->
						<div class="single-banner shop-page-banner">
							<c:forEach var="value" items="${getDanhMucofMaDanhMuc }">
								<h2>${value.getTendanhmuc() }</h2>
							</c:forEach>
						</div>
						
						<!-- Li's Banner Area End Here -->
						<!-- shop-top-bar start -->
						<div class="shop-top-bar mt-30">
							<div class="shop-bar-inner">
								
								
							</div>
							<!-- product-select-box start -->
							<div class="product-select-box">
								<div class="product-short">
									<p id="madanhmuc" hidden>${madanhmuc}</p>
									<p>Sort By:</p>
									<select class="nice-select">
										<option value="default">Default</option>
										<option value="name_AZ">Name (A - Z)</option>
										<option value="name_ZA">Name (Z - A)</option>
										<option value="price_AZ">Price (Low &gt; High)</option>
										<option value="price_ZA">Price (High &gt; Low</option>
									</select>
								</div>
							</div>
							<!-- product-select-box end -->
						</div>
						<!-- shop-top-bar end -->
						<!-- shop-products-wrapper start -->
						<div class="shop-products-wrapper">
							<div class="tab-content">
								<div id="grid-view" class="tab-pane fade active show"
									role="tabpanel">
									<div class="product-area shop-product-area">
										<div class="row">
											<c:forEach var="sanpham" items="${listSanPham }">
												<div class="col-lg-4 col-md-4 col-sm-6 mt-40">
													<!-- single-product-wrap start -->
													<div class="single-product-wrap">
														<div class="product-image">
															<a href="http://localhost:8080/ecommerce/chitiet/${sanpham.getMasanpham()}"> <img
																src='<c:url value="/resources/images/product/large-size/${sanpham.getHinhsanpham() }" />'
																alt="Li's Product Image">
															</a> <span class="sticker">New</span>
														</div>
														<div class="product_desc">
															<div class="product_desc_info">
																<h4>
																	<a class="product_name" href="http://localhost:8080/ecommerce/chitiet/${sanpham.getMasanpham()}">${sanpham.getTensanpham() }</a>
																</h4>
																<div class="price-box">
																	<span class="new-price">$${sanpham.getGiatien() }</span>
																</div>
															</div>
															<div class="add-actions">
																<ul class="add-actions-link">
																	<li class="add-cart active add-lstcart"
															data-dungluong="${sanpham.getRom() }"
															data-tensanpham="${sanpham.getTensanpham() }"
															data-hinhsanpham="${sanpham.getHinhsanpham() }"
															data-tiensanpham="${sanpham.getGiatien() }"
															data-machitiet="${sanpham.getMasanpham() }"
															data-tensanpham="${sanpham.getTensanpham() }${sanpham.getRom() }">Add to
															car</li>
																</ul>
															</div>
														</div>
													</div>
													<!-- single-product-wrap end -->
												</div>
											</c:forEach>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- shop-products-wrapper end -->
					</div>
					<!-- filter --> 
					<div class="col-lg-3 order-2 order-lg-1">
						<div class="sidebar-categores-box">
							<div class="sidebar-title">
								<h2>Filter By</h2>
							</div>
							<button class="btn-clear-all mb-sm-30 mb-xs-30">Clear
								all</button>
							<div class="filter-sub-area pt-sm-10 pt-xs-10">
								<h5 class="filter-sub-titel">Price</h5>
								<div class="price-checkbox">
									<form action="#">
										<ul>
											<li><input type="checkbox" name="price-categori"
												value="100"> 100 </li>
											<li><input type="checkbox" name="price-categori"
												value="500"> 100 - 500</li>
											<li><input type="checkbox" name="price-categori"
												value="1000"> 500 - 1000 </li>
											<li><input type="checkbox" name="price-categori"
												value="1000m"> 1000 </li>
										</ul>
									</form>
								</div>
							</div>
							<div class="filter-sub-area pt-sm-10 pb-sm-15 pb-xs-15">
								<h5 class="filter-sub-titel">ROM</h5>
								<div class="categori-checkbox">
									<ul>
										<c:forEach var="value" items="${getRom }">
											<li><input type="checkbox" name="product-categori"
												value="${value.getRom()}"> ${value.getRom()} GB</li>
										</c:forEach>
									</ul>
								</div>
							</div>
							<div class="filter-sub-area pt-sm-10 pb-sm-15 pb-xs-15">
								<h5 class="filter-sub-titel">RAM</h5>
								<div class="size-checkbox">
									<ul>
										<c:forEach var="value" items="${getRam }">
											<li><input type="checkbox" name="ram-checkbox"
												value="${value.getRam()}"> ${value.getRam()} GB</li>
										</c:forEach>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Content Wraper Area End Here -->
		
		<!-- Begin Footer Area -->
		<jsp:include page="../footer/footer_html.jsp" />
		<!-- Footer Area End Here -->
		
	</div>
	<!-- Body Wrapper End Here -->
	<!-- jQuery-V1.12.4 -->

	<jsp:include page="../footer/footer.jsp" />
	<script src='<c:url value="/resources/js/listsanphamtheodanhmuc.js" />'></script>
</body>

<!-- index30:23-->
</html>
