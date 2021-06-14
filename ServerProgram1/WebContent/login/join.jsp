<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

<script>
	$(document).ready(function(){
		const f1 = $('#f1');
		const id1 = $('#id1');
		const name1 = $('#name1');
		f1.submit(function(event){
			if (id1.val() == '' || name1.val()=='') {
				alert("아이디와 이름은 필수입니다.")
				event.preventDefault();
				return false;
			}
		})		
	})
</script>
</script>
</head>
<body>
<h1>회원가입 폼</h1>
	<form id="f1" name="f1" method="post" action="join.do">
		아이디&nbsp; <input type="text" id="id1" name="id1">
		이름&nbsp; <input type="text" id="name1" name="name1">
		<br>
		<button>회원가입</button>&nbsp;
	</form>
	<button onclick="location.href='../login.jsp'">돌아가기</button>
</body>
</html>