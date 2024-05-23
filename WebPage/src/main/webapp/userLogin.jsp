<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.chainsys.model.LoginUser"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.chainsys.util.JdbcUser"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
    href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round|Open+Sans">
<link rel="stylesheet"
    href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style type="text/css">
body {
    color: #404E67;
    background: #F5F7FA;
    font-family: 'Open Sans', sans-serif;
}

.table-wrapper {
    width: 100%;
    margin: 30px auto;
    background: #fff;
    padding: 20px;
    box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
}

.table-title {
    padding-bottom: 10px;
    margin: 0 0 10px;
}

.table-title h2 {
    margin: 6px 0 0;
    font-size: 22px;
}

.table-title .add-new {
    float: right;
    height: 30px;
    font-weight: bold;
    font-size: 12px;
    text-shadow: none;
    min-width: 100px;
    border-radius: 50px;
    line-height: 13px;
}

.table-title .add-new i {
    margin-right: 4px;
}

table.table {
    table-layout: fixed;
    width: 800px; /* Set the width of the table */
    margin: auto; /* Center the table horizontally */
}

table.table tr th, table.table tr td {
    border-color: #e9e9e9;
}

table.table th i {
    font-size: 5px;
    margin: 0 5px;
    cursor: pointer;
}

table.table td a {
    cursor: pointer;
    display: inline-block;
    margin: 0 5px;
    width: 150px;
}

table.table td a.add {
    /* Removed color property */
}

table.table td a.edit {
    /* Removed color property */
}

table.table td form.delete button {
    /* Remove custom styling */
}

table.table td i {
    font-size: 19px;
}

table.table td a.add i {
    font-size: 24px;
    margin-right: -1px;
    position: relative;
    top: 3px;
}

table.table .form-control {
    height: 32px;
    line-height: 32px;
    box-shadow: none;
    border-radius: 2px;
}

table.table .form-control.error {
    border-color: #f50000;
}

table.table td .add {
    display: none;
}

</style>
</head>
<body>
    <div class="container">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-8">
                        <h2>
                            User <b>Details</b>
                        </h2>
                    </div>
                    <div class="col-sm-4">
                        <button type="button" class="btn btn-info add-new">
                            <i class="fa fa-plus"></i> Add New
                        </button>
                    </div>
                </div>
            </div>
            <form>
                <table border="1" class="table">
                    <tr>
                        <th>UserName</th>
                        <th>Email ID</th>
                        <th>PhoneNumber</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    <tbody>
                        <%
                        JdbcUser use = new JdbcUser();
                        ArrayList<LoginUser> array = use.Read();
                        for (LoginUser login : array) {
                        %>
                        <tr>
                            <td><%=login.getUsername()%></td>
                            <td><%=login.getEmail()%></td>
                            <td><%=login.getPhonenumber()%></td>
                
                                  <td>
                                  <form action="Login" method="get">
                                    <input type="hidden" name="action" value="update"> 
                                    <input type="hidden" name="updateid" value="<%=login.getId()%>">
                                    <button type="submit" onclick="location.href="'update.jsp?updateid=<%=login.getId() %>'"><i class="material-icons">&#xE254;</i>
                                 </button>
                                </form>
                                </td>
                                <td>
                               
                                    <input type="hidden" name="action" value="delete"> 
                                    <input
                                        type="hidden" name="deleteid" value="<%=login.getId()%>">
                                    <button type="submit" title="delete" ><i
                                    class="fa fa-trash"></i></button>
                                </td>

                            <%
                            }
                            %>
                            </tr>
                        
                    </tbody>

                </table>
            </form>
        </div>
    </div>
</body>
</html>
