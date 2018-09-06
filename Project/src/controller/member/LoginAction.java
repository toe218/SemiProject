package controller.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAO.MemberDAO;
import model.DTO.Member;

public class LoginAction implements Action {
		public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
								throws Exception {
		System.out.println("loginAction디버그");	
		ActionForward forward = null;
		MemberDAO dao = new MemberDAO();
		Member dto = new Member();	
		
		dto.setMemberId(request.getParameter("memberId"));
		dto.setMemberPass(request.getParameter("memberPass"));
		int i = dao.isMember(dto);
		
		if(i==0) {
			System.out.println("비밀번호오류");
			return null;
		} else if(i==-1) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('등록되지 않은 회원입니다.');");
			
			out.print("</script>");
			out.close();
			return null;
		}
		
		
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();
		session.setAttribute("id", dto.getMemberId());
		
		if (request.getParameter("memberId").equals("admin") && request.getParameter("memberPass").equals("admin")) {
			System.out.println("관리자접속됨");
			PrintWriter out = response.getWriter();


		}
		
		
		return forward;
		}
}
