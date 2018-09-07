<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<% String id = (String)session.getAttribute("id"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요일별 판매 랭킹</title>
<style type='text/css'>
@import url("Test.css");
</style>
<link rel="stylesheet" type="text/css" href="Test.css" />
</head>
<body>



<div id="main2">

<div id="main4">
<a href ="./QnaBoardList.bb"><img src="MemberView/images/askicon.png" width="20" height="20"> Q & A</a>&nbsp;
<a href ="./ReviewList.re"><img src="MemberView/images/reviewicon.png" width="20" height="20"> 후기게시판</a> &nbsp;
<a href ="./RankingList.ra"><img src="MemberView/images/rankicon.png" width="20" height="20"> 랭킹</a>&nbsp;
<a href ="./GoodsList.go"><img src="MemberView/images/goodsicon.png" width="20" height="20"> 상품</a>&nbsp;
<a href ="./search.tb"><img src="MemberView/images/searchicon.jpg" width="20" height="20"> 검색</a>
</div>

<div id="main1" align="center"><a href="./main.tb">Real.T.B.</a></div>

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

<a href="./adminMain.tb"> 관리자 페이지 </a> &nbsp;&nbsp;

<%} %>

<a href="logout.tb">로그아웃</a></p>



<%
	}
 %>

<div id="todayRank">
<p class="todayRank" align="center" margin="1000px">Today's</p>
<p align="center">Rank In R.T.B</p>
</div>




<% if(false){ %>

<h1 align="center">상품이 존재하지 않습니다.</h1>

<% }else{ %>

<!-- 
<a href="RankingSell.ra"><img src="RankingView/images/sale.png">
<font size="5">판매 랭킹</font></a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="RankingClick.ra"><img src="RankingView/images/click.png">
<font size="5">클릭수 랭킹</font></a>
 -->

<center margin="2000px"><font-color="black">Real Rank In <br/>Real.T.B.</font-color></center>

<center>
<div id="rankimage1">
<a href="RankingSell.ra">
<img src="RankingView/images/sale.png"></a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="RankingClick.ra">
<img src="RankingView/images/click.png"></a>
</div>
</center>

<center>
<div id="rankimage2">
<a href="RankingSell.ra">
<font size="5">판매 랭킹 보러 가기</font></a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="RankingClick.ra">
<font size="5">조회 랭킹 보러 가기</font></a></a>
</div>
</center>


<a href="main.tb">메인으로</a>

<!-- 
<div align="center">
<img src="RankingView/images/salesClick.png" usemap="#Map" border="0">
<map name="Map">
<area shape="rect" coords="19,17,371,337" href="RankingSell.ra" target="_blank" alt="판매">
<area shape="rect" coords="394,19,693,348" href="RankingClick.ra" target="_blank" alt="클릭">
</map>
</div>

<div id="cellC" align="center">
<a href="RankingSell.ra"><font size="10">판매 랭킹</font></a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="RankingClick.ra"><font size="10">클릭수 랭킹</font></a>
</div>
 -->

<% } %>

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