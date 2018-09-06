<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	int goodsNumber = Integer.parseInt(request.getParameter("goodsNumber"));
	int qty = Integer.parseInt(request.getParameter("qty"));
	int goodMoney = Integer.parseInt(request.getParameter("goodMoney"));
	String goodsName = request.getParameter("goodsName");
	String goodsImage = request.getParameter("goodsImage");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

function deposit(){
	
	var totalMoney = <%=qty%>*<%=goodMoney%>; /* 서버 단의 데이터를 클라이언트 단으로 가져오는 방법 */
	var pay = prompt("금액을 입력해주세요. \n\n결제금액 : "+totalMoney ,"");
	
	
	if(totalMoney==pay){ /* var간의 비교는 equals가 아니라 ==으로 */
	
		alert("상품 결제 완료");
	
		frm.submit(); /* 함수이기 때문에 submit;이 아니라 submit();이라고 해야함 */
	
	}else{
		
		alert("정확한 금액을 입력해주세요");
	
		location.href="./GoodBuy.go?goodsNumber=<%=goodsNumber %>&qty=<%= qty%>&goodMoney=<%=goodMoney%>&goodsImage=<%= goodsImage%>&goodsName=<%= goodsName%>";
	}

}

</script>

</head>
<body>

<!-- 값을 하나 보낼때는 href="#?값"로 보내면 되지만(&을 쓰면 여러개도 가능), input값을 보내거나 복수의 값(hidden 추천)을 보낼때는 form에 있는 action으로 보내기 위해 submit을 활용-->

<form action = "GoodPay.go" name = "frm"> 

<input type="hidden" name="goodsNumber" value="<%= goodsNumber%>">
<input type="hidden" name="qty" value="<%= qty%>">

<table border =1 align="center">
<tr><td>결제페이지</td></tr>
<tr><td><img src="./boardupload/<%= goodsImage%>"></td></tr>
<tr><td>상품이름 : <%= goodsName%></td></tr>
<tr><td>가격 : <%= goodMoney%></td></tr>
<tr><td>수량 : <%= qty %></td></tr>
<tr><td align="center"><a><input type="button" onclick = "javascript:deposit();" value="결제"></a></td></tr> 

<!-- a태그안에 button이 들어갔다고 해서,무조건 submit이 되지는 않음 >> 결론 : <input type="button" 형식을 지킬 것! -->
<!-- <input type="button" 이 아니라 ,<button이라고 바로쓰면 submit 버튼으로 인식되어, onclick에 관계없이 무조건 submit 됨  >> 결론 : <input type="button" 형식을 지킬 것! -->

<!-- onclick을 통해 function을 사용하면 원하는 기능(입력체크, prompt, alert)등을 활용한 후에, 마지막에  폼네임.submit(); 을 적어줘서 최종적으로 action의 경로로 이동할 수 있다  -->

<!-- javascript: 이거 안적어줘도 상관없음 >> 다음에 쓰는게 <script>에 있다는 의미인데, 어짜피 onclick은 function을 찾아가므로 굳이 javascript: 를 적어줄 필요는 없다 -->
</table>
<h3 align="center"><a href="./GoodCartList.go">장바구니로 돌아가기</a></h3>
</form>


</body>
</html>