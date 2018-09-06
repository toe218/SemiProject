package biz;

import java.io.Serializable;    
import java.util.ArrayList; 
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dto.Goods;

public class CartBiz implements Serializable{ // 상품정보를 session에 저장하기위해 필요한 클래스
	
	public void addCart(HttpServletRequest request, Goods good) {
		
		HttpSession session = request.getSession(); // session을 만듬
		
		List cartList = (List)session.getAttribute("cartList"); // 장바구니 상품이 있다고 가정하고 감 >> 없으면 null로 들어감
		
		if(cartList==null){
		
			cartList = new ArrayList();
		
		}
		
		Cart cart = null; // 상품정보를 임시로 저장하기 위한 클래스 >> DTO와의 차이점 >> 상품정보외 "수량" 등의 구매정보를 포함시키기 위해서 만듬
		
		boolean newCart = true;// 새로운 상품인지 아닌지 확인하기 위한 변수
		
		for(int i =0;i < cartList.size();i++) {// session에 선택한 상품이 존재하는지 확인 
			
			cart = (Cart)cartList.get(i);
			
			if(good.getGoodsNumber() == cart.getGoodsNumber()) {
				newCart = false;
				cart.setQty(cart.getQty()+1);
			}
		}

		if(newCart) {
			
			cart = new Cart();
			
			cart.setGoodsNumber(good.getGoodsNumber());
			cart.setGoodsImage(good.getGoodsImage());
			cart.setGoodsName(good.getGoodsName());
			cart.setGoodsPrice(good.getGoodsPrice());
			cart.setQty(1);
			
			cartList.add(cart);
			
		}
		
		session.setAttribute("cartList", cartList);
	
	}
	
	public void downCartQty(HttpServletRequest request, String goodsName) {
		
		HttpSession session = request.getSession();
		List cartList = (List) session.getAttribute("cartList");
		
		for(int i=0;i<cartList.size();i++) {
			
			Cart cart =(Cart)cartList.get(i);
			
			if(cart.getGoodsName().equals(goodsName)) {
				
				cart.setQty(cart.getQty()-1); // session안의 값을 그대로 변경했으므로 따로 저장할 필요가 없다
			
			}
		}
	}
	
	public void upCartQty(HttpServletRequest request, String goodsName) {
		
		HttpSession session = request.getSession();
		List cartList = (List) session.getAttribute("cartList");
		
		for(int i=0;i<cartList.size();i++) {
			
			Cart cart =(Cart)cartList.get(i);
			
			if(cart.getGoodsName().equals(goodsName)) {
				
				cart.setQty(cart.getQty()+1); // session안의 값을 그대로 변경했으므로 따로 저장할 필요가 없다
			}
		}
		
	}
	
	public void removeCartItem(HttpServletRequest request, String[] goodsName) {
		
		HttpSession session = request.getSession();
		List list = (List)session.getAttribute("cartList");
		
		for (int i = 0; i < goodsName.length; i++){ //배열
			
			for(int j=0; j < list.size(); j++){ // 리스트
				
				Cart cart = (Cart)list.get(j);
				
				if(goodsName[i].equals(cart.getGoodsName())) {
					
					list.remove(list.get(j));
				}
			}
		}
	}
}
