<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" %>
<% List memberList = (List)request.getAttribute("memberList");  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="modifyForm" action="#" method="post" 
	id="modifyForm">
	<table border=1 align="center">
		<tr><td colspan =2 >
				<font size=5>정보수정 페이지</font>
			</td>
		</tr>
		<tr><td>ID  </td>
			<td> <%=memberList.get(1) %>
				
			</td>
		</tr>
		<tr><td>비밀번호  </td>
			<td>
				<input type="password" name="memberPass" />
			</td>
		</tr>
		<tr><td>비밀번호 확인 </td>
			<td>
				<input type="password" name="memberPass2" />
			</td>
		</tr>
		<tr><td>이름  </td>
		    <td><%=memberList.get(2) %>
				   
		    </td>
		</tr>
		<tr><td>생년월일(XXXX-XX-XX)  </td>
			<td><%=memberList.get(3) %>

			</td>
		</tr>
		<tr><td>성별 </td>
		    <td><%=memberList.get(4) %>
				
		    </td>
		</tr>
		<tr><td>휴대폰번호  </td>
		    <td>
				<input type="text" name="memberPhone">
				        
		    </td>
		</tr>
		<tr><td>이메일 주소  </td>
			<td>
				<input type="text" name="memberEmail" 
					size=30/>
			</td>
		</tr>
		<tr><td>이메일 수신여부 </td>
		    <td>
				<input type="radio" name="ReceiveMail"
				      value="y" checked>동의
				<input type="radio" name="ReceiveMail"
				      value="n" />거부    
		    </td>
		</tr>
		<tr><td>우편번호(5자리)  </td>
			<td>
				<input type="text" name="postcode" 
					size=10/>
			</td>
		</tr>
		<tr><td>주소  </td>
			<td>
				<input type="text" name="addr1" 
					size=30/>
			</td>
		</tr>
		<tr><td>상세주소  </td>
			<td>
				<input type="text" name="addr2" 
					size=30/>
			</td>
		</tr>
		<tr><td colspan=2 align="center">
				<a href="javascript:checkIt();">
				수정하기</a>&nbsp;&nbsp;
				<a href="javascript:joinform.reset()">
				다시작성</a>
			</td>
		</tr>
	</table>
</form>

<hr>
<center><a href = "mypageMain.tb">마이페이지로 이동</a></center>
<center><a href = "main.tb">메인으로 이동</a></center>
</body>
</html>