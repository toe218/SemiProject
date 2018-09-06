<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ page import = "model3.DTO.*" %>
<%
	int nowpage = ((Integer)request.getAttribute("page")).intValue();
	int maxpage = (Integer)request.getAttribute("maxpage");
	int startpage = (Integer)request.getAttribute("startpage");
	int endpage = (Integer)request.getAttribute("endpage");
	int listcount = (Integer)request.getAttribute("listcount");
	List qnaboardList = (List)request.getAttribute("qnaboardList");	
%>
<!DOCTYPE html>
<html>
<head>

<style type='text/css'>
@import url("Test.css");
</style>
<link rel="stylesheet" type="text/css" href="Test.css" />

<meta charset="UTF-8">
<title>문의 게시판</title>
</head>
<body>
<div id="table1">
<table width=50% border="0" cellpadding="0" cellspacing="0">
<% if(listcount>0) { %>
	<tr align="center" valign="middle">
		<td colspan="4">문의 게시판</td>
		<td align=right>
			<font size=2>글 개수 : <%= listcount %> </font>
		
		</td>
	</tr>
	
	<tr align="center" valign="middle" bordercolor="#333333">
		<td style="font-family:Tahoma;font-size:8pt; width="8%" height="26">
			<div align="center">번호</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="50%">
			<div align="center">제목</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="14%">
			<div align="center">작성자</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="17%">
			<div align="center">날짜</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="11%">
			<div align="center">조회수</div>
		</td>	
	</tr>
<% for(int i=0;i<qnaboardList.size();i++) {
	QnaBoardBean qbl = (QnaBoardBean)qnaboardList.get(i);
%>	
	<tr>
		<td><%= qbl.getQnaNum() %></td>
		<td>
			<% 
				if(qbl.getQnaLev()!=0) {
					for(int ii=0;ii<qbl.getQnaLev();ii++) {
						out.print("▶");
					}
				}
			%>
			<a href="./QnaBoardDetailAction.bb?num=<%= qbl.getQnaNum() %>"><%=qbl.getQnaSubject() %></a>
		</td>
		<td><%= qbl.getMemberId() %></td>
		<td><%= qbl.getQnaRegdate() %></td>
		<td><%= qbl.getQnaReadcount() %></td>		
	</tr>
<% } %>

	<tr align=center height=20 >
		<td colspan=7 style=font-family:Tahoma;font-size:10pt;>
		<% if(nowpage <= 1) { %>		
		[이전]
		<% } else { %>
		<a href="./QnaBoardList.bb?page=<%=nowpage-1 %>">[이전]</a>&nbsp;
		<% } %>
			<%
				for(int a=startpage; a<=endpage;a++) {
					if(a==nowpage) {
						out.print("["+a+"]");
					} else {
			%>
					<a href="./QnaBoardList.bb?page=<%=a%>">[<%= a %>]</a>&nbsp;&nbsp;
			<%
					}
				}
			%>
		<%if(nowpage >= maxpage) { %>
				[다음]
			<% }else { %>
			<a href="./QnaBoardList.bb?page=<%=nowpage+1%>">[다음]</a>
			<% } %>
		</td>
	</tr>
<% } else { %>
	<tr align="center" valign="middle">
		<td colspan="4">문의 게시판</td>
		<td align=right>
			<font size=2>등록된 글이 없습니다.</font>
		</td>
	</tr>
<% } %>	
	<tr align="right">
		<td colspan="5">
			<a href="./QnaBoardWrite.bb">[글쓰기]</a>
		</td>
	</tr>
	
</table>
</div>
</body>
</html>