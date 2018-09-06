<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "dto.*"%>
<%
	Goods good	= (Goods)request.getAttribute("good");
%>

<%
	String id = (String)session.getAttribute("id");
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

<% if(id!=null){ %>

<h1 align="center"><%= good.getGoodsName() %>의 정보</h1>
<table align="center" width="600">
	<tr bgcolor="orange">
		<td align="right">조회수 : <%= good.getClick() %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="./GoodCartAdd.go?goodsNumber=<%= good.getGoodsNumber()%>">장바구니 담기</a>
	</tr>
</table>
<table align="center" width="600" border = "1" name ="form">
	<tr>
		<td rowspan="7"><img src="./boardupload/<%=good.getGoodsImage()%>"/></td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<td>가격: <%= good.getGoodsPrice() %> </td>
	</tr>
	<tr>
	 <td>요약: <%= good.getGoodsSummary() %></td>
	</tr>
	<tr>
	 <td>분류: <%= good.getSort() %></td>
	</tr>
	<tr>
	 <td>시즌: <%= good.getSortSeason() %></td>
	</tr>
	<tr>
	 <td>특징: <%=good.getGoodsDetail() %></td>
	</tr>

	<form action="./GoodBuy.go" method="get" id="frm">	

	<input type="hidden" name="goodsNumber" value="<%= good.getGoodsNumber()%>">
	<input type="hidden" name="goodMoney" value="<%= good.getGoodsPrice()%>">
	<input type="hidden" name="goodsName" value="<%= good.getGoodsName()%>">
	<input type="hidden" name="goodsImage" value="<%= good.getGoodsImage()%>">
	<tr>
	<td>구매개수: <input type ="text" name ="qty"/></td>
	</tr>
<form/>
	<tr><td colspan="2" align="center"><input type = "submit" value ="구매"/></td></tr>
	
	<tr><td colspan="2" align="center"><a href="./GoodsList.go">목록보기</a></td></tr>
</table>

<% }else{%>

<h1 align="center"><%= good.getGoodsName() %>의 정보</h1>
<table align="center" width="600">
	<tr bgcolor="orange">
		<td align="right">조회수 : <%= good.getClick() %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="./GoodCartAdd.go?goodsNumber=<%= good.getGoodsNumber()%>">장바구니 담기</a>
	</tr>
</table>
<table align="center" width="600" border = "1" name ="form">
	<tr>
		<td rowspan="7"><img src="./boardupload/<%=good.getGoodsImage()%>"/></td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<td>가격: <%= good.getGoodsPrice() %> </td>
	</tr>
	<tr>
	 <td>요약: <%= good.getGoodsSummary() %></td>
	</tr>
	<tr>
	 <td>분류: <%= good.getSort() %></td>
	</tr>
	<tr>
	 <td>시즌: <%= good.getSortSeason() %></td>
	</tr>
	<tr>
	 <td>특징: <%=good.getGoodsDetail() %></td>
	</tr>
	

	<form action="./login.tb" method="get" id="frm">	

	<input type="hidden" name="goodsNumber" value="<%= good.getGoodsNumber()%>">
	<input type="hidden" name="goodMoney" value="<%= good.getGoodsPrice()%>">
	<input type="hidden" name="goodsName" value="<%= good.getGoodsName()%>">
	<input type="hidden" name="goodsImage" value="<%= good.getGoodsImage()%>">
	<tr>
	<td>구매개수: <input type ="text" name ="qty"/></td>
	</tr>
<form/>
	<tr><td colspan="2" align="center"><input type = "submit" value ="구매"/></td></tr>
	<tr><td colspan="2" align="center"><a href="./GoodsList.go">목록보기</a></td></tr>
</table>
<%} %>
</body>
</html>