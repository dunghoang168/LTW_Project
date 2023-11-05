<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<!-- Site meta -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Trang chủ</title>
<!-- CSS -->
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600"
	rel="stylesheet" type="text/css">
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:include page="Menu.jsp"></jsp:include>
	<div class="container">

		<div class="row">

			<div class="col">
				<div id="carouselExampleIndicators" class="carousel slide"
					data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#carouselExampleIndicators" data-slide-to="0"
							class="active"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img class="d-block w-100"
								src="https://www.owndays.com/storage/top/sliders/vn_vi_large_258_version_1693b831-c9da-43f1-b5fb-09cd84b8e7a4.webp"
								alt="First slide">
						</div>
						<div class="carousel-item">
							<img class="d-block w-100"
								src="https://www.owndays.com/storage/top/sliders/vn_vi_large_246_version_3a514e3f-3f31-47a4-8d1c-ec83dad75647.webp"
								alt="Second slide">
						</div>
						<div class="carousel-item">
							<img class="d-block w-100"
								src="https://www.owndays.com/storage/top/sliders/vn_vi_large_209_version_d5b50bea-2565-43a7-830b-6c817a74289d.webp"
								alt="Third slide">
						</div>
					</div>
					<a class="carousel-control-prev" href="#carouselExampleIndicators"
						role="button" data-slide="prev"> <span
						class="carousel-control-prev-icon" aria-hidden="true"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
						role="button" data-slide="next"> <span
						class="carousel-control-next-icon" aria-hidden="true"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>
			</div>
			<div class="col-12 col-md-3">
				<div class="card">
					<div class="card-header bg-info text-white text-uppercase">
						<i class="fa fa-heart"></i> Top sản phẩm
					</div>
					<div class="card-body">
						<img class="img-fluid" src="${last.image}" />
						<h5 class="card-title">${last.name}</h5>
						<p class="card-text">${last.title}</p>
						<p class="bloc_left_price">${last.price}00vnđ</p>
					</div>

				</div>
			</div>
		</div>
	</div>


	<div class="container mt-3">
		<div class="row">
			<div class="col-sm">
				<div class="card">
					<div class="card-header bg-info text-white text-uppercase">
						<i class="fa fa-star"></i> Last products
					</div>
					<div class="card-body">
						<div class="row">


							<c:forEach items="${listLast}" var="o">
								<div class="col-12 col-md-6 col-lg-4">
									<div class="card">
										<img class="card-img-top" src="${o.image}"
											alt="Card image cap">
										<div class="card-body">
											<h4 class="card-title show_txt">
												<a href="detail?pid=${o.id}" title="View Product">${o.name}</a>
											</h4>
											<p class="card-text show_txt">${o.title}</p>
											<div class="row">
												<div class="col">
													<p class="btn btn-secondary btn-block">${o.price}00vnđ</p>
												</div>
												<div class="col">
													<a href="show?id=${o.id}" class="btn btn-info btn-block"><i
						class="fas fa-shopping-cart"></i>  Thêm
														vào giỏ hàng</a>
												</div>
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


	<div class="container mt-3 mb-4">
		<div class="row">
			<div class="col-sm">
				<div class="card">
					<div class="card-header bg-info text-white text-uppercase">
						<i class="fa fa-trophy"></i> Best products
					</div>
					<div class="card-body">
						<div class="row">

							<c:forEach items="${listBest}" var="o">
								<div class="col-12 col-md-6 col-lg-4">
									<div class="card">
										<img class="card-img-top" src="${o.image}"
											alt="Card image cap">
										<div class="card-body">
											<h4 class="card-title show_txt">
												<a href="detail?pid=${o.id}" title="View Product">${o.name}</a>
											</h4>
											<p class="card-text show_txt">${o.title}</p>
											<div class="row">
												<div class="col">
													<p class="btn btn-secondary btn-block">${o.price}00vnđ</p>
												</div>
												<div class="col">
													<a href="show?id=${o.id}" class="btn btn-info btn-block"><i
						class="fas fa-shopping-cart"></i>  Thêm
														vào giỏ hàng</a>
												</div>
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
	<script src="//code.jquery.com/jquery-3.2.1.slim.min.js"
		type="text/javascript"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		type="text/javascript"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		type="text/javascript"></script>

	<jsp:include page="Footer.jsp"></jsp:include>
</body>

</html>
