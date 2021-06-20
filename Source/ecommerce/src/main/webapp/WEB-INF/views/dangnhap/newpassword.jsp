<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html class="no-js" lang="zxx">

<!-- login-register31:27-->
<head>
<jsp:include page="../header/header.jsp" />
<meta charset="UTF-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>New Password</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
		.field-icon {
  float: right;
  margin-left: -25px;
  margin-top: -25px;
  position: relative;
  z-index: 2;
}
</style>
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
						<li class="active">New Password</li>
					</ul>
				</div>
			</div>
		</div>
		<!-- Li's Breadcrumb Area End Here -->
		<!-- Begin Login Content Area -->
		<div class="page-section mb-60">
			<div class="container">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-xs-12 col-lg-6 mb-30">
						<form action="form-newpassword" method="post" >
							<div class=" form-group">
								<label for="newpassword">Mật khẩu mới</label> 
								<input type="password" name="newpassword" id="newpassword"
									class="form-control" /><br />
								<label for="confirmpassword">Xác nhận mật khẩu</label> 
								<input type="password" name="confirmpassword" id="confirmpassword" class="form-control" /><br />
								<p class="col-4 message-updatepassword" style="color:red;margin-bottom: 10px;"></p>
								<span style="color: red;">${errors }</span>
								<p><button type = "submit" class="btn btn-primary">Update</button></p>
							
								
							</div>
						</form>
					</div>
				</div>
				
			</div>
		</div>
		<!-- Login Content Area End Here -->
		<!-- Begin Footer Area -->
		<jsp:include page="../footer/footer_html.jsp" />
		<!-- Footer Area End Here -->
	</div>
	<!-- Body Wrapper End Here -->

	<jsp:include page="../footer/footer.jsp" />
	<script src='<c:url value="/resources/js/user.js" />'></script>
</body>
<script>
$(".toggle-password").click(function() {
	
	  $(this).toggleClass("fa-eye fa-eye-slash");
	  var input = $($(this).attr("toggle"));
	  alert(input.attr("type"));
	  if (input.attr("type") == "password") {
	    input.attr("type", "text");
	  } else {
	    input.attr("type", "password");
	  }
	});
function myFunction(){
	var x = document.getElementById("password");
	if(x.type === "password"){
		x.type = "text";
	} else {
		x.type = "password";
	}
}
</script>
<!-- login-register31:27-->
</html>
