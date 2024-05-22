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
	width: 500px;
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
}

table.table tr th, table.table tr td {
	border-color: #e9e9e9;
}

table.table th i {
	font-size: 13px;
	margin: 0 5px;
	cursor: pointer;
}

table.table th:last-child {
	width: 100px;
}

table.table td a {
	cursor: pointer;
	display: inline-block;
	margin: 0 5px;
	min-width: 24px;
}

table.table td a.add {
	color: #27C46B;
}

table.table td a.edit {
	color: #FFC107;
}

table.table td a.delete {
	color: #E34724;
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
				<table border="1">
					<tr>
						<th>UserName</th>
						<th>Email ID</th>
						<th>PhoneNumber</th>
						<th>Edit</th>
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
							<td><a class="add" title="Add" data-toggle="tooltip"><i
									class="material-icons">&#xE03B;</i></a> <a class="edit"
								title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
								<form action="Login" method="post">
									<input type="hidden" name="action" value="delete"> <input
										type="hidden" name="deleteid" value="<%=login.getUsername()%>">
									<!-- Pass user ID -->
									<button type="submit" class="delete-btn">Delete</button>
								</form></td>

							<%
							}
							%>
						
					</tbody>

				</table>
			</form>
		</div>
	</div>
</body>
</html>