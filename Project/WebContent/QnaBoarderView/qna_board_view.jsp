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
</head>
<body>
<table cellpadding="0" cellspacing="0">
	<tr align="center" valign="middle">
		<td colspan="5">문의 게시판</td>
	</tr>
	
	<tr>
		<td style="font-family:돋음; font-size:12" height="16">
			<div align="center">제목&nbsp;&nbsp;</div>
		</td>
		<td style="font-family:돋음; font-size:12">
			<%= qnaboard.getQnaSubject() %>
		</td>
	</tr>
	
	<tr bgcolor ="ccccc">
		<td colspan="2" style="height:1px;">
		</td>
	</tr>
	
	<tr>
		<td style="font-family:돋음; font-size:12">
			<div align="center">내 용</div>
		</td>
		<td style="font-family:돋음; font-size:12">
			<table border=0 width=490 height=250 style="table-layout:fixed">
				<tr>
					<td valign=top style="font-family:돋음; font-size:12">
					<%=qnaboard.getQnaContent() %>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12">
			<div align="center">첨부파일</div>		
		</td>
		<td style="font-family:돋음; font-size:12">
			<a href="./boardupload/<%=qnaboard.getQnaImage() %>">
				<%=qnaboard.getQnaImage() %>
			</a>
		</td>
	</tr>
	<tr bgcolor="cccccc">
		<td colspan="2" style="height:1px;"></td>
	</tr>
	<tr><td colspan="2">&nbsp;</td></tr>
	<tr align="center" valign="middle">
		<td colspan="5">
			<font size=2>
				<a href="./QnaBoardReplyView.bb?num=<%=qnaboard.getQnaNum()%>">
				[답변]
				</a>&nbsp;&nbsp;
				<a href="./QnaBoardModify.bb?num=<%=qnaboard.getQnaNum()%>">
				[수정]
				</a>&nbsp;&nbsp;
				<a href="./QnaBoardDelete.bb?num=<%=qnaboard.getQnaNum()%>">
				[삭제]
				</a>&nbsp;&nbsp;
				<a href="./QnaBoardList.bb">[목록]</a>&nbsp;&nbsp;
			</font>
		</td>
	</tr>
</table>
</body>
</html>