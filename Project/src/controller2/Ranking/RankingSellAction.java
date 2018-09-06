package controller2.Ranking;

import java.util.List;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;

import controller2.Review.Action;
import controller2.Review.ActionForward;
import dao.GoodsDao;

public class RankingSellAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		
		GoodsDao dao = new GoodsDao();
		
		List rank = dao.getSellRank();
		
		request.setAttribute("rank", rank);
		
		forward.setRedirect(false);
		forward.setPath("./RankingView/rankingSellList.jsp");
		
		return forward;
	}

}
