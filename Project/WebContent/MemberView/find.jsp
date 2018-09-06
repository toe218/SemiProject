<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center><h1>ID&비밀번호찾기</h1></center>

<form action="./idFind.tb" method="post" name="frmId">
<table border="1" align="center">
	<tr align="center"><td>ID찾기</td></tr>
	<tr><td>가입시 입력한 이메일 <input type="text" name="memberEmail"></td></tr>
	<tr align="center"><td><input type="submit" value="찾기"></td></tr>

</table>

</form> 
<br/>
<br/>
<br/>
<form action="#" method="post" name="frmPass">
<table border="1" align="center">
	<tr align="center"><td>비밀번호</td></tr>
	<tr><td>가입시 입력한 이메일 <input type="text"></td></tr>
	<tr align="center"><td><a href ="#">찾기</a></td></tr>

</table>

</form> 

</body>
</html>