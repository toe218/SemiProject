package controller3.qnaboard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QnaBoardFrontController 
	extends javax.servlet.http.HttpServlet
	implements javax.servlet.Servlet {
	
	protected void doProcess(HttpServletRequest request,
			HttpServletResponse response) {
		
		String RequestURI = request.getRequestURI();
		String ContextPath = request.getContextPath();
		String command = 
		RequestURI.substring(ContextPath.length());
		ActionForward forward = null;
		Action action = null;
		
		if(command.equals("/QnaBoardList.bb")) {
			action = new QnaBoardListAction();
			try {
			forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/QnaBoardWrite.bb")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("./QnaBoarderView/qna_board_write.jsp");
			try { 
				dispatcher.forward(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/QnaBoardAddAction.bb")) {
			action = new QnaBoardAddAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/QnaBoardDetailAction.bb")) {
			action = new QnaBoardDetailAction();
			try { 
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/QnaBoardReplyView.bb")) {
			action = new QnaBoardReplyView();
			try { 
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/QnaBoardReplyAction.bb")) {
			action = new QnaBoardReplyAction();
			try { 
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		} else if(command.equals("/QnaBoardModify.bb")) {
			action = new QnaBoardModifyView();
			try { 
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/QnaBoardModifyAction.bb")) {
			action = new QnaBoardModifyAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/QnaBoardDelete.bb")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./QnaBoarderView/qna_board_delete.jsp");
		} else if(command.equals("/QnaBoardDeleteAction.bb")) {
			action = new QnaBoardDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} 
		
		if(forward != null) {
			try { 
				if(forward.isRedirect()) {
					response.sendRedirect(
							forward.getPath());
				} else {
					RequestDispatcher dispatcher = 
							request.getRequestDispatcher(forward.getPath());
					dispatcher.forward(request, response);
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
				throws ServletException, IOException {
		
		System.out.println("get");
		doProcess(request, response);
	}
	public void doPost(HttpServletRequest request,
			HttpServletResponse response) 
				throws ServletException, IOException {
		
		System.out.println("post");
		doProcess(request, response);
	}

}
