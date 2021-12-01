<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
createForm  이다 
	<form id="fo" action="register" method="post">
						<div class="mainSec-a">								
							<input type="text"  name="id" placeholder="input id"><br>
							<input type="password" name="password" placeholder="input password"><br>			
							<input type="text" name="email" placeholder="input email"><br>			
							<input type="text" name="address" placeholder="(optional) address"><br>								
							<br><br>	
						</div>				
						<div><button class="button" >회원가입</button></div><br>					
					</form>	
</body>
</html>