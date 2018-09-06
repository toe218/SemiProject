package controller2.Ranking;

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
		
		if(command.equals("/RankingList.ra")) {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("./RankingView/rankingPage.jsp");
			
			try {
				
				dispatcher.forward(request, response);
			
			}catch(Exception e) {
				
				e.printStackTrace();
			
			}
				
		}else if(command.equals("/RankingSell.ra")) {
		
			action = new RankingSellAction();
			
			try {
				forward = action.execute(request, response);
				
			}catch(Exception e) {
				e.printStackTrace();
			
			}
			
		}else if(command.equals("/RankingClick.ra")) {
		
			action = new RankingClickAction();
			
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