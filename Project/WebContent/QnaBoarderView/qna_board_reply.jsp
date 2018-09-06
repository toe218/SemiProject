<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model3.DTO.*"%>
<%
	QnaBoardBean qnaboard = (QnaBoardBean)request.getAttribute("qnaboarddata");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script language="javascript">
	function replyboard() {
		boardform.submit();
	}
	</script>
</head>
<body>
<form action="QnaBoardReplyAction.bb" method="post" name="boardform">
	<input type="hidden" name="QNA_NUM" value="<%=qnaboard.getQnaNum()%>">
	<input type="hidden" name="QNA_REF" value="<%=qnaboard.getQnaRef()%>">
	<input type="hidden" name="QNA_LEV" value="<%=qnaboard.getQnaLev()%>">
	<input type="hidden" name="QNA_SEQ" value="<%=qnaboard.getQnaSeq()%>">	

<table cellpadding="0" cellspacing="0">
	<tr align="center" valign="middle">
		<td colspan="5">문의 게시판</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12" height="16">
			<div align="center">글쓴이</div>
		</td>
		<td>
			<input name="MEMBER_ID" type="text"/>
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size=12" height="16" >
			<div align="center">제 목</div>
		</td>
		<td>
			<input name="QNA_SUBJECT" type="text" size="50"
				maxlength="100" value="RE: <%= qnaboard.getQnaSubject() %>"/>
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12">
			<div align="center">내 용</div>
		</td>
		<td>
			<textarea name="QNA_CONTENT" cols="67" rows="15"></textarea>
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12">
			<div align="center">비밀번호</div>
		</td>
		<td>
			<input name="QNA_PW" type="password">
		</td>
	</tr>
	
	<tr bgcolor="cccccc">
		<td colspan="2" style="height:1px;"></td>
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