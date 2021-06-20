<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header>
			<!-- Begin Header Top Area -->
			<div class="header-top" id="minicart">
				<div class="container">
					<div class="row">
						<!-- Begin Header Top Left Area -->
						<div class="col-lg-3 col-md-4">
							<div class="header-top-left">
								<ul class="phone-wrap">
									<li></li>
								</ul>
							</div>
						</div>
						<!-- Header Top Left Area End Here -->
						<!-- Begin Header Top Right Area -->
						<div class="col-lg-9 col-md-8">
							<div class="header-top-right">
								<ul class="ht-menu">
									<!-- Begin Setting Area -->
									<li>
										<div class="ht-setting-trigger">
											<span>Setting</span>
										</div>
										<div class="setting ht-setting">
											<ul class="ht-setting-list">
												<c:choose>
													<c:when test="${username != null }">
														<li><a class="circle-avatar" href="http://localhost:8080/ecommerce/user"><span>${username}</span></a></li>
														<li><a href="http://localhost:8080/ecommerce/logout">Logout</a></li>
													</c:when>
													<c:otherwise>
														<li><a href="http://localhost:8080/ecommerce/login">Login</a></li>
													</c:otherwise>
												</c:choose>
											</ul>
										</div>
									</li>
									<!-- Setting Area End Here -->
								</ul>
							</div>
						</div>
						<!-- Header Top Right Area End Here -->
					</div>
				</div>
			</div>
			<!-- Header Top Area End Here -->
			<!-- Begin Header Middle Area -->
			<div class="header-middle pl-sm-0 pr-sm-0 pl-xs-0 pr-xs-0">
				<div class="container">
					<div class="row">
						<!-- Begin Header Logo Area -->
						<div class="col-lg-3">
							<div class="logo pb-sm-30 pb-xs-30">
								<a href="/ecommerce"> <img
									src='<c:url value="/resources/images/menu/logo/1.jpg" />'
									alt="">
								</a>
							</div>
						</div>
						<!-- Header Logo Area End Here -->
						<!-- Begin Header Middle Right Area -->
						<div class="col-lg-9 pl-0 ml-sm-15 ml-xs-15">
							<!-- Begin Header Middle Searchbox Area -->
							<form action="#" class="hm-searchbox">
								<input type="text" id="search" name="search"
									placeholder="Enter your search key ...">
								<button class="li-btn" type="submit">
									<i class="fa fa-search"></i>
								</button>
							</form>
							<!-- Header Middle Searchbox Area End Here -->
							<!-- Begin Header Middle Right Area -->
							<div class="header-middle-right">
								<ul class="hm-menu">
									<!-- Header Middle Wishlist Area End Here -->
									<!-- Begin Header Mini Cart Area -->
									<li class="hm-minicart">
										<div class="hm-minicart-trigger">
											<span class="item-icon"></span> <span class="item-text">
												<span class="cart-item-count countcart">${countCart }</span>
											</span>
										</div> <span></span>
										<div class="minicart" style="z-index: 991;">
											<ul class="minicart-product-list">
												<c:forEach var="value" items="${giohangs }">
													<li>
														<a href="single-product.html" class="minicart-product-image"> 
														 <img src='<c:url value="/resources/images/product/large-size/${value.getHinhsanpham()}" />'
															alt="cart products">
														</a>
														<div class="minicart-product-details">
															<span class="li-product-name" data-masp="${value.getMasp()}">${value.getTensp()}</span><br />
															<span class="">${value.getGiatien()}</span>
														</div>
														<button  
														data-masp="${value.getMasp()}"
														class="close remove-listcart remove-cart" title="Remove">
															<i class="fa fa-close"></i>
														</button>
													</li>
												</c:forEach>
											</ul>
											<div class="minicart-button">
												<a href="http://localhost:8080/ecommerce/cart"
													class="li-button li-button-fullwidth li-button-dark"> <span>View
														Full Cart</span>
												</a> <a href="http://localhost:8080/ecommerce/thanhtoan"
													class="li-button li-button-fullwidth"> <span>Checkout</span>
												</a>
											</div>
										</div>
									</li>
									<!-- Header Mini Cart Area End Here -->
								</ul>
							</div>
							<!-- Header Middle Right Area End Here -->
						</div>
						<!-- Header Middle Right Area End Here -->
					</div>
				</div>
			</div>
			<!-- Header Middle Area End Here -->
			<!-- Begin Header Bottom Area -->
			<div class="header-bottom header-sticky d-none d-lg-block d-xl-block">
				<div class="container">
					<div class="row">
						<div class="col-lg-12">
							<div class="hb-menu">
								<nav>
									<ul>
										<li><a href="/ecommerce">Home</a></li>
										<c:forEach var="value" items="${danhmuc }">
											<li><a href="http://localhost:8080/ecommerce/${value.getMadanhmuc() }/${value.getTendanhmuc() }">${value.getTendanhmuc() }</a></li>
										</c:forEach>
									</ul>
								</nav>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Header Bottom Area End Here -->
			<!-- Begin Mobile Menu Area -->
			<div class="mobile-menu-area d-lg-none d-xl-none col-12">
				<div class="container">
					<div class="row">
						<div class="mobile-menu"></div>
					</div>
				</div>
			</div>
			<!-- Mobile Menu Area End Here -->
		</header>