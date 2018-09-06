package controller3.qnaboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model3.DAO.QnaBoardDAO;
import model3.DTO.QnaBoardBean;

public class QnaBoardModifyView implements Action {
	public ActionForward execute(
			HttpServletRequest request,
			HttpServletResponse response) 
				throws Exception {
		ActionForward forward =new ActionForward();
		QnaBoardDAO qnaboarddao = new QnaBoardDAO();
		QnaBoardBean qnaboarddata = new QnaBoardBean();
		int num = Integer.parseInt(request.getParameter("num"));
		qnaboarddata = qnaboarddao.getDetail(num);
		System.out.println("11111"+qnaboarddata.getQnaContent());
		System.out.println("수정 상세보기");
		request.setAttribute("qnaboarddata", qnaboarddata);
		forward.setRedirect(false);
		forward.setPath("./QnaBoarderView/qna_board_modify.jsp");
		
		return forward;
	}
}
