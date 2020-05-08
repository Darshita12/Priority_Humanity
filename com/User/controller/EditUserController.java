package com.User.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.User.bean.UserBean;
import com.User.dao.UserDao;


public class EditUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession();
		
		UserBean userBean=(UserBean)session.getAttribute("UserBean");
		
		int UserId=userBean.getUserId();
		/* System.out.println("--"+request.getParameter("UserId")); */
		UserDao userDao=new UserDao();
		//UserBean userBean=new UserBean();
		userBean=userDao.editUser(UserId);
		request.setAttribute("UserBean", userBean);
		request.getRequestDispatcher("EditUser.jsp").forward(request, response);
	}

}
