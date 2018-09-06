package controller2.Goods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller2.Review.Action;
import controller2.Review.ActionForward;
import biz.CartBiz;

public class GoodCartQtyDownAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		
		String goodsName = request.getParameter("goodsName");
		CartBiz cartBiz = new CartBiz();
		cartBiz.downCartQty(request, goodsName);
		
		forward.setRedirect(true);
		forward.setPath("./GoodCartList.go");
		
		return forward;
	}
}