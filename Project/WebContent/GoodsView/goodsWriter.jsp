<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GoodsWriter.jsp</title>
</head>
<body>
<form action="./GoodsAddAction.go" method="post" enctype="multipart/form-data" name="frm">
	<table align="center" width="600">
	<tr>
		 <td rowspan="7"><img src=""/></td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		 <td>상품이름 : </td>
		 <td><input type ="text" name ="goodsName"/></td>
	</tr>
	<tr>
		 <td>이미지 : </td>
		 <td><input type ="file" name ="goodsImage"/></td>
	</tr>
	<tr>
		 <td>요약정보 : </td>
		 <td><input type ="text" name ="goodsSummary"/></td>
	</tr>
	<tr>
		 <td>가격 : </td>
		 <td><input type ="text" name ="goodsPrice"/></td>
	</tr>
	<tr>
		 <td>분류: </td>
		 <td><input type ="text" name ="sort"/></td>
	</tr>
	<tr>
		 <td>시즌: </td>
		 <td><input type ="text" name ="sortSeason"/></td>
	</tr>
	<tr>
		 <td>상세정보: </td>
		 <td><textarea rows="50" cols="30" name ="goodsDetail"></textarea></td>
	</tr>
	<tr>
    <tr>
    	<td colspan="3" align="center">
    	<a href="adminMain.tb">[관리자 페이지]</a>
    	<a href="javascript:frm.submit();">[저장]</a> <!-- 그냥 frm.submit()이라고만 쓰면 action이 안됨 -->
    	<a href="./main.tb">[메인으로]</a>
    	</td>
    </tr>
    
</table>
</form>
</body>
</html>