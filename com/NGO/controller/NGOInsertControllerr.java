package com.NGO.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.NGO.Bean.NGOBean;
import com.NGO.Dao.NGODao;


public class NGOInsertControllerr extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean isMultipart;
	private String filePath;
	private int maxFileSize = 500 * 1024;
	private File file;
	
	

	public void init() {
		filePath = getServletContext().getInitParameter("file-upload");
		System.out.println("----" + filePath);

	}

    
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		throw new ServletException("GET method used with " + getClass().getName() + ": POST method required.");
		
	}
 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		isMultipart =  ServletFileUpload.isMultipartContent(request);
		response.setContentType("text/html");
		java.io.PrintWriter out = response.getWriter();
		if (!isMultipart) {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet upload</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<p>No file uploaded</p>");
			out.println("</body>");
			out.println("</html>");
			return;

		}
	

		DiskFileItemFactory factory = new DiskFileItemFactory();
	
		System.out.println(factory);
		
		factory.setSizeThreshold(maxFileSize);
		factory.setRepository(new File("c:\\temp"));

		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(maxFileSize);

		try {

			List fileItems = upload.parseRequest(request);
			Iterator<FileItem> i = fileItems.iterator();

			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet upload</title>");
			out.println("</head>");
			out.println("<body>");
			
			NGOBean ngoBean=new NGOBean();
			while (i.hasNext()) {

				FileItem fi = (FileItem) i.next();
				
				if (!fi.isFormField()) {

					System.out.println("file uploadding if");
					String fieldName = fi.getFieldName();
					String fileName = fi.getName();
					String contentType = fi.getContentType();
					boolean isInMemory = fi.isInMemory();
					long sizeInBytes = fi.getSize();

					if (fileName.lastIndexOf("\\") >= 0) {
						file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\")));
					} else {
						file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\") + 1));
					}
					fi.write(file);
					

					out.println("Uploaded Fieldname: " + fieldName + "<br>");
					out.println("Uploaded Filename: " + fileName + "<br>");
					out.println("Uploaded contentType: " + contentType + "<br>");
					out.println("new fileName= " + fileName);
					System.out.println(file);
					ngoBean.setFile(fileName);
				}

				else {


					String fieldName = fi.getFieldName();
					if (fieldName.equals("txtNGOName")) {
						System.out.println("NGOName=" + fi.getString());
						ngoBean.setName(fi.getString());

					}
					if (fieldName.equals("txtNGOEmailId")) {
						System.out.println("NGOEmail=" + fi.getString());
						ngoBean.setEmailId(fi.getString());

					}
					if (fieldName.equals("pwdPassword")) {
						System.out.println("pwdPassword=" + fi.getString());
						ngoBean.setPassword(fi.getString());

					}
					if (fieldName.equals("txtNGODirector")) {
						System.out.println("NGODirector=" + fi.getString());
						ngoBean.setDirector(fi.getString());

					}
					if (fieldName.equals("txtNGOState")) {
						System.out.println("txtNGOState=" + fi.getString());
						ngoBean.setState(fi.getString());

					}
					if (fieldName.equals("txtNGOcity")) {
						System.out.println("txtNGOcity=" + fi.getString());
						ngoBean.setCity(fi.getString());

					}
					if (fieldName.equals("txtNGOCategory")) {
						System.out.println("txtNGOCategory=" + fi.getString());
						int s = Integer.parseInt(fi.getString());
						ngoBean.setCategory(s);

					}
					if (fieldName.equals("txtNGOAddress")) {
						System.out.println("txtNGOAddress=" + fi.getString());
						ngoBean.setAddress(fi.getString());

					}
					if (fieldName.equals("txtNGOAuthorizedEmailId")) {
						System.out.println("txtNGOAuthorizedEmailId=" + fi.getString());
						ngoBean.setAuthorized_EmailID(fi.getString());

					}
					if (fieldName.equals("txtNGOContactNO")) {
						System.out.println("txtNGOContactNO=" + fi.getString());
						ngoBean.setContactno(fi.getString());

					}
					if (fieldName.equals("txtNGOMobileNO")) {
						System.out.println("txtNGOMobileNO=" + fi.getString());
						ngoBean.setMobileno(fi.getString());

					}
					if (fieldName.equals("txtNGOURL")) {
						System.out.println("txtNGOURL=" + fi.getString());
						ngoBean.setURL(fi.getString());

					}
					if (fieldName.equals("file")) {
						System.out.println("file=" + fi.getString());
						ngoBean.setName(fi.getString());

					}
				}
			}
			if (new NGODao().addNGO(ngoBean)) {

				response.sendRedirect("index.jsp");

			} else {
				response.sendRedirect("NGOform.jsp");

			}

		} catch (Exception ex) {
			ex.printStackTrace();

		}
	}

	}
