package com.NGO.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.NGO.Bean.NGOBean;
import com.NGO.Dao.NGODao;


public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String emailId=request.getParameter("txtEmailId");
		String password=request.getParameter("pwdPassword");
		boolean isLogin = true;
		NGODao ngoDao=new NGODao();
		NGOBean ngoBean=new NGOBean();
		ngoBean=ngoDao.login(emailId, password);
		if(ngoBean!=null) {
		HttpSession session=request.getSession();
		session.setAttribute("NGOBean", ngoBean);
		session.setAttribute("UserType", false);
		session.setAttribute("isLogin", true);
		response.sendRedirect("index.jsp");
		}
		else {
		response.sendRedirect("NGOLogin.jsp");
		}
	}

}
