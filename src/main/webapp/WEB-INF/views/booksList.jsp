<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="ru.library.entity.Book" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>

<html>
<head>
    <title>Books list</title>
</head>
<body>
<%
    List<Book> list = (List) request.getAttribute("books");
%>

<%
    for (Book u : list) {
%>

<table border = "1">
    <tr>
        <th>Id</th>
        <th>Name book</th>
        <th>ISBN</th>
        <th>Author</th>
        <th>Book reader</th>
    </tr>
    <tr>
        <td><%=u.getId()%></td>
        <td><%=u.getName()%></td>
        <td><%=u.getIsbn()%></td>
        <td><%=u.getAuthor()%></td>
        <td><%=u.getBookReader()%></td>
        <td><a href="/delete/<c:out value='<%=u.getId()%>' />">Delete</a></td>
        <td><a href="/update/<c:out value='<%=u.getId()%>' />">Update</a></td>
    </tr>
</table>
<%
    }
%>
<a href="/addBook">Create book</a>
<br>
<a href="/">Back</a>
</body>
</html>