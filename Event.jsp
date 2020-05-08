<%@page import="com.NGO.Bean.NGOBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.Event.bean.EventBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
        <link rel="stylesheet" href="styles/bootstrap.css">
        <link rel="stylesheet" href="styles/main.css">
        <link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <header class="header grey-header">
            <nav class="navbar navbar-expand-lg navbar-light no-padding text-uppercase">
                <div class="container">
                    <a class="navbar-brand no-margin no-padding" href="./">
                        <img src="img/sanskarlogo.png" alt=""><img
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
                <ul class="navbar-nav">
                            <li class="nav-item"><a class="nav-link" href="index.jsp">Home</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="">About Us</a>
						</li>
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
        
        <section class="donate-section">
            <div class="container">
                <div id="mySidenav" class="sidenav">

                    <form action="EventInsertController">
                       
                       <div class="form-group">
                           <label for="EventName">Event Name:</label>
                           <input type="text" class="form-control" id="EventName" placeholder="Event Name"  name="EventName">${EventName}
                       </div>
                        <div class="form-group">
                           <label for="EventAddress">Address:</label>
                           <textarea cols="20" rows="5" class="form-control" id="EventAddress" name="EventAddress"></textarea>
                      ${EventAddress}
                       </div>
                        <div class="form-group">
                           <label for="EventDate">Event Name:</label>
                           <input type="date" class="form-control" id="EventDate"   name="Date">
                       ${Date}
                       </div>

                      
                        <button type="submit" class="btn btn-primary">Register</button>
                        <button type="reset" class="btn btn-success">Reset</button>

                      </form>
                </div>

               
            
                           
    <!--================ Start Upcoming Event Area =================-->
    <section class="upcoming_event_area section-gap-top">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-6">
                    <div class="section-title">
                        <h2><span>Upcoming</span> Event</h2>
                    </div>
                </div>
            </div>

            <div class="row">
            <%NGOBean ngoBean = (NGOBean)session.getAttribute("NGOBean");
		
			
			if(ngoBean!=null){
			
			
		
		%>
            <%
			List<EventBean> listOfEvent = (ArrayList)request.getAttribute("listOfEvent");
			for (int i = 0; i < listOfEvent.size(); i++) {

				EventBean eventBean = listOfEvent.get(i);
		%>
                <div class="col-lg-6">
                    <div class="single_upcoming_event">
                        <div class="row align-items-center">
                            <div class="col-lg-6 col-md-6">
                                <figure>
                                    <img class="img-fluid w-100" src="img/e1.jpg" alt="">
                                    <div class="date">
                                       <%=eventBean.getEventDate()%>
                                    </div>
                                </figure>
                            </div>
                            <div class="col-lg-6 col-md-6">
                                <div class="content_wrapper">
                                    <h3 class="title">
                                        <a href="event-details.html"><%=eventBean.getEventname()%></a>
                                    </h3>
                                    <p>
                                        <%=eventBean.getEventaddress() %>
                                    </p>
                                    <div class="d-flex count_time justify-content-lg-start justify-content-center" id="clockdiv1">
                                        <div class="single_time">
                                            <h4 class="days">552</h4>
                                            <p>Days</p>
                                        </div>
                                        <div class="single_time">
                                            <h4 class="hours">08</h4>
                                            <p>Hours</p>
                                        </div>
                                        <div class="single_time">
                                            <h4 class="minutes">45</h4>
                                            <p>Minutes</p>
                                        </div>
                                    </div>
                                    <a href="#" class="primary-btn2">Learn More</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                              
<%
			}//for
		}//if 
			else{
				response.sendRedirect("Login.jsp");
			}
		
		%>


               </div>
        </div>
        </div>
    </section>
    <!--================ End Upcoming Event Area =================-->

    

    </body>
    <script src="scripts/vendor/jquery.min.js" charset="utf-8"></script>
    <script src="scripts/vendor/bootstrap.min.js" charset="utf-8"></script>
    <script src="scripts/vendor/owl.carousel.min.js" charset="utf-8"></script>
    <script src="scripts/index.js" charset="utf-8"></script>
</html>

<form action="EventInsertController">
		<table>
			<tr>
				<td>EventName</td>
				<td><input type="text" name="EventName">${EventName}
				
				</td>
			</tr>

			<tr>
				<td>EventAddress</td>
				<td><input type="text" name="EventAddress">
				${EventAddress}
				</td>
			</tr>
			<tr>
				<td>Date</td>
				<td><input type="date" name="Date">
				${Date}
				</td>

			</tr>
			<tr>
				<td><input type="submit" name="SUBMIT">
			</tr>
		</table>
	</form>

</body>
</html>