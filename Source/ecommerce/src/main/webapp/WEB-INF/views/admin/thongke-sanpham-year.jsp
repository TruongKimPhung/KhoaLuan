<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<title>RuangAdmin - Thống Kê Sản Phẩm</title>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
   
  <link href='<c:url value="/resources/admin/img/logo/logo.png" />' rel="icon">
 
  <link type="text/css" rel="stylesheet" href='<c:url value="/resources/admin/vendor/fontawesome-free/css/all.min.css" />' />
  <link type="text/css" rel="stylesheet" href='<c:url value="/resources/admin/vendor/bootstrap/css/bootstrap.min.css" />' />
  <link type="text/css" rel="stylesheet" href='<c:url value="/resources/admin/css/ruang-admin.min.css" />' />
  <link type="text/css" rel="stylesheet" href='<c:url value="/resources/admin/vendor/datatables/dataTables.bootstrap4.min.css" />' />
</head>

<body id="page-top">
  <div id="wrapper">
    <!-- Sidebar -->
    <jsp:include page="left-dashboard.jsp" />  
    <!-- Sidebar -->
    <div id="content-wrapper" class="d-flex flex-column">
      <div id="content">
        <!-- TopBar -->
         <jsp:include page="hearder-dashboard.jsp" /> 
        <!-- Topbar -->
        <!-- Container Fluid-->
        <div class="container-fluid" id="container-wrapper">
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">Thống Kê Sản Phẩm</h1>
          </div>

          <!-- Row -->
          <div class="row">
            <!-- Datatables -->
            <div class="col-lg-12">
              <div class="card mb-4">
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary">Sản phẩm trong năm</h6>
                </div>
                <div class="table-responsive p-3">
                  <table class="table align-items-center table-flush" id="dataTable">
                    <thead class="thead-light">
                      <tr>
							<th>Tên sản phẩm</th>
							<th>Số lượng</th>
							<th>Giá tiền</th>
							<th>Tổng số lượng bán ra</th>
							<th>Doanh Thu</th>
							<th>
								<select class="target">
									<option value="all">all</option>
									<option value="1day">1 day</option>
									<option value="1week">1 week</option>
									<option value="1month">1 month</option>
									<option value="1year" selected="selected">1 year</option>
								</select>
							</th>
						</tr>
                    </thead>
                    
                    <tbody>
						<c:set var="tongdoanhthu" value="${0}" />
						<c:set var="tongsoluongbanra" value="${0}" />
						<c:set var="tongsoluong" value="${0}" />
						<c:forEach var="sp" items="${sanpham }">
							<tr>
								<td>${sp.getTensanpham() }</td>
								<c:set var="tongsoluong" value="${tongsoluong + sp.getSoluong()}" />
								<td>${sp.getSoluong() }</td>
								<%-- <td>${ sp.getGiatien()}<td> --%>
								<%-- <td><fmt:formatNumber type="currency" value="1000000000000" /><td> --%>
								<%-- <td><fmt:formatNumber type="currency" value="${ sp.getGiatien()}" /><td> --%>
								<td>${sp.getGiatien() }</td>
								<td>
									<c:set var="total" value="${0}" />
									<c:forEach var="cthd" items="${sp.getChitiethoadon() }">
										<c:set var="total" value="${total + cthd.getSoluong()}" />
										<c:set var="tongsoluongbanra" value="${tongsoluongbanra + cthd.getSoluong()}" />
									</c:forEach>
									${total }
								</td>
								<td>
									<c:set var="total" value="${0}" />
									<c:forEach var="cthd" items="${sp.getChitiethoadon() }">
										<c:set var="total" value="${total + cthd.getTongtien()}" />
										<c:set var="tongdoanhthu" value="${tongdoanhthu + cthd.getTongtien()}" />
									</c:forEach>
									${total }
								</td>  
								<td></td>
							</tr>
						</c:forEach>
						
					</tbody>
					<tfoot>
						<tr>
							<th>Total: </th>
							<th>${tongsoluong }</th>
							<th></th>
							<th>${tongsoluongbanra }</th>
							<th>${tongdoanhthu }</th>
							<th></th>
						</tr>
                      <tr>
                      	<th>
	                      <spring:url value="thongke-sanpham-year/?type=xls" var="xlsURL" />
							<spring:url value="thongke-sanpham-year/?type=pdf" var="pdfURL" />
							<a href="${xlsURL }">Download Excel</a> <a href="${pdfURL }">Download
								PDF</a>
						</th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                      </tr>
                    </tfoot>
                  </table>
                </div>
              </div>
            </div>
          </div>
          <!--Row-->

          <!-- Documentation Link -->
          <div class="row">
            <div class="col-lg-12">
              <p>DataTables is a third party plugin that is used to generate the demo table below. For more information
                about DataTables, please visit the official <a href="https://datatables.net/" target="_blank">DataTables
                  documentation.</a></p>
            </div>
          </div>

          <!-- Modal Logout -->
          <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabelLogout"
            aria-hidden="true">
            <div class="modal-dialog" role="document">
              <div class="modal-content">
                <div class="modal-header">
                  <h5 class="modal-title" id="exampleModalLabelLogout">Ohh No!</h5>
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                  </button>
                </div>
                <div class="modal-body">
                  <p>Are you sure you want to logout?</p>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-outline-primary" data-dismiss="modal">Cancel</button>
                  <a href="login.html" class="btn btn-primary">Logout</a>
                </div>
              </div>
            </div>
          </div>

        </div>
        <!---Container Fluid-->
      </div>

      <!-- Footer -->
      <footer class="sticky-footer bg-white">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>copyright &copy; <script> document.write(new Date().getFullYear()); </script> - developed by
              <b><a href="https://indrijunanda.gitlab.io/" target="_blank">indrijunanda</a></b>
            </span>
          </div>
        </div>
      </footer>
      <!-- Footer -->
    </div>
  </div>

  <!-- Scroll to top -->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>
  <script src='<c:url value="/resources/admin/vendor/jquery/jquery.min.js" />'></script>
<script src='<c:url value="/resources/admin/vendor/bootstrap/js/bootstrap.bundle.min.js" />'></script>
<script src='<c:url value="/resources/admin/vendor/jquery-easing/jquery.easing.min.js" />'></script>
<script src='<c:url value="/resources/admin/js/ruang-admin.min.js" />'></script>
<script src='<c:url value="/resources/js/thongke.js" />'></script>
  <!-- Page level plugins -->
<script src='<c:url value="/resources/admin/vendor/datatables/jquery.dataTables.min.js" />'></script>
<script src='<c:url value="/resources/admin/vendor/datatables/dataTables.bootstrap4.min.js" />'></script>

  <!-- Page level custom scripts -->
  <script>
    $(document).ready(function () {
      $('#dataTable').DataTable(); // ID From dataTable 
      $('#dataTableHover').DataTable(); // ID From dataTable with Hover
    });
  </script>

</body>

</html>