<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% String id = (String)session.getAttribute("id"); %>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<style type='text/css'>
@import url("Test.css");
</style>
<link rel="stylesheet" type="text/css" href="Test.css" />

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


<div id="main2">

<div id="main4">
<a href ="./QnaBoardList.bb"><img src="MemberView/images/askicon.png" width="20" height="20"> 문의게시판</a>&nbsp;
<a href ="./ReviewList.re"><img src="MemberView/images/reviewicon.png" width="20" height="20"> 후기게시판</a> &nbsp;
<a href ="./RankingList.ra"><img src="MemberView/images/rankicon.png" width="20" height="20"> 랭킹</a>&nbsp;
<a href ="./GoodsList.go"><img src="MemberView/images/goodsicon.png" width="20" height="20"> 상품</a>&nbsp;
 <a href ="./search.tb"><img src="MemberView/images/searchicon.jpg" width="20" height="20"> 검색</a>
</div>

<div id="main1" align="center"><a href="./main.tb">Real Total Beautyshop</a></div>

<div id="main3"> <!-- 코드 수정 : p-> div -->
<a href ="./login.tb"><img src="MemberView/images/loginicon.png" width="15" height="15"> 로그인</a> &nbsp;
<a href ="./mypageMain.tb"><img src="MemberView/images/myicon.png" width="15" height="15"> 마이페이지</a>&nbsp;
<a href ="./intro.tb"><img src="MemberView/images/introicon.png" width="15" height="15"> 회사소개</a> &nbsp;
</div>
</div>



<%
	if (session.getAttribute("id") != null) {
%>
<p align="right"><b><%= id %></b> 님 반갑습니다! &nbsp;&nbsp;

<% if (id!=null && id.equals("admin")) { %>

<a href="./adminMain.tb"> <img src="MemberView/images/adminicon.png" width="15" height="15"> 관리자 페이지 </a> &nbsp;&nbsp;

<%} %>

<a href="logout.tb"><img src="MemberView/images/logouticon.png" width="15" height="15"> 로그아웃</a>  &nbsp;&nbsp;</p>


<%
	}
 %>


<br>
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
	
	
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	
	
	<footer class="foot" align="center"; text-align="center";> 
	<address> 사업자등록번호 : 221-99-50000 | 대표이사:환우영 | 사업자등록정보 확인<br/>
	주소 : 충남 천안시 동남구 삼룡동 306-1 | 대표전화 : 1111-8888 | 팩스 : 033-888-8888 |
	이메일 : <a href="mailto:dlwprmaks@tlfhtlfh.com">wlqdp@rlfrjdo.com</a>.<br> 
	</address> 
	<small>Copyright &copy; 2018 Real.T.B.</small> 
	</footer>


	
	
</body>
</html>