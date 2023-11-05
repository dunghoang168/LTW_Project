
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css" type="text/css">
</head>

<body>
	<jsp:include page="Menu.jsp"></jsp:include>

	<div class="shopping-cart">
		<div class="px-4 px-lg-0">

			<div class="pb-5">
				<div class="container">
					<div class="row">
						<div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

							<!-- Shopping cart table -->
							<div class="table-responsive">
								<table class="table">
									<thead>
										<tr>
											<th scope="col" class="border-0 bg-light">
												<div class="p-2 px-3 text-uppercase">Sản Phẩm</div>
											</th>
											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Đơn Giá</div>
											</th>
											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Số Lượng</div>
											</th>
											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Xóa</div>
											</th>
										</tr>
									</thead>
									<tbody>

										<c:forEach items="${list}" var="o">
											<tr>
												<th scope="row">
													<div class="p-2">
														<img src="${o.image}" alt="" width="70"
															class="img-fluid rounded shadow-sm">
														<div class="ml-3 d-inline-block align-middle">
															<h5 class="mb-0">
																<a href="#" class="text-dark d-inline-block">${o.name}</a>
															</h5>
															<span class="text-muted font-weight-normal font-italic"></span>
														</div>
													</div>
												</th>
												<td class="align-middle"><strong>${o.price}00</strong></td>
												<td class="align-middle"><a
													href="sub?action=s&id=${o.id}">
														<button class="btnSub">-</button>
												</a> <strong>${o.amount}</strong> <a
													href="sub?action=add&id=${o.id}"><button class="btnAdd">+</button></a></td>

												<td class="align-middle"><a href="delCart?id=${o.id}"
													class="text-dark">
														<button type="button" class="btn btn-danger"><i class="fa fa-trash"></i></button>
												</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<!-- End -->
						</div>
					</div>

					<div class="row py-5 p-4 bg-white rounded shadow-sm">

						<div class="col-lg-6">
							<div class="col">
								<label
									class="bg-light rounded-pill px-5 py-3 text-uppercase font-weight-bold">Thông
									tin khách hàng</label>
							</div>
							<form>
								<!-- 2 column grid layout with text inputs for the first and last names -->

								<div class="row mb-4">

									<div class="col">
										<div class="form-outline">

											<label class="form-label" for="form6Example1">Họ </label> <input
												type="text" id="form6Example1" class="form-control" />
										</div>
									</div>
									<div class="col">
										<div class="form-outline">

											<label class="form-label" for="form6Example2">Tên </label> <input
												type="text" id="form6Example2" class="form-control" />
										</div>
									</div>
								</div>

								<!-- Text input -->
								<div class="form-outline mb-4">

									<label class="form-label" for="form6Example4">Địa chỉ</label> <input
										type="text" id="form6Example4" class="form-control" />
								</div>

								<!-- Email input -->
								<div class="form-outline mb-4">

									<label class="form-label" for="form6Example5">Email</label> <input
										type="email" id="form6Example5" class="form-control" />
								</div>

								<!-- Number input -->
								<div class="form-outline mb-4">

									<label class="form-label" for="form6Example6">Số điện
										thoại</label> <input type="number" id="form6Example6"
										class="form-control" />
								</div>
								<div class="col-sm-12  col-md-6">
									<button class="btn btn-block btn-light" ><a href="home">Tiếp tục mua sắm</a>
										</button>
								</div>
							</form>

						</div>

						<div class="col-lg-6">

							<div
								class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Thành
								tiền</div>
							<div class="p-4">

								<ul class="list-unstyled mb-4">
									<li class="d-flex justify-content-between py-3 border-bottom"><strong
										class="text-muted">Tổng tiền hàng</strong> <strong>${total}00</strong></li>

									<li class="d-flex justify-content-between py-3 border-bottom"><strong
										class="text-muted">Phí vận chuyển</strong><strong>Free
											ship</strong></li>
									<li class="d-flex justify-content-between py-3 border-bottom"><strong
										class="text-muted">Phí VAT</strong><strong>
											${total*0.1}00</strong></li>

									<li class="d-flex justify-content-between py-3 border-bottom">
										<div class="payment-info">
											<div
												class="d-flex justify-content-between align-items-center">
												<strong class="text-muted">Phương thức thanh toán</strong><img
													class="rounded" src="" width="30">
											</div>
											<span class="type d-block mt-3 mb-1" for="form6Example4">Loại
												thẻ</span><label class="radio"> <input type="radio"
												name="card" value="payment" checked> <span><img
													width="30"
													src="https://img.icons8.com/color/48/000000/mastercard.png" /></span>
											</label> <label class="radio"> <input type="radio"
												name="card" value="payment"> <span><img
													width="30"
													src="https://img.icons8.com/officel/48/000000/visa.png" /></span>
											</label> <label class="radio"> <input type="radio"
												name="card" value="payment"> <span><img
													width="30"
													src="https://img.icons8.com/ultraviolet/48/000000/amex.png" /></span>
											</label> <label class="radio"> <input type="radio"
												name="card" value="payment"> <span><img
													width="30"
													src="https://img.icons8.com/officel/48/000000/paypal.png" /></span>
											</label>
											<div>
												<label class="credit-card-label">Tên thẻ</label><input
													type="text" class="form-control credit-inputs"
													placeholder="tên">
											</div>
											<div>
												<label class="credit-card-label">Số thẻ</label><input
													type="text" class="form-control credit-inputs"
													placeholder="0000 0000 0000 0000">
											</div>
											<div class="row">
												<div class="col-md-6">
													<label class="credit-card-label">Ngày</label><input
														type="text" class="form-control credit-inputs"
														placeholder="12/24">
												</div>
												<div class="col-md-6">
													<label class="credit-card-label">CVV</label><input
														type="text" class="form-control credit-inputs"
														placeholder="342">
												</div>
											</div>


										</div>
									</li>

									<li class="d-flex justify-content-between py-3 border-bottom"><strong
										class="text-muted">Tổng thanh toán</strong>
										<h5 class="font-weight-bold">${totalP}00 vnđ</h5></li>
								</ul>

								<a href="buy" class="btn btn-dark rounded-pill py-2 btn-block">Mua
									hàng</a>
							</div>

						</div>
					</div>

				</div>
			</div>
		</div>
	</div>

</body>

</html>

