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
  <title>RuangAdmin - User</title>
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
            <h1 class="h3 mb-0 text-gray-800">User</h1>
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="./">Home</a></li>
              <li class="breadcrumb-item">Tables</li>
              <li class="breadcrumb-item active" aria-current="page">DataTables</li>
            </ol>
          </div>

          <!-- Row -->
          <div class="row">
            <!-- Datatables -->
            <div class="col-lg-12">
              <div class="card mb-4">
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary">Thông Tin User</h6>
                  <div style="float: right; margin-top: 10px;">
					<button id="xoa-user-admin" class="btn btn-info">Xóa</button>
				  </div>
                </div>
                <div class="table-responsive p-3">
                  <table class="table align-items-center table-flush" id="dataTable">
                    <thead class="thead-light">
                      <tr>
                        <th>
                        	<div class="checkbox">
									<label><input id="checkall" type="checkbox" value=""></label>
							</div>
						</th> 
                       	<th>Username</th>
						<th>Họ Tên</th>
						<th>Địa Chỉ</th>
						<th>Giới Tính</th>
						<th>CMND</th>
						<th>Email</th>
						<th>Role</th>
                        <th></th>
                      </tr>
                    </thead>
                    <tfoot>
                      <tr>
                        <th></th> 
                       	<th>Username</th>
						<th>Họ Tên</th>
						<th>Địa Chỉ</th>
						<th>Giới Tính</th>
						<th>CMND</th>
						<th>Email</th>
						<th>Role</th>
                        <th></th>
                      </tr>
                    </tfoot>
                    <tbody>
	                     <c:forEach var="value" items="${user }">
	                      		<tr>
	                    			<td>
	                    				<div class="checkbox">
											<label>
												<input class="checkboxuser" type="checkbox" value="${value.getUsername()}">
											</label>
										</div>
									</td>
		                       		<td>${ value.getUsername() }</td>
		                        	<td>${ value.getHoten() }</td>
		                        	<td>${ value.getDiachi() }</td>
		                        	<td>${ value.getGioitinh() }</td>
									<td>${ value.getCmnd() }</td>
		                       		<td>${ value.getEmail() }</td>
		                       		<c:choose>
										<c:when test="${value.getAuthorities() != null}">
											<c:forEach var="value1" items="${value.getAuthorities() }">
												<td class="role">${value1.getAuthority() }</td>
											</c:forEach>
										</c:when>
									 	<c:otherwise>
											<td class="role">vvv</td>
										</c:otherwise>
									</c:choose>
		                       		<td><a href="qluser/${value.getUsername()}" class="btn btn-warning fa fa-edit" ></a></td>
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
<script src='<c:url value="/resources/js/admin.js" />'></script>
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