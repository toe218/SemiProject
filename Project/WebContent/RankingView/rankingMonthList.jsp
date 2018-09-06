<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>월별 판매 랭킹</title>
</head>
<body>
<script type="text/javascript">

</script>
<h1 align="center"><font color ="black"><font size = 15>월별 판매 랭킹</font></font></h1>
<table width="600" align="center">
<tr>
<td align="right"><a href="">메인으로</a></td>
</tr>
</table>

<% if(false){ %>

<h1 align="center">상품이 존재하지 않습니다.</h1>

<% }else{ %>

<form action="" method="post" name="form">
<table align="center" width="600" border="1">
	
	<tr align="center" bgcolor="orange">
		<td>번호	</td>
		<td>상품이미지</td>
		<td>상품명</td>
		<td>가격</td>
		<td>구매수</td>
	</tr>
	
	<tr align="center">
		<td>번호입력</td>
		<td><img src="./boardupload/" width="70" height="70"/>상품이미지입력</td>
		<td>상품명입력</td>
		<td>가격입력</td>
		<td>구매수입력</td>
	</tr>
	

</table>
</form>

<% } %>

</body>
</html>