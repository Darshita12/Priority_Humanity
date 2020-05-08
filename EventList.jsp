<%@page import="java.util.ArrayList"%>
<%@page import="com.Event.bean.EventBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>Event Id</th>
			<th>Event Name</th>
			<th>Event Address</th>
			<th>Date</th>
		</tr>
		<%
			List<EventBean> listOfEvent = (ArrayList) request.getAttribute("listOfEvent");

			for (int i = 0; i < listOfEvent.size(); i++) {

				EventBean eventBean = listOfEvent.get(i);
		%>
		<tr>
			<td><%=eventBean.getEventid()%></td>
			<td><%=eventBean.getEventname()%></td>
			<td><%=eventBean.getEventaddress() %></td>
			<td><%=eventBean.getEventDate()%></td>
			<td><a href="DeleteEventServlet?eid=<%=eventBean.getEventid()%>">DELETE</a></td>
			<td><a href="EditEventServlet?eid=<%=eventBean.getEventid() %>">UPDATE</a></td>
		</tr>

		<%
			} //end of for
		%>



	</table>

</body>
</html>