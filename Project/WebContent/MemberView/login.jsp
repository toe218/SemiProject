<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String id = (String)session.getAttribute("id"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function checkId(){
	if(!document.frm.memberId.value){
		alert("아이디를 입력하세요.");
		document.frm.memberId.focus();
		return false;
	}
	if(!document.frm.memberPass.value){
		alert("비밀번호를 입력하세요.");
		document.frm.memberPass.focus();
		return false;
	}
	document.frm.submit();
}
</script>
</head>
<body>
<% if (id == null)  {%>
	<h1>로그인 페이지</h1>
	
	<center><h3>로그인</h3></center>
	<form action = "./loginAction.tb" method="post" name ="frm" align="center">
	
	<table border="1" align="center">
		<tr><td colspan="2"> <input type = "text" size="35" name="memberId" placeholder="아이디"></td></tr>
		<tr><td colspan="2"> <input type = "password" size="35" name ="memberPass" placeholder="비밀번호"></td></tr>
		<tr><td colspan="2"> <a href="javascript:checkId();">로그인</a></td></tr>
		<tr>
			<td><a href ="./find.tb">ID&비밀번호찾기</a></td>
			<td><a href ="./terms.tb">회원가입</a></td>
		</tr>
	</table>
	
	</form>
	<br/>
<% 	} else {	%>
	<p align="center"><b><%= id %></b>님께서는 이미 로그인이 된 상태입니다. </p>

<%	} %>	
	<center><a href = "./main.tb">메인페이지로 이동</a>&nbsp;&nbsp;&nbsp;<a href="logout.tb">로그아웃</a></center>
</body>
</html>