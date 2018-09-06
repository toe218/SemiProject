package controller2.Goods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller2.Review.Action;
import controller2.Review.ActionForward;
import dao.GoodsDao;

public class GoodsDeleteAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		request.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();
		
		GoodsDao dao = new GoodsDao();
		
		int goodsNumber = Integer.parseInt(request.getParameter("goodsNumber"));
		
		int result = dao.goodDelete(goodsNumber);
		
		if(result==0) {
			
			System.out.println("상품 삭제 실패");
		}
		
		System.out.println("상품 삭제 완료");
		
		forward.setRedirect(true);
		forward.setPath("./GoodsList.go");
		
		return forward;
		
	}
}



