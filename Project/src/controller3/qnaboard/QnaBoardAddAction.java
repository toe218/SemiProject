package controller3.qnaboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model3.DAO.QnaBoardDAO;
import model3.DTO.QnaBoardBean;

public class QnaBoardAddAction implements Action{
	public ActionForward execute(
			HttpServletRequest request,
			HttpServletResponse response) 
				throws Exception {
		ActionForward forward = new ActionForward();
		QnaBoardDAO qnaboarddao = new QnaBoardDAO();
		QnaBoardBean qnaboarddata = new QnaBoardBean();
		
		System.out.println(request.getRealPath("/"));
		String realFolder = request.getRealPath("/boardupload");
		int filesize=5*1024*1024;
		int i = 0;
		
		MultipartRequest multi = null;
		multi = new MultipartRequest(
				request, realFolder, filesize, "UTF-8",
				new DefaultFileRenamePolicy());
		
		qnaboarddata.setMemberId(multi.getParameter("MEMBER_ID"));
		qnaboarddata.setQnaPw(multi.getParameter("QNA_PW"));
		qnaboarddata.setQnaSubject(multi.getParameter("QNA_SUBJECT"));
		qnaboarddata.setQnaContent(multi.getParameter("QNA_CONTENT"));
		qnaboarddata.setQnaImage(multi.getFilesystemName((String)multi.getFileNames().nextElement()));

		i = qnaboarddao.boardInsert(qnaboarddata);
		
		if(i>0) 
			System.out.println("게시글 저장");
		else System.out.println("게시글 저장 실패");
		forward.setRedirect(true);
		forward.setPath("./QnaBoardList.bb");
		
		return forward;
	}
}
