<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String id = (String)session.getAttribute("id"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회사소개 페이지 intro.jsp</title>
<style type='text/css'>
@import url("Test.css");
</style>
<link rel="stylesheet" type="text/css" href="Test.css" />

</head>
<body>




<div id="main2">

<div id="main4">
<a href ="./QnaBoardList.bb"><img src="MemberView/images/askicon.png" width="20" height="20"> 문의게시판</a>&nbsp;
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


	<center><h1>회사소개</h1></center>

<center><img src="IntroView/images/introBack.png" width="1500" height="400"></center>
	
	<div id="info" align="center">
	<br/>
	저희 쇼핑몰을 방문해 주셔서 감사드립니다. 저희 쇼핑몰은 회원제를 실시하고 있습니다.<br/> 
	처음 오신 분은 먼저 회원가입을 하신 후 이용하시길 바랍니다.<br/> 
	회원가입을 안 하시더라도 비회원의 자격으로 상품을 구입하실 수 있습니다.<br/>
	<br/>
	상품 주문방법<br/>
	1. 각 코너를 클릭하셔서 들어갑니다.<br/>
	2. "바로가기" 메뉴 또는 사진이나 상품명을 클릭하세요!<br/>
	3. "장바구니 담기"를 클릭하세요!<br/>
	4. "장바구니에 넣었습니다" 메시지가 나오면, 주문상품을 확인한 후 "주문버튼"을 클릭하세요!<br/>
	5. 주문버튼을 누르면, "주문서"가 나옵니다! 주문서를 작성 후 "주문"을 클릭하면 주문이 완료됩니다!<br/>
	<br/>
	전화<br/>
	주소 : 충남 천안시 동남구 삼룡동 306-1<br/>
	전화 : 1111-8888 <br/>
	메일 : wlqdp@rlfrjdo.com<br/>
	<br/>
	배송일<br/>
	배송 방법은 택배입니다.<br/>
	주문하신 날로부터 4 ~ 7일 안에 받을 수 있습니다.<br/>
	온라인 입금 시 입금 확인 후 4 ~ 7일<br/>
	신용카드 결제 시 주문 후 4 ~ 7일<br/>
	<br/>
	반품 안내<br/>
	고객의 변심에 의한 교환 및 반품이면 배송비는 소비자부담입니다.<br/>
	상품의 이상에 의한 교환 및 반품이면 배송비는 판매자부담입니다.<br/>
	문의 : 1661-2239<br/>
	<br/>
	개인정보 취급방침 <a href="#">[약관보기]</a>
	담당 : 잉야영<br/>
	전화 : 1661-2239<br/>
	메일 : lkjoibb@naver.com<br/>
	</div>



	<a href="./main.tb">메인페이지로 이동하기</a>	
	
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