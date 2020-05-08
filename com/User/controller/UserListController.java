package com.User.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.User.bean.UserBean;
import com.User.dao.UserDao;


public class UserListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	UserDao userDao=new UserDao();
	List<UserBean> listOfUser=new ArrayList<UserBean>();
	//UserBean userBean=new UserBean();
	//userBean=userDao.listOfUser1();
	listOfUser=userDao.listOfUser();
	request.setAttribute("ListOfUser", listOfUser);
	//request.setAttribute("UserBean", userBean);
	request.getRequestDispatcher("UserList.jsp").forward(request, response);
	System.out.println("bvbb");
	}

}
