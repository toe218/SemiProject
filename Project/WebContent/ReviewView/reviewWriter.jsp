<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후기 작성</title>
</head>
<body>
<form action="./ReviewAddAction.re" method="post" enctype="multipart/form-data" name="frm">
	<table align="center" width="600" border =1>
	<tr>
	 <td>ID : </td>
	 <td></td>
	</tr>
	<tr>
	 <td>상품등록번호 : </td>
	 <td></td>
	</tr>
	<tr>
	 <td>상품명 :</td>
	 <td></td>
	</tr>
	<tr>
	 <td>제목 : </td>
	 <td><input type ="text" name ="boardSubject"/></td>
	</tr>
	<tr>
	 <td>내용: </td>
	 <td><textarea rows="50" cols="30" name ="boardContent"></textarea></td>
	</tr>
	<tr>
	 <td>이미지</td>
	 <td><input type ="file" name ="boardImage"/></td>
	</tr>
	<tr>
	 <td>비밀번호: </td>
	 <td><input type ="text" name ="boardPw"/></td>
	</tr>
	
	<tr>
    <tr><td colspan="3" align="center">
    	<a href="ReviewList.re">목록보기</a>
    	<a href="javascript:frm.submit();">저장</a>
    	</td></tr>
    
</table>
</form>
</body>
</html>