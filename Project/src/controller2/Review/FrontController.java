package controller2.Review;

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
		
		if(command.equals("/ReviewList.re")) {
			
			action = new ReviewListAction();
			
			try {
				forward = action.execute(request, response);
				
			}catch(Exception e) {
				e.printStackTrace();
			
			}
			
		}else if(command.equals("/ReviewWrite.re")) {
			
			action = new ReviewWriteAction();
			
			try {
				forward = action.execute(request, response);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
				
		}else if(command.equals("/ReviewAddAction.re")) {
			
			action = new ReviewAddAction();
			
			try {
				forward = action.execute(request, response);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else if(command.equals("/ReviewDetailAction.re")) {
			
			action = new ReviewDetailAction();
			
			try {
				forward = action.execute(request, response);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
				
		}else if(command.equals("/ReviewReplyView.re")) {
			
			action = new ReviewReplyView();
			
			try {
				forward = action.execute(request, response);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
				
		}else if(command.equals("/ReviewReplyAction.re")) {
			
			action = new ReviewReplyAction();
			
			try {
				forward = action.execute(request, response);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else if(command.equals("/ReviewModify.re")) {
			
			action = new ReviewModifyView();
			
			try {
				forward = action.execute(request, response);
				
			}catch(Exception e) {
				
				e.printStackTrace();
			}
				
		}else if(command.equals("/ReviewModifyAction.re")) {
			
			action = new ReviewModifyAction();
			
			try {
				forward = action.execute(request, response);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
				
		}else if(command.equals("/ReviewDelete.re")) {
			
			forward = new ActionForward();
			
			forward.setRedirect(false);
			forward.setPath("./ReviewView/reviewDelete.jsp");
			
		}else if(command.equals("/ReviewDeleteAction.re")) {
			
			action = new ReviewDeleteAction();
			
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