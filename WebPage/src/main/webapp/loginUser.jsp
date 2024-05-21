<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Login" method="post">
<label for="username">Name:</label>
<input type="text" id="username" name="username" placeholder="Enter the user name" required><br>
<label for="email">Email:</label>
<input type="text" id="email" name="email" placeholder="Enter the email id" required><br>
<label for="phonenumber">PhoneNumber:</label>
<input type="text" id="phonenumber" name="phonenumber" placeholder="Enter the phonenumber" required><br>
<button type="submit">Register</button>
</form>

</body>
</html>