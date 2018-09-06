<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요일별 판매 랭킹</title>
</head>
<body>
<script type="text/javascript">

</script>

<h1 align="center"><font color ="black"><font size = 15>랭킹</font></font></h1>
<table width="600" align="center">
<tr>
<td align="right"><a href="main.go">메인으로</a></td>
</tr>
</table>

<% if(false){ %>

<h1 align="center">상품이 존재하지 않습니다.</h1>

<% }else{ %>

<a href="RankingSell.ra">판매 랭킹</a></br></br>
<a href="RankingClick.ra">클릭수 랭킹</a></br></br>


<% } %>

</body>
</html>