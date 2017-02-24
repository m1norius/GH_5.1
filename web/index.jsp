<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<form action="servlet" method="post">
    Input name:<br>

    <input type="text" class="txtname" name="name"><br>

    Message:<br>
    <textarea name="message" rows="10" cols="20"></textarea>
    <br>
    Rating:
    <select name="rating">
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
    </select>
    <br>
    <br>
    <input type="submit" value="Submit">
</form>
<br>

<b>Entries book:</b><br>

<c:forEach var="entry" items="${enumBook}">
    <br>
    <b>Date:</b> <c:out value="${entry.key}"/>
    <br>
    <b>Name:</b> <c:out value="${entry.value['name']}"/>
    <br>
    <b> Message:</b> <c:out value="${entry.value['message']}"/>
    <br>
    <b>Rating:</b> <c:out value="${entry.value['rating']}"/>
    <br>
</c:forEach>

<%--${fn:length(enumBook)}--%>
</body>
</html>