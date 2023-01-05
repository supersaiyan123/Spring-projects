<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<center><h1>All Registered Data</h1></center>
<h1>
<a href="home">HOME</a>
</h1>

<script type="text/javascript">
function AddStudent()
{
	document.fn.action="Register.jsp";
	document.fn.submit();
}

function DeleteStudent()
{
	document.fn.action="delete";
	document.fn.submit();
}

function EditStudent()
{
	document.fn.action="edit";
	document.fn.submit();
}

</script>
</head>
<body>
	
<form name="fn">
<table border="1" align="center">
<th>Sr No</th>
<th>Student id</th>
<th>Name</th>
<th>uname</th>
<th>Password</th>
<th>Mobile no</th>


<tr>
 <c:forEach items="${data}" var="user">
<br>
<td><input type="radio" name="sid" value="${user.sid}"></td>
<td>${user.sid}</td>
<td>${user.name}</td>
<td>${user.uname}</td>
<td>${user.password}</td>
<td>${user.mobile}</td>


</tr>
</c:forEach>
</table>

<table border="2" align="center">
<tr>
<td><input type="button" value="ADD" onclick="AddStudent()"></td>
<td><input type="button" value="EDIT" onclick="EditStudent()"></td>
<td><input type="button" value="DELETE" onclick="DeleteStudent()"></td>
</tr>

</table>
</form>

</body>
</html>