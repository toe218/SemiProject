<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원탈퇴</h1>
<form action="./memberOutAction.tb">
<table border="1" algin="center">
<tr><td>탈퇴사유를 간략히 적어주세요</td></tr>
<tr><td><textarea cols="30" rows="5"></textarea></td></tr>
<tr><td><input type="submit" value="탈퇴"></td></tr>

</table>

</form>
<hr>
<center><a href = "./mypageMain.tb">마이페이지로 이동</a></center>
<center><a href = "./main.tb">메인으로 이동</a></center>
</body>
</html>