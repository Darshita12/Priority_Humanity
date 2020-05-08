package com.NGO.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.NGO.Bean.NGOBean;
import com.NGO.Dao.NGODao;

public class UpdateNGO extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int Id = Integer.parseInt(request.getParameter("txtId"));
		String Name = request.getParameter("txtNGOName");
		int Category = Integer.parseInt(request.getParameter("txtNGOCategory"));
		String EmailId = request.getParameter("txtNGOEmailId");
		String Password = request.getParameter("pwdPassword");
		
		String Director = request.getParameter("txtNGODirector");
		String Address = request.getParameter("txtNGOAddress");
		String AuthorizedEmailId = request.getParameter("txtNGOAuthorized_EmailId");
		String ContactNo = request.getParameter("txtNGOContactNo");
		String MobileNo = request.getParameter("txtNGOMobileNo");
		String URL = request.getParameter("txtNGOURL");
		String State = request.getParameter("txtNGOState");
		String City = request.getParameter("txtNGOCity");
		
		NGOBean ngoBean = new NGOBean();
		ngoBean.setId(Id);
		ngoBean.setName(Name);
		ngoBean.setCategory(Category);
		ngoBean.setEmailId(EmailId);
		ngoBean.setPassword(Password);
		ngoBean.setDirector(Director);
		ngoBean.setAddress(Address);
		ngoBean.setAuthorized_EmailID(AuthorizedEmailId);
		ngoBean.setContactno(ContactNo);
		ngoBean.setMobileno(MobileNo);
		ngoBean.setURL(URL);
		ngoBean.setState(State);
		ngoBean.setCity(City);
		NGODao ngoDao=new NGODao();
		if(ngoDao.updateNGO(ngoBean))
		{
			response.sendRedirect("NGOListController");
		}
		else
		{
			response.sendRedirect("NGOListController");
		}
	}

}
