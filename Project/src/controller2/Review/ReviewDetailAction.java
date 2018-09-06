package controller2.Review;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReviewDao;
import dto.Board;

public class ReviewDetailAction implements Action{
		
		public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
			
			request.setCharacterEncoding("UTF-8");
			ActionForward forward = new ActionForward();
			ReviewDao reviewDAO= new ReviewDao();
			Board bd = new Board();
			
			int num = Integer.parseInt(request.getParameter("num"));
			bd = reviewDAO.getDetail(num);
			
			if(bd==null) {
				
				System.out.println("상세보기할 글이 없습니다");
				return null;
				
			}
				System.out.println("상세보기 성공");
				request.setAttribute("board", bd);
			
			forward.setPath("./ReviewView/reviewView.jsp");
			forward.setRedirect(false);
			
			return forward;
		}

	}
