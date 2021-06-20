<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!doctype html>
<html class="no-js" lang="zxx">
    
<!-- compare32:03-->
<head>
<jsp:include page="../header/header.jsp" />
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Compare</title>
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
                            <li class="active">Compare</li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- Li's Breadcrumb Area End Here -->
            <!-- Compare Area -->
            
            <div class="compare-area pt-60 pb-60">
            	<span style="margin-left: 367px;">So sánh điện thoại 
            		<strong>${sp.getTensanpham() } ${sp.getRom() }</strong> và 
            		<strong>${spCompare.getTensanpham() } ${spCompare.getRom() }</strong>
            	</span>
                <div class="container">
                    <div class="compare-table table-responsive">
                        <table class="table table-bordered table-hover mb-0">
                            <tbody>
                                <tr>
                                    <th class="compare-column-titles"></th>
                                    <td class="compare-column-productinfo">
                                        <div class="compare-pdoduct-image">
                                            <a href="http://localhost:8080/ecommerce/chitiet/${sp.getMasanpham() }">
                                                <img  src='<c:url value="/resources/images/product/large-size/${sp.getHinhsanpham() }" />' alt="Product Image">
                                                
                                            </a>
                                            <a href="#"
                                            data-dungluong="${sp.getRom() }"
                                            data-tensanpham="${sp.getTensanpham() }"
											data-hinhsanpham="${sp.getHinhsanpham() }"
											data-tiensanpham="${sp.getGiatien() }"
											data-machitiet="${sp.getMasanpham() }"
											class="add-cart ho-button ho-button-sm">
                                                <span>ADD TO CART</span>
                                            </a>
                                        </div>
                                    </td>
                                    <td class="compare-column-productinfo">
                                        <div class="compare-pdoduct-image">
                                            <a href="http://localhost:8080/ecommerce/chitiet/${spCompare .getMasanpham() }">
                                                <img src='<c:url value="/resources/images/product/large-size/${spCompare.getHinhsanpham() }" />' alt="Product Image">
                                            </a>
                                            <a href="#"
                                             data-dungluong="${spCompare.getRom() }"
                                             data-tensanpham="${spCompare.getTensanpham() }"
											 data-hinhsanpham="${spCompare.getHinhsanpham() }"
											 data-tiensanpham="${spCompare.getGiatien() }"
											 data-machitiet="${spCompare.getMasanpham() }"
                                             class="add-cart ho-button ho-button-sm">
                                                <span>ADD TO CART</span>
                                            </a>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Product Name:</th>
                                    <td>
                                        <h5 class="compare-product-name">
                                        	<a href="http://localhost:8080/ecommerce/chitiet/${sp .getMasanpham() }">${sp.getTensanpham() } ${sp.getRom() }</a>
                                        </h5>
                                    </td>
                                    <td>
                                        <h5 class="compare-product-name">
                                        	<a href="http://localhost:8080/ecommerce/chitiet/${spCompare .getMasanpham() }">${spCompare.getTensanpham() } ${spCompare.getRom() }</a>
                                        </h5>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Price:</th>
                                    <td>$${sp.getGiatien() }</td>
                                    <td class="tiensp">$${spCompare.getGiatien() }</td>
                                </tr>
                                <tr>
                                    <th>Màn hình:</th>
                                    <td>${sp.getManhinh() }</td>
                                    <td>${spCompare.getManhinh() }</td>
                                </tr>
                                 <tr>
                                    <th>Hệ điều hành:</th>
                                    <td>${sp.getHedieuhanh() }</td>
                                    <td>${spCompare.getHedieuhanh() }</td>
                                </tr>
                                <tr>
                                    <th>Camera sau:</th>
                                    <td>${sp.getCamerasau() }</td>
                                    <td>${spCompare.getCamerasau() }</td>
                                </tr>
                                <tr>
                                    <th>Camera trước:</th>
                                    <td>${sp.getCameratruoc() }</td>
                                    <td>${spCompare.getCameratruoc() }</td>
                                </tr>
                                <tr>
                                    <th>CPU:</th>
                                    <td>${sp.getCpu() }</td>
                                    <td>${spCompare.getCpu() }</td>
                                </tr>
                                <tr>
                                    <th>Bộ nhớ trong:</th>
                                    <td>${sp.getRom() } GB</td>
                                    <td>${spCompare.getRom() } GB</td>
                                </tr>
                                <tr>
                                    <th>RAM:</th>
                                    <td>${sp.getRam() } GB</td>
                                    <td>${spCompare.getRam() } GB</td>
                                </tr>
                                <tr>
                                    <th>Dung lượng pin:</th>
                                   <td>${sp.getDungluongpin() }</td>
                                    <td>${spCompare.getDungluongpin() }</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <!--// Compare Area -->
            <!-- Begin Footer Area -->
            <jsp:include page="../footer/footer_html.jsp" />
            <!-- Footer Area End Here -->
        </div>
       
        	<jsp:include page="../footer/footer.jsp" />
    </body>

<!-- compare32:04-->
</html>
