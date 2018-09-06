package controller2.Review;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;

import controller2.Review.Action;
import controller2.Review.ActionForward;
import dao.ReviewDao;
import dto.Board;

public class ReviewReplyAction implements Action{

public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		request.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		ReviewDao boarddao = new ReviewDao();
		Board boarddata = new Board();
		
		boarddata.setBoardNum(Integer.parseInt(request.getParameter("boardNum")));
		boarddata.setBoardWriter(request.getParameter("boardWriter"));
		boarddata.setBoardPw(request.getParameter("boardPw"));
		boarddata.setBoardSubject(request.getParameter("boardSubject"));
		boarddata.setBoardContent(request.getParameter("boardContent"));
		boarddata.setBoardRef(Integer.parseInt(request.getParameter("boardRef")));
		boarddata.setBoardLev(Integer.parseInt(request.getParameter("boardLev")));
		boarddata.setBoardSeq(Integer.parseInt(request.getParameter("boardSeq")));
		
		int result= boarddao.boardReply(boarddata);
		if(result==0) {
		System.out.println("답글 DB 저장 실패");
		return null;
		}
		System.out.println("답글 DB 저장 성공");
		
		forward.setRedirect(true);
		forward.setPath("./ReviewDetailAction.re?num="+result);
		
		return forward;
	}
}
