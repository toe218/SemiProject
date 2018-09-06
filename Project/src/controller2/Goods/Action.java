package controller2.Goods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action { // forward와 sendredirect하는 코드를 줄이기 위해서 만듬 // 정의되어 있는 메소드를 재정의하기위해 만듬

		public ActionForward execute(HttpServletRequest request, HttpServletResponse response) // 재정의할 메소드 execute()
		throws Exception; // 인터페이스는 바디가 없으므로 {}가 없음

}
