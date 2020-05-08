<%@page import="com.Event.bean.EventBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="EventUpdateServlet">
		<%
			EventBean eventBean = (EventBean) request.getAttribute("eventBean");
		%>
		<table>
			<input type="hidden" name="eid" value="<%=eventBean.getEventid()%>">
			<tr>
				<td>EventName</td>
				<td><input type="text" name="Eventname"
					value="<%=eventBean.getEventname()%>"></td>
			</tr>


			<tr>
				<td>EventAddress</td>
				<td><input type="text" name="Eventaddress"
					value="<%=eventBean.getEventaddress()%>"></td>
			</tr>

			<tr>
				<td>EventDate</td>
				<td><input type="date" name="EventDate"
					value="<%=eventBean.getEventDate()%>"></td>
			</tr>
			<tr>
				<td><input type="submit" name="SUBMIT"></td>
			</tr>

		</table>
	</form>
</body>
</html>