package com.User.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.User.bean.CityBean;
import com.User.bean.UserBean;
import com.User.dao.CityDao;
import com.User.dao.UserDao;


public class UserInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String FirstName=request.getParameter("txtFirstName");
		String LastName=request.getParameter("txtLastName");
		String UserEmail=request.getParameter("txtUserEmail");
		String UserPassword=request.getParameter("txtUserPassword");
		String UserContact=request.getParameter("txtUserContact");
		String UserState=request.getParameter("stateName");
		String UserCity=request.getParameter("cityName");
		String UserGender=request.getParameter("gender");
		UserDao userDao=new UserDao();
		//CityDao cityDao=new CityDao();

		System.out.println(UserGender);
		UserBean userBean=new UserBean();
		userBean.setFirstName(FirstName);
		userBean.setLastName(LastName);
		userBean.setEmail(UserEmail);
		userBean.setPassword(UserPassword);
		userBean.setContact(UserContact);
		userBean.setState(UserState);
		userBean.setCity(UserCity);
		userBean.setGender(UserGender);
		/*List<CityBean> listOfCity=new ArrayList<CityBean>();
		listOfCity=cityDao.listofCity(valajax);
		request.setAttribute("ListOfCity", listOfCity);
		request.getRequestDispatcher("UserReg.jsp").forward(request, response);
*/
		
		userDao.addUser(userBean);
		

	}

}
