package controller.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAO.MemberDAO;
import model.DTO.Member;

public class ModifyViewAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
		throws Exception {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		
		ActionForward forward = null;
		MemberDAO dao = new MemberDAO();
		Member dto = new Member();
		
		dto.setMemberId(id);
		List list = dao.modifyView(dto);
		
		request.setAttribute("memberList", list);
		
		System.out.println("modifydebugging");
		
		return forward;
	}

}
