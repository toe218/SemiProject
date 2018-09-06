<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  String foundId = (String)request.getAttribute("id"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center><h1>ID&비밀번호찾기결과</h1></center>

찾으시는 ID는 <%=foundId %>("id") %>입니다.




	<center><a href = "./main.tb">메인페이지로 이동</a></center>
</body>
</html>