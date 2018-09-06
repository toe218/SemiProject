<%@page import="dto.Goods"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="java.util.*"%>

<%
	List rank = (List)request.getAttribute("rank");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>클릭수 랭킹</title>
</head>
<body>
<script type="text/javascript">

</script>
<h1 align="center"><font color ="black"><font size = 15>클릭수 랭킹</font></font></h1>
<table width="600" align="center">
<tr>
<td align="right"><a href="./RankingList.ra">랭킹 메인으로</a></td>
</tr>
</table>

<% if(rank==null){ %>

<h1 align="center">상품이 존재하지 않습니다.</h1>

<% }else{ %>

<table align="center" width="600" border="1">
	
	<tr align="center" bgcolor="orange">
		<td>번호	</td>
		<td>상품이미지</td>
		<td>상품명</td>
		<td>가격</td>
		<td>클릭수</td>
	</tr>
	
<% for(int i = 0; i<rank.size();i++){ 
		Goods good = (Goods)rank.get(i);
%>	
	<tr align="center">
		<td><%= good.getGoodsNumber() %></td>
		<td><img src="./boardupload/<%= good.getGoodsImage() %>" width="70" height="70"/></td>
		<td><%= good.getGoodsName() %></td>
		<td><%= good.getGoodsPrice() %></td>
		<td><%= good.getClick() %></td>
	</tr>
<% } %>
</table>
</form>
<% } %>
</body>
</html>