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
		
	   
		
		return forward;

	}
}
