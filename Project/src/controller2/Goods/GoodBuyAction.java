package controller2.Goods;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;

import controller2.Review.Action;
import controller2.Review.ActionForward;

public class GoodBuyAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		forward.setPath("./GoodsView/goodPay.jsp");
		
		return forward;

	}
}