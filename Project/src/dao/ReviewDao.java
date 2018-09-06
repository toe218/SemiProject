package dao;

import java.sql.Connection;         
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Board;


public class ReviewDao {
	
	Connection con =null;
	PreparedStatement pstmt = null;
	String sql = null;
	ResultSet rs = null;
	
	public Connection getConnection() throws Exception{
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		Class.forName(driver);
		con = DriverManager.getConnection(url, "smrit", "oracle");
		
		return con;
	}
	
	public int reviewInsert(Board reviewDTO){
		
		int i = 0;
		int num = 0;
		
		try { 
				
			con = getConnection(); // con = con으로 써도 에러는 없으나  불안하면 conn으로
			sql = "select max(BOARD_NUM) from board";		
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
		
			if(rs.next()) {
				
				num = rs.getInt(1) + 1;
				
			}else {
				
				num = 1;
				
			}
			
			sql = "insert into board(BOARD_NUM, BOARD_SUBJECT, BOARD_CONTENT, BOARD_PW, BOARD_IMAGE, BOARD_REF, BOARD_LEV,"
					+ " BOARD_SEQ, BOARD_READCOUNT, BOARD_DATE) values(?,?,?,?,?,?,?,?,?,sysdate)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			pstmt.setString(2, reviewDTO.getBoardSubject());
			pstmt.setString(3, reviewDTO.getBoardContent());
			pstmt.setString(4, reviewDTO.getBoardPw());
			pstmt.setString(5, reviewDTO.getBoardImage());
			pstmt.setInt(6, num); // 참조글번호  >> 자신이 부모글이면 현재 번호를 그대로 가져옴 
			pstmt.setInt(7, 0); // 원글인지, 댓글인지, 댓글의 댓글인지를 설정
			pstmt.setInt(8, 0); // 댓글의 순서를 정하는 것 
			pstmt.setInt(9, 0);
			
			i = pstmt.executeUpdate();
			
			
			System.out.println("DB에"+i+"개가 저장되었습니다");
			
		}catch(Exception e) {
		
			e.printStackTrace();
			
		}finally{
			
			if(rs != null) try {rs.close();} catch(SQLException ex) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
			if(con != null) try {con.close();} catch(SQLException ex) {}
			
		}
		
		return i;
	}
	
