<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.demo.entity.Book" %>
<%@ page import="java.util.ArrayList" %>
<!doctype html>
<html>
	<head>
		 <meta charset="utf-8">
		 <title>Library Management System</title>
		 <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
		 <link rel="stylesheet" href="css/bookstore.css">
		 <script>
         	function confirmOrder(bookId) {
         		/* console.log(bookId) */
         		event.preventDefault();
         		alert("Do you want to borrow this book? ")
         		$.ajax({
                    url:"/bookStore/borrowBook?bookId="+bookId,
                    method: 'POST',
                    complete: function(msg) {
                        history.go(0);
                    }
                })
         		/* var bookParams = {
         			bookname:bookName
				};
         		alert("Do you want to borrow this book? ")
            	$.ajax({
                	url:"/bookStore/borrowBook?bookname="+encodeURIComponent(bookName),
                	method: 'POST',
                	data : bookParams,
                	dataType:'json',//接受数据格式
                	success : function(data) {

                	},

                	failure : function(data) {

                	},
                    complete: function(msg) {
                    	history.go(0);
                    } 
                }) */
            }
        </script>
	</head>
	
	<body>
		<ul>
		  <li><a href="/">Home</a></li>
		  <li><a href="/bookIndex">Book Index Page</a></li>
		  <li><a href="/borrowRecord">Borrow Record</a></li>
		  <li><a href="/userLogin">User Login Page</a></li>
		  <li><a href="/managerIndex">Manager Login Page</a></li>
		</ul>
		<h2 class="pagetitle">Book Store</h2>
		<form action="/bookStore" method="post">   <!-- 注意这里的method应该是post，不能是get -->
			<div class="info">
				<!-- <div>
					<input type="text" class="" name="bookName" placeholder="Please input book name" required><br>
					<button>Search Book</button>
				</div> -->
				<input type="submit" value="Show All Books" >
                <table class="tb">
                	<thead>
                    	<tr>
                        	<th>Book Name</th>
                            <th>Book Number</th>
                            <th>Book Price</th>
                            <th>Situation</th>
                       </tr>
                    </thead>
                    <tbody>
                        <%
							ArrayList<Book> contents = (ArrayList<Book>) session.getAttribute("books");
                            if(contents!=null) {
	                            for(Book content:contents) {
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
                            }
                        %>
                      </tbody>
                </table>
            </div>
		</form>
	</body>
</html>