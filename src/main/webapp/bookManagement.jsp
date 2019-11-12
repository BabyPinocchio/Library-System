<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
	<head>
		 <meta charset="utf-8">
		 <title>Library Management System</title>
		 <link rel="stylesheet" href="/css/bookmanagement.css">
		 	<!-- 后端如何和前端通信,把后端的添加成功或者失败的消息传给前端 -->
			 <script>
		    	function confirmDialog(){
					alert("Do you want to delete this book? ")
		    	}
		    </script> 
	</head>
	
	<body>
		<ul>
		  <li><a href="/">Home</a></li>
		  <li><a href="/managerIndex">Manager Index</a></li>
		  <li><a href="/bookStore">Book Store</a></li>
		</ul>
		<h1 class="pagetitle">Book Management for Managers</h1>
		<form action="/bookManagement/addBook" method="post">   <!-- 注意这里的method应该是post，不能是get -->
			<div class="info1">
				<table class="tb">
				    <tr>
				        <td>Book Name: </td>
				        <td><input type="text" class="question2" name="bookName" placeholder="Please input book name"></td>
				    </tr>
				    <tr>
				        <td>Book Price: </td>
				        <td><input type="text" class="question2" name="price" placeholder="Please input price"></td>
				    </tr>
				    <tr>
				        <td>Book Number: </td>
				        <td><input type="text" class="question2" name="num" placeholder="Please input number"></td>
				    </tr>
				</table>
			  <input type="submit" value="Add" class="btn">
			</div>
		</form>
		<form action="/bookManagement/updateBook" method="post">   <!-- 注意这里的method应该是post，不能是get -->
			<div class="info2">
				<table class="tb">
				    <tr>
				        <td>Book Name: </td>
				        <td><input type="text" class="question2" name="bookName" placeholder="Please input book name"></td>
				    </tr>
				    <tr>
				        <td>Change Number: </td>
				        <td><input type="text" class="question2" name="number" placeholder="Please input number"></td>
				    </tr>
				</table>
			  <input type="submit" value="Update" class="btn">
			</div>
		</form>
		<form action="/bookManagement/deleteBook" method="post">   <!-- 注意这里的method应该是post，不能是get -->
			<div class="info3">
				<table class="tb">
				    <tr>
				        <td>Book Name: </td>
				        <td><input type="text" class="question2" name="bookName" placeholder="Please input book name"></td>
				    </tr>
				</table>
			  <input type="submit" value="Delete" class="btn" onclick="confirmDialog()">
			</div>
		</form>
	</body>
</html>