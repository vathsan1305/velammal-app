<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="entity.*" import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Table</title>

<style type="text/css">
  body {
    font-family: Arial, sans-serif;
  }

  h1 {
    text-align: center;
  }

  table {
    margin: 0 auto; /* centers the table horizontally */
    border-collapse: collapse;
    width: 70%;
  }

  th, td {
    border: 1px solid #999;
    padding: 10px;
    text-align: center;
  }

  th {
    background-color: white;
  }
</style>

</head>
<body>
<%@ include file="header.html" %>
<h1>${title}</h1>

<table>
  <tr>
    <th>Roll Number</th>
    <th>First Name</th>
    <th>Date Of Birth</th>
    <th>Mark Scored</th>
    <th>Edit Action</th>
    <th>Delete Action</th>
  </tr>

<%
  List<Student> students = (List<Student>) request.getAttribute("list");
  for (Student eachStudent : students) {
%>
  <tr>
    <td><%= eachStudent.getRollNumber() %></td>
    <td><%= eachStudent.getFirstName() %></td>
    <td><%= eachStudent.getDateOfBirth() %></td>
    <td><%= eachStudent.getMarkScored() %></td>
    <td><a href="editstudent?id=<%=eachStudent.getRollNumber()%>">Edit</a></td>
    <td><a href="deletestudent?id=<%=eachStudent.getRollNumber() %>">Delete</a></td>
    
  </tr>
<%
  }
%>

</table>

</body>
</html>
