package controller2.Review;

import java.io.PrintWriter;  

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller2.Review.Action;
import controller2.Review.ActionForward;
import dao.ReviewDao;

public class ReviewDeleteAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		request.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		ReviewDao boarddao = new ReviewDao();
		
		
		int num = Integer.parseInt(request.getParameter("num"));
		String BOARD_PASS = request.getParameter("boardPw");
		
		boolean usercheck = boarddao.isReviewWriter(num, BOARD_PASS);
		
		if(usercheck==false) {
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('비밀번호가 일치하지 않아 삭제할 권한이 없습니다.');");
			out.println("location.href='./ReviewList.re';");
			out.println("</script>");
			out.close();
		
			return null;
		}
		
		int result = boarddao.boardDelete(num);
		
		if(result==0) {
			
			System.out.println("삭제 실패");
		}
		System.out.println("삭제 성공");
		
		forward.setRedirect(true);
		forward.setPath("./ReviewList.re");
		
		return forward;
		
	}
}



