package com.NGO.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.NGO.Dao.NGODao;

/**
 * Servlet implementation class DeleteNGO
 */
public class DeleteNGO extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int NGOId=Integer.parseInt(request.getParameter("Id"));
		NGODao ngoDao=new NGODao();
		ngoDao.deleteNGO(NGOId);
	}

}
