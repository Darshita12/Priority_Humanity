package com.product.controller;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.product.bean.ProductBean;
import com.product.dao.ProductDao;

//ProductInsertController

public class ProductInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private boolean isMultipart;
	private String filePath;
	private int maxFileSize = 500 * 1024;
	private File file;
	
	

	public void init() {
		filePath = getServletContext().getInitParameter("file-uplode");
		System.out.println("----" + filePath);

	}
	
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		
		
		isMultipart = ServletFileUpload.isMultipartContent(request);
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
			
			
			
			ProductBean productBean = new ProductBean();

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
					
					/*
					 * fileName = new String("ProD" + productBean.getShopId() + "_" +
					 * productBean.getProductId() + "-" + productBean.getProductName() +
					 * fileName.substring(fileName.lastIndexOf(".")));
					 */
					
					fi.write(file);
		

					out.println("Uploaded Fieldname: " + fieldName + "<br>");
					out.println("Uploaded Filename: " + fileName + "<br>");
					out.println("Uploaded contentType: " + contentType + "<br>");
					out.println("new fileName= " + fileName);
					System.out.println(file);
							

					productBean.setImagePath(filePath.concat(fileName));

				}

				else {


					String fieldName = fi.getFieldName();

					if (fieldName.equals("shopId")) {
						// System.out.println(Integer.parseInt(fi.getString()));
						// String shopID = fi.getString();
						System.out.println("shop id =" + fi.getString());

						productBean.setShopId(Integer.parseInt(fi.getString()));

					}
					if (fieldName.equals("txtName")) {
						System.out.println("shopName=" + fi.getString());
						productBean.setProductName(fi.getString());

					}
					if (fieldName.equals("quantity")) {
						System.out.println(fi.getString());

						productBean.setQuantity(Integer.parseInt(fi.getString()));
					}
					if (fieldName.equals("category")) {
						System.out.println(fi.getString());

						productBean.setCategory(fi.getString());
					}
					if (fieldName.equals("subcategory")) {
						System.out.println(fi.getString());

						productBean.setSubCategory(fi.getString());
					}
					if (fieldName.equals("description")) {
						System.out.println(fi.getString());

						productBean.setDescription(fi.getString());
					}
					if (fieldName.equals("cost")) {
						System.out.println(fi.getString());

						productBean.setCost(Integer.parseInt(fi.getString()));
					}

				}

			}
			if (new ProductDao().addProduct(productBean)) {

				System.out.println("product Added");

			} else {
				System.out.println("product is not added");

			}

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		throw new ServletException("GET method used with " + getClass().getName() + ": POST method required.");
	}

}
