<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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

<title>SB Admin 2 - Tables</title>

<!-- Custom fonts for this template -->
<link href="assets/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="assets/css/sb-admin-2.min.css" rel="stylesheet">

<!-- Custom styles for this page -->
<link href="assets/vendor/datatables/dataTables.bootstrap4.min.css"
	rel="stylesheet">

</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<div class="container-fluid">
					<!-- DataTales Example -->

					<div class="row">
						<div class="col">
							<div class="card shadow mb-4">
								<div class="card-header py-3">
									<h6 class="m-0 font-weight-bold text-primary">Add New
										Contact</h6>
								</div>
								<div class="card-body">
									<div class="form-group">
										<label for="exampleFormControlSelect1">Address
											Book&nbsp;<span class="required">*</span>
										</label> <select class="form-control dropdownValidate"
											id="addressBookName">
											<option value="Book1">Book 1</option>
											<option value="Book2">Book 2</option>
										</select>
									</div>
									<div class="form-group">
										<label for="inputFactoryName">Name&nbsp;<span
											class="required">*</span></label> <input type="text"
											class="form-control emptyValidate" id="name"
											placeholder="Name">
									</div>
									<div class="form-group">
										<label for="inputFactoryName">Number&nbsp;<span
											class="required">*</span></label> <input type="text"
											class="form-control emptyValidate" id="number"
											placeholder="Number">
									</div>
									<div class="form-group">
										<button type="button" class="btn btn-primary"
											id="deletebtnone" onclick="save();">Submit</button>
									</div>
								</div>
							</div>
						</div>
							<div class="col">
								<div class="card shadow mb-4">
									<div class="card-header py-3">
										<h6 class="m-0 font-weight-bold text-primary">Unique to each address book</h6>
									</div>
									<div class="card-body">
										<div class="table-responsive">
											<table class="table table-bordered" id="" width="100%"
												cellspacing="0">
												<thead>
													<tr>
														<th>Name</th>
														<th>Position</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="contact" items="${ uniqueContacts }">
														<tr>
															<td><c:out value="${ contact.name }" /></td>
															<td><c:out value="${ contact.number }" /></td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- Begin Page Content -->
					<div class="container-fluid">


						<!-- DataTales Example -->
						<div class="row">
							<div class="col">
								<div class="card shadow mb-4">
									<div class="card-header py-3">
										<h6 class="m-0 font-weight-bold text-primary">Address
											Book One</h6>
									</div>
									<div class="card-body">
										<div class="table-responsive">
											<table class="table table-bordered" id="" width="100%"
												cellspacing="0">
												<thead>
													<tr>
														<th>Name</th>
														<th>Position</th>
														<th></th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="contact" items="${ bookOneAllContacts }">
														<tr>
															<td><c:out value="${ contact.name }" /></td>
															<td><c:out value="${ contact.number }" /></td>
															<td><button type="button" class="btn btn-danger"
																	id="submitbtn"
																	onclick="deleteContact('${contact.name}','Book1')">Delete</button></td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
							<div class="col">
								<div class="card shadow mb-4">
									<div class="card-header py-3">
										<h6 class="m-0 font-weight-bold text-primary">Address
											Book Two</h6>
									</div>
									<div class="card-body">
										<div class="table-responsive">
											<table class="table table-bordered" id="" width="100%"
												cellspacing="0">
												<thead>
													<tr>
														<th>Name</th>
														<th>Position</th>
														<th></th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="contact" items="${ bookTwoAllContacts }">
														<tr>
															<td><c:out value="${ contact.name }" /></td>
															<td><c:out value="${ contact.number }" /></td>
															<td><button type="button" class="btn btn-danger"
																	id="deletebtntwo"
																	onclick="deleteContact('${contact.name}','Book2')">Delete</button>
															</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>

					</div>
					<!-- /.container-fluid -->

				</div>
				<!-- End of Main Content -->

				<!-- Footer -->
				<footer class="sticky-footer bg-white">
					<div class="container my-auto">
						<div class="copyright text-center my-auto">
							<span>Copyright &copy; Your Website 2019</span>
						</div>
					</div>
				</footer>
				<!-- End of Footer -->

			</div>
			<!-- End of Content Wrapper -->

		</div>
		<!-- End of Page Wrapper -->

		<!-- Scroll to Top Button-->
		<a class="scroll-to-top rounded" href="#page-top"> <i
			class="fas fa-angle-up"></i>
		</a>


		<!-- Bootstrap core JavaScript-->
		<script src="assets/vendor/jquery/jquery.min.js"></script>
		<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

		<!-- Core plugin JavaScript-->
		<script src="assets/vendor/jquery-easing/jquery.easing.min.js"></script>

		<!-- Custom scripts for all pages-->
		<script src="assets/js/sb-admin-2.min.js"></script>

		<!-- Page level plugins -->
		<script src="assets/vendor/datatables/jquery.dataTables.min.js"></script>
		<script src="assets/vendor/datatables/dataTables.bootstrap4.min.js"></script>

		<!-- Page level custom scripts -->
		<script src="assets/js/demo/datatables-demo.js"></script>

		<script type="text/javascript">
			function save() {

				var name = $("#name").val();
				var number = $("#number").val();
				var addressBookName = $("#addressBookName").val();

				var obj = new Object();

				obj.name = name;
				obj.number = number;
				obj.addressBookName = addressBookName;

				if (isNaN(number)) {
					alert(number + " is not a number");
					return false;
				}

				$
						.ajax({
							type : "POST",
							url : "http://localhost:8080/api/addressbook/createnewcontact",
							data : JSON.stringify(obj),
							contentType : "application/json; charset=utf-8",
							dataType : "json",
							async : !1,
							success : function(data) {
								// 					alert(JSON.stringify(data));
								location.reload(true);
							},
							error : function(data) {
								alert(data);
							}
						});
			}

			function deleteContact(name, addressBook) {
				var obj = new Object();

				obj.name = name;
				obj.addressBookName = addressBook;

				$
						.ajax({
							type : "POST",
							url : "http://localhost:8080/api/addressbook/deletecontact",
							data : JSON.stringify(obj),
							contentType : "application/json; charset=utf-8",
							dataType : "json",
							async : !1,
							success : function(data) {
								// 					alert(JSON.stringify(data));
								location.reload(true);
							},
							error : function(data) {
								alert(data);
							}
						});
			}
		</script>
</body>

</html>
