<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
</head>
<body>
	<div align="center">
		<h1>Update Employee Details</h1>

		<form method="get" action="updateProcess">

			<span>Id</span> <input type="number" name="id" required /> <br>
			<span> Name </span> <input type="text" name="name" required /> <br>
			<input type="submit" value="Update User" />

		</form>
	</div>

</body>
</html>