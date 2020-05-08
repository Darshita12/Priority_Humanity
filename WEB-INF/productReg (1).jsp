<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PRODUCT ADD PAGE</title>
</head>
<body>
	<h1>Product Adding form</h1>
	<form action="../ProductInsertController" method="post"
		enctype="multipart/form-data">
		<table>
			<tr>

				<%String shopid=session.getAttribute("shopId").toString();
					out.println(shopid);
				%>
				<td><input type="hidden" name="shopId" value="<%=shopid%>"></td>
			</tr>


			<tr>
				<td>Product Name</td>
				<td><input type="text" name="txtName">${ProductName}</td>
			</tr>

			<tr>
				<td>Quantity</td>
				<td><input type="number" name="quantity" min="1">${quantity}</td>
			</tr>

			<tr>
				<td>Category</td>
				<td><select name="category">
						<option value="male">MALE</option>
						<option value="female">FEMALE</option>
						<option value="both">BOTH</option>
				</select>${category}</td>
			</tr>

			<tr>
				<td>Sub Category</td>
				<td><select name="subcategory">
						<option value="animals">Animals</option>
						<option value="art">Art and Crafts</option>
						<option value="baby">Baby Gear</option>
						<option value="body">Bath and Body</option>
						<option value="computers">Computers</option>
						<option value="electronics">Electronics</option>
						<option value="flowers">Flowers and Plants</option>
						<option value="food">Food</option>
						<option value="baskets">Gift Baskets</option>
						<option value="certificates">Gift Certificates</option>
						<option value="household">Household</option>
						<option value="jewelry">Jewelry</option>
						<option value="keepsakes">Keepsakes</option>
						<option value="leisure">Leisure</option>
						<option value="occupational">Occupational Themed Gifts</option>
						<option value="office">Office</option>
						<option value="outdoors">Outdoors</option>
						<option value="Party Supplies">Party Supplies</option>
						<option value="scented">Scented Gifts</option>
						<option value="sports">Sports & Recreation</option>
						<option value="toys">Toys</option>
						<option value="others..">Others</option>

				</select>${subcategory}</td>
			</tr>


			<tr>
				<td>Product Details</td>
				<td><input type="text" name="description">${description}</td>
			</tr>
			
			<tr>
				<td>Product Cost</td>
				<td><input type="number" name="cost" min="1">${cost}</td>
			</tr>
			

			<tr>
				<td>Photo:</td>
				<td><input type="file" name="file" value="" />${file}</td>
			</tr>



		</table>
		<input type="submit" value="Submit">


		
			<table>
				<tr>
					<td style="width: 450px; height: auto;"><iframe name=""
							src="" style="width: 550px; height: 300px"></iframe></td>
							
							
				</tr>
			</table>
		
	</form>




</body>
</html>