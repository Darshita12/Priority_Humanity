package com.User.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.User.bean.UserBean;
import com.User.dao.UserDao;


public class UpdateUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int UserId=Integer.parseInt(request.getParameter("txtUserId"));
		String FirstName=request.getParameter("txtFirstName");
		String LastName=request.getParameter("txtLastName");
		String UserEmail=request.getParameter("txtUserEmail");
		String UserPassword=request.getParameter("txtUserPassword");
		String UserContact=request.getParameter("txtUserContact");
		//String UserState=request.getParameter("stateName");
		//String UserCity=request.getParameter("cityName");
		System.out.println(FirstName);
		UserBean userBean=new UserBean();
		userBean.setUserId(UserId);
		userBean.setFirstName(FirstName);
		userBean.setLastName(LastName);
		userBean.setEmail(UserEmail);
		userBean.setPassword(UserPassword);
		userBean.setContact(UserContact);
		//userBean.setState(UserState);
		//userBean.setCity(UserCity);
		System.out.println(userBean.getFirstName());
		UserDao userDao=new UserDao();
		if(userDao.updateUser(userBean))
		{
			response.sendRedirect("index.jsp");
		}
		else
		{
			response.sendRedirect("index.jsp");
		}
		
	}

}
