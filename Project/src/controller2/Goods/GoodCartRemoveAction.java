package controller2.Goods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller2.Review.Action;
import controller2.Review.ActionForward;
import biz.CartBiz;

public class GoodCartRemoveAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		request.setCharacterEncoding("UTF-8");
		ActionForward forward = new ActionForward();

		String[] goodsName =request.getParameterValues("delete");
		
		CartBiz cartBiz = new CartBiz();
		
		cartBiz.removeCartItem(request, goodsName);
		
		forward.setRedirect(true);
		forward.setPath("./GoodCartList.go");
		
		return forward;
	}
}
