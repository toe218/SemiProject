package controller2.Review;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;

import dao.ReviewDao;
import dto.Board;
public class ReviewModifyView implements Action{

public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		request.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		ReviewDao boarddao = new ReviewDao();
		Board boarddata = new Board();

		int num = Integer.parseInt(request.getParameter("num"));
		
		boarddata = boarddao.getDetail(num);
		
		System.out.println("수정할 글 로딩 완료");
		
		request.setAttribute("boarddata", boarddata);
		
		forward.setRedirect(false);
		forward.setPath("./ReviewView/reviewModify.jsp");
		
		return forward;
	}
	
}

