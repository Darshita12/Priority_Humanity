package com.Admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Admin.bean.AdminBean;
import com.Admin.dao.AdminDao;
import com.User.bean.UserBean;
import com.User.dao.UserDao;


public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("txtAdminEmail");
		String password=request.getParameter("txtAdminPassword");
		
		AdminDao adminDao=new AdminDao();
		AdminBean adminBean=new AdminBean();
		adminBean=adminDao.login(email, password);
		UserDao userDao=new UserDao();
		UserBean userBean=new UserBean();
		userBean=userDao.listOfUser1();
		/*if(adminBean!=null) {*/
		HttpSession session=request.getSession();
		session.setAttribute("UserBean1", userBean);
		session.setAttribute("AdminBean", adminBean);
		session.setAttribute("isLogin", true);
		session.setAttribute("AdminType", true);
		response.sendRedirect("index.jsp");	}
	
	/*else
	{
		response.sendRedirect("AdminLogin.jsp");
	}
	}*/
}
