<%--
  Created by IntelliJ IDEA.
  User: administrator
  Date: 06.01.2020
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ru.library.entity.Book" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit book</h1>

<form name="book" action="/updateBook" method="post">
    <p>Id</p>
    <input title="Id" type="text" name="id" value="${book.id}">
    <p>Isbn</p>
    <input title="Isbn" type="text" name="isbn" value="${book.isbn}">
    <p>Name</p>
    <input title="Name" type="text" name="name" value="${book.name}">
    <p>Author</p>
    <input title="Author" type="text" name="author" value="${book.author}">
    <p>Book reader</p>
    <input title="Author" type="text" name="bookReader" value="${book.bookReader}">
    <input type="submit" value="OK">
</form>

<br>
<a href="/books">Back</a>

</body>
</html>
