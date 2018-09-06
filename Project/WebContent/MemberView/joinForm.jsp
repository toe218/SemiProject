<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="joinForm" action="./joinAction.tb" method="post" 
	id="joinForm">
	<table border=1 align="center">
		<tr><td colspan =2 >
				<font size=5>회원가입 페이지</font>
			</td>
		</tr>
		<tr><td>ID  </td>
			<td>
				<input type="text" name="memberId" /> &nbsp;
				<input type="button" value="ID중복확인">
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
		    <td>
				<input type="text"  name="memberName"/>    
		    </td>
		</tr>
		<tr><td>나이  </td>
			<td>
				<input type="text" name="memberAge"/>	
			</td>
		</tr>
		<tr><td>성별 </td>
		    <td>
				<input type="radio" name="memberGender"
				      value="M" >남자 
				<input type="radio" name="memberGender"
				      value="F" />여자     
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
				<input type="radio" name="receiveMail"
				      value="Y" checked>동의
				<input type="radio" name="receiveMail"
				      value="N" />거부    
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
				<input type="submit" value="가입(임시)">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
</form>

<br/>
<hr>
	<center><a href = "./main.tb">메인페이지로 이동</a></center>
</body>
</html>