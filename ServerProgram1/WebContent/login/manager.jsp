<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

<script>
	
	</script>
</head>
<body>
<h1>회원 관리 시스템</h1>
<a href="">로그아웃</a>
<hr>
	<form id="f3" name="f3" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td>이름</td>
				<td>등급</td>
				<td>포인트</td>
			</tr>
			<tr>
				<td>${login.id }</td>
			
				<td><input type="text" value="${login.name }" id="name3" name="name3"></td>
				<td>${login.grade }</td>
				<td><input type="text" value="${login.point }"id="point3" name="point3"></td>
			</tr>
		</table>
		<input type="hidden" id="id3" name="id3" value="${login.id}">
		<button formaction="update.do">수정하기</button><button formaction="delete.do">탈퇴하기</button>
	</form>
</body>
</html>