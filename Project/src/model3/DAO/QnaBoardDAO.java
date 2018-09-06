package model3.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model3.DTO.QnaBoardBean;

public class QnaBoardDAO {
	Connection conn = null;
	Connection con = null;
	PreparedStatement pstmt = null;
	String sql = null;
	ResultSet rs = null;
	public Connection getConnection() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		Class.forName(driver);
		conn = DriverManager.getConnection(url, "smrit", "oracle");
		return conn;
	}
	public int boardDelete(int num) {
		int result = 0;
		sql = " delete from qna where QNA_NUM =? ";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try {pstmt.close();}
				catch(SQLException ex) {}
			if(con!=null) try {con.close();}
				catch(SQLException ex) {}
	}
		return result;
	}
	
	public int boardModify(QnaBoardBean modifyboard) {
		int result = 0;
		sql = " update qna "
				+ " set QNA_SUBJECT=?, QNA_CONTENT=? "
				+ " where QNA_NUM=? ";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, modifyboard.getQnaSubject());
			pstmt.setString(2, modifyboard.getQnaContent());
			pstmt.setInt(3, modifyboard.getQnaNum());
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try {pstmt.close();}
				catch(SQLException ex) {}
			if(con!=null) try {con.close();}
				catch(SQLException ex) {}
	}
		return result;
	}
	
	public boolean isBoardWriter(int num,String pass) {
		try {
			sql = " select QNA_PW from qna "
					+ " where QNA_NUM=? ";
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			rs.next();
			if(pass.equals(rs.getString(1))) {
				return true;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();}
				catch(SQLException ex) {}
			if(pstmt!=null) try {pstmt.close();}
				catch(SQLException ex) {}
			if(con!=null) try {con.close();}
				catch(SQLException ex) {}
		}
		return false;
	}
	
	public int boardReply(QnaBoardBean qnaboard) {
		int i = 0;
		try {
			con = getConnection();
			sql = " select max(QNA_NUM)+1 from qna";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int maxnum = 0;
			if(rs.next()) maxnum = rs.getInt(1);
			else maxnum = 1;
			i = maxnum;
			
			sql = " update qna "
					+ " set QNA_SEQ = QNA_SEQ + 1 "
					+ " where QNA_REF=? "
					+ " and QNA_SEQ > ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qnaboard.getQnaRef());
			pstmt.setInt(2, qnaboard.getQnaSeq());
			int result = pstmt.executeUpdate();
			
			int re_seq = qnaboard.getQnaSeq()+1;
			int re_lev = qnaboard.getQnaLev()+1;
			
			sql = " insert into qna (QNA_NUM, "
					+ " MEMBER_ID, QNA_PW, QNA_SUBJECT, "
					+ " QNA_CONTENT, QNA_IMAGE, QNA_REF, "
					+ " QNA_LEV, QNA_SEQ, QNA_READCOUNT, "
					+ " QNA_REGDATE) "
					+ " values(?,?,?,?,?,?,?,?,?,?,sysdate) ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, maxnum);
			pstmt.setString(2, qnaboard.getMemberId());
			pstmt.setString(3, qnaboard.getQnaPw());
			pstmt.setString(4, qnaboard.getQnaSubject());
			pstmt.setString(5, qnaboard.getQnaContent());
			pstmt.setString(6, "");
			pstmt.setInt(7, qnaboard.getQnaRef());
			pstmt.setInt(8, re_lev);
			pstmt.setInt(9, re_seq);
			pstmt.setInt(10, 0);
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();}
				catch(SQLException ex) {}
			if(pstmt!=null) try {pstmt.close();}
				catch(SQLException ex) {}
			if(con!=null) try {con.close();}
				catch(SQLException ex) {}
}
		return i;
	}
	public QnaBoardBean getDetail(int num) {
		QnaBoardBean qnaboard = null;
		try {
			con = getConnection();
			sql = " update qna "
					+ " set QNA_READCOUNT = "
					+ "     QNA_READCOUNT + 1 "
					+ " where QNA_NUM = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			int result = pstmt.executeUpdate();
			System.out.println(result+"개가 수정되었습니다.");
			sql = " select * from qna "
					+ "where QNA_NUM = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				qnaboard = new QnaBoardBean();
				qnaboard.setQnaNum(rs.getInt("QNA_NUM"));
				qnaboard.setMemberId(rs.getString("MEMBER_ID"));
				qnaboard.setQnaSubject(rs.getString("QNA_SUBJECT"));
				qnaboard.setQnaContent(rs.getString("QNA_CONTENT"));
				qnaboard.setQnaImage(rs.getString("QNA_IMAGE"));
				qnaboard.setQnaRef(rs.getInt("QNA_REF"));
				qnaboard.setQnaLev(rs.getInt("QNA_LEV"));
				qnaboard.setQnaSeq(rs.getInt("QNA_SEQ"));
				qnaboard.setQnaReadcount(rs.getInt("QNA_READCOUNT"));
				qnaboard.setQnaRegdate(rs.getDate("QNA_REGDATE"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();}
				catch(SQLException ex) {}
			if(pstmt!=null) try {pstmt.close();}
				catch(SQLException ex) {}
			if(con!=null) try {con.close();}
					catch(SQLException ex) {}
}
		return qnaboard;
	}
	public int getListCount() {
		int x = 0;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(
					"select count(*) from qna");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				x = rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();}
					catch(SQLException ex) {}
			if(pstmt!=null) try {pstmt.close();}
					catch(SQLException ex) {}
			if(con!=null) try {con.close();}
					catch(SQLException ex) {}
		}
		return x;
	}
	public List getBoardList(int page, int limit) {
		List list = new ArrayList();
		
		try { 
			con = getConnection();
			sql = "select * from ("
					+ " select rownum rnum, QNA_NUM, MEMBER_ID, QNA_PW, QNA_SUBJECT, QNA_CONTENT, "
					+ " QNA_IMAGE, QNA_REF, QNA_LEV, QNA_SEQ, QNA_READCOUNT, QNA_REGDATE "
					+ " from (select * "
					+ " from qna order by QNA_REF desc, QNA_SEQ asc) )"
					+ " where rnum >= ? and rnum <=?";
			
		int startRow = (page-1) * limit +1;
		int endRow = startRow + limit -1;
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1,  startRow);
		pstmt.setInt(2, endRow);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			QnaBoardBean qnaboard = new QnaBoardBean();
			qnaboard.setQnaNum(rs.getInt("QNA_NUM"));
			qnaboard.setMemberId(rs.getString("MEMBER_ID"));
			qnaboard.setQnaSubject(rs.getString("QNA_SUBJECT"));
			qnaboard.setQnaContent(rs.getString("QNA_CONTENT"));
			qnaboard.setQnaImage(rs.getString("QNA_IMAGE"));
			qnaboard.setQnaRef(rs.getInt("QNA_REF"));
			qnaboard.setQnaLev(rs.getInt("QNA_LEV"));
			qnaboard.setQnaSeq(rs.getInt("QNA_SEQ"));
			qnaboard.setQnaReadcount(rs.getInt("QNA_READCOUNT"));
			qnaboard.setQnaRegdate(rs.getDate("QNA_REGDATE"));
			list.add(qnaboard);
		}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();}
					catch(SQLException ex) {}
			if(pstmt!=null) try {pstmt.close();}
					catch(SQLException ex) {}
			if(con!=null) try {con.close();}
					catch(SQLException ex) {}
		}
		return list;
	}
	
	public int boardInsert(QnaBoardBean qnaboard) {
		int i = 0;
		int num = 0;
		try {
			con = getConnection();
			sql = "select max(QNA_NUM) from qna";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				num = rs.getInt(1) + 1;
			} else {
				num = 1;
			}
			sql = "insert into qna(QNA_NUM, MEMBER_ID, "
					+ "QNA_PW, QNA_SUBJECT, "
					+ "QNA_CONTENT, QNA_IMAGE, "
					+ "QNA_REF, QNA_LEV, QNA_SEQ, "
					+ "QNA_READCOUNT, QNA_REGDATE)"
					+ " values(?,?,?,?,?,?,?,?,?,?,sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, qnaboard.getMemberId());
			pstmt.setString(3, qnaboard.getQnaPw());
			pstmt.setString(4, qnaboard.getQnaSubject());
			pstmt.setString(5, qnaboard.getQnaContent());
			pstmt.setString(6, qnaboard.getQnaImage());
			pstmt.setInt(7, num);
			pstmt.setInt(8, 0);
			pstmt.setInt(9, 0);
			pstmt.setInt(10, 0);
			i = pstmt.executeUpdate();
			System.out.println(i+"개가 저장되었습니다.");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();}
				catch(SQLException ex) {}
			if(pstmt!=null) try {pstmt.close();}
				catch(SQLException ex) {}
			if(con!=null) try {con.close();}
				catch(SQLException ex) {}
		}
		return i;
	}
}
