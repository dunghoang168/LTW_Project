<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- https://mvnrepository.com/artifact/javax.servlet.jsp.jstl/javax.servlet.jsp.jstl-api -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mắt kính thời trang</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
	integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm"
	crossorigin="anonymous" />
<link href="css/style.css" rel="stylesheet" type="text/css">
<style>
.jumbotronn {
	background-image:
		url('https://img.freepik.com/premium-photo/gradient-banner-background-background-header-gradint-effects_873925-72248.jpg?size=338&ext=jpg&ga=GA1.1.386372595.1698192000&semt=ais');		
		margin-bottom: 1.7rem;
		text-align: center;		
		width: 100%;
		height: 10rem;
}
.jumbotronn-text {
	text-align: center;
	padding: 25px;
	
}
</style>

</head>
<body>
	<!--begin of menu-->
	<nav class="navbar navbar-expand-md navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="indexControl"><font
				face="Comic sans MS" size="5"><i
					class="fas fa-glasses fa-spin"></i> Glass Strore</font></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarsExampleDefault"
				aria-controls="navbarsExampleDefault" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse justify-content-end"
				id="navbarsExampleDefault">
				<ul class="navbar-nav m-auto">

					<li class="nav-item"><a class="nav-link" href="indexControl"><i
							class="fas fa-home"></i> Home</a></li>


					<li class="nav-item"><a class="nav-link" href="home">Sản
							phẩm</a></li>

					<c:if test="${sessionScope.accSession.isSell == 1}">
						<li class="nav-item"><a class="nav-link" href="manager">Quản
								lí sản phẩm</a></li>
					</c:if>
					<c:if test="${sessionScope.accSession.isAdmin == 1}">
						<li class="nav-item"><a class="nav-link" href="#">Quản lí
								tài khoản</a></li>
					</c:if>
					<c:if test="${sessionScope.accSession != null}">
						<li class="nav-item"><a class="nav-link" href="#">Xin
								chào ${sessionScope.accSession.user}</a></li>
						<li class="nav-item"><a class="nav-link" href="logout">Đăng
								xuất <i class="fas fa-user" style="color: #ffffff;"></i>
						</a></li>
					</c:if>
					<c:if test="${sessionScope.accSession == null}">
						<li class="nav-item"><a class="nav-link" href="Login.jsp">Đăng
								nhập <i class="fas fa-user" style="color: #ffffff;"></i>
						</a></li>
					</c:if>
				</ul>
				<form action="search" method="post" class="form-inline my-2 my-lg-0">
					<div class="input-group input-group-sm">
						<input value="${txtS}" name="txt" type="text" class="form-control"
							aria-label="Small" aria-describedby="inputGroup-sizing-sm"
							placeholder="Tìm kiếm...">
						<div class="input-group-append">
							<button type="submit" class="btn btn-secondary btn-number">
								<i class="fa fa-search"></i>
							</button>
						</div>
					</div>
					<a class="btn btn-info btn-sm ml-3" href="Cart.jsp"> <i
						class="fas fa-shopping-cart"></i> <span
						class="badge rounded-pill bg-danger">${quanlity} </span>
					</a>
				</form>
			</div>

		</div>
	</nav>
	<section class="jumbotronn">
		<div class="jumbotronn-text">
			<h1 class="jumbotronn-heading">Siêu thị mắt kính chất lượng cao</h1>
			<p class="lead text-muted mb-0">Uy tín tạo nên thương hiệu với
				hơn 10 năm cung cấp các sản phẩm</p>
		</div>
	</section>
	<!--end of menu-->
	<div class="container">
		<div class="row">
			<div class="col">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="indexControl"> <i
								class="fas fa-home"></i> Trang chủ
						</a></li>
						<li class="breadcrumb-item"><a href="home">Danh mục sản
								phẩm</a></li>
						<!-- <li class="breadcrumb-item active" aria-current="#">Sub-category</li> -->
					</ol>
				</nav>
			</div>
		</div>
	</div>
</body>
</html>