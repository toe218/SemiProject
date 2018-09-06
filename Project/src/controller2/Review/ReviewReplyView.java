package controller2.Review;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;

import controller2.Review.Action;
import controller2.Review.ActionForward;
import dao.ReviewDao;
import dto.Board;

public class ReviewReplyView implements Action {
		
		public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
			
			request.setCharacterEncoding("UTF-8");
			ActionForward forward = new ActionForward();
			ReviewDao boarddao = new ReviewDao();
			Board bd = new Board();
			
			int num = Integer.parseInt(request.getParameter("num"));
			
			bd = boarddao.getDetail(num);
			
			if(bd==null) {
				
				System.out.println("답글 페이지 이동 실패");
				return null;
				
			}
			
			System.out.println("답글 페이지 이동 완료");
			
			request.setAttribute("board", bd);
			
			forward.setRedirect(false);
			forward.setPath("./ReviewView/reviewReply.jsp");
			
			return forward;
		}
	}
