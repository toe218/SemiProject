<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.*,dto.Board"%>
<% 
	int nowpage = (Integer)request.getAttribute("page");
	int maxpage = (Integer)request.getAttribute("maxpage");
	int startpage = (Integer)request.getAttribute("startpage");
	int endpage = (Integer)request.getAttribute("endpage");
	int listcount = (Integer)request.getAttribute("listcount");	
	List reviews = (List)request.getAttribute("reviewlist");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후기 게시판</title>
</head>
<body>


<table width=50% border=1 cellpadding="0" cellspacing="0">
	
<% if(listcount > 0){ %>
		
	<tr align="center" valign="middle">
		<td colspan="4">후기 게시판</td>
		<td align=right>
			<font size=2>글 개수 : <%= listcount %> <%-- ${listcount}과 같다--%> </font>
		</td>
	</tr>
	
	<tr align="center" valign="middle" bordercolor="#333333">
		<td style="font-family:Tahoma;font-size:8pt;" width="8%" height="26">
			<div align="center">글번호</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="50%">
			<div align="center">제목</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="14%">
			<div align="center">ID</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="17%">
			<div align="center">날짜</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="11%">
			<div align="center">조회수</div>
		</td>
	</tr>
	
	<% 
		for(int i= 0; i < reviews.size(); i++){
			
			
		Board bd = (Board)reviews.get(i);
	%>
	
	<tr >
		<td height="23" style="font-family:Tahoma;font-size:10pt;">
		<%=bd.getBoardNum() %>
		</td>
		
		<td style="font-family:Tahoma;font-size:10pt;">
			<div align="left">
			<a href="./ReviewDetailAction.re?num=<%=bd.getBoardNum()%>">
		<%=bd.getBoardSubject() %>	
			</a>
			</div>
		</td>
		
		<td style="font-family:Tahoma;font-size:10pt;">
			<div align="center"><%=bd.getBoardWriter() %></div>
		</td>
		<td style="font-family:Tahoma;font-size:10pt;">
			<div align="center"><%=bd.getBoardRegdate() %></div>
		</td>	
		<td style="font-family:Tahoma;font-size:10pt;">
			<div align="center"><%=bd.getBoardReadcount() %></div>
		</td>
	</tr>
	<% } %>
	
	<tr align=center height=20>
	
		<td colspan=7 style=font-family:Tahoma;font-size:10pt;>

			<% if(nowpage<=1){ %>
			
			[이전]&nbsp;
			
			<%}else{ %>	
			
			<a href="./ReviewList.re?page=<%= nowpage-1 %>">[이전]</a>&nbsp;
			
			<% } %>	
			
				<%
					for(int a = startpage ; a <= endpage ; a++){
						
						if(a==nowpage){
							
							out.print("["+a+"]");
						
						}else{
				%>		
						<a href="./ReviewList.re?page=<%= a %>">[<%= a %>]</a>
				<% 		
					}
				}
				%>
				<% 
					if(nowpage>=maxpage){
				%>
				[다음]
				<%}else{ %>
			<a href="./ReviewList.re?page=<%= nowpage+1 %>">[다음]</a>
				<% } %>
		</td>
	</tr>

<% }else{ %>

	<tr align="center" valign="middle">
		<td colspan="4">후기 게시판</td>
		<td align=right>
			<font size=2>등록된 글이 없습니다.</font>
		</td>
	</tr>

<% } %>

	<tr align="right">
		<td colspan="5">
	   		<a href="./ReviewWrite.re">[글쓰기]</a><a href="./main.tb">[메인으로]</a>
		</td>
	</tr>
</table>



</body>
</html>