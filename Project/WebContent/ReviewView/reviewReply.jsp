<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "dto.*" %>
<%
	Board bd = (Board)request.getAttribute("board");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후기 댓글</title>
	<script language="javascript">
	function replyboard(){
		boardform.submit();
	}
	</script>
</head>
<body>
<form action="./ReviewReplyAction.re" method="post" name="boardform">
<input type="hidden" name="boardNum" value="<%=bd.getBoardNum()%>">
<input type="hidden" name="boardRef" value="<%=bd.getBoardRef()%>">
<input type="hidden" name="boardLev" value="<%=bd.getBoardLev()%>">
<input type="hidden" name="boardSeq" value="<%=bd.getBoardSeq()%>">

<table cellpadding="0" cellspacing="0">
	<tr align="center" valign="middle">
		<td colspan="5">후기 댓글</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12" height="16">
			<div align="center">글쓴이</div>
		</td>
		<td>
			<input name="boardWriter" type="text"/>
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12" height="16">
			<div align="center">제 목</div>
		</td>
		<td>
			<input name="boardSubject" type="text" size="50" 
				maxlength="100" value="Re: <%= bd.getBoardSubject()%>"/>
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12">
			<div align="center">내 용</div>
		</td>
		<td>
			<textarea name="boardContent" cols="67" rows="15"></textarea>
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12">
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
		<a href="javascript:replyboard()">[등록]</a>&nbsp;&nbsp;
		<a href="javascript:history.go(-1)">[뒤로]</a>
		</td>
	</tr>
</table>
</form>
</body>
</html>