	public int getListCount() {
		
		int x= 0;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement("select count(*) from board");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				x = rs.getInt(1);
			}
		
		}catch(Exception e) {
		
			e.printStackTrace();
		
		}finally{
			
			if(rs != null) try {rs.close();} catch(SQLException ex) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
			if(con != null) try {con.close();} catch(SQLException ex) {}
			
		}
		
		return x;
	}

	public List getReviewList(int page, int limit) {
	
	List list = new ArrayList();
	
	try {
		con = getConnection();
		sql = "select * from(" + 
				" SELECT ROWNUM RNM, BOARD_NUM, BOARD_WRITER, BOARD_PW, BOARD_SUBJECT, BOARD_CONTENT," + 
				" BOARD_VIDEO, BOARD_REF, BOARD_LEV, BOARD_SEQ, BOARD_READCOUNT, BOARD_DATE" + 
				" FROM (select * from board order by BOARD_REF DESC, BOARD_SEQ ASC))" + 
				" WHERE RNM >= ? and RNM <= ?";
		
		// 2페이지는 11~20
		
		int startRow = (page-1)*limit+1;
		int endRow = startRow+limit-1;
		
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, startRow);
		pstmt.setInt(2, endRow);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
		
			Board board = new Board();
			
			board.setBoardNum(rs.getInt("BOARD_NUM"));
			board.setBoardWriter(rs.getString("BOARD_WRITER"));
			board.setBoardSubject(rs.getString("BOARD_SUBJECT"));
			board.setBoardContent(rs.getString("BOARD_CONTENT"));
			board.setBoardVideo(rs.getString("BOARD_VIDEO"));
			board.setBoardRef(rs.getInt("BOARD_REF"));
			board.setBoardLev(rs.getInt("BOARD_LEV"));
			board.setBoardSeq(rs.getInt("BOARD_SEQ"));
			board.setBoardReadcount(rs.getInt("BOARD_READCOUNT"));
			board.setBoardRegdate(rs.getDate("BOARD_DATE"));
			
			list.add(board); // board에 추가한 DTO를 list에 넣어준다
		}
		
	}catch(Exception e) {
		e.printStackTrace();
		
	}finally{
		
		if(rs != null) try {rs.close();} catch(SQLException ex) {}
		if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
		if(con != null) try {con.close();} catch(SQLException ex) {}
		
	}
	
	return list;
	
}
	
	public Board getDetail(int num) {
		
		Board bd = null;
		
		try {
			
			con = getConnection();
			
			sql = " update board set BOARD_READCOUNT = BOARD_READCOUNT+1 where BOARD_NUM = ?"; // 상세보기를 하면 조회수가 증가하므로, 먼저 조회수를 업데이트하고 select
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num); // 위에 물음표를 쓴 것은 sql 쿼리안에 변수를 넣을 수 없으므로, num이라는 변수는 기본쿼리를 먼저 보내고 넣어준다.
			int result =  pstmt.executeUpdate();
			System.out.println(num +"번 글의 조회수가"+result+"개 증가했습니다");

			sql = " select * from board where BOARD_NUM = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				
				bd = new Board();
				
				bd.setBoardNum(rs.getInt("BOARD_NUM"));
				bd.setBoardWriter(rs.getString("BOARD_WRITER"));
				bd.setBoardSubject(rs.getString("BOARD_SUBJECT"));
				bd.setBoardContent(rs.getString("BOARD_CONTENT"));
				bd.setBoardImage(rs.getString("BOARD_IMAGE"));
				bd.setBoardRef(rs.getInt("BOARD_REF"));
				bd.setBoardLev(rs.getInt("BOARD_LEV"));
				bd.setBoardSeq(rs.getInt("BOARD_SEQ"));
				bd.setBoardReadcount(rs.getInt("BOARD_READCOUNT"));
				bd.setBoardRegdate(rs.getDate("BOARD_DATE"));
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		
		}finally{
			
			if(rs != null) try {rs.close();} catch(SQLException ex) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
			if(con != null) try {con.close();} catch(SQLException ex) {}
			
		}
		
		return  bd;
	}
	
	public int boardReply(Board boarddata) {
		
		int i = 0;
		
		Board bd = new Board();
		
		bd = boarddata;
		
		try {
			
			con = getConnection();
			sql = "select max(BOARD_NUM)+1 from board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			int maxnum = 0;
			
			if(rs.next()) {
				maxnum = rs.getInt(1); // "1"이라고 쓰면 문자로 인식해서 에러남 그냥 1로 적어줄 것!
			}else {
				maxnum = 1;
			}
			
			i = maxnum; // 자기글 번호
			
			//새로 등록된 글이 아니라, 기존의 글들의 SEQ를 변경함  
			sql = "update board set BOARD_SEQ = BOARD_SEQ + 1  where BOARD_REF = ? and BOARD_SEQ > ? "; 
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bd.getBoardRef());
			pstmt.setInt(2, bd.getBoardSeq());
			pstmt.executeUpdate();
			
			//새로 등록되는 글의 SEQ를 갱신함
			int re_seq = bd.getBoardSeq()+1;
			int re_lev = bd.getBoardLev()+1;
			
			sql = " insert into board(BOARD_NUM, BOARD_WRITER, BOARD_PW, BOARD_SUBJECT, BOARD_CONTENT, BOARD_VIDEO, BOARD_REF, BOARD_LEV, "
					+ " BOARD_SEQ, BOARD_READCOUNT, BOARD_DATE) values(?,?,?,?,?,?,?,?,?,?,sysdate) ";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, maxnum);
			pstmt.setString(2, bd.getBoardWriter());
			pstmt.setString(3, bd.getBoardPw());
			pstmt.setString(4, bd.getBoardSubject());
			pstmt.setString(5, bd.getBoardContent());
			pstmt.setString(6, ""); // 파일인데  null로 넣으면 에러나서 공백으로 넣음
			pstmt.setInt(7, bd.getBoardRef());  
			pstmt.setInt(8, re_lev); 
			pstmt.setInt(9, re_seq); 
			pstmt.setInt(10, 0);
			
			pstmt.executeUpdate();
			
			
		}catch(Exception e){
			
			e.printStackTrace();
		
		}finally{
			
			if(rs != null) try {rs.close();} catch(SQLException ex) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
			if(con != null) try {con.close();} catch(SQLException ex) {}
			
		}
			
		return i;
	}
	
	public boolean isReviewWriter(int num, String pw) {
		
		boolean flag = false;
		
		try {
			con = getConnection();
			sql = "select BOARD_PW from board where BOARD_NUM =? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				
				if(pw.equals(rs.getString(1))) {
				
					flag = true;
				
				}
			
			}
			
			
			
		}catch(Exception e){
			
			e.printStackTrace();
		
		}finally{
			
			if(rs != null) try {rs.close();} catch(SQLException ex) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
			if(con != null) try {con.close();} catch(SQLException ex) {}
			
		}
			
		return flag;
	}
	
	public int boardModify(Board boarddata){
		
		int result = 0;
		
		try {
			
			con= getConnection();
			sql = "update board set BOARD_SUBJECT =? , BOARD_CONTENT=? where BOARD_NUM =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, boarddata.getBoardSubject());
			pstmt.setString(2, boarddata.getBoardContent());
			pstmt.setInt(3, boarddata.getBoardNum());
			
			result = pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
		
		}finally{
			
			if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
			if(con != null) try {con.close();} catch(SQLException ex) {}
			
		}
		
		return result;
	}
	
	public int boardDelete(int num) {
		
		int i = 0;
		
		try {

			con = getConnection();
			sql = "delete from board where BOARD_NUM =? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			i = pstmt.executeUpdate();
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}finally{
			
			if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
			if(con != null) try {con.close();} catch(SQLException ex) {}
			
		}
		
		return i;
	}
	// 여기서부터 상품 
	public List getGoods() {
		
		List goods = new ArrayList();
		
		try {
			con= getConnection();
			sql = "select*from board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Board bd = new Board();
				
				bd.setBoardNum(rs.getInt("BOARD_NUM"));
				bd.setBoardSubject(rs.getString("BOARD_SUBJECT"));
				bd.setBoardContent(rs.getString("BOARD_CONTENT"));
				
				goods.add(bd); // 가져온 하나하나의 정보를 List에 담음
				
			}
			
		}catch(Exception e){}
		
		return goods;
		
	}
	
	
}


