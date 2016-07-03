<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="javax.servlet.http.*,java.util.List,java.util.ArrayList;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Library</title>
</head>
<body>
	<div id="status">
		<form action="/FileUploader/bansal/library-servlet/books"
			method="post">
			<input type="text" name="searchItem" value=""> <input
				type="submit">
		</form>
	</div>
	<div id="style">
		<%
			List<List<String>> books = (ArrayList<List<String>>) request.getAttribute("retrievedData");
			if (books != null) {
		%>
		<table border="1" style="width: 100%">
			<% for(List<String> row : books){%>
			<tr>
				<% for(String rowData : row){%>
				<td><%=rowData%></td>
				<%} %>
			</tr>
			<%} %>
		</table>
		<%
			}
		%>
	</div>
</body>
</html>