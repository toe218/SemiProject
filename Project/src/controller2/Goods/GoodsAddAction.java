package controller2.Goods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import controller2.Review.Action;
import controller2.Review.ActionForward;
import dao.GoodsDao;
import dto.Goods;

public class GoodsAddAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		
		GoodsDao dao = new GoodsDao();
		Goods good = new Goods();
		
		String realFolder = request.getRealPath("/boardupload");
		int fileSize = 5*1024*1024;
		MultipartRequest multi = null;
		multi = new MultipartRequest(request, realFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());
		
		good.setGoodsName(multi.getParameter("goodsName"));
		good.setGoodsPrice(Integer.parseInt(multi.getParameter("goodsPrice")));
		good.setGoodsImage(multi.getFilesystemName((String)multi.getFileNames().nextElement()));
		good.setGoodsSummary(multi.getParameter("goodsSummary"));
		good.setSort(multi.getParameter("sort"));
		good.setSortSeason(multi.getParameter("sortSeason"));
		good.setGoodsDetail(multi.getParameter("goodsDetail"));
		
		int i = dao.goodInsert(good);
		
		if(i>0) {
			
			System.out.println("상품저장 성공");
		}else {
			
			System.out.println("상품저장 실패");
		}
		
		forward.setPath("./GoodsList.go");
		forward.setRedirect(true);
		
		return forward;
		
	}

}
