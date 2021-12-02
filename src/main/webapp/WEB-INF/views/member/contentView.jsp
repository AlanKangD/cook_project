<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	function deleteMem(){
		if (confirm("정말 삭제하시겠습니까?") == true){
			location.href="${contextPath}/member/deleteMem?id=${dto.id}";
		}else{
			return;
		}
	}
</script>
</head>
<body>
<c:import url="../default/header.jsp"/>
<div align="center">
	
	<form action="${contextPath }/member/modifyMem" method="post">
	<table border="1" >
		<tr>
			<th>이름</th>	<td><input type="text" name="id" value="${dto.id }" readonly="readonly"> </td>
		</tr> 
		<tr> 
			 <th>비밀번호</th> <td><input type="text" name="password" value="${dto.password}"></td>
		</tr>
		<tr>
			 <th>이메일</th> <td><input type="email" name="email" value="${dto.email }"></td>
		</tr>
		<tr>	 
			 <th>주소</th><td><input type="text" name="address" value="${dto.address }"></td>
		</tr>	
	</table>
	<br>
	<button type="submit">수정하기</button>	
	</form>
	<button onclick="deleteMem()">삭제하기</button>	
</div>


<c:import url="../default/footer.jsp"/>

</body>
</html>