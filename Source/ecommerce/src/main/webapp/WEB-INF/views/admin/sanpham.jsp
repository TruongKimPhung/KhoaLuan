<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>RuangAdmin - Sản Phẩm</title>
<%--   <link href='<c:url value="/resources/admin/img/logo/logo.png" />' rel="icon">
  
  <link type="text/css" rel="stylesheet" href='<c:url value="/resources/admin/vendor/fontawesome-free/css/all.min.css" />' />
  <link type="text/css" rel="stylesheet" href='<c:url value="/resources/admin/vendor/bootstrap/css/bootstrap.min.css" />' />
  <link type="text/css" rel="stylesheet" href='<c:url value="/resources/admin/css/ruang-admin.min.css" />' />
  <link type="text/css" rel="stylesheet" href='<c:url value="/resources/admin/vendor/datatables/dataTables.bootstrap4.min.css" />' /> --%>
	<jsp:include page="header-admin/header-admin.jsp" /> 
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
          </div>

          <!-- Row -->
          <div class="row">
            <!-- Datatables -->
            <div class="col-lg-12">
              <div class="card mb-4">
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary">Sản Phẩm</h6>
                  <div style="float: right; margin-top: 10px;">
					<a class="btn btn-info" href="themsanpham">Thêm sản phẩm</a>
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter"
                    id="#modalCenter">Delete</button>
					<!-- <button id="xoa-sanpham" class="btn btn-info">Xóa</button> -->
					<!-- xoa san pham start -->
					<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog"
			            aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			            <div class="modal-dialog modal-dialog-centered" role="document">
			              <div class="modal-content">
			                <div class="modal-header">
			                  <h5 class="modal-title" id="exampleModalCenterTitle">Delete Product</h5>
			                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			                    <span aria-hidden="true">&times;</span>
			                  </button>
			                </div>
			                <div class="modal-body">
			                  Do you want delete product ?
			                </div>
			                <div class="modal-footer">
			                  <button type="button" class="btn btn-outline-primary" data-dismiss="modal">Close</button>
			                  <button id="xoa-sanpham" type="button" class="btn btn-primary">Delete</button>
			                </div>
			              </div>
			            </div>
			          </div>
			          <!-- xoa san pham end -->
				  </div>
                </div>
                <div class="table-responsive p-3">
                  <table class="table align-items-center table-flush" id="dataTable">
                    <thead class="thead-light">
                      <tr>
                        <th></th>
                        <th>Product Name</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Import Date</th>
                        <th></th>
                      </tr>
                    </thead>
                    <tfoot>
                      <tr>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                      </tr>
                    </tfoot>
                    <tbody>
                      <c:forEach var="value" items="${allSanPham }">
                       	<tr>
                       		<td><div class="checkbox">
										<label><input class="checkboxsanpham" type="checkbox"
											value="${value.getMasanpham()}"></label>
									</div></td>
	                        <td class="tensp" data-masp="${value.getMasanpham()}">${value.getTensanpham()}</td>
	                        <td>${ value.getGiatien() }</td>
	                        <td>${ value.getSoluong() }</td>
	                        <td>${ value.getNgaynhap() }</td>
	                        <td><a
									href="updatesanpham/${value.getMasanpham()}/${value.getTensanpham()}"
									class="btn btn-warning fa fa-edit"></a></td>
                       </tr>
                      </c:forEach>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
            <!-- DataTable with Hover -->
            <div class="col-lg-12">
              <div class="card mb-4">
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
<script src='<c:url value="/resources/js/sanpham.js" />'></script>
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