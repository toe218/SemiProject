<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ page import = "model3.DTO.*" %>
<% String id = (String)session.getAttribute("id"); %>
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

<h1></h1>


<div id="main2">

<div id="main4">
<a href ="./QnaBoardList.bb">문의게시판</a>&nbsp;
<a href ="./ReviewList.re">후기게시판</a> &nbsp;
<a href ="./RankingList.ra">랭킹</a>&nbsp;
<a href ="./GoodsList.go">상품</a>&nbsp;
<a href ="./search.tb">검색</a> 
</div>

<div id="main1" align="center"><a href="http://localhost:8080/Project/main.tb">Real Total Beautyshop</a></div>

<div id="main3"> 

<a href ="./mypageMain.tb">마이페이지</a>&nbsp;
<a href ="./intro.tb">회사소개</a> &nbsp;
</div>
</div>

<%
	if (session.getAttribute("id") != null) {
%>
<p align="right"><b><%= id %></b> 님 반갑습니다! &nbsp;&nbsp;

<% if (id!=null && id.equals("admin")) { %>

<a href="./adminMain.tb"> 관리자 페이지 </a> &nbsp;&nbsp;

<%} %>

<a href="logout.tb">로그아웃</a></p>



<%
	}
 %>




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