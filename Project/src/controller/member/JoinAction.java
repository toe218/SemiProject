package controller.member;

import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO.MemberDAO;
import model.DTO.Member;

public class JoinAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
							throws Exception {
		System.out.println("joinAction디버그");// 디버그
		ActionForward forward = null;

		




		
		
		request.setCharacterEncoding("utf-8");
		
		MemberDAO dao = new MemberDAO();
		Member dto = new Member();
		
		dto.setMemberId(request.getParameter("memberId"));
		dto.setMemberPass(request.getParameter("memberPass"));
		dto.setMemberName(request.getParameter("memberName"));
		dto.setMemberAge(Integer.parseInt(request.getParameter("memberAge")));
		dto.setMemberGender(request.getParameter("memberGender"));
		dto.setMemberPhone(request.getParameter("memberPhone"));
		dto.setMemberEmail(request.getParameter("memberEmail"));
		dto.setReceiveMail(request.getParameter("receiveMail"));
		dto.setPostcode(request.getParameter("postcode"));
		dto.setAddr1(request.getParameter("addr1"));
		dto.setAddr2(request.getParameter("addr2"));
		
		int i = dao.joinMember(dto);
		
		if(i>0) {
			System.out.println("회원가입 완료!");
		
		
		}else {
			System.out.println("가입실패!");
		}
		

		return forward;
	}
}
