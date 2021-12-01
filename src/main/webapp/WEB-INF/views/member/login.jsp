<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	로그인이다
	<form action="${contextPath }/member/login" method="post">
		<div>
			<input type="text" name="id" placeholder="아이디"><br> 
			<input type="password" name="password" placeholder="비밀번호">
		</div>
		<div>
			<button type="submit" class="button">로그인</button>
		</div>
		<br>
	</form>
	<a href="${contextPath }/member/registerForm">회원가입으로 이동 </a>
</body>
</html>