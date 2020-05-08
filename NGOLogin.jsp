<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">
<title>NGO</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="styles/index.css">
<link rel="stylesheet" href="styles/vendor/bootstrap.min.css">
<link rel="stylesheet" href="styles/vendor/owl.carousel.min.css">
<link rel="stylesheet" href="styles/vendor/owl.theme.default.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.13/css/all.css">
	<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- <script>

	var request;
	
	function sendInfo() {
		
		var email = document.vinform.email.value;
		var url = "EmailFinder.jsp?email=" + email;

		if (window.XMLHttpRequest) {
			request = new XMLHttpRequest();
			
		} else if (window.ActiveXObject) {
			request = new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		
		try {
			request.onreadystatechange = getInfo;
			request.open("GET", url, true);
			request.send();
		} catch (e) {
			alert("Unable to connect to server");
		}
	}

	function getInfo() {
		if (request.readyState == 4) {
			var val = request.responseText;
			document.getElementById('mylocation').innerHTML = val;
		}
	}
</script>
 -->	
</head>
<body>
	<header class="header grey-header">
		<nav
			class="navbar navbar-expand-lg navbar-light no-padding text-uppercase">
			<div class="container">
				<a class="navbar-brand no-margin no-padding" href="./"> <img
					src="img/sanskarlogo.png" alt="">
				</a>
				<button class="navbar-toggler" type="button" aria-expanded="false"
					aria-label="Toggle navigation">
					<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 30 30">
                        <path stroke="rgba(255, 255, 255, 1)"
							stroke-width="2" stroke-linecap="round" stroke-miterlimit="10"
							d="M4 7h22M4 15h22M4 23h22" />
                    </svg>
				</button>

				<div class="navbar-collapse justify-content-end" id="navbarToggler">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" href="index.jsp">Home</a>
						</li>
						
						<li class="nav-item"><a class="nav-link" href="NGOListController1">Donate</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="NGOListController">Search
								Ngos</a></li>
						<%
						if (session.getAttribute("UserType") != null){
							boolean UserType = (Boolean)session.getAttribute("UserType");
							if(UserType){
						
						%>
						<li class="nav-item"><a class="nav-link"
							href="EventListController1">Events</a></li>
							<%}else{%>
							<li class="nav-item"><a class="nav-link"
							href="EventListController">Events</a></li>
							
							<% }} %>
							<%
						if (session.getAttribute("AdminType") != null){
							boolean AdminType = (Boolean)session.getAttribute("AdminType");
							if(AdminType){
						
						%>
						<li class="nav-item">
							<div class="dropdown">
								<button class="btn btn-default dropdown-toggle" type="button"
									id="menu1" data-toggle="dropdown">
									<!-- <span class="fa fa-user-circle"
										style="padding-right: 5px; font-size: 20px;"> --> </span><b>Action </b>

									<ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
									<li class="dropdown-item"><a tabindex="-1"
											href="UserListController">User</a></li>
											<li class="dropdown-item"><a tabindex="-1"
											href="NGOListControllerAdmin">NGO</a></li>
											</ul>
							</div>
						</li>

							<% }}%>
							
						<li class="nav-item active"><a class="nav-link"
							href="Login.jsp">Login</a></li>
						<li class="nav-item"><a class="nav-link" href="register.jsp">SignUp</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="">About Us</a>
						</li>
						<%
						if (session.getAttribute("isLogin") != null){
							boolean isLogin = (Boolean)session.getAttribute("isLogin");
							if(isLogin){
						
						%>
						
						
						<li class="nav-item">
							<div class="dropdown">
								<button class="btn btn-default dropdown-toggle" type="button"
									id="menu1" data-toggle="dropdown">
									<span class="fa fa-user-circle"
										style="padding-right: 5px; font-size: 20px;"> </span><b>Welcome</b>

									<ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
										<%
						if (session.getAttribute("UserType") != null){
							boolean UserType = (Boolean)session.getAttribute("UserType");
							if(UserType){
						
						%>
						<li class="nav-item"><a tabindex="-1"
											href="EditUserController">Edit Profile</a></li>
							<%}else{%>
							<li class="nav-item"><a tabindex="-1"
											href="EditNGO">Edit Profile</a></li>
							
							<% }} %>

										<li class="dropdown-item"><a tabindex="-1" href="#">Notification</a></li>

										<!-- <li class="dropdown-item"><a  tabindex="-1" href="#">Payments</a></li> -->
										<li class="dropdown-item"><a tabindex="-1"
											href="UserLogoutController"><span class="fa fa-power-off"
												style="padding-right: 5px;"></span>Logout</a></li>
									</ul>
							</div>
						</li>
						<%}} %>
						
					</ul>
				</div>
			</div>
		</nav>
	</header>
	<div class="side-nav overlay">
		<div class="navbar-collapse justify-content-end" id="navbarToggler">
			<div class="close-button">
				<svg viewBox="0 0 348.333 348.334">
                    <path
						d="M336.559,68.611L231.016,174.165l105.543,105.549c15.699,15.705,15.699,41.145,0,56.85   c-7.844,7.844-18.128,11.769-28.407,11.769c-10.296,0-20.581-3.919-28.419-11.769L174.167,231.003L68.609,336.563   c-7.843,7.844-18.128,11.769-28.416,11.769c-10.285,0-20.563-3.919-28.413-11.769c-15.699-15.698-15.699-41.139,0-56.85   l105.54-105.549L11.774,68.611c-15.699-15.699-15.699-41.145,0-56.844c15.696-15.687,41.127-15.687,56.829,0l105.563,105.554   L279.721,11.767c15.705-15.687,41.139-15.687,56.832,0C352.258,27.466,352.258,52.912,336.559,68.611z" />
                </svg>
			</div>
			<ul class="navbar-nav text-uppercase">
				<li class="nav-item"><a class="nav-link" href="index.jsp">Home</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="">About Us</a></li>
				<li class="nav-item"><a class="nav-link" href="donate.jsp">Donate</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="SearchNgo.jsp">Search
						Ngos</a></li>
				<li class="nav-item"><a class="nav-link"
					href="EventListController">Events</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="Login.jsp">Login</a></li>
				<li class="nav-item"><a class="nav-link" href="register.jsp">SignUp</a>
				</li>
			</ul>
		</div>
	</div>




	<div class="modal login-section">
		<div class="modal-login">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">
						<b style="color: #111142;">NGO Login</b>
					</h5>
				</div>
				<div class="modal-body">
					<form action="LoginController" method="post">
						<div class="form-group">
							<i class="fa fa-user"></i> <input type="text"
								class="form-control" name="txtEmailId" placeholder="Username" required="required">
						</div>
						<div class="form-group">
							<i class="fa fa-lock"></i> <input type="password"
								class="form-control" name="pwdPassword" placeholder="Password" required="required">
						</div>
						<div class="form-group">
							<input type="submit" class="btn btn-primary btn-block btn-lg" 
								value="Login">
						</div>
					</form>

				</div>
				<div class="modal-footer">
					<a href="forget-pwd.jsp">Forgot Password?</a>
				</div>
			</div>
		</div>
	</div>
</body>
<script src="scripts/vendor/jquery.min.js" charset="utf-8"></script>
<script src="scripts/vendor/bootstrap.min.js" charset="utf-8"></script>
<script src="scripts/vendor/owl.carousel.min.js" charset="utf-8"></script>
<script src="scripts/index.js" charset="utf-8"></script>
</html>
