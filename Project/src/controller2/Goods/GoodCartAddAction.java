package controller2.Goods;

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import controller2.Review.Action;
import controller2.Review.ActionForward;
import dao.GoodsDao;
import dto.Goods;
import biz.CartBiz;


public class GoodCartAddAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		GoodsDao dao = new GoodsDao();
		
		int goodsNumber= Integer.parseInt(request.getParameter("goodsNumber"));
		Goods good = dao.getGood(goodsNumber);
		
		//session에 상품을 등록
		CartBiz cartBiz = new CartBiz(); 
		cartBiz.addCart(request,good);
		
		forward.setRedirect(true);
		forward.setPath("./GoodCartList.go");
		
		return forward;
	}

}
