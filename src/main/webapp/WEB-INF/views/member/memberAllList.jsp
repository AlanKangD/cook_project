<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="../default/header.jsp"/>
<div align="center">
	<table border="1" >
		<tr>
			<th>이름</th> <th>비밀번호</th> <th>이메일</th> <th>주소</th> 
		</tr>
		<c:forEach var="memberList" items="${memberAllList }">
			<tr>
				<td><a href="${contextPath }/member/contentView?id=${memberList.id }">${memberList.id }</a></td> 
				<td>${memberList.password }</td> 
				<td>${memberList.email }</td> 
				<td>${memberList.address }</td>
			</tr>
		</c:forEach>
	</table>
</div>


<c:import url="../default/footer.jsp"/>

</body>
</html>