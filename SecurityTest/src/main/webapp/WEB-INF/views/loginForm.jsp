<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Security Custom LoginForm</title>
</head>
<body>
	<h1>LOGIN</h1>
	<hr/>
	
	<h3><c:out value="${error }"/></h3>		<!-- 에러 발생 시, 출력할 메세지 -->
	<h3><c:out value="${logout }"/></h3>	<!-- 로그아웃 시, 출력할 메세지 -->

	<!-- security를 적용 후 데이터를 전송 시, csrfInput으로 시큐리티 토큰을 전송해야한다. -->	
	<form action="/login" method="post">
		아이디 : <input type="text" name="username"/><br/>
		비밀번호 : <input type="text" name="password"/><br/>
		<input type="checkbox" name="remember-me"/> Remember-Me<br/>
		<input type="submit" value="로그인"/>
		<sec:csrfInput/>
	</form>
</body>
</html>














