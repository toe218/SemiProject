package controller2.Goods;

import java.net.URLEncoder; 

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;

import controller2.Review.Action;
import controller2.Review.ActionForward;
import dao.GoodsDao;
import dto.Goods;

public class GoodsViewAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int goodsNumber = Integer.parseInt(request.getParameter("goodsNumber"));
		
		GoodsDao dao = new GoodsDao();
		Goods good = dao.getGood(goodsNumber);
		request.setAttribute("good", good);
		
		Cookie cookie = new Cookie("image"+goodsNumber, URLEncoder.encode(good.getGoodsImage()));
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./GoodsView/goodView.jsp");
		forward.setRedirect(false);
		
		return forward;
	
	}

}
