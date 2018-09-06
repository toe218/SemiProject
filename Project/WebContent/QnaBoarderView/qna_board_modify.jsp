<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model3.DTO.*"%>
<%
	QnaBoardBean qnaboard = (QnaBoardBean)request.getAttribute("qnaboarddata");
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function modifyboard(){
		modifyform.submit();
	}
	</script>
</head>
<body>
<form action="QnaBoardModifyAction.bb" method="post" name="modifyform">
<input type="hidden" name="QNA_NUM" value="<%=qnaboard.getQnaNum()%>">
<table cellpadding="0" cellspacing="0">
	<tr align="center" valign="middle">
		<td>문의 게시판</td>
	</tr>
	<tr>
		<td height="16" style="font-family:돋음; font-size:12">
			<div align="center">제 목</div>
		</td>
		<td>
			<input name="QNA_SUBJECT" size="50" maxlength="100"
				value="<%=qnaboard.getQnaSubject() %>">
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12">
			<div align="center">내 용</div>
		</td>
		<td>
			<textarea name="QNA_CONTENT" cols="67" rows="15"><%=qnaboard.getQnaContent()%></textarea>
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12">
			<div align="center">파일 첨부</div>
		</td>
		<td>
			&nbsp;&nbsp;<%=qnaboard.getQnaImage()%>
		</td>
	</tr>
	<tr>
		<td height="16" style="font-family:돋음; font-size:12">
			<div align="center">비밀번호</div>
		</td>
		<td>
			<input name="QNA_PW" type="password">
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
			<a href="javascript:modifyboard()">[수정]</a>&nbsp;&nbsp;
			<a href="javascript:history.go(-1)">[뒤로]</a>&nbsp;&nbsp;
			</font>
		</td>
	</tr>	
</table>
</form>
</body>
</html>