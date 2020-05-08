<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>File Upload:</h3>
	Select a file to upload:
	<br />
	<form action="UploadFileServlet" method="post"
		enctype="multipart/form-data">
		
		<hr>
		<input type="file" name="file" size="50" />
		<hr>
		<br /> <label>USERNAME</label> <input type="text" name="txtUserName">
		<br /> <label>USEREMAIL</label> <input type="text"
			name="txtUserEmail"> <input type="submit" value="Upload File" />
	</form>

</body>
</html>