package controller2.Review;

import java.io.PrintWriter; 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller2.Review.Action;
import controller2.Review.ActionForward;
import dao.ReviewDao;
import dto.Board;

public class ReviewModifyAction implements Action{

public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		request.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		ReviewDao boarddao = new ReviewDao();
		Board boarddata = new Board();
		
		boolean usercheck = false;
		
		usercheck = boarddao.isReviewWriter(Integer.parseInt(request.getParameter("boardNum")), request.getParameter("boardPw"));
		
		if(usercheck==false) {
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('비밀번호가 일치하지 않아 수정할 권한이 없습니다.');");
			out.println("location.href='./ReviewList.re';");
			out.println("</script>");
			out.close();
			
			return null;
			
		}
		boarddata.setBoardNum(Integer.parseInt(request.getParameter("boardNum")));
		boarddata.setBoardSubject(request.getParameter("boardSubject"));
		boarddata.setBoardContent(request.getParameter("boardContent"));
		
		int result = boarddao.boardModify(boarddata);
		
		if(result != 0){
			
			System.out.println(boarddata.getBoardNum()+"번글이 수정되었습니다");
			
		}else{
		
			System.out.println("수정실패");
		
		}
		
		forward.setRedirect(true);
		forward.setPath("./ReviewDetailAction.re?num="+ boarddata.getBoardNum());
		
		return forward;

	}
}