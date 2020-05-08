<%@page import="java.util.ArrayList"%>
<%@page import="com.User.bean.UserBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">

<head>
<!-- Mobile Specific Meta -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Favicon-->
<link rel="shortcut icon" href="img/fav.png">

<title>NGO</title>

<link
	href="https://fonts.googleapis.com/css?family=Lora:400,700|Roboto:300,400"
	rel="stylesheet">

<!--
            CSS
            ============================================= -->


<link rel="stylesheet" href="styles/index.css">
<link rel="stylesheet" href="styles/vendor/bootstrap.min.css">
<link rel="stylesheet" href="styles/vendor/owl.carousel.min.css">
<link rel="stylesheet" href="styles/vendor/owl.theme.default.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.13/css/all.css">
<link rel="stylesheet" href="styles/bootstrap.css">
<link rel="stylesheet" href="styles/main.css">
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
						<li class="nav-item"><a class="nav-link" href="index.jsp">Home</a>
						</li>

						<li class="nav-item"><a class="nav-link"
							href="NGOListController1">Donate</a></li>
						<li class="nav-item"><a class="nav-link"
							href="NGOListController">Search Ngos</a></li>
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
										<li class="nav-item"><a tabindex="-1" href="EditNGO">Edit
												Profile</a></li>

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
	<section class="mt-25 ml-20 search-section">
		<div class="container">
			<div class="d-flex">
				<div class="ngo-serach-form w-100">
					<div class="panel panel-success">
						<div class="panel-heading">
							<h4 class="panel-title" style="color: white;">Data Search</h4>

						</div>
						<div class="panel-body">
							<%
							UserBean userBean=(UserBean)session.getAttribute("UserBean1");
						 if(userBean!=null)
						{ %>
							<table class="table table-striped">
								<tr>
									<th><b>USER_ID</b></th>
									<%-- <%out.println("\t"); %> --%>
									<th><b>FIRST NAME</b></th>
									<th><b>LAST NAME</b></th>
									<th><b>EMAIL</b></th>
									<th><b>PASSWORD</b></th>
									<th><b>State</b></th>
									<th><b>City</b></th>
									<th><b>ACTIONS</b></th>
									<!-- <th><b>Logout</b></th> -->

								</tr>
								<%
	List<UserBean> listOfUser=(ArrayList)request.getAttribute("ListOfUser");
	for(int i=0;i<listOfUser.size();i++)
	{
%>
<tr>
							<%
							 userBean=listOfUser.get(i);%>
				
							<td><%=userBean.getUserId()%></td>
				<td><%=userBean.getFirstName()%></td>
				<td><%=userBean.getLastName() %></td>
				<td><%=userBean.getEmail() %></td>
				<td><%=userBean.getContact() %></td>
				<td><%=userBean.getState() %></td>
				<td><%=userBean.getCity() %></td>
				<td> 
				<button class="delete"><i class="glyphicon glyphicon-trash icon-white"></i><a href="DeleteUserController?UserId=<%=userBean.getUserId() %>">DELETE</a></button>
					</td>
					<!-- <td><a href="LogoutController">LOGOUT</a></td> -->

						</tr>
						<% } }%>
						</table>

				</div>
			</div>
		</div>
	</section>
						