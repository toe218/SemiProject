package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO.MemberDAO;
import model.DTO.Member;

public class IdFindAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		System.out.println("IdFindAction디버그");	
		ActionForward forward = null;
		MemberDAO dao = new MemberDAO();
		Member dto = new Member();	
		
		dto.setMemberEmail(request.getParameter("memberEmail"));
		
		int i = dao.idFind(dto);
		
		if (i==1) {
			
		
			request.setAttribute("id", dto.getMemberId());
		
		
		}
		forward.setRedirect(false);
		forward.setPath("./findResult.tb");
		return forward;
	}
	
}

