<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.html" %>
<form action="addstudent" method="post">

<div>
<label>	Roll Number</label>
<input type ="text" name="rollNumber" required/>
</div>

<div>
<label>First Name</label>
<input type ="text" name="firstName" required/>
</div>

<div>
<label>Date of Birth</label>
<input type ="date" name="dateOfBirth" required/>
</div>

<div>
<label>Mark Scored</label>
<input type ="text" name="markScored" required/>
</div>

<input type="submit" value="Add">
</form>
</body>
</html>