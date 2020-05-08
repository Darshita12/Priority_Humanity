package com.NGO.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.NGO.Bean.NGOBean;
import com.NGO.Dao.NGODao;
import com.User.bean.UserBean;

public class EditNGO extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		NGOBean ngoBean = (NGOBean)session.getAttribute("NGOBean");

		int Id = ngoBean.getId();
		NGODao ngoDao = new NGODao();
		//NGOBean ngoBean = new NGOBean();
		ngoBean = ngoDao.editNGO(Id);
		request.setAttribute("NGOBean", ngoBean);
		request.getRequestDispatcher("EditNGO.jsp").forward(request, response);
	}

}
