<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색 페이지 search.jsp</title>
</head>
<body>
	<center>
	<h1>검색 페이지</h1>
	<br/>
	<h3>상품명으로 검색</h3>
	<form action="./searchListAction.tb" method="post">
		상품명 : <input type="text" name="name">
		<input type="submit" value="검색">
	</form>
	<h3>상품내용으로 검색</h3>
	<form action="./detailSearch.tb" method="post">
		상품내용 : <input type="text" name="detail">
		<input type="submit" value="검색">
	</form>
	<br/><br/>
	<a href="./main.tb">메인페이지로 이동</a>
	</center>	
</body>
</html>