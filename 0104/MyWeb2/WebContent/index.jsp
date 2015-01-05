<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:out value="Hello World!"/>
<p>It is now: <fmt:formatDate value="<%=new java.util.Date()%>" pattern="E, yyyy-MM-dd h:mm:ss a" /></p>
I am here! 
</body>
</html>