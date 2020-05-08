<%@page import="com.User.dao.CityDao"%>
<%@page import="com.User.bean.CityBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.User.bean.StateBean" %>
<%@page import="com.User.dao.StateDao" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign Up</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="userreg.css">
</head>
<body>
    

    <div class="main">
        <div class="container" >
            <div class="signup-content">

             
                <div class="signup-form" style="margin-left: 280px;">
                    <form method="POST" class="register-form" id="register-form" action="NGOInsertControllerr" >
                        <div style="background-color: #ff6801;">
                            <h2 style="color: white;font-weight: 2px;padding-bottom: 4px;margin-left: 2px;">NGOs Registration</h2>
                        </div>
                        
                         
                            <div class="form-group">
                                <label for="Ngo_name">Name of Ngo:</label>
                                <input type="text" name="txtNGOName" required/>
                            </div>
                        
                        <div class="form-group">
                            <label for="email">Email Id :</label>
                            <input type="text" name="txtNGOEmailId" required/>
                        </div>
                         <div class="form-group">
                            <label for="address">Password:</label>
                            <input type="text" name="pwdPassword"  required/>
                        </div>
                        <div class="form-group">
                            <label for="address">Confrim Password:</label>
                            <input type="text" name="pwdPassword" required/>
                        </div>
                        <div class="form-group">
                            <label for="address">Name of Chairman/Director/President:</label>
                            <input type="text" name="txtNGODirector" required/>
                        </div>
                    
                        <div class="form-row">
                            <div class="form-group">
                                <label for="state">State :</label>
                                <div class="form-select">
                                    <select name="txtNGOState" id="state">
                                        <option value="0">---Select state---</option>
<%
	List<StateBean> listOfState=new ArrayList<StateBean>();
	StateDao stateDao=new StateDao();
	StateBean stateBean=new StateBean();
	listOfState=stateDao.selectState();
	for(int i=0;i<listOfState.size();i++)
	{
		 stateBean=listOfState.get(i);
%>
<option value="<%=stateBean.getState_Id()%>" ><%=stateBean.getState_Name()%></option>
<%} %> </select>
                                    <span class="select-icon"><i class="zmdi zmdi-chevron-down"></i></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="city">City :</label>
                                <div class="form-select">
                                    <select name="txtNGOcity" id="city">
                                       <option value="0">--select city--</option>
<%
	// List<CityBean> listOfCity=(ArrayList)request.getAttribute("ListOfCity");
	List<CityBean> listOfCity=new ArrayList<CityBean>();
	CityBean cityBean=new CityBean();
	CityDao cityDao=new CityDao();
	listOfCity=cityDao.selectcity();
	for(int i=0;i<listOfCity.size();i++)
	{
		cityBean=listOfCity.get(i);
%>
<option value="<%=cityBean.getCityId()%>"><%=cityBean.getCityName() %></option>
<%} %>

                                    </select>
                                    <span class="select-icon"><i class="zmdi zmdi-chevron-down"></i></span>
                                </div>
                            </div>
                        </div>

                           <div class="form-group">
                                <label for="state">Type of NGOs:</label>
                                <div class="form-select">
                                    <select name="txtNGOCategory" id="type">
                                        <option value=""></option>
                                        <option value="v1">Education</option>
                                        <option value="v2">vedow</option>
                                    </select>
                                    <span class="select-icon"><i class="zmdi zmdi-chevron-down"></i></span>
                                </div>
                            </div>

                         <div style="background-color: #ff6801;">
                            <h2 style="color: white;font-weight: 2px;padding-bottom: 2px;margin-left: 2px;">Details Of Achievements</h2>
                        </div>


                        <div style="background-color: #ff6801;">
                            <h2 style="color: white;font-weight: 2px;padding-bottom: 2px;margin-left: 2px;">Contact Details</h2>
                        </div>

                         <div class="form-group">
                            <label for="address">Office Address with Pin Code:</label>
                             <textarea cols="40" rows="5" name="txtNGOAddress"></textarea><br/>
                        </div>

                         <div class="form-group">
                            <label for="address">Authorized Signatory Email Address:</label>
                            <input type="text" name="txtNGOAuthorizedEmailId" required/>
                        </div>
                          <div class="form-row" >
                                               
                                <div class="form-group">
                                <label for="father_name">Phone 1:</label>
                                <input type="text" name="txtNGOContactNO" required/>
                            </div>
                            <div class="form-group">
                                <label for="father_name">Mobile:</label>
                                <input type="text" name="txtNGOMobileNO" required/>
                            </div>
                        </div>

                          <div class="form-group">
                            <label for="email">Website URL of NGO:</label>
                            <input type="text" name="txtNGOURL" required/>
                        </div>

                        <div style="background-color: #ff6801;">
                            <h2 style="color: white;font-weight: 2px;padding-bottom: 2px;margin-left: 2px;">Self Declaration</h2>
                        </div>

                        <div class="form-row">
                            <div class="form-checkbox">
                                <input type="checkbox" name="option1" >
                            </div>
                                
                                <p> I hereby declare and affrim that the information provided by me is true and correct to the best of my knowledge and belief that this NGO has not signed up earlier.I am solely responsible for updating/correcting any changes in the above information.</p>
                            
                            </div>
                        

                       
                        
                            
                      
                        <div class="form-submit">
                            <input type="submit" value="Resister" class="submit" name="submit" id="submit" />
                            <input type="submit" value="Back" class="submit" name="reset" id="reset" />
                            
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </div>

    <!-- JS -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="js/main.js"></script>
</body>
</html>