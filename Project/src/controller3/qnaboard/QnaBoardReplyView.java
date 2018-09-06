package controller3.qnaboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model3.DAO.QnaBoardDAO;
import model3.DTO.QnaBoardBean;

public class QnaBoardReplyView implements Action{
	public ActionForward execute(
			HttpServletRequest request,
			HttpServletResponse response) 
				throws Exception {
		ActionForward forward = new ActionForward();
		QnaBoardDAO qnaboarddao = new QnaBoardDAO();
		QnaBoardBean qnaboarddata = new QnaBoardBean();
		int num = Integer.parseInt(request.getParameter("num"));
		qnaboarddata = qnaboarddao.getDetail(num);
		
		if(qnaboarddata==null) {
			System.out.println("답장 페이지 이동 실패");
			return null;
		}
		System.out.println("답장 페이지 이동 완료");
		request.setAttribute("qnaboarddata", qnaboarddata);
		
		forward.setRedirect(false);
		forward.setPath("./QnaBoarderView/qna_board_reply.jsp");
		
		return forward;
	}
}
