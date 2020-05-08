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
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css">
    	<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    	
    </head>
    <body>
        <header class="header grey-header">
            <nav class="navbar navbar-expand-lg navbar-light no-padding text-uppercase">
                <div class="container">
                    <a class="navbar-brand no-margin no-padding" href="./">
                        <img src="img/logo.png" alt="">
                        <img
					src="img/SanSkar.png" alt="">
                    </a>
                    <button class="navbar-toggler" type="button" aria-expanded="false" aria-label="Toggle navigation">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 30 30">
                            <path stroke="rgba(255, 255, 255, 1)" stroke-width="2" stroke-linecap="round"
                                stroke-miterlimit="10" d="M4 7h22M4 15h22M4 23h22" />
                        </svg>
                    </button>

                    <div class="navbar-collapse justify-content-end" id="navbarToggler">
                        <ul class="navbar-nav">
                          
                        <li class="nav-item"><a class="nav-link" href="index.jsp">Home</a>
						</li>
						
						<li class="nav-item"><a class="nav-link" href="NGOListController1">Donate</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="NGOListController">Search Ngos</a>
						</li>
						
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
							
						<li class="nav-item active"><a class="nav-link"	href="Login.jsp">Login</a></li>
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
                      
                         <li class="nav-item"><a class="nav-link" href="index.jsp">Home</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="">About Us</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="donate.jsp">Donate</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="SearchNgo.jsp">Search Ngos</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="EventListController1">Events</a></li>
						<li class="nav-item active"><a class="nav-link"	href="Login.jsp">Login</a></li>
						<li class="nav-item"><a class="nav-link" href="register.jsp">SignUp</a>
						</li>
                </ul>
            </div>
        </div>
        <section class="register-section text-center">
            <div class="container">
                <h2>Register As</h2>
                <p>Become part of a community of like-minded people.
                </p>
                <div class="row">
                    <div class="col-lg-6">
                        <div class="column-wrapper ngo-section flex justify-content-center align-items-center">
                            <a href="NGOform.jsp">
                                <button class="button button-primary">NGO SignUp</button>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="column-wrapper user-section flex justify-content-center align-items-center">
                            <a href="UserReg.jsp">
                                <button class="button button-primary">User SignUp</button>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    <br/>
        <br/>


         <footer class="ftco-footer ftco-bg-dark ftco-section" style="background-color: #224480;">
    <div class="container">
      <div class="row mb-5">
        <div class="col-md">
          <div class="ftco-footer-widget mb-5">
             
              <ul class="list-unstyled">
              <li><a href="index.html" style="color: white;">Home</a></li><br/>
              <li><a href="index.html" style="color: white;">About us</a></li><br/>
              <li><a href="index.html" style="color: white;">Contact us</a></li><br/>

            </ul>
              <ul class="ftco-footer-social list-unstyled float-md-left float-lft mt-3">
                <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li>
                <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li>
                <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>
            </ul>
     
          </div>

        </div>
        <div class="col-md">
          <div class="ftco-footer-widget mb-5 ml-md-4">
     
            <ul class="list-unstyled">
              <li><a href="donate.html" style="color: white;">Donate</a></li><br/>
              <li><a href="event.html" style="color: white;">Event</a></li><br/>
              <li><a href="SearchNgo.html" style="color: white;">Search by NGOs</a></li>
            </ul>
          </div>
        </div>


        <div class="col-md">
          <div class="ftco-footer-widget mb-5">
            <div class="column-wrapper">
       
             
              <div class="call d-flex">
                <svg viewBox="0 0 35 35">
                  <path
                    d="M25.302,0H9.698c-1.3,0-2.364,1.063-2.364,2.364v30.271C7.334,33.936,8.398,35,9.698,35h15.604   c1.3,0,2.364-1.062,2.364-2.364V2.364C27.666,1.063,26.602,0,25.302,0z M15.004,1.704h4.992c0.158,0,0.286,0.128,0.286,0.287   c0,0.158-0.128,0.286-0.286,0.286h-4.992c-0.158,0-0.286-0.128-0.286-0.286C14.718,1.832,14.846,1.704,15.004,1.704z M17.5,33.818   c-0.653,0-1.182-0.529-1.182-1.183s0.529-1.182,1.182-1.182s1.182,0.528,1.182,1.182S18.153,33.818,17.5,33.818z M26.021,30.625   H8.979V3.749h17.042V30.625z"
                    data-original="#000000" class="active-path" data-old_color="#000000" fill="#FFFFFF" />
                </svg>
                <p class="text-capitalize">
                  Telephone:
                  <a href="tel:+91 9727871119" style="color: white;">+91 9727871119</a>
                </p>
              </div>
              <div class="email d-flex">
                <svg viewBox="0 0 511.626 511.626">
                  <path
                    d="M49.106,178.729c6.472,4.567,25.981,18.131,58.528,40.685c32.548,22.554,57.482,39.92,74.803,52.099    c1.903,1.335,5.946,4.237,12.131,8.71c6.186,4.476,11.326,8.093,15.416,10.852c4.093,2.758,9.041,5.852,14.849,9.277    c5.806,3.422,11.279,5.996,16.418,7.7c5.14,1.718,9.898,2.569,14.275,2.569h0.287h0.288c4.377,0,9.137-0.852,14.277-2.569    c5.137-1.704,10.615-4.281,16.416-7.7c5.804-3.429,10.752-6.52,14.845-9.277c4.093-2.759,9.229-6.376,15.417-10.852    c6.184-4.477,10.232-7.375,12.135-8.71c17.508-12.179,62.051-43.11,133.615-92.79c13.894-9.703,25.502-21.411,34.827-35.116    c9.332-13.699,13.993-28.07,13.993-43.105c0-12.564-4.523-23.319-13.565-32.264c-9.041-8.947-19.749-13.418-32.117-13.418H45.679    c-14.655,0-25.933,4.948-33.832,14.844C3.949,79.562,0,91.934,0,106.779c0,11.991,5.236,24.985,15.703,38.974    C26.169,159.743,37.307,170.736,49.106,178.729z"
                    data-original="#000000" class="active-path" data-old_color="#000000" fill="#FFFFFF" />
                  <path
                    d="M483.072,209.275c-62.424,42.251-109.824,75.087-142.177,98.501c-10.849,7.991-19.65,14.229-26.409,18.699    c-6.759,4.473-15.748,9.041-26.98,13.702c-11.228,4.668-21.692,6.995-31.401,6.995h-0.291h-0.287    c-9.707,0-20.177-2.327-31.405-6.995c-11.228-4.661-20.223-9.229-26.98-13.702c-6.755-4.47-15.559-10.708-26.407-18.699    c-25.697-18.842-72.995-51.68-141.896-98.501C17.987,202.047,8.375,193.762,0,184.437v226.685c0,12.57,4.471,23.319,13.418,32.265    c8.945,8.949,19.701,13.422,32.264,13.422h420.266c12.56,0,23.315-4.473,32.261-13.422c8.949-8.949,13.418-19.694,13.418-32.265    V184.437C503.441,193.569,493.927,201.854,483.072,209.275z"
                    data-original="#000000" class="active-path" data-old_color="#000000" fill="#FFFFFF" />
                </svg>
                <p>
                  <a href="mailto:sanskarfoundation@gmail.com" target="_blank" style="color: white;">
                    sanskarfoundation@gmail.com
                  </a>
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12 text-center">

          <div style="color:rgba(255, 255, 255, 0.7);">
            
            Copyright &copy;<script>
              document.write(new Date().getFullYear());
            </script> All rights reserved | Sanskar Youth Foundation
          
          <div>
        </div>
      </div>

    </div>
  </footer>
    </body>
    <script src="scripts/vendor/jquery.min.js" charset="utf-8"></script>
    <script src="scripts/vendor/bootstrap.min.js" charset="utf-8"></script>
    <script src="scripts/vendor/owl.carousel.min.js" charset="utf-8"></script>
    <script src="scripts/index.js" charset="utf-8"></script>
</html>
