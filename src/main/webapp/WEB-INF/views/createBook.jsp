<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: administrator
  Date: 06.01.2020
  Time: 02:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form name="book" action="/addBook" method="post">
    <p>Isbn</p>
    <input title="Isbn" type="text" name="isbn">
    <p>Name</p>
    <input title="Name" type="text" name="name">
    <p>Author</p>
    <input title="Author" type="text" name="author">
    <p>Book reader</p>
    <input title="Book reader" type="text" name="bookReader">
    <input type="submit" value="OK">
<br>
<a href="/bookslist">Back</a>
</body>
</html>
