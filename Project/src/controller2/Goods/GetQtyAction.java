package controller2.Goods;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.Cart;
import controller2.Review.Action;
import controller2.Review.ActionForward;
import dto.Goods;

public class GetQtyAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		ActionForward forward = new ActionForward();
		List cartList = (List)session.getAttribute("cartList");
		Goods good  = null;
		List buyList = new ArrayList();
		
		String str = request.getParameter("str");
		String str2 = str.substring(9);
		String[] goodNumber = str2.split(",");
		
		System.out.println(str2);
		
		for(String key : goodNumber) {
			
			int key2 = Integer.parseInt(key);
			
			System.out.println(key2);
			
			for(int i =0 ;i<cartList.size();i++ ) {
			
				Cart cart = (Cart)cartList.get(i);
				
				if(cart.getGoodsNumber()==key2){
					
					good = new Goods();
					
					good.setGoodsNumber(cart.getGoodsNumber());
					good.setGoodsName(cart.getGoodsName());
					good.setGoodsPrice(cart.getGoodsPrice());
					good.setGoodsImage(cart.getGoodsImage());
					good.setSalesQty(cart.getQty());
					
					buyList.add(good);
					
				}
			}
		}
		
		request.setAttribute("buyList", buyList);
		forward.setPath("./GoodsView/goodCartListPay.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
