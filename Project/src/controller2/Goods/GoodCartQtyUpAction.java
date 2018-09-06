package controller2.Goods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller2.Review.Action;
import controller2.Review.ActionForward;
import biz.CartBiz;

public class GoodCartQtyUpAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		String goodsName = request.getParameter("goodsName");
		
		//session에 있는 상품 수량 변경
		CartBiz cartBiz = new CartBiz();
		cartBiz.upCartQty(request, goodsName);
		
		forward.setRedirect(true);
		forward.setPath("./GoodCartList.go");
		
		return forward;
	}
}