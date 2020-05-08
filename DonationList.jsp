<%@page import="java.util.ArrayList"%>
<%@page import="com.Donation.Bean.DonationBean"%>
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
			<th>Donation Id</th>
			<th>Donation Amount </th>
			<th>Donation Date</th>
		</tr>
		<%
			List<DonationBean> listOfDonation = (ArrayList)request.getAttribute("listOfDonation");
			
			for (int i = 0; i < listOfDonation.size(); i++) {

				DonationBean donationBean = listOfDonation.get(i);
		%>
		<tr>
			<td><%=donationBean.getDonationid()%></td>
			<td><%=donationBean.getDonationamount()%></td>
			<td><%=donationBean.getDonationdate()%></td>
			<td><a href="DeleteDonationServlet?did=<%=donationBean.getDonationid()%>">DELETE</a></td>
			<td><a href="EditDonationServlet?did=<%=donationBean.getDonationid() %>">UPDATE</a></td>
		</tr>

		<%
			} //end of for
		%>



	</table>


</body>
</html>