<%@page import="com.Donation.Bean.DonationBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="DonationUpdateServlet">
		<%
			DonationBean donationBean = (DonationBean) request.getAttribute("donationBean");
		%>
		<table>
			<input type="hidden" name="did"
				value="<%=donationBean.getDonationid()%>">
			<tr>
				<td>Donation Amount</td>
				<td><input type="Int" name="DonationAmount"
					value="<%=donationBean.getDonationamount()%>"></td>
			</tr>


			<td><input type="submit" name="SUBMIT"></td>
			</tr>

		</table>
	</form>


</body>
</html>