<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import ="dto.*"%>
<%
  Board bd = (Board)request.getAttribute("boarddata");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	</head>
<body>
<script type="text/javascript">
	function modifyReview(){
		
		modifyform.submit();
		
	}
</script>
<form action="ReviewModifyAction.re" method="post" name="modifyform">
<input type="hidden" name="boardNum" value="<%=bd.getBoardNum()%>">
<table cellpadding="0" cellspacing="0">
	<tr align="center" valign="middle">
		<td colspan="5">리뷰 수정</td>
	</tr>
	<tr>
		<td height="16" style="font-family:돋음; font-size:12">
			<div align="center">제 목</div>
		</td>
		<td>
			<input name="boardSubject" size="50" maxlength="100" 	
			value="<%=bd.getBoardSubject()%>">
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12">
			<div align="center">내 용</div>
		</td>
		<td>
			<textarea name="boardContent" cols="67" rows="15"><%=bd.getBoardContent()%></textarea>
		</td>
	</tr>
	<tr>
		<td>
			이미지
		</td>
		<td style="font-family:돋음; font-size:12">
			&nbsp;&nbsp;<%=bd.getBoardImage()%>
		</td>
	</tr>
	<tr>
		<td height="16" style="font-family:돋음; font-size:12">
			<div align="center">비밀번호</div>
		</td>
		<td>
			<input name="boardPw" type="password">
		</td>
	</tr>
	
	<tr bgcolor="cccccc">
		<td colspan="2" style="height:1px;">
		</td>
	</tr>
	<tr><td colspan="2">&nbsp;</td></tr>
	
	<tr align="center" valign="middle">
		<td colspan="5">
			<font size=2>
			<a href="javascript:modifyReview()">[수정]</a>&nbsp;&nbsp;
			<a href="javascript:history.go(-1)">[뒤로]</a>&nbsp;&nbsp;
			</font>
		</td>
	</tr>
</table>
</form>
</body>
</html>