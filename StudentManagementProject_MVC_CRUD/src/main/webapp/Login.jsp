<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<h1 align="center">WELCOME TO STUDENTS PORTAL</h1>
<h3 align="center">Fill The Details Below To Login</h3>

</head>

<body align="center">

	<form action="Studentlogin">
		<table border="1" align="center">
			<tr>
				<td>USERNAME :</td>
				<td><input type="text" name="uname"></td>
			</tr>
			<tr>
				<td>PASSWORD</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="login"></td>
			</tr>


		</table>
	</form>

</body>
</html>