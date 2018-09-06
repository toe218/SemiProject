package controller2.Review;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;

public class ReviewWriteAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception{
		
		ActionForward forward = new ActionForward();
		
		forward.setPath("./ReviewView/reviewWriter.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
