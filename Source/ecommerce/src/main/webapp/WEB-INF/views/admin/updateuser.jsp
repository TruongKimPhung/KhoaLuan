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
  <link href='<c:url value="/resources/admin/img/logo/logo.png" />' rel="icon">
  <title>RuangAdmin - Update User</title>
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
            <h1 class="h3 mb-0 text-gray-800">Update User</h1>
          </div>

          <!-- Row -->
          <div class="row">
            <!-- Datatables -->
            <div class="col-lg-2"></div>
            <div class="col-lg-8">
              <div class="card mb-4">
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">

                </div>
                <div class="table-responsive p-3">
                 	<form id="form-admin-updateuser" action="">
					<div class=" form-group">
						 
						<strong><span id="username">${ user.getUsername() }</span></strong><br /> <br /> 
						<label for="hoten">Họ Tên</label> 
						<input type="text" name="hoten" id="hoten"
							class="form-control" value="${user.getHoten() }" /><br /> 
						<label for="diachi">Địa Chỉ</label> 
						<input type="text" name="diachi"
							id="diachi" class="form-control" value="${user.getDiachi() }" /><br />
						<label for="gioitinh">Giới Tính</label> 
						<input type="text" name="gioitinh" id="gioitinh" class="form-control"
							value="${user.getGioitinh() }" /><br /> 
						<label for="cmnd">CMND</label>
						<input type="text" name="cmnd" id="cmnd" class="form-control"
							value="${user.getCmnd() }" /><br /> 
						<label for="email">Email</label>
						<input type="text" name="email" id="email" class="form-control"
							value="${user.getEmail() }" /><br /> 
						 <select
							name="role" class="form-control" id="role">
							<c:choose>
								<c:when test="${role != null}">
									<option selected value='${role }'>${role }</option>
     							</c:when>
								<c:otherwise>
									<option selected value=''>Chọn role</option>
     							</c:otherwise>
							</c:choose>
							  <option value="ROLE_ADMIN">ROLE_ADMIN</option>
							  <option value="ROLE_MEMBER">ROLE_MEMBER</option>
						</select><br>
					</div>
					<p><button id="btnAdminUpdateUser" class="btn btn-primary">Update</button></p>
					
				</form>
                </div>
              </div>
            </div>
            <div class="col-lg-2"></div>
          </div>
          <!--Row-->
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
  <!-- Page level plugins -->
<script src='<c:url value="/resources/admin/vendor/datatables/jquery.dataTables.min.js" />'></script>
<script src='<c:url value="/resources/admin/vendor/datatables/dataTables.bootstrap4.min.js" />'></script>
<script src='<c:url value="/resources/js/admin.js" />'></script>
  <!-- Page level custom scripts -->
  <script>
    $(document).ready(function () {
      $('#dataTable').DataTable(); // ID From dataTable 
      $('#dataTableHover').DataTable(); // ID From dataTable with Hover
    });
  </script>

</body>

</html>