<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>NOTICE REGISTER : access to admin</h3>
	
	<sec:authentication property="principal.member" var="member"/>
	<sec:authentication property="principal.member.userName" var="name"/>
	<sec:authentication property="principal.member.userId" var="id"/>
	<sec:authentication property="principal.member.userPw" var="pw"/>
	
	<p>${member }</p>
	<p>
		사용자명 : ${name }<br/>
		아이디 : ${id }<br/>
		비밀번호 : ${pw }<br/>
	</p>
	<br/>
	
	<p>
		<sec:authorize access="hasRole('ROLE_MEMBER')">
			역할명은 회원입니다!<br/>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			역할명은 관리자입니다!<br/>
		</sec:authorize>
	</p>
	
	<a href="/">HOME</a>
</body>
</html>