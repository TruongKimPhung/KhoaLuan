<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link href='<c:url value="/resources/admin/img/logo/logo.png" />'
	rel="icon">
<title>RuangAdmin - Thêm Sản Phẩm</title>
<link type="text/css" rel="stylesheet"
	href='<c:url value="/resources/admin/vendor/fontawesome-free/css/all.min.css" />' />
<link type="text/css" rel="stylesheet"
	href='<c:url value="/resources/admin/vendor/bootstrap/css/bootstrap.min.css" />' />
<link type="text/css" rel="stylesheet"
	href='<c:url value="/resources/admin/css/ruang-admin.min.css" />' />
<link type="text/css" rel="stylesheet"
	href='<c:url value="/resources/admin/vendor/datatables/dataTables.bootstrap4.min.css" />' />
<style>
.error-show {
	display: inline-block;
	color: red;
}

.not-error {
	display: none
}
</style>
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
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">Thêm Sản Phẩm</h1>
					</div>

					<!-- Row -->
					<div class="row">
						<div class="col-lg-12">
							<div class="card mb-4">
								<div class="table-responsive p-3">
									<form id="form-sanpham" action="">
										<div class="form-group row">
											<div class="col-sm-6">
												<label for="danhmucsanpham">Danh mục</label> <select
													name="danhmucsanpham" class="form-control"
													id="danhmucsanpham">
													<c:forEach var="valuedanhmuc" items="${ danhmuc}">
														<option value="${valuedanhmuc.getMadanhmuc() }">${valuedanhmuc.getTendanhmuc() }</option>
													</c:forEach>
												</select>
											</div>
											<div class="col-sm-6">
												<label for="tensanpham">Tên sản phẩm<span> (*)</span></label>
												<input type="text" name="tensanpham" id="tensanpham"
													class="form-control" placeholder="tên sản phẩm"/>
											</div>
										</div>
										<div class="form-group row">
											<div class="col-sm-6">
												<label for="giatien">Giá tiền</label> <input type="text"
													name="giatien" id="giatien" class="form-control"
													placeholder="giá tiền" />
											</div>
											<div class="col-sm-6">
												<label for="dungluongpin">Dung lượng pin</label> <input
													type="text" name="dungluongpin" id="dungluongpin"
													class="form-control" placeholder="Dung lượng pin" />
											</div>
										</div>
										<div class="form-group row">
											<div class="col-sm-6">
												<label for="hinhanh">Hình ảnh</label> <input type="file"
													name="hinhanh" id="hinhanh" class="form-control" />
											</div>
											<div class="col-sm-3">
												<label for="soluong">Số lượng</label> <input type="text"
													name="soluong" id="soluong" class="form-control"
													placeholder="Số lượng" />
											</div>
											<div class="col-sm-3">
												<label for="manhinh">Màn hình</label> <input type="text"
													name="manhinh" id="manhinh" class="form-control"
													placeholder="Màn hình" />
											</div>
										</div>
										<div class="form-group row">
											<div class="col-sm-6">
												<label for="hedieuhanh">Hệ điều hành</label> <input
													type="text" name="hedieuhanh" id="hedieuhanh"
													class="form-control" placeholder="Hệ điều hành" />
											</div>
											<div class="col-sm-3">
												<label for="camerasau">Camera sau</label> <input type="text"
													name="camerasau" id="camerasau" class="form-control"
													placeholder="Camera sau" />
											</div>
											<div class="col-sm-3">
												<label for="cameratruoc">Camera trước</label> <input
													type="text" name="cameratruoc" id="cameratruoc"
													class="form-control" placeholder="Camera trước" />
											</div>
										</div>
										<div class="form-group row">
											<div class="col-sm-6">
												<label for="cpu">CPU</label> <input type="text" name="cpu"
													id="cpu" class="form-control" placeholder="CPU" />
											</div>
											<div class="col-sm-3">
												<label for="ram">RAM</label> <input type="text" name="ram"
													id="ram" class="form-control" placeholder="RAM" />
											</div>
											<div class="col-sm-3">
												<label for="rom">ROM</label> <input type="text" name="rom"
													id="rom" class="form-control" placeholder="ROM" />
											</div>
										</div>
										<div class="form-group row">
											<div class="col-sm-12">
												<label for="mota">Mô tả</label> <textarea type="text"
													name="mota" id="mota" class="form-control"
													placeholder="Mô tả" ></textarea>
											</div>
										</div>
									</form>
								</div>
								<p>
									<button onclick="btnThemSanPham()" class="btn confirm btn btn-primary">Thêm sản phẩm</button>
								</p>
								<!-- id="btnThemSanPham"  -->
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Scroll to top -->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script
		src='<c:url value="/resources/admin/vendor/jquery/jquery.min.js" />'></script>
	<script
		src='<c:url value="/resources/admin/vendor/bootstrap/js/bootstrap.bundle.min.js" />'></script>
	<script
		src='<c:url value="/resources/admin/vendor/jquery-easing/jquery.easing.min.js" />'></script>
	<script src='<c:url value="/resources/admin/js/ruang-admin.min.js" />'></script>
	<!-- Page level plugins -->
	<script
		src='<c:url value="/resources/admin/vendor/datatables/jquery.dataTables.min.js" />'></script>
	<script
		src='<c:url value="/resources/admin/vendor/datatables/dataTables.bootstrap4.min.js" />'></script>
	<script src='<c:url value="/resources/js/sanpham.js" />'></script>
	<!-- Page level custom scripts -->
	<script>
		$(document).ready(function() {
			$('#dataTable').DataTable(); // ID From dataTable 
			$('#dataTableHover').DataTable(); // ID From dataTable with Hover
		});
	</script>

</body>

</html>