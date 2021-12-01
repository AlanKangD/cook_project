<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.mainTable {
	margin: auto;
}

.mainTable td {
	text-align: center;
}

.name {
	text-align: right;
}

.a{ margin-right: 200px;}


</style>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="wrap content">
		<div class="a">
			<table class="mainTable">
				<tr>
					<td>
						<h3>
							내 사전에 불가능은 없다.<br> 불가능은 소극적인 자의 환영이며<br> 비겁한 자의 도피처 이다.<br>
						</h3>
					</td>
				</tr>
				<tr>
					<td>
						<h3 class="name">- 나폴레옹</h3>
					</td>
				</tr>
			</table>
		</div>
		<div class="b">
			<form action="${contextPath }/member/login" method="post">
						<div>	
							<input type="text" name="id" placeholder="아이디"><br>
							<input type="password" name="password" placeholder="비밀번호">		
						</div>			
						<div><button type="submit" class="button">로그인</button></div><br>
				<%-- 		<input type="checkbox" name="autoLogin">로그인 유지 --%>
					</form>
 					<a href="${contextPath }/member/registerForm">회원가입으로 이동 </a>
		</div>
	</div>
	<jsp:include page="footer.jsp" />

</body>
</html>
