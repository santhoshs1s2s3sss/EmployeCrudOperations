<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<body>

	<div style="margin: 50px" align="center">
		<h1>Get Employee Details</h1>

		<form method="get" action="userdetails">
			<div style="margin-bottom: 10px">
				<span>Id</span> <input type="number" name="id" required />
			</div>
			<input type="submit" value="Get Details" />
		</form>

	</div>
</body>
</html>