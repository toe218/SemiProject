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
</head>
<body>
<script type="text/javascript">
	function checkQty(goodsName,qty){
		if(qty <= 1){ // 수량이 0이거나 1이면 안되므로 멈춤 
			return false;
		}else{
			location.href="GoodCartQtyDown.go?goodsName="+goodsName;
		}
	}
</script>
<h1 align="center"> <font color ="black"><font size = 15> 장바구니</font></font></h1>
<table width="600" align="center" border = "1">
</table>

<% if(cartList==null){%>

<h1 align="center">상품이 존재하지 않습니다.</h1>

<% }else{ %>

<form action="./GoodCartRemove.go" method="post" name="myForm">
<table align="center" width="600" border="1">
	<tr align="center" bgcolor="orange">
		<td>번호	</td>
		<td>상품이미지</td>
		<td>상품명</td>
		<td>가격</td>
		<td>수량</td>
		<td align="center">
		<input type="submit" name="delete" value="삭제" />
		</td>
	</tr>
	
<% for(int i = 0; i<cartList.size();i++){ 
	Cart cart = (Cart)cartList.get(i);
%>
	<tr align="center">
		<td><%= i+1 %></td>
		<td><img src="./boardupload/<%= cart.getGoodsImage() %>" width="70" height="70"/></td>
		<td><%= cart.getGoodsName() %></td>
		<td><%= cart.getGoodsPrice() %></td>
		<td>
		<a href="./GoodCartQtyUp.go?goodsName=<%=cart.getGoodsName()%>">
		<img src="GoodsView/images/upicon.png" width="15" height="15"></a>
		<br>
			<%= cart.getQty() %>
		<br>
		<a href="javascript:checkQty('<%=cart.getGoodsName()%>','<%=cart.getQty()%>')">
		<img src="GoodsView/images/downicon.png" width="15" height="15"></a>
		<br>
		</td>
		
		
	<td align="center">
	<input type="checkbox" name="delete" value="<%= cart.getGoodsName()%>"/>


	</td>
	<tr><td colspan="6" align="center"><a href="./GoodBuy.go?goodsNumber=<%= cart.getGoodsNumber()%>&qty=<%= cart.getQty() %>&goodMoney=<%=cart.getGoodsPrice()%>&goodsName= <%= cart.getGoodsName() %>&goodsImage=<%=cart.getGoodsImage()%>">구매</a></td>
	</tr>
	
	<% } %>	
	
	</table>
</form>



<table align="center" width="600" border="1">
	<tr align="center" bgcolor="yellow">
		<td align="right" colspan="6"><font color ="gray" size="5">총 결제금액 : </font><font color ="black" size="8"><%= totalMoney %></font></td>
	</tr>
	<tr><td align="right"><a href="GoodsList.go">쇼핑계속하기</a></td>
	</tr>
		</table>

<% } %>

</body>
</html>