<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String id = (String)session.getAttribute("id"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	if (id != null) {
%>
<center><h1>마이페이지 메인</h1></center>

<p align="right"><b><%= id %></b> 님 반갑습니다! &nbsp;&nbsp;<a href="logout.tb">로그아웃</a></p>



<hr/>
<ul>
		<li><a href ="./GoodCartList.go">장바구니</a></li>
		<li><a href ="./wishList.tb">관심상품</a></li>
		<li><a href ="./myOrders.tb">주문내역</a></li>
		<li><a href ="./pointMoney.tb">적립금</a></li>
		<li><a href ="./modifyView.tb">정보수정</a></li>
		<li><a href ="./memberOut.tb">회원탈퇴</a></li>
</ul>
<hr/>
<%
	} else {
 %>
 	<br><br><br>
 	<div align="center">
 
 	<p>로그인이 필요한 페이지 입니다.</p>
 	
 	<a href = "./login.tb">로그인</a>
 
 	</div>
 	<br>
 <%}  %>
<center><a href = "./main.tb">메인페이지로 이동</a></center>
</body>
</html>