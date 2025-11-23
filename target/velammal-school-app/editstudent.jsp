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
<form action="editstudent" method="post">

<div>
<label>	Roll Number</label>
<input type ="text" name="rollNumber" readonly="readonly" value=${obj.rollNumber}>
</div>

<div>
<label>First Name</label>
<input type ="text" name="firstName" value=${obj.firstName}>
</div>

<div>
<label>Date of Birth</label>
<input type ="date" name="dateOfBirth" value=${obj.dateOfBirth}>
</div>

<div>
<label>Mark Scored</label>
<input type ="text" name="markScored" value=${obj.markScored}>
</div>

<input type="submit" value="Update">
</form>


</body>
</html>