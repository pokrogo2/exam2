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
		const f = $('#f');
		const id = $('#id');
		const name = $('#name');
		f.submit(function(event){
			if (id.val() == '' || name.val()=='') {
				alert("아이디와 이름은 필수입니다.")
				event.preventDefault();
				return false;
			}
		})		
	})
</script>
</head>
<body>
	<div class="container">
			<h3>회원 관리 프로그램</h3>
		<form id="f" name="f" method="post" action="loginPage.do"><br>
			<input type="text" id="id" name="id"><br>
			<input type="text" id="name" name="name"><br>
			<button>로그인</button>			
			<a	href="login/join.jsp">회원가입</a>
		</form>
	
	</div>
</body>
</html>