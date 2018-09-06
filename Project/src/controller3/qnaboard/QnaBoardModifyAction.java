package controller3.qnaboard;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model3.DAO.QnaBoardDAO;
import model3.DTO.QnaBoardBean;

public class QnaBoardModifyAction implements Action {
	public ActionForward execute(
			HttpServletRequest request,
			HttpServletResponse response)
				throws Exception {
		ActionForward forward = new ActionForward();
		QnaBoardDAO qnaboarddao = new QnaBoardDAO();
		QnaBoardBean qnaboarddata = new QnaBoardBean();
		
		boolean usercheck = false;
		usercheck = qnaboarddao.isBoardWriter(
				Integer.parseInt(
				request.getParameter("QNA_NUM")),
				request.getParameter("QNA_PW"));
		if(usercheck==false) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정할 권한이 없습니다.');");
			out.println("location.href='.QnaBoardList.bb';");
			out.println("</script>");
			out.close();
			return null;
		}
		qnaboarddata.setQnaNum(Integer.parseInt(request.getParameter("QNA_NUM")));
		qnaboarddata.setQnaSubject(request.getParameter("QNA_SUBJECT"));
		qnaboarddata.setQnaContent(request.getParameter("QNA_CONTENT"));
		int result = qnaboarddao.boardModify(qnaboarddata);
		forward.setRedirect(true);
		forward.setPath("./QnaBoardDetailAction.bb?num="+qnaboarddata.getQnaNum());
		
		
		
		
		
		
		return forward;
	}
}
