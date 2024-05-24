<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.chainsys.dao.UserDetails" %>
<%@ page import="com.chainsys.model.LoginPage" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form>
<table border="1">
<tr>
<td>FirstName</td>
<td>LastName</td>
<td>Course</td>
<td>Gender</td>
<td>Phone</td>
<td>Email</td>
<td>Password</td>
</tr>
<tbody>
        <% 
        ArrayList<LoginPage> array = (ArrayList<LoginPage>) request.getAttribute("array");
        if (array != null) {
            for (LoginPage user : array) {
        %>
        <tr>
            <td><%=user.getFirstname() %></td>
            <td><%=user.getLastname() %></td>
           <td><%=user.getCourse() %></td>
            <td><%=user.getGender() %></td>
            <td><%=user.getPhoneno() %></td>
            <td><%=user.getEmail() %></td>
             <td><%=user.getPassword() %></td>
        </tr>
        <% 
            }
        } else {
        %>
        <tr>
            <td colspan="5">No users found.</td>
        </tr>
        <% } %>
    </tbody>
</table>
</form>
</body>
</html> --%>