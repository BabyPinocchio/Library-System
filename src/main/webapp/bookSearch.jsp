<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.demo.entity.Book" %>
<%@ page import="java.util.*" %>
<!doctype html>
<html>
	<head>
		 <meta charset="utf-8">
		 <title>Library Management System</title>
		 <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
		 <link rel="stylesheet" href="/css/bookstore.css">
		 <script>
         	function confirmOrder(bookId) {
         		/* console.log(bookId) */
         		event.preventDefault();
         		confirm("Do you want to borrow this book? ")
         		$.ajax({
                    url:"/bookStore/bookSearch/borrowBook?bookId="+bookId,
                    method: 'POST',
                    complete: function(msg) {
                        history.go(0);
                    }
                })
            }
         </script>
	</head>
	
	<body>
		<ul>
		  <li><a href="/">Home</a></li>
		  <li><a href="/bookStore">Book Store</a></li>
		  <li><a href="/borrowRecord">Borrow Record</a></li>
		</ul>
		<h2 class="pagetitle">Book Store</h2>
		<div class="info">
        	<table class="tb">
            	<thead>
                	<tr>
                    	<th>Book Name</th>
                        <th>Book Number</th>
                        <th>Book Price</th>
                        <th>Borrow</th>
                    </tr>
             	</thead>
                <tbody>
                	<%
						Book content = (Book) session.getAttribute("book");
                        if(content!=null) {
	                    	int bookId = content.getBookId();
	                        String bookName = content.getBookName();
	                        int number = content.getNum();
	                        double price = content.getPrice();
                    %>
                    <tr>
                    	<td><%=bookName%></td>
                        <td><%=number%></td>
                        <td><%=price%></td>
                        <td><button onclick="confirmOrder(<%=bookId%>)">Borrow</button></td>
                    </tr>
                    <%
                    	 }
                    %>
           		</tbody>
        	</table>
    	</div>
	</body>
</html>