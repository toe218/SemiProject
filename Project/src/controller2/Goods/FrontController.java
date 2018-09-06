package controller2.Goods;

import java.io.IOException;     

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller2.Review.Action;
import controller2.Review.ActionForward;


public class FrontController extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		doProcess(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
				
		doProcess(request,response);
	}
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		Action action = null;
		ActionForward forward = null;
		
		if(command.equals("/main.go")) {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/GoodsView/main.jsp");
			
			try {
				
				dispatcher.forward(request, response);
			
			}catch(Exception e) {
				
				e.printStackTrace();
			
			}
				
		}else if(command.equals("/GoodsWriter.go")) {
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("./GoodsView/goodsWriter.jsp");
			
			try {
				
				dispatcher.forward(request, response);
			
			}catch(Exception e) {
				
				e.printStackTrace();
			
			}
			
		}else if(command.equals("/GoodsAddAction.go")) {
			
			action = new GoodsAddAction();
			
			try {
				forward = action.execute(request, response);
			
			}catch(Exception e) {
				
				e.printStackTrace();
			
			}
			
		}else if(command.equals("/GoodsList.go")) {
			
			action = new GoodsListAction();
			
			try {
				forward = action.execute(request, response);
			
			}catch(Exception e) {
				
				e.printStackTrace();
			
			}
			
		}else if(command.equals("/GoodView.go")) {
			
			action = new GoodsViewAction();
			
			try {
				forward = action.execute(request, response);
			
			}catch(Exception e) {
				
				e.printStackTrace();
			
			}
			
		}else if(command.equals("/GoodCartAdd.go")) {
			
			action = new GoodCartAddAction();
			
			try {
				forward = action.execute(request, response);
			
			}catch(Exception e) {
				
				e.printStackTrace();
			
			}
				
		}else if(command.equals("/GoodCartList.go")) {
			
			action = new GoodCartListAction();
			
			try {
				forward = action.execute(request, response);
			
			}catch(Exception e) {
				
				e.printStackTrace();
			
			}
		}else if(command.equals("/GoodCartQtyUp.go")) {
			
			action = new GoodCartQtyUpAction();
			
			try {
				forward = action.execute(request, response);
			
			}catch(Exception e) {
				
				e.printStackTrace();
			
			}
			
		}else if(command.equals("/GoodCartQtyDown.go")) {
			
			action = new GoodCartQtyDownAction(); // DAO는사용하지 않지만 session에 있는 수량을 변경하기 위해서 Action을 활용
			
			try {
				forward = action.execute(request, response);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
				
		}else if(command.equals("/GoodCartRemove.go")) {
			
			action = new GoodCartRemoveAction(); // DAO는사용하지 않지만 session에 있는 장바구니 상품을 삭제하기 위해서 dao를 활용
			
			try {
				forward = action.execute(request, response);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
				
		}else if(command.equals("/GoodBuy.go")) {
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("./GoodsView/goodPay.jsp");
			
			try {
				
				dispatcher.forward(request, response);
			
			}catch(Exception e) {
				
				e.printStackTrace();
			
			}
				
		}else if(command.equals("/GoodPay.go")) {
			
			action = new GoodsPayAction();
			
			try {
				
				forward = action.execute(request, response);
				
			}catch(Exception e) {
				
				e.printStackTrace();
			}
				
		}else if(command.equals("/GoodsDelete.go")) {
			
			action = new GoodsDeleteAction();
			
			try {
				
				forward = action.execute(request, response);
				
			}catch(Exception e) {
				
				e.printStackTrace();
			}
				
		}
	
		if(forward != null) {
			
			try {
			
				if(forward.isRedirect()){
			
					response.sendRedirect(forward.getPath());
				
			}else {
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
				
			}
		
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
			
		}
		
	}
	
}