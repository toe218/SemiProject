package controller2.Review;

import java.util.ArrayList;    
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReviewDao;

public class ReviewListAction implements Action{
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) // 재정의할 메소드 execute()
			throws Exception{
		
		ActionForward forward = new ActionForward();
		
		ReviewDao reviewDAO= new ReviewDao();
		List reviewlist = new ArrayList();
		
		int page = 1; // 1페이지를 기본값
		int limit = 10; // 한페이지의 최대 출력 갯수
		
		// 요청한 페이지가 있는 경우 >> 페이지를 받아옴
		if(request.getParameter("page") != null) {
			
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		// 페이지를 나누기 위해서는 총 게시글의 갯수를 가져오기
		
		int listcount = reviewDAO.getListCount();
		
		reviewlist = reviewDAO.getReviewList(page,limit); // page에 해당되는 게시글을 limit개수만큼 가져오겠다
		
		int maxpage = (int)((double)listcount/limit + 0.95); // 총페이지수 >> 0.95만큼을 더하고 정수화하면 올림과 같음 //현재 보여줄 페이지수 (1~10,11~20)
		int startpage = ((int)((double)page/10+0.9)-1)*10+1; // 페이지가 바뀐 다음에 시작되는 번호 >> 현재 페이지 값을 줘야, 어떤 범위의 페이지 목록을 보여줄지 정할 수 있다 
		int endpage = startpage+10-1;
		if(endpage>maxpage){endpage = maxpage;} 
			
		// 페이지 정보를 request에 저장하여 전달
		request.setAttribute("page", page); 
		request.setAttribute("maxpage", maxpage); 
		request.setAttribute("startpage", startpage); 
		request.setAttribute("endpage", endpage); 
		request.setAttribute("listcount", listcount); 
		request.setAttribute("reviewlist", reviewlist); 
		
		forward.setPath("./ReviewView/reviewList.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
