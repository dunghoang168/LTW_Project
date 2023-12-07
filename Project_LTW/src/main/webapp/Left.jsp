
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
<link href="css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<%-- Left Page --%>
	<div class="col-sm-3">
		<div class="card bg-light mb-3">
			<div class="card-header bg-info text-white text-uppercase">
				<i class="fa fa-list"></i> Tất cả sản phẩm
			</div>
			<ul class="list-group category_block">
				<c:forEach items="${listCC}" var="o">
					<li class="list-group-item text-white ${tag == o.cid ? "active":""}"><a
						href="category?cid=${o.cid}">${o.cname}</a></li>
				</c:forEach>

			</ul>
		</div>
		<div class="card bg-light mb-3">
			<div class="card-header bg-info text-white text-uppercase">Sản phẩm mới ra mắt
				</div>
			<div class="card-body">
				<img class="img-fluid" src="${last.image}" />
				<h5 class="card-title">${last.name}</h5>
				<p class="card-text">${last.title}</p>
				<p class="bloc_left_price">${last.price}00 vnđ</p>
			</div>
		</div>
	</div>

</body>
</html>