
package controller3.qnaboard;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model3.DAO.QnaBoardDAO;

public class QnaBoardListAction implements Action {
	ActionForward forward = null;
	public ActionForward execute(
			HttpServletRequest request,
			HttpServletResponse response) 
				throws Exception {
		
		QnaBoardDAO qnaboarddao = new QnaBoardDAO();
		List qnaboardList = new ArrayList();
		
		int page = 1;
		int limit = 10;
		
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
			
		}
		
		int listcount = qnaboarddao.getListCount();
		qnaboardList = qnaboarddao.getBoardList(page,limit);
		int maxpage = (int)((double)listcount/limit+0.95);
		int startpage = ((int)((double)page/10+0.9)-1)*10+1;
		int endpage = startpage+10-1;
		if(endpage>maxpage) endpage = maxpage;
		
		request.setAttribute("page", page);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("listcount", listcount);
		request.setAttribute("qnaboardList", qnaboardList);
		
		forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./QnaBoarderView/qna_board_list.jsp");
		
		return forward;
	}
	
}
