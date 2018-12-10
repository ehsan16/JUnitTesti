<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Artists</title>

</head>
<body>
<h1>Artistit</h1>
<ul>
 <c:forEach items="${artists}" var="artist">
 <li><a 
 href="ListaaArtisti?id=<c:out value="${ artist.getId() } " /> "><c:out 
 						value="${ artist.getName()  }" /></a></li>
 						</c:forEach>
</ul>


</body>
</html>