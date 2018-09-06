package controller2.Goods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller2.Review.Action;
import controller2.Review.ActionForward;
import dao.GoodsDao;
import dto.Goods;

public class GoodsPayAction implements Action {
	
public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		
		GoodsDao dao = new GoodsDao();
		
		int goodsNumber = Integer.parseInt(request.getParameter("goodsNumber"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		
		dao.pay(goodsNumber,qty);
		
		forward.setRedirect(true);
		forward.setPath("./GoodsList.go");
		
		return forward;

	}
}
