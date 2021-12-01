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
<c:import url="../default/header.jsp"/>
	<form id="fo" action="register" method="post">
						<div align=center>								
							<input type="text"  name="id" placeholder="input id"><br>
							<input type="password" name="password" placeholder="input password"><br>			
							<input type="text" name="email" placeholder="input email"><br>			
							<input type="text" name="address" placeholder="(optional) address"><br>								
							<br><br>										
							<button class="button" >회원가입</button>
					</div>					
					</form>	
					
<c:import url="../default/footer.jsp"/>
</body>
</html>