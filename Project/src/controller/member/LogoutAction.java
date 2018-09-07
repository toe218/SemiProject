package controller.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





public class LogoutAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		System.out.println("logoutAction디버그");	
		ActionForward forward = null;

			
		
	
	
		 
		request.getSession().removeAttribute("id");	
		
		
//		PrintWriter out = response.getWriter();
//		response.setContentType("text/html;charset=utf-8");
//		out.println("<script>");
//		out.println("alert('로그아웃 되었습니다.');");
//		out.println("</script>");
//		out.close();
//		
//		forward = new ActionForward();
//		forward.setRedirect(false);;
//		forward.setPath("./main.tb");
		
		return forward;

	}
}
