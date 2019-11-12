<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.demo.entity.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<!doctype html>
<html>
	<head>
		 <meta charset="utf-8">
		 <title>Library Management System</title>
		 <link rel="stylesheet" href="css/borrowrecord.css">
		 <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
		 <script>
         	function confirmOrder(relationId) {
         		/* console.log(bookId) */
         		event.preventDefault();
         		alert("Do you want to return this book? ")
         		$.ajax({
                    url:"/borrowRecord/returnBook?relationId="+relationId,
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
		  <li><a href="/bookIndex">Book Index Page</a></li>
		  <li><a href="/bookStore">Book Store Page</a></li>
		</ul>
		<h2 class="pagetitle">User Borrow Record</h2>
		<form action="/borrowRecord" method="post">   <!-- 注意这里的method应该是post，不能是get -->
			<div class="info">
				<input type="submit" value="Show Borrow Records" >
                <table class="tb">
                	<thead>
                    	<tr>
                        	<th>Book Name</th>
                            <th>Borrow Time</th>
                            <th>Return</th>
                       </tr>
                    </thead>
                    <tbody>
                        <%
                        ArrayList<Relation> contents = (ArrayList<Relation>) session.getAttribute("result");
                        if(contents!=null) {
                            for(Relation content:contents) {
                            	int relationId = content.getRelationId();
                            	String bookName = content.getBookName();
                                Date time = content.getTime();
								SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");  
								String date = formatter.format(time);  
                        %>
                        <tr>
                            <td><%=bookName%></td>
                            <td><%=date%></td>
                            <td><button onclick="confirmOrder(<%=relationId%>)">Return</button></td>
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