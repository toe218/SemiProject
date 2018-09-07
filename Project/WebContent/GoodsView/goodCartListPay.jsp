<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="java.util.*, dto.Goods" %>
<% 
	List buyList = (List)request.getAttribute("buyList"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

<%-- function deposit(){
	
	var totalMoney = <% %>; 
	var pay = prompt("금액을 입력해주세요. \n\n결제금액 : "+totalMoney ,"");
	
	
	if(totalMoney==pay){ /* var간의 비교는 equals가 아니라 ==으로 */
	
		alert("상품 결제 완료");
	
		frm.submit(); 
	
	}else{
		
		alert("정확한 금액을 입력해주세요");
	
		location.href="#";
	}

} 
 --%>
</script>

</head>
<body>

<form action="GoodPay.go" method="post" name="myForm">
	<table align="center" width="700" border="1">

	<tr align="center" bgcolor="orange">
		<td>상품이미지</td>
		<td>상품명</td>
		<td>가격</td>
		<td>수량</td>
	</tr>
	
<% 
	int totalMoney = 0;

	for(int i = 0 ; i < buyList.size() ;i++){ 
	Goods go = (Goods)buyList.get(i);
%>
	<tr align="center">
		<td><img src="./boardupload/<%= go.getGoodsImage() %>" width="70" height="70"/></td>
		<td><%= go.getGoodsName() %></td>
		<td><%= go.getGoodsPrice() %></td>
		<td><%= go.getSalesQty() %></td>
	</tr>
<% 	
		totalMoney += go.getGoodsPrice()*go.getSalesQty();
	} 
%>	
	
	</table>


<table align="center" width="600" border="1">
	<tr align="center" bgcolor="yellow">
		<td align="right" colspan="6"><font color ="gray" size="5">선택상품 총금액 : <%= totalMoney %></font><font color ="black" size="8"></font></td>
	</tr>
	<tr>
		<td align="right"><input type="button" name="pay" value="결제" onclick ="deposit();" /></td>
		<td align="right"><a href="GoodsList.go">쇼핑계속하기</a></td>
	</tr>
</table>
</form>

</body>
</html>