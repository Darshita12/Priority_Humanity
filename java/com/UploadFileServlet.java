package com;


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


public class UploadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private boolean isMultipart;
	private String filePath;
	private int maxFileSize = 50 * 1024; 
	// private int maxMemSize = 4 * 1024;
	private File file;

	public void init() {
		// Get the file location where it would be stored.

		filePath = getServletContext().getInitParameter("file-upload");
		System.out.println("----" + filePath);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Check that we have a file upload request
		
				isMultipart = ServletFileUpload.isMultipartContent(request);
				//request -->file -->true
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

				// maximum size that will be stored in memory
				factory.setSizeThreshold(maxFileSize);

				// Location to save data that is larger than maxMemSize.
				factory.setRepository(new File("c:\\temp"));

				// Create a new file upload handler
				ServletFileUpload upload = new ServletFileUpload(factory);

				// maximum file size to be uploaded.
				upload.setSizeMax(maxFileSize);

				try {
					// Parse the request to get file items.
					List<FileItem> fileItems = upload.parseRequest(request);

					// Process the uploaded file items
					Iterator<FileItem> i = fileItems.iterator();

					out.println("<html>");
					out.println("<head>");
					out.println("<title>Servlet upload</title>");
					out.println("</head>");
					out.println("<body>");

					while (i.hasNext()) {
						FileItem fi = (FileItem) i.next();// image.jpg//firsname
						//file ->firstname -->txtx 
						if (!fi.isFormField()) {
							
							// Get the uploaded file parameters
							String fieldName = fi.getFieldName();
							String fileName = fi.getName();
							String contentType = fi.getContentType();
							/*boolean isInMemory = fi.isInMemory();
							long sizeInBytes = fi.getSize();
		*/
							//
							// Write the file
							//c://abc//axyz//sam.jpg
							
							if (fileName.lastIndexOf("\\") >= 0) {
								file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\")));
							} else {
								file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\") + 1));
							}
							fi.write(file);
							out.println("Uploaded Filename: " + fileName.concat("sam") + "<br>");
						} 
						else {
							/*
							 * String name = request.getParameter("txtUserName");
							 * System.out.println(name);
							 */
							
							String fieldName = fi.getFieldName();

							//System.out.println(fieldName);
							if (fieldName.equals("txtUserName")) {

								
								//set in bean
								System.out.println(fi.getString());
							}
							if (fieldName.equals("txtUserEmail")) {

								System.out.println(fi.getString());
							}

						}
					}
					out.println("</body>");
					out.println("</html>");
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}


	}

