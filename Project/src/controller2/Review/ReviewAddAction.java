package controller2.Review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.ReviewDao;
import dto.Board;

public class ReviewAddAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) // 재정의할 메소드 execute()
			throws Exception{
		
		int i = 0;	
		
		ActionForward forward = new ActionForward();
		ReviewDao reviewDAO = new ReviewDao();
		Board reviewDTO = new Board(); 
		
		String realFolder = request.getRealPath("/boardupload");
		int fileSize = 5*1024*1024; // 파일크기 최대 5mb
		MultipartRequest multi = null; //파일을 저장하기 위한 클래스
		multi = new MultipartRequest(request, realFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy()); // 파일저장 완료
		
		// DTO에 REQUEST로 받은 값들을 저장
		reviewDTO.setBoardSubject((multi.getParameter("boardSubject")));
		reviewDTO.setBoardContent(multi.getParameter("boardContent"));
		reviewDTO.setBoardPw(multi.getParameter("boardPw"));
		reviewDTO.setBoardImage(multi.getFilesystemName((String)multi.getFileNames().nextElement()));
		// DTO에 저장 끝!
		
		// DAO에 데이터를전달
		i = reviewDAO.reviewInsert(reviewDTO);
		
		if(i>0) {
			System.out.println("리뷰 DB저장 완료");
		}else {
			System.out.println("리뷰 DB저장 실패");
		}
		
		forward.setPath("./ReviewList.re");
		forward.setRedirect(true);
		
		return forward;
	}

}
