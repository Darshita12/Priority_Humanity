<%@page import="com.NGO.Bean.NGOBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.NGO.Dao.NGODao"%>

<%@page import="com.NGO.Bean.NGOTypeBean" %>
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
	
</head>
<body>
	<header class="header grey-header">
		<nav
			class="navbar navbar-expand-lg navbar-light no-padding text-uppercase">
			<div class="container">
				<a class="navbar-brand no-margin no-padding" href="./"> <img
					src="img/SanSkar.png" alt="">
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
						<li class="nav-item active"><a class="nav-link"
							href="index.jsp">Home</a></li>
						
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
	<li class="nav-item"><a class="nav-link" href="Login.jsp">Login</a>
						</li>
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
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link"
					href="index.jsp">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="">About Us</a></li>
				<li class="nav-item"><a class="nav-link" href="donate.jsp">Donate</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="SearchNgo.jsp">Search
						Ngos</a></li>
				<li class="nav-item"><a class="nav-link"
					href="EventListController1">Events</a></li>
				<li class="nav-item"><a class="nav-link" href="Login.jsp">Login</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="register.jsp">SignUp</a>
				</li>
			</ul>
		</div>
	</div>

	<section class="donate-section">
		<div class="container">
			<div id="mySidenav" class="sidenav">

				<form action="NGOListByCauseDonate">
					<div class="form-group">
						<label for="causes">Select Cause</label>  <select
										class="form-control" name="txtNGOCategory" id="causes">
								
									
									<%
									
									List<NGOTypeBean> listOfNGOType =new ArrayList<NGOTypeBean>();
	NGOTypeBean ngoTypeBean=new NGOTypeBean();
	NGODao ngoDao=new NGODao();
	listOfNGOType=ngoDao.NGOtypelist();
	for(int i=0;i<listOfNGOType.size();i++)
	{
		ngoTypeBean=listOfNGOType.get(i);
%>
<option value="<%=ngoTypeBean.getId1()%>"><%=ngoTypeBean.getType() %></option>
<%} %>
									</select>
	
					</div>
					<div class="form-group">
						<label for="location">Select Your Location</label> <select
							class="form-control" id="location">
							<option>--Any--</option>
							<option>Ahmedabad</option>
							<option>vadodara</option>
							<option>Rajkot</option>
							<option>jamnagar</option>
							<option>Junagadh</option>
							<option>surat</option>
							<option>Anand</option>
							<option>Navsari</option>
							<option>Morbi</option>
							<option>Gandhinagar</option>
							<option>Mehsana</option>
							<option>Porbandar</option>
							<option>Banaskatha</option>
							<option>Bharuch</option>
							<option>Bhuj</option>
							<option>Kutch</option>
							<option>Naroda</option>
							<option>Sanand</option>

						</select>
					</div>

					<!-- <div class="form-group">
						<label for="searchNgo">Search by NGO</label> <input type="text"
							class="form-control" id="searchNgo" placeholder="Search">
					</div> -->
					<button type="submit" class="btn btn-primary">Search</button>
					<button type="reset" class="btn btn-success">Reset</button>

				</form>
			</div>

			<section class="ngo-list">
				<div class="container">

					<div class="row">
						<div class="col-md-6">
							<div class="column-wrapper">
								<div class="card">
									<img src="img/Blind_NGO.jpg" class="card-img-top" alt=" " />
									<div class="card-body">
										<h5 class="card-title">
											<a href="http://www.bwcdahod.com/"> <b>Blind Welfare
													Council Dahod</b>
											</a>
										</h5>
										<p class="card-text">Help pay teachers' salaries for an
											NGO working with special children</p>

										<div class="d-flex justify-content-between">
											<a href="Details.jsp" class="button-primary">Read More</a> <a
												href="#" class="button-primary">Donate</a>
										</div>
									</div>
								</div>
							</div>
						</div>
						<%if (session.getAttribute("Category1") != null){
					boolean Category = (Boolean)session.getAttribute("Category1");
					System.out.println(Category);

					if(Category){ %>
				
					<%
		List<NGOBean> listOfNGO =(ArrayList)session.getAttribute("listOfNGO");
					System.out.println(listOfNGO);

		System.out.println("sdad");
		System.out.println("bp");
			 if (listOfNGO.size() >= 0 ) { 
			for (int i = 0; i < listOfNGO.size(); i++) {
				NGOBean ngoBean = listOfNGO.get(i);
				%>
							<div class="col-md-6">
							<div class="column-wrapper">
								<div class="card">
									<img src="img/Education.jpeg" class="card-img-top" alt=" " />
									<div class="card-body">
										<h5 class="card-title">
											<a href="https://silf.in/"> <b><%=ngoBean.getName()%></b>
											</a>
										</h5>
										<p class="card-text"><%=ngoBean.getAddress()%></p>
										<div class="d-flex justify-content-between">
											<a href="Details.jsp" class="button-primary">Read More</a> <a
												href="https://silf.in/donate-2/" class="button-primary">Donate</a>
										</div>
									</div>
								</div>
							</div>
						</div>
						<%
				}
				}}}else{
		List<NGOBean> listOfNGO =(ArrayList)request.getAttribute("NGOList");
		System.out.println("sdad");
			if (listOfNGO.size() >= 0 ) {
				for (int i = 0; i < listOfNGO.size(); i++) {
					NGOBean ngoBean = listOfNGO.get(i);
					%>
					
						<div class="col-md-6">
							<div class="column-wrapper">
								<div class="card">
									<img src="img/Education.jpeg" class="card-img-top" alt=" " />
									<div class="card-body">
										<h5 class="card-title">
											<a href="https://silf.in/"> <b><%=ngoBean.getName()%></b>
											</a>
										</h5>
										<p class="card-text"><%=ngoBean.getAddress()%></p>
										<div class="d-flex justify-content-between">
											<a href="Details.jsp" class="button-primary">Read More</a> <a
												href="https://silf.in/donate-2/" class="button-primary">Donate</a>
										</div>
									</div>
								</div>
							</div>
						</div>
						<%
				
				}}} /*  */
			%>
			
						


					</div>
				</div>
			</section>

		</div>
	</section>


</body>
<script src="scripts/vendor/jquery.min.js" charset="utf-8"></script>
<script src="scripts/vendor/bootstrap.min.js" charset="utf-8"></script>
<script src="scripts/vendor/owl.carousel.min.js" charset="utf-8"></script>
<script src="scripts/index.js" charset="utf-8"></script>
</html>
