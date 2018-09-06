package controller3.qnaboard;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model3.DAO.QnaBoardDAO;

public class QnaBoardDeleteAction implements Action {
	public ActionForward execute(
			HttpServletRequest request,
			HttpServletResponse response) 
				throws Exception {
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("utf-8");
		int num = Integer.parseInt(request.getParameter("num"));
		String QNA_PW = request.getParameter("QNA_PW");
		QnaBoardDAO qnaboarddao = new QnaBoardDAO();
		boolean usercheck = qnaboarddao.isBoardWriter(num, QNA_PW);
		if(usercheck==false) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제할 권한이 없습니다');");
			out.println("location.href='.QnaBoardList.bb';");
			out.println("</script>");
			out.close();
			return null;
		}
		int result = qnaboarddao.boardDelete(num);
		if(result==0) {
			System.out.println("게시판 삭제 실패");
			return null;
		}
		System.out.println("게시판 삭제 성공");
		forward.setRedirect(true);
		forward.setPath("./QnaBoardList.bb");
		
		return forward;
	}
}


