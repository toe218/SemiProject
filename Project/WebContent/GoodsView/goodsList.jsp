<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.*"%>
<%@ page import = "dto.*" %>
<% 
	List goods = (List)request.getAttribute("goods");
%>
<%
	List today = (List)request.getAttribute("images");
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
<% if(id!=null){ %>
	
	<h1 align="center"> 상품 목록</h1>&nbsp;&nbsp;&nbsp;&nbsp;
	<% if(!id.equals("admin")) { %> <h2 align="center"><a href ="./GoodCartList.go">장바구니로 가기</a></h2><% } %>
	<h2 align="center"><a href ="./main.tb">메인으로</a></h2>

<table align="center">
	<tr>
	<% for(int i=0; i < goods.size(); i++){ 
		Goods go = (Goods)goods.get(i);
	%>	
		<td>
			<a href="GoodView.go?goodsNumber=<%=go.getGoodsNumber() %>"><img src="./boardupload/<%=go.getGoodsImage() %>" height="100" width="100" border="0"></a><br>
			상품명 :<%=  go.getGoodsName()%> <br>가격 : <%= go.getGoodsPrice() %>원  
			<% if(id.equals("admin")) { %> <a href="./GoodsDelete.go?goodsNumber=<%=go.getGoodsNumber()%>">삭제 </a> <% } %>
		</td>
		
	<%	if(i==0||i%2!=0){ continue;}
	else{ out.print("</tr><tr>");}
	}%>
	</tr>
</table>

<% }else{ %>

	<h1 align="center"> 상품 목록</h1>&nbsp;&nbsp;&nbsp;&nbsp;
	<h2 align="center"><a href ="./GoodCartList.go">장바구니로 가기</a></h2>
	<h2 align="center"><a href ="./main.tb">메인으로</a></h2>

<table align="center">
	<tr>
	<% for(int i=0; i < goods.size(); i++){ 
		Goods go = (Goods)goods.get(i);
	%>	
		<td>
			<a href="GoodView.go?goodsNumber=<%=go.getGoodsNumber() %>"><img src="./boardupload/<%=go.getGoodsImage() %>" height="100" width="100" border="0"></a><br>
			상품명 :<%=  go.getGoodsName()%> <br>가격 : <%= go.getGoodsPrice() %>원  
		</td>
		
	<%	if(i==0||i%2!=0){ continue;}
	else{ out.print("</tr><tr>");}
	}%>
	</tr>
</table>

<% } %>

<br><br>
<h1 align="center">오늘 본 상품</h1>
<table align="center" width="600">
<tr>

<% if(today !=null &&today.size()>0){
		
	for(int i =0; i<today.size(); i++){%>
	
		<td align="center">
			<img src="./boardupload/<%=today.get(i)%>" height="200" width="150" border="0">
		</td>
<%	if(i==0||i%2!=0){ continue;}
else{ out.print("</tr><tr>");}
	} 
} %> 

</tr>
</table>
</body>
</html>