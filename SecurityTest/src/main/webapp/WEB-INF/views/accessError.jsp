<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Access Denied Page</title>
</head>
<body>
	<h3>Access Denied</h3>
	<h2>${SPRING_SECURITY_403_EXCEPTION.message }</h2>
	<h2>${msg }</h2>
</body>
</html>