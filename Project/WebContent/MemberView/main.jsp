<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% String id = (String)session.getAttribute("id"); %>
<!DOCTYPE html>
<html>
<head>
<style type='text/css'>
@import url("Test.css");
</style>
<link rel="stylesheet" type="text/css" href="../Test.css" />

<meta charset="UTF-8">
<title>메인페이지 main.jsp</title>
</head>
<body>
<%
	Cookie[] cookies = request.getCookies();
	String cValue ="0";
	int intValue = 0;
	
	if (cookies != null && cookies.length >0) {
		for (int i=0; i< cookies.length; i++) {
			if (cookies[i].getName().equals("counter")){
				cValue = cookies[i].getValue();
			}
		}
		
	}
	intValue = Integer.parseInt(cValue) + 1;
	cValue = Integer.toString(intValue);
	
	Cookie nCookie = new Cookie("counter", cValue);
	nCookie.setMaxAge(60*60*24);
	response.addCookie(nCookie);
	


%>

<h1></h1>

<hr>
<div id="main2">

<div id="main4">
<a href ="./QnaBoardList.bb">문의게시판</a>&nbsp;
<a href ="./ReviewList.re">후기게시판</a> &nbsp;
<a href ="./RankingList.ra">랭킹</a>&nbsp;
<a href ="./GoodsList.go">상품</a>&nbsp;
<a href ="./search.tb">검색</a> 
</div>

<div id="main1" align="center">Real.T.B</div>

<div id="main3"> <!-- 코드 수정 : p-> div -->
<a href ="./login.tb">로그인</a> &nbsp;
<a href ="./mypageMain.tb">마이페이지</a>&nbsp;
<a href ="./intro.tb">회사소개</a> &nbsp;
</div>
</div>



<%
	if (session.getAttribute("id") != null) {
%>
<p align="right"><b><%= id %></b> 님 반갑습니다! &nbsp;&nbsp;

<% if (id!=null && id.equals("admin")) { %>

<a href="./adminMain.tb"> 관리자 페이지 </a> &nbsp;&nbsp;

<%} %>

<a href="logout.tb">로그아웃</a></p>


<%
	}
 %>


<hr>
<p align="right"> 오늘 <b><%= cValue %> </b>번째 방문자입니다. </p>

<!--  
<div border=1>
	<dl>
		<dt><h3><a href ="./GoodsList.go">상품</a></h3></dt>
		<dd><a href ="#">TOP</a></dd>
		<dd><a href ="#">BOTTOM</a></dd>
		<dd><a href ="#">OUTER</a></dd>
		<dd><a href ="#">INNER</a></dd>
		
	</dl> 
	<dl>
		<dt><h3><a href ="#">잡화</a></h3></dt>
		<dd><a href ="#">신발</a></dd>
		<dd><a href ="#">가방</a></dd>
		<dd><a href ="#">액세서리</a></dd>
	</dl>
	<dl>
		<dt><h3><a href ="#">화장품</a></h3></dt>
		<dd><a href ="#">기초</a></dd>
		<dd><a href ="#">메이크업</a></dd>
		<dd><a href ="#">향수</a></dd>
		<dd><a href ="#">헤어</a></dd>	
	</dl>
</div>
-->	

<div id="slide">
	<input type="radio" name="pos" id="pos1" checked>
	<input type="radio" name="pos" id="pos2">
	<input type="radio" name="pos" id="pos3">
	<input type="radio" name="pos" id="pos4">
	<input type="radio" name="pos" id="pos5">
	<ul id="ul" align="center" width=80%; height=300px;>
		<li><img src="MemberView\images\and3.jpg"></li>
		<li><img src="MemberView\images\and1.jpg"></li>
		<li><img src="MemberView\images\and2.jpg"></li>
		<li><img src="MemberView\images\and5.jpg"></li>
		<li><img src="MemberView\images\and4.jpg"></li>	
	</ul>
	<p class="pos">
		<label for="pos1"></label>
		<label for="pos2"></label>
		<label for="pos3"></label>
		<label for="pos4"></label>
		<label for="pos5"></label>
	</p>
</div>

<!-- 
	<hr>
	<h1>환영합니다 웰컴 이랏샤이마세</h1>
	 -->
	
	
	
	
</body>
</html>