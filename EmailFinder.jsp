<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String email=request.getParameter("email");
		System.out.println(email);
	if(email.contains("@")&&email.contains("."))
	{
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/darshita", "root", "1234");
		PreparedStatement pstmt=conn.prepareStatement("select * from student1 where StudentEmail=?");
		pstmt.setString(1, email);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			
			System.out.println("valid");
		}
		else
		{
			out.println("Invalid");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
%>

</body>
</html>