package controller2.Goods;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;

import controller2.Review.Action;
import controller2.Review.ActionForward;
import dao.GoodsDao;


public class GoodsListAction implements Action { // DB에 저장된 리스트를 가져와서 JSP파일에 보내기 위한 클래스 + 오늘 본 상품

		public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

			Cookie[] cookies = request.getCookies();
			List<String> images = new ArrayList<String>();
			if(cookies != null) {
				for(int i =0 ;i < cookies.length ;i++) {
					if(cookies[i].getName().startsWith("image")){
						images.add(cookies[i].getValue());
					}
				}
			}
			request.setAttribute("images", images);
			
			GoodsDao dao = new GoodsDao();
			List goods = dao.goodsGet();
			request.setAttribute("goods", goods);
			
			ActionForward forward = new ActionForward();
			forward.setPath("./GoodsView/goodsList.jsp");
			forward.setRedirect(false);
			
			return forward;
		}
}