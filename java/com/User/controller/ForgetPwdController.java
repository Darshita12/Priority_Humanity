package com.User.controller;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.User.bean.UserBean;
import com.User.dao.UserDao;




public class ForgetPwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		System.out.println(request.getParameter("uid"));
		int id=Integer.parseInt(request.getParameter("uid"));
		String password=request.getParameter("pwdPassword");
		UserBean userBean=new UserBean();
		userBean.setUserId(id);
		userBean.setPassword(password);
		if(new UserDao().setNewPassword(userBean))
		{
			response.sendRedirect("index.jsp");
		}
		else
		{
			response.sendRedirect("ResetPwd.jsp");
			//request.getRequestDispatcher("ResetPwd.jsp").forward(request, response);
		}
				}

	}


