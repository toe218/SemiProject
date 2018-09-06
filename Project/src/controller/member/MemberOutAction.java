package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO.MemberDAO;
import model.DTO.Member;

public class MemberOutAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		System.out.println("memberOutDebug");	
		ActionForward forward = null;
		MemberDAO dao = new MemberDAO();
		Member dto = new Member();	
		
		
		
		
		
		
		return forward;
	}

}
