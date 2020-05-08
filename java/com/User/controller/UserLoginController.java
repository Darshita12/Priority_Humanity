package com.User.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.User.bean.UserBean;
import com.User.dao.UserDao;
import com.mysql.cj.Session;


public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email=request.getParameter("txtUserEmail");
		String password=request.getParameter("txtUserPassword");
		
		UserDao userDao=new UserDao();
		UserBean userBean=new UserBean();
		userBean=userDao.login(email, password);
		HttpSession session=request.getSession();
		if(userBean!=null) {
		session.setAttribute("UserBean", userBean);
		session.setAttribute("isLogin", true);
		session.setAttribute("UserType", true);
		
		response.sendRedirect("index.jsp");}
		else
		{
			response.sendRedirect("UserLogin.jsp");
		}
	}

}
