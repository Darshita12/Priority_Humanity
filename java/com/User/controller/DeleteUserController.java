package com.User.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.User.dao.UserDao;

public class DeleteUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int UserId=Integer.parseInt(request.getParameter("UserId"));
		UserDao userDao=new UserDao();
		userDao.deleteUser(UserId);
		
	}

}
