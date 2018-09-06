package controller3.qnaboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model3.DAO.QnaBoardDAO;
import model3.DTO.QnaBoardBean;

public class QnaBoardDetailAction implements Action {
	public ActionForward execute(
			HttpServletRequest request,
			HttpServletResponse response) 
				throws Exception {
		request.setCharacterEncoding("UTF-8");
		ActionForward forward = null;
		QnaBoardDAO qnaboarddao = new QnaBoardDAO();
		QnaBoardBean qnaboarddata = new QnaBoardBean(); 
		
		int num = Integer.parseInt(request.getParameter("num"));
		qnaboarddata = qnaboarddao.getDetail(num);
		if(qnaboarddata == null) {
			System.out.println("상세보기 실패");
			return null;
		}
		System.out.println("상세보기 성공");
		request.setAttribute("qnaboarddata", qnaboarddata);
		forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./QnaBoarderView/qna_board_view.jsp");
		
		return forward;
	}
}
