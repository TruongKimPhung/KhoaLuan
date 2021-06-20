<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!doctype html>
<html class="no-js" lang="zxx">

<!-- single-product31:30-->
<head>
<jsp:include page="../header/header.jsp" />
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Single Product || limupa - Digital Products Store
	eCommerce Bootstrap 4 Template</title>
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
						<li class="active">Single Product</li>
					</ul>
				</div>
			</div>
		</div>
		<!-- Li's Breadcrumb Area End Here -->
		<!-- content-wraper start -->
		<div class="content-wraper">
			<div class="container">
				<div class="row single-product-area">
					<div class="col-lg-5 col-md-6">
						<!-- Product Details Left -->
						<div class="product-details-left">

							<div class="product-details-images slider-navigation-1">
								<c:forEach var="value" items="${ hinhsanpham }">
									<div class="lg-image">
										<a class="popup-img venobox vbox-item"
											href='<c:url value="/resources/images/product/large-size/${value }" />'
											data-gall="myGallery"> <img
											src='<c:url value="/resources/images/product/large-size/${value }" />'
											alt="product image">
										</a>
									</div>
								</c:forEach>
							</div>
							<div class="product-details-thumbs slider-thumbs-1">
								<c:forEach var="value" items="${ hinhsanpham }">
									<div class="sm-image">
										<img
											src='<c:url value="/resources/images/product/large-size/${ value }" />'
											alt="product image thumb">
									</div>
								</c:forEach>
							</div>
						</div>
						<!--// Product Details Left -->
					</div>
					<div class="col-lg-7 col-md-6">
						<div class="product-details-view-content pt-60">
							<div class="product-info">
									<h2>${sanpham.getTensanpham() }</h2>
								<div class="price-box pt-20">
									<span class="new-price new-price-2">${sanpham.getGiatien() }
										$</span>
								</div>
								<div class="product-desc">
									<p>
										<span>${sanpham.getMota()}</span>
									</p>
								</div>

								<div class="single-add-to-cart">
									<form action="#" class="cart-quantity">
										<div class="quantity">
											<label>Quantity</label>
											<div class="cart-plus-minus">
												<input class="cart-plus-minus-box" value="1" type="text">
												<div class="dec qtybutton">
													<i class="fa fa-angle-down"></i>
												</div>
												<div class="inc qtybutton">
													<i class="fa fa-angle-up"></i>
												</div>
											</div>
										</div>
									</form>
								</div>
								<div class="buttonSubmit">
										<button
											data-dungluong="${sanpham.getRom() }"
											data-tensanpham="${sanpham.getTensanpham() }"
											data-hinhsanpham="${sanpham.getHinhsanpham() }"
											data-tiensanpham="${sanpham.getGiatien() }"
											data-machitiet="${sanpham.getMasanpham() }"
											 id="myBtn"
											class="btn btn-success add-cart">Thêm Vào Giỏ Hàng</button>
										<button
											data-dungluong="${sanpham.getRom() }"
											data-tensanpham="${sanpham.getTensanpham() }"
											data-hinhsanpham="${sanpham.getHinhsanpham() }"
											data-tiensanpham="${sanpham.getGiatien() }"
											data-machitiet="${sanpham.getMasanpham() }"
										 class="muangay btn btn-success btn-muangay">
										 Mua Ngay
										 </button>
								</div>
								<div class="chitietsanpham">
									<h2>Thông số kỹ thuật</h2>
										<ul class="thongso">
											<li>
												<span>Màn hình:</span> 
												<div>${sanpham.getManhinh() }</div>
											</li>
											<li>
												<span>Hệ điều hành:</span> 
												<div>${sanpham.getHedieuhanh() }</div>
											</li>
											<li>
												<span>Camera sau:</span>
												<div>${sanpham.getCamerasau() }</div>
											</li>
											<li>
												<span>Camera trước:</span>
												<div>${sanpham.getCameratruoc() }</div>
											</li>
											<li>
												<span>CPU:</span> 
												<div>${sanpham.getCpu() }</div>
											</li>
											<li>
												<span>RAM:</span> 
												<div>${sanpham.getRam() }</div>
											</li>
											<li>
												<span>Bộ nhớ trong:</span> 
												<div>${sanpham.getRom() }</div>
											</li>
											<li>
												<span>Dung lượng pin:</span> 
												<div>${sanpham.getDungluongpin() }</div>
											</li>
										</ul>
								</div>
								<div class="block-reassurance">
									
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- content-wraper end -->
		
		<!-- Begin Li's Laptop Product Area -->
		<section class="product-area li-laptop-product pt-30 pb-50">
			<div class="container">
				<div class="row">
					<!-- Begin Li's Section Area -->
					<div class="col-lg-12">
						<div class="li-section-title">
							<h2>
								<span>So sánh với các sản phẩm tương tự:</span>
							</h2>
						</div>
						<div class="row">

							 <c:forEach var="value" items="${lstCompare }">
								<div class="col-lg-3">
									<div class="product-active notowl">
										<!-- single-product-wrap start -->
										<div class="single-product-wrap">
											<div class="product-image">
												<a href="${value.getMasanpham() }"> <img 
													src='<c:url value="/resources/images/product/large-size/${value.getHinhsanpham() }" />'
													alt="Li's Product Image">
												</a>
											</div>
											<div class="product_desc">
												<div class="product_desc_info">
													<h4>
													 	<a class="product_name" href="${value.getMasanpham() }">${value.getTensanpham() }</a>
													</h4>
													<div class="price-box">
														<span class="new-price">$${value.getGiatien()}</span>
													</div>
													<div class="comparesp">
														<a href="http://localhost:8080/ecommerce/compare/${sanpham.getMasanpham() } ${value.getMasanpham() }  ${sanpham.getTensanpham() }vs ${value.getTensanpham() } ">So sánh chi tiết</a> 
													</div> 
												</div>
												<div class="add-actions">
													<ul class="add-actions-link">
														<li class="add-cart active add-lstcart"
															data-dungluong="${value.getRom() }"
															data-hinhsanpham="${value.getHinhsanpham() }"
															data-tiensanpham="${value.getGiatien() }"
															data-machitiet="${value.getMasanpham() }"
															data-tensanpham="${value.getTensanpham() }">Add to
															car</li>
													</ul>
												</div>
											</div>
										</div>
										<!-- single-product-wrap end -->

									</div>
								</div>
							</c:forEach> 

						</div>
					</div>
					<!-- Li's Section Area End Here -->
				</div>
			</div>
		</section>
		<!-- Li's Laptop Product Area End Here -->
		<!-- Begin Footer Area -->
		<div class="footer">
			<!-- Begin Footer Static Top Area -->
			<div class="footer-static-top">
				<div class="container">
					<!-- Begin Footer Shipping Area -->
					<div class="footer-shipping pt-60 pb-55 pb-xs-25">
						<div class="row">
							<!-- Begin Li's Shipping Inner Box Area -->
							<div class="col-lg-3 col-md-6 col-sm-6 pb-sm-55 pb-xs-55">
								<div class="li-shipping-inner-box">
									<div class="shipping-icon">
										<img
											src='<c:url value="/resources/images/shipping-icon/1.png" />'
											alt="Shipping Icon">
									</div>
									<div class="shipping-text">
										<h2>Free Delivery</h2>
										<p>And free returns. See checkout for delivery dates.</p>
									</div>
								</div>
							</div>
							<!-- Li's Shipping Inner Box Area End Here -->
							<!-- Begin Li's Shipping Inner Box Area -->
							<div class="col-lg-3 col-md-6 col-sm-6 pb-sm-55 pb-xs-55">
								<div class="li-shipping-inner-box">
									<div class="shipping-icon">
										<img
											src='<c:url value="/resources/images/shipping-icon/2.png" />'
											alt="Shipping Icon">
									</div>
									<div class="shipping-text">
										<h2>Safe Payment</h2>
										<p>Pay with the world's most popular and secure payment
											methods.</p>
									</div>
								</div>
							</div>
							<!-- Li's Shipping Inner Box Area End Here -->
							<!-- Begin Li's Shipping Inner Box Area -->
							<div class="col-lg-3 col-md-6 col-sm-6 pb-xs-30">
								<div class="li-shipping-inner-box">
									<div class="shipping-icon">
										<img
											src='<c:url value="/resources/images/shipping-icon/3.png" />'
											alt="Shipping Icon">
									</div>
									<div class="shipping-text">
										<h2>Shop with Confidence</h2>
										<p>Our Buyer Protection covers your purchasefrom click to
											delivery.</p>
									</div>
								</div>
							</div>
							<!-- Li's Shipping Inner Box Area End Here -->
							<!-- Begin Li's Shipping Inner Box Area -->
							<div class="col-lg-3 col-md-6 col-sm-6 pb-xs-30">
								<div class="li-shipping-inner-box">
									<div class="shipping-icon">
										<img
											src='<c:url value="/resources/images/shipping-icon/4.png" />'
											alt="Shipping Icon">
									</div>
									<div class="shipping-text">
										<h2>24/7 Help Center</h2>
										<p>Have a question? Call a Specialist or chat online.</p>
									</div>
								</div>
							</div>
							<!-- Li's Shipping Inner Box Area End Here -->
						</div>
					</div>
					<!-- Footer Shipping Area End Here -->
				</div>
			</div>
			<!-- Footer Static Top Area End Here -->
			<!-- Begin Footer Static Middle Area -->
			<div class="footer-static-middle">
				<div class="container">
					<div class="footer-logo-wrap pt-50 pb-35">
						<div class="row">
							<!-- Begin Footer Logo Area -->
							<div class="col-lg-4 col-md-6">
								<div class="footer-logo">
									<img src='<c:url value="/resources/images/menu/logo/1.jpg" />'
										alt="Footer Logo">
									<p class="info">We are a team of designers and developers
										that create high quality HTML Template & Woocommerce, Shopify
										Theme.</p>
								</div>
								<ul class="des">
									<li><span>Address: </span> 6688Princess Road, London,
										Greater London BAS 23JK, UK</li>
									<li><span>Phone: </span> <a href="#">(+123) 123 321
											345</a></li>
									<li><span>Email: </span> <a
										href="mailto://info@yourdomain.com">info@yourdomain.com</a></li>
								</ul>
							</div>
							<!-- Footer Logo Area End Here -->
							<!-- Begin Footer Block Area -->
							<div class="col-lg-2 col-md-3 col-sm-6">
								<div class="footer-block">
									<h3 class="footer-block-title">Product</h3>
									<ul>
										<li><a href="#">Prices drop</a></li>
										<li><a href="#">New products</a></li>
										<li><a href="#">Best sales</a></li>
										<li><a href="#">Contact us</a></li>
									</ul>
								</div>
							</div>
							<!-- Footer Block Area End Here -->
							<!-- Begin Footer Block Area -->
							<div class="col-lg-2 col-md-3 col-sm-6">
								<div class="footer-block">
									<h3 class="footer-block-title">Our company</h3>
									<ul>
										<li><a href="#">Delivery</a></li>
										<li><a href="#">Legal Notice</a></li>
										<li><a href="#">About us</a></li>
										<li><a href="#">Contact us</a></li>
									</ul>
								</div>
							</div>
							<!-- Footer Block Area End Here -->
							<!-- Begin Footer Block Area -->
							<div class="col-lg-4">
								<div class="footer-block">
									<h3 class="footer-block-title">Follow Us</h3>
									<ul class="social-link">
										<li class="twitter"><a href="https://twitter.com/"
											data-toggle="tooltip" target="_blank" title="Twitter"> <i
												class="fa fa-twitter"></i>
										</a></li>
										<li class="rss"><a href="https://rss.com/"
											data-toggle="tooltip" target="_blank" title="RSS"> <i
												class="fa fa-rss"></i>
										</a></li>
										<li class="google-plus"><a
											href="https://www.plus.google.com/discover"
											data-toggle="tooltip" target="_blank" title="Google +"> <i
												class="fa fa-google-plus"></i>
										</a></li>
										<li class="facebook"><a href="https://www.facebook.com/"
											data-toggle="tooltip" target="_blank" title="Facebook"> <i
												class="fa fa-facebook"></i>
										</a></li>
										<li class="youtube"><a href="https://www.youtube.com/"
											data-toggle="tooltip" target="_blank" title="Youtube"> <i
												class="fa fa-youtube"></i>
										</a></li>
										<li class="instagram"><a
											href="https://www.instagram.com/" data-toggle="tooltip"
											target="_blank" title="Instagram"> <i
												class="fa fa-instagram"></i>
										</a></li>
									</ul>
								</div>
								<!-- Begin Footer Newsletter Area -->
								<div class="footer-newsletter">
									<h4>Sign up to newsletter</h4>
									<form action="#" method="post" id="mc-embedded-subscribe-form"
										name="mc-embedded-subscribe-form"
										class="footer-subscribe-form validate" target="_blank"
										novalidate>
										<div id="mc_embed_signup_scroll">
											<div id="mc-form" class="mc-form subscribe-form form-group">
												<input id="mc-email" type="email" autocomplete="off"
													placeholder="Enter your email" />
												<button class="btn" id="mc-submit">Subscribe</button>
											</div>
										</div>
									</form>
								</div>
								<!-- Footer Newsletter Area End Here -->
							</div>
							<!-- Footer Block Area End Here -->
						</div>
					</div>
				</div>
			</div>
			<!-- Footer Static Middle Area End Here -->
			<!-- Begin Footer Static Bottom Area -->
			<div class="footer-static-bottom pt-55 pb-55">
				<div class="container">
					<div class="row">
						<div class="col-lg-12">
							<!-- Begin Footer Links Area -->
							<div class="footer-links">
								<ul>
									<li><a href="#">Online Shopping</a></li>
									<li><a href="#">Promotions</a></li>
									<li><a href="#">My Orders</a></li>
									<li><a href="#">Help</a></li>
									<li><a href="#">Customer Service</a></li>
									<li><a href="#">Support</a></li>
									<li><a href="#">Most Populars</a></li>
									<li><a href="#">New Arrivals</a></li>
									<li><a href="#">Special Products</a></li>
									<li><a href="#">Manufacturers</a></li>
									<li><a href="#">Our Stores</a></li>
									<li><a href="#">Shipping</a></li>
									<li><a href="#">Payments</a></li>
									<li><a href="#">Warantee</a></li>
									<li><a href="#">Refunds</a></li>
									<li><a href="#">Checkout</a></li>
									<li><a href="#">Discount</a></li>
									<li><a href="#">Refunds</a></li>
									<li><a href="#">Policy Shipping</a></li>
								</ul>
							</div>
							<!-- Footer Links Area End Here -->
							<!-- Begin Footer Payment Area -->
							<div class="copyright text-center">
								<a href="#"> <img src="images/payment/1.png" alt="">
								</a>
							</div>
							<!-- Footer Payment Area End Here -->
							<!-- Begin Copyright Area -->
							<div class="copyright text-center pt-25">
								<span><a href="https://www.templatespoint.net"
									target="_blank">Templates Point</a></span>
							</div>
							<!-- Copyright Area End Here -->
						</div>
					</div>
				</div>
			</div>
			<!-- Footer Static Bottom Area End Here -->
		</div>
		<!-- Footer Area End Here -->
		<!-- Begin Quick View | Modal Area -->
		<jsp:include page="../footer/footer_html.jsp" />
		<!-- Quick View | Modal Area End Here -->
	</div>
	<!-- Body Wrapper End Here -->

	<jsp:include page="../footer/footer.jsp" />
</body>

<!-- single-product31:32-->
</html>
