<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

.a {
	margin-right: 200px;
}
</style>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	
	function ajax1() {
		var id = $("#id").val()
		var password = $("#password").val()
		var form = {
			id : id,
			password : password
		}
		console.log(form)

		$.ajax({ // 함수명을 ajax1로 바꾸고 form을 삭제, 컨트롤러에 벨류값 " "씌워줌 
			url : "member/login",
			type : "post",
			data : JSON.stringify(form),
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			success : function(data) {
				console.log(data)
				if (data.result == false) {
					alert("아이디와 비밀번호를 다시 확인해 주세요")
				} else {
					$("#divHide").hide();
					let html = ""
					html += data.result + "님, 환영합니다!<br>";
					html += "<a href='${contextPath }/member/logout'>로그아웃</a>";
			
					$("#success").html(html)
					//로그아웃 
				}
			},
			error : function() {
				alert("문제 발생!")
			}
		})
	}
</script>
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
			<span id="success">
				<c:if test="${loginUser != null }">
	 						${loginUser }님, 환영합니다! 			<br>
					<a href="${contextPath }/member/logout">로그아웃</a>
				</c:if>
			</span>
			<c:if test="${loginUser == null }">
				<div id="divHide">
					<input type="text" name="id" id="id" placeholder="아이디"><br>
					<input type="password" name="password" id="password"
						placeholder="비밀번호">
					<button onclick="ajax1()">로그인</button>
					<br>
					<%-- 		<input type="checkbox" name="autoLogin">로그인 유지 --%>
					<a href="${contextPath }/member/registerForm">회원가입</a>
				</div>
			</c:if>
		</div>
	</div>
	<jsp:include page="footer.jsp" />

</body>
</html>
