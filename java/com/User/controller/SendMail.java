package com.User.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.User.bean.UserBean;
import com.User.controller.Mailer;
import com.User.dao.UserDao;

/**
 * Servlet implementation class SendMail
 */
public class SendMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	public void service(HttpServletRequest request,  HttpServletResponse response)  throws ServletException, IOException 
	{  
		
		
		
		//search mail
		//update query 
		//sent mail... 
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();  
      
		String to=request.getParameter("to");
		UserBean userBean=new UserBean();
		userBean.setEmail(to);
		/*
		 * String subject=request.getParameter("subject"); String
		 * msg=request.getParameter("msg");
		 */
          UserDao userDao=new UserDao();
          userBean=userDao.forgetPwd(userBean);
          System.out.println(userBean.getEmail());
          System.out.println(userBean.getUserId());
		
		  Mailer.send(to,userBean.getUserId());
		 	response.sendRedirect("index.jsp"); 
		out.close();  
    }  
  
}
