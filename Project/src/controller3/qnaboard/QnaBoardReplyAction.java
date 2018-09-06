package controller3.qnaboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model3.DAO.QnaBoardDAO;
import model3.DTO.QnaBoardBean;

public class QnaBoardReplyAction implements Action {
	public ActionForward execute(
			HttpServletRequest request,
			HttpServletResponse response) 
				throws Exception {
		request.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		QnaBoardDAO qnaboarddao = new QnaBoardDAO();
		QnaBoardBean qnaboarddata = new QnaBoardBean();
		
		qnaboarddata.setQnaNum(Integer.parseInt(request.getParameter("QNA_NUM")));
		qnaboarddata.setMemberId(request.getParameter("MEMBER_ID"));
		qnaboarddata.setQnaPw(request.getParameter("QNA_PW"));
		qnaboarddata.setQnaSubject(request.getParameter("QNA_SUBJECT"));
		qnaboarddata.setQnaContent(request.getParameter("QNA_CONTENT"));
		qnaboarddata.setQnaRef(Integer.parseInt(request.getParameter("QNA_REF")));
		qnaboarddata.setQnaLev(Integer.parseInt(request.getParameter("QNA_LEV")));
		qnaboarddata.setQnaSeq(Integer.parseInt(request.getParameter("QNA_SEQ")));
		int result = qnaboarddao.boardReply(qnaboarddata);
		if(result==0) {
			System.out.println("답장 실패");
			return null;
		}
		System.out.println("답장 완료");
		forward.setRedirect(true);
		forward.setPath("./QnaBoardDetailAction.bb?num="+result);
		return forward;
	}

}
