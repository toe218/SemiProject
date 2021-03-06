<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="java.util.List, biz.*"%>

<%
	List cartList = (List)request.getAttribute("cartList");

	int totalMoney = (Integer)request.getAttribute("totalMoney");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	
	function checkQty(goodsName,qty){

		if(qty <= 1){ // 수량이 0이거나 1이면 안되므로 멈춤 
			return false;
		}else{
			location.href="GoodCartQtyDown.go?goodsName="+goodsName;
		}
	}
	
	function buyAction(){
		
		var chk = new Array();
			chk = document.myForm.Number;
		var str;
		
		for(var i = 0;i<chk.length;i++){
			if(chk[i].checked==true){
				str+=chk[i].value+","; 
			}
		}
			/* document.write(str); 웹출력  */
			location.href="./GoodCartListPay.go?str="+str;
	}

</script>

</head>
<body>

<h1 align="center"> <font color ="black"><font size = 15> 장바구니</font></font></h1>

<% if(cartList==null){%>

<h1 align="center">상품이 존재하지 않습니다.</h1>

<% }else{ %>

<form action="./GoodCartRemove.go" method="post" name="myForm">

<table align="center" width="700" border="1">

	<tr align="center" bgcolor="orange">
		<td>번호	</td>
		<td>상품이미지</td>
		<td>상품명</td>
		<td>가격</td>
		<td>수량</td>
		<td><a href="javascript:buyAction();">선택상품 구매</a> <!-- 왜 버튼으로 만들면 onclick이 안되는가? -->
		<td align="center"><input type="submit" name="delete" value="삭제" /></td>
	</tr>
	
<% 
	for(int i = 0; i<cartList.size();i++){ 
	Cart cart = (Cart)cartList.get(i);
%>
	<tr align="center">
		<td><%= i+1 %></td>
		<td><img src="./boardupload/<%= cart.getGoodsImage() %>" width="70" height="70"/></td>
		<td><%= cart.getGoodsName() %></td>
		<td><%= cart.getGoodsPrice() %></td>
		<td>
		<a href="./GoodCartQtyUp.go?goodsName=<%=cart.getGoodsName()%>">
		<img src="GoodsView/images/upicon.png" width="15" height="15" border="0"/>
		</a>
		<br>
			<%= cart.getQty() %>
		<br>
		<a href="javascript:checkQty('<%=cart.getGoodsName()%>','<%=cart.getQty()%>')">
		<img src="GoodsView/images/downicon.png" width="15" height="15" border="0"/>
		</a>
		<br>
		</td>

	<td align="center"><input type="checkbox" name="Number" value="<%= cart.getGoodsNumber()%>"/></td>
	<td align="center"><input type="checkbox" name="delete" value="<%= cart.getGoodsName()%>"/></td>
	<tr><td colspan="7" align="center"><a href="./GoodBuy.go?goodsNumber=<%= cart.getGoodsNumber()%>&qty=<%= cart.getQty() %>&goodMoney=<%=cart.getGoodsPrice()%>&goodsName= <%= cart.getGoodsName() %>&goodsImage=<%=cart.getGoodsImage()%>">구매</a></td>
	</tr>
	
	<% } %>	
	
	</table>
</form>

<table align="center" width="600" border="1">
	<tr align="center" bgcolor="yellow">
		<td align="right" colspan="6"><font color ="gray" size="5">장바구니 총금액 : </font><font color ="black" size="8"><%= totalMoney %></font></td>
	</tr>
	<tr>
		<td align="right"><a href="GoodsList.go">쇼핑계속하기</a></td>
	</tr>
</table>

<% } %>

</body>
</html>