<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Application </title>
</head>
<body>
<form action = "/FileUploader/bansal/uploading/upload" method="post" enctype="multipart/form-data" >
Upload File: <input type="file" name="file" value="Choose File"/><br/>
<input type="submit" value="upload"/>
</form>
</body>
</html>