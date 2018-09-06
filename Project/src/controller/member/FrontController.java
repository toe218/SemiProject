package controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class FrontController extends javax.servlet.http.HttpServlet
							implements javax.servlet.Servlet {

	
	protected void doProcess (HttpServletRequest request, HttpServletResponse response) {
		
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = uri.substring(contextPath.length());
		
		Action action = null;
		ActionForward forward = null;
		
		if (command.equals("/main.tb")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./MemberView/main.jsp");
		} else if(command.equals("/login.tb")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./MemberView/login.jsp");
			
		} else if (command.equals("/join.tb")) {
			forward = new ActionForward ();
			forward.setRedirect(false);
			forward.setPath("./MemberView/joinForm.jsp");
		} else if (command.equals("/intro.tb")) {
			forward = new ActionForward ();
			forward.setRedirect(false);
			forward.setPath("./IntroView/intro.jsp");
		}else if (command.equals("/terms.tb")) {
			forward = new ActionForward ();
			forward.setRedirect(false);
			forward.setPath("./MemberView/terms.jsp");
		}else if (command.equals("/find.tb")) {
			forward = new ActionForward ();
			forward.setRedirect(false);
			forward.setPath("./MemberView/find.jsp");
		}else if (command.equals("/search.tb")) {
			forward = new ActionForward ();
			forward.setRedirect(false);
			forward.setPath("./SearchView/search.jsp");

		}else if (command.equals("/memberOut.tb")) {
			forward = new ActionForward ();
			forward.setRedirect(false);
			forward.setPath("./MypageView/memberOut.jsp");
			
		}  else if (command.equals("/pointMoney.tb")) {
			forward = new ActionForward ();
			forward.setRedirect(false);
			forward.setPath("./MypageView/pointMoney.jsp");
		} else if (command.equals("/myOrders.tb")) {
			forward = new ActionForward ();
			forward.setRedirect(false);
			forward.setPath("./MypageView/myOrders.jsp");
		} else if (command.equals("/wishList.tb")) {
			forward = new ActionForward ();
			forward.setRedirect(false);
			forward.setPath("./MypageView/wishList.jsp");
		} else if (command.equals("/cartList.tb")) {
			forward = new ActionForward ();
			forward.setRedirect(false);
			forward.setPath("./MypageView/cartList.jsp");
		} else if (command.equals("/payment.tb")) {
			forward = new ActionForward ();
			forward.setRedirect(false);
			forward.setPath("./MypageView/payment.jsp");
			
		} else if (command.equals("/adminMain.tb")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./AdminView/adminMain.jsp");
			
		}
		// 액션
		else if (command.equals("/joinAction.tb")) {
			action = new JoinAction();
			try {
				forward = action.execute(request, response);
				} catch(Exception e) {
					e.printStackTrace();
			}
			forward = new ActionForward ();
			forward.setRedirect(false);
			forward.setPath("./MemberView/login.jsp");
		} else if(command.equals("/loginAction.tb")) {
			action = new LoginAction();
			try {
				forward = action.execute(request, response);
				} catch(Exception e) {
					e.printStackTrace();
			}
			forward = new ActionForward ();
			forward.setRedirect(false);
			forward.setPath("./MemberView/main.jsp");
			
		} else if(command.equals("/logout.tb")) {
			action = new LogoutAction ();
			try {
				forward = action.execute(request, response);
				} catch(Exception e) {
					e.printStackTrace();
			}
			forward = new ActionForward ();
			forward.setRedirect(false);
			forward.setPath("./MemberView/main.jsp");
			
		} else if (command.equals("/mypageMain.tb")) {
			
			
			
			forward = new ActionForward ();
			forward.setRedirect(false);
			forward.setPath("./MypageView/mypageMain.jsp");
			
		} else if (command.equals("/idFind.tb")) {
			action = new IdFindAction();
			System.out.println("iddebug");
			try {
				forward = action.execute(request, response);
				} catch(Exception e) {
					e.printStackTrace();
			}
			
			
		} else if (command.equals("/memberOutAction.tb")) {
			action = new MemberOutAction();
			System.out.println("memberOutActionDebug");
			try {
				forward = action.execute(request, response);
				} catch(Exception e) {
					e.printStackTrace();
			}
			forward.setRedirect(false);
			forward.setPath("./main.tb");
			
			
		} else if (command.equals("/modifyView.tb")) {
			action = new ModifyViewAction();
			System.out.println("modifyViewActionDebug");
			try {
				forward = action.execute(request, response);
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			forward.setRedirect(true);
			forward.setPath("./MypageView/modifyForm.jsp");
			
		}
	
		
		
		
		if(forward != null) {
			try {
				if(forward.isRedirect()==true) {
					response.sendRedirect(forward.getPath());
				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
					dispatcher.forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response) 
						throws ServletException, IOException {
		
		doProcess (request, response);
		
	}
	
	protected void doPost (HttpServletRequest request, HttpServletResponse response) 
						throws ServletException, IOException {
		doProcess (request, response);
	}
}
