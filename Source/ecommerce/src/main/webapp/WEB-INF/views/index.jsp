<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!doctype html>
<html class="no-js" lang="zxx">

<!-- index28:48-->
<head>
<jsp:include page="header/header.jsp" />
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Home Version One || limupa - Digital Products Store
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
		<jsp:include page="header/header_html.jsp" />
		<!-- Header Area End Here -->
		<!-- Begin Product Area -->
		<div class="product-area pt-60 pb-50">
			<div class="container">
				<div class="row">
					<div class="col-lg-12">
						<div class="li-product-tab">
							<ul class="nav li-product-menu">
								<li><a class="active" data-toggle="tab"
									href="#li-new-product"><span>New Arrival</span></a></li>
							</ul>
						</div>
						<!-- Begin Li's Tab Menu Content Area -->
					</div>
				</div>
				<div class="tab-content">
					<div id="li-new-product" class="tab-pane active show"
						role="tabpanel">
						<div class="row">
							<div class="product-active owl-carousel">
 								<c:forEach var="sanpham" items="${listSanPhams_NewArrival }">	
 									<div class="col-lg-12">
										<!-- single-product-wrap start -->
										<div class="single-product-wrap">
											<div class="product-image">
												<a href="chitiet/${sanpham.getMasanpham() }"> <img
													class="hinhanhsanpham" alt="hinh"
													src='<c:url value="/resources/images/product/large-size/${sanpham.getHinhsanpham() }" />' />
												</a> <span class="sticker">New</span>
											</div>
											<div class="product_desc">
												<div class="product_desc_info">
													<div class="product-review">
													</div>
													<h4>
														<a class="product_name" href="chitiet/${sanpham.getMasanpham() }">
														${sanpham.getTensanpham() }</a>
													</h4>
													<div class="price-box">
														<span class="new-price">$${sanpham.getGiatien() }</span>
													</div>
												</div>
												<div class="add-actions">
													<ul class="add-actions-link">
														<li class="add-cart active add-lstcart"
															data-dungluong="${sanpham.getRom() }"
															data-hinhsanpham="${sanpham.getHinhsanpham() }"
															data-tiensanpham="${sanpham.getGiatien() }"
															data-machitiet="${sanpham.getMasanpham() }"
															data-tensanpham="${sanpham.getTensanpham() }">Add to
															car</li>
													</ul>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Product Area End Here -->
		<!-- Begin Li's Trendding Products Area -->
		<section
			class="product-area li-laptop-product li-trendding-products best-sellers pb-45">
			<div class="container">
				<div class="row">
					<!-- Begin Li's Section Area -->
					<div class="col-lg-12">
						<div class="li-section-title">
							<h2>
								<span>Bestsellers</span>
							</h2>
						</div>
						<div class="row">
							<div class="product-active owl-carousel">
								<c:forEach var="sanpham" items="${listSanPhams_bestseller }">
									<div class="col-lg-12">
										<!-- single-product-wrap start -->
										<div class="single-product-wrap">

											<div class="product-image">
												<a href="chitiet/${sanpham.getMasanpham() }"> <img
													src='<c:url value="/resources/images/product/large-size/${sanpham.getHinhsanpham() }" />'
													alt="Li's Product Image">
												</a> <span class="sticker">New</span>
											</div>
											
											<div class="product_desc">
												<div class="product_desc_info">
													<h4>
														<a class="product_name" href="chitiet/${sanpham.getMasanpham() }">${sanpham.getTensanpham() }</a>
													</h4>
													
													<div class="price-box">
														<c:set var="price_giamgia" value="${0}" />
														<c:set var="price" value="${0}" />
														<c:forEach var="value" items="${ sanpham.getKhuyenmai() }">
															<c:set var="price_giamgia" value="${100 - value.getGiamgia()}" />
															<span class="discount-percentage">
																-${value.getGiamgia()} % 
															</span>
														</c:forEach>
														<span class="new-price">$${sanpham.getGiatien() * price_giamgia / 100 }</span>
														<span class="old-price">$${sanpham.getGiatien() }</span> 
														<c:set var="price_giamgia" value="${0}" />
														<c:set var="price" value="${0}" />
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
															data-tensanpham="${sanpham.getTensanpham() } }">Add to
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
					<!-- Li's Section Area End Here -->
				</div>
			</div>
		</section>
		<!-- Li's Trendding Products Area End Here -->
		
		<!-- Begin Li's Static Home Area -->
		<div class="li-static-home">
			<div class="container">
				<div class="row">
					<div class="col-lg-12">
						<!-- Begin Li's Static Home Image Area -->
						<div class="li-static-home-image"></div>
						<!-- Li's Static Home Image Area End Here -->
						<!-- Begin Li's Static Home Content Area -->
						<div class="li-static-home-content">
							<p>
								Sale Offer<span>-20% Off</span>This Week
							</p>
							<h2>Featured Product</h2>
							<h2>Meito Accessories 2018</h2>
							<p class="schedule">
								Starting at <span> $1209.00</span>
							</p>
							<div class="default-btn">
								<a href="shop-left-sidebar.html" class="links">Shopping Now</a>
							</div>
						</div>
						<!-- Li's Static Home Content Area End Here -->
					</div>
				</div>
			</div>
		</div>
		<!-- Li's Static Home Area End Here -->
		<!-- Begin Li's Laptop Product Area -->
		<section class="product-area li-laptop-product pt-60 pb-45">
			<div class="container">
				<div class="row">
					<!-- Begin Li's Section Area -->
					<div class="col-lg-12">
						<div class="li-section-title">
							<h2>
								<span>Điện Thoại</span>
							</h2>
						</div>
						<div class="row">
							<div class="product-active owl-carousel">
								<c:forEach var="sanpham" items="${listdienthoai }">	
 									<div class="col-lg-12">
										<!-- single-product-wrap start -->
										<div class="single-product-wrap">
											<div class="product-image">
												<a href="chitiet/${sanpham.getMasanpham() }"> <img
													class="hinhanhsanpham" alt="hinh"
													src='<c:url value="/resources/images/product/large-size/${sanpham.getHinhsanpham() }" />' />
												</a> <span class="sticker">New</span>
											</div>
											<div class="product_desc">
												<div class="product_desc_info">
													<div class="product-review">
													</div>
													<h4>
														<a class="product_name" href="chitiet/${sanpham.getMasanpham() }">
														${sanpham.getTensanpham() }</a>
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
															data-tensanpham="${sanpham.getTensanpham() } }">Add to
															car</li>
													</ul>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
					<!-- Li's Section Area End Here -->
				</div>
			</div>
		</section>
		<!-- Li's Laptop Product Area End Here -->
		<!-- Begin Footer Area -->
		<jsp:include page="footer/footer_html.jsp" />
		<!-- Footer Area End Here -->
		<div class="modal fade modal-wrapper" id="exampleModalCenter" >
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-body">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            <div class="modal-inner-area row">
                                <div class="col-lg-5 col-md-6 col-sm-6">
                                   <!-- Product Details Left -->
                                    <div class="product-details-left">
                                        <div class="product-details-images slider-navigation-1">
                                            <div class="lg-image">
                                                <img src="images/product/large-size/1.jpg" alt="product image">
                                            </div>
                                            <div class="lg-image">
                                                <img src="images/product/large-size/2.jpg" alt="product image">
                                            </div>
                                            <div class="lg-image">
                                                <img src="images/product/large-size/3.jpg" alt="product image">
                                            </div>
                                            <div class="lg-image">
                                                <img src="images/product/large-size/4.jpg" alt="product image">
                                            </div>
                                            <div class="lg-image">
                                                <img src="images/product/large-size/5.jpg" alt="product image">
                                            </div>
                                            <div class="lg-image">
                                                <img src="images/product/large-size/6.jpg" alt="product image">
                                            </div>
                                        </div>
                                        <div class="product-details-thumbs slider-thumbs-1">                                        
                                            <div class="sm-image"><img src="images/product/small-size/1.jpg" alt="product image thumb"></div>
                                            <div class="sm-image"><img src="images/product/small-size/2.jpg" alt="product image thumb"></div>
                                            <div class="sm-image"><img src="images/product/small-size/3.jpg" alt="product image thumb"></div>
                                            <div class="sm-image"><img src="images/product/small-size/4.jpg" alt="product image thumb"></div>
                                            <div class="sm-image"><img src="images/product/small-size/5.jpg" alt="product image thumb"></div>
                                            <div class="sm-image"><img src="images/product/small-size/6.jpg" alt="product image thumb"></div>
                                        </div>
                                    </div>
                                    <!--// Product Details Left -->
                                </div>

                                <div class="col-lg-7 col-md-6 col-sm-6">
                                    <div class="product-details-view-content pt-60">
                                        <div class="product-info">
                                            <h2>Today is a good day Framed poster</h2>
                                            <span class="product-details-ref">Reference: demo_15</span>
                                            <div class="rating-box pt-20">
                                                <ul class="rating rating-with-review-item">
                                                    <li><i class="fa fa-star-o"></i></li>
                                                    <li><i class="fa fa-star-o"></i></li>
                                                    <li><i class="fa fa-star-o"></i></li>
                                                    <li class="no-star"><i class="fa fa-star-o"></i></li>
                                                    <li class="no-star"><i class="fa fa-star-o"></i></li>
                                                    <li class="review-item"><a href="#">Read Review</a></li>
                                                    <li class="review-item"><a href="#">Write Review</a></li>
                                                </ul>
                                            </div>
                                            <div class="price-box pt-20">
                                                <span class="new-price new-price-2">$57.98</span>
                                            </div>
                                            <div class="product-desc">
                                                <p>
                                                    <span>100% cotton double printed dress. Black and white striped top and orange high waisted skater skirt bottom. Lorem ipsum dolor sit amet, consectetur adipisicing elit. quibusdam corporis, earum facilis et nostrum dolorum accusamus similique eveniet quia pariatur.
                                                    </span>
                                                </p>
                                            </div>
                                            <div class="product-variants">
                                                <div class="produt-variants-size">
                                                    <label>Dimension</label>
                                                    <select class="nice-select">
                                                        <option value="1" title="S" selected="selected">40x60cm</option>
                                                        <option value="2" title="M">60x90cm</option>
                                                        <option value="3" title="L">80x120cm</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="single-add-to-cart">
                                                <form action="#" class="cart-quantity">
                                                    <div class="quantity">
                                                        <label>Quantity</label>
                                                        <div class="cart-plus-minus">
                                                            <input class="cart-plus-minus-box" value="1" type="text">
                                                            <div class="dec qtybutton"><i class="fa fa-angle-down"></i></div>
                                                            <div class="inc qtybutton"><i class="fa fa-angle-up"></i></div>
                                                        </div>
                                                    </div>
                                                    <button class="add-to-cart" type="submit">Add to cart</button>
                                                </form>
                                            </div>
                                            <div class="product-additional-info pt-25">
                                                <a class="wishlist-btn" href="wishlist.html"><i class="fa fa-heart-o"></i>Add to wishlist</a>
                                                <div class="product-social-sharing pt-25">
                                                    <ul>
                                                        <li class="facebook"><a href="#"><i class="fa fa-facebook"></i>Facebook</a></li>
                                                        <li class="twitter"><a href="#"><i class="fa fa-twitter"></i>Twitter</a></li>
                                                        <li class="google-plus"><a href="#"><i class="fa fa-google-plus"></i>Google +</a></li>
                                                        <li class="instagram"><a href="#"><i class="fa fa-instagram"></i>Instagram</a></li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>   
	</div>
	<!-- Body Wrapper End Here -->
	<!-- jQuery-V1.12.4 -->

	<jsp:include page="footer/footer.jsp" />
</body>

<!-- index30:23-->
</html>