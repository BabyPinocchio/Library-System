<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
	<head>
		 <meta charset="utf-8">
		 <title>Library Management System</title>
		 <link rel="stylesheet" href="css/userSignup.css">
	</head>
	
	<body>
		<ul>
		  <li><a href="/">Home</a></li>
		  <li><a href="/userLogin">UserLogin</a></li>
		</ul>
		<h1 class="pagetitle">Manager Login Page</h1>
		<form action="/bookManagement" method="post">
			<div class="info">
				<table  class="tb">
				    <tr>
				        <td>Manager Name : </td>
				        <td><input type="text" class="question2" name="managerName" placeholder="Please input manager name"></td>
				    </tr>
				    <tr>
				        <td>Password :   </td>
				        <td><input type="password" class="question2" name="password" placeholder="Please input password"></td>
				    </tr>
				</table>
			  <input type="submit" value="Login" class="btn">
			</div>
		</form>
	</body>
</html>