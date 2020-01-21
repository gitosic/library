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
<h1>Book info</h1>
<%
    List<Book> list = (List) request.getAttribute("books");
%>

<%
    /*for (Book u : list) {*/
    /*list.get(1);*/
%>

<%--<table border = "1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Isbn</th>
        <th>Author</th>
    </tr>
    <tr>
        <td><a href="/book/<%=u.getId()%>"><%=u.getId()%></a></td>
        <td><%=u.getName()%></td>
        <td><%=u.getIsbn()%></td>
        <td><%=u.getAuthor()%></td>
        <td><a href="/delete/<c:out value='<%=u.getId()%>' />">Delete</a></td>
        <td><a href="/update/<c:out value='<%=u.getId()%>' />">Update</a></td>
    </tr>
</table>--%>
<br>
<a href="/books">Back</a>

<%
    /*}*/
%>
</body>
</html>
