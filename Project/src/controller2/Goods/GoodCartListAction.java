package controller2.Goods;

import java.util.List; 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller2.Review.Action;
import controller2.Review.ActionForward;
import biz.Cart;

public class GoodCartListAction implements Action { // cartList만 넘겨주면 필요가 없지만 총합계 금액을 구하기 위해 만든 클래스

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		ActionForward forward = new ActionForward();
		
		// 총합계를 구하기 위해서 session에 있는 값을 List로 반환
		HttpSession session = request.getSession();
		List cartList = (List)session.getAttribute("cartList");
		int totalMoney =0; // 총합계 금액을 구하기 위한 변수
		
		if(cartList!=null) {
		
		for(int i =0 ;i<cartList.size();i++ ) {
			Cart cart = (Cart)cartList.get(i);
			int money = cart.getGoodsPrice()*cart.getQty();
			totalMoney+=money;
			}
		}
		
		request.setAttribute("totalMoney", totalMoney);
		request.setAttribute("cartList", cartList);
		
		forward.setRedirect(false);
		forward.setPath("./GoodsView/goodCartList.jsp");
		
		return forward;
	}
}
