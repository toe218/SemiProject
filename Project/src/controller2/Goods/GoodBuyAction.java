package controller2.Goods;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import controller2.Review.Action;
import controller2.Review.ActionForward;
import dao.GoodsDao;
import dto.Goods;

public class GoodBuyAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		ActionForward forward = new ActionForward();
		GoodsDao dao = new GoodsDao();
		Goods go = new  Goods();
		List list = new ArrayList();
		
		int goodsNumber = Integer.parseInt(request.getParameter("goodsNumber"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		
		System.out.println(goodsNumber);
		System.out.println(qty);
		/*int goodMoney = Integer.parseInt(request.getParameter("goodMoney"));
		String goodsName = request.getParameter("goodsName");
		String goodsImage = request.getParameter("goodsImage");
		
		go.setGoodsNumber(goodsNumber);
		go.setGoodsName(goodsName);
		go.setSalesQty(qty);
		go.setGoodsPrice(goodMoney);
		go.setGoodsImage(goodsImage);
		
		list.add(go);
		*/
		
		
		
		
		
		
		
		
		forward.setRedirect(false);
		forward.setPath("./GoodsView/goodPay.jsp");
		
		return forward;

	}
}