package model.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import model.DTO.Member;


public class MemberDAO {
	Connection conn = null;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	
	public Connection getConnection() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		Class.forName(driver);
		conn = DriverManager.getConnection(url, "smrit", "oracle");
		return conn;
	}
	
	public int joinMember(Member dto) {
		int i= 0;
		
		try {
		con = getConnection();
		sql = "insert into MEMBER ("
				+ "MEMBER_ID,MEMBER_PASS,MEMBER_NAME,MEMBER_AGE,MEMBER_GENDER,MEMBER_PHONE,"
				+ "MEMBER_EMAIL,RECEIVE_MAIL,POSTCODE,ADDR1,ADDR2)"
				+ " values (?,?,?,?,?,?,?,?,?,?,?)";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getMemberId());
		pstmt.setString(2, dto.getMemberPass());
		pstmt.setString(3, dto.getMemberName());
		pstmt.setInt(4, dto.getMemberAge());
		pstmt.setString(5, dto.getMemberGender());
		pstmt.setString(6, dto.getMemberPhone());
		pstmt.setString(7, dto.getMemberEmail());
		pstmt.setString(8, dto.getReceiveMail());
		pstmt.setString(9, dto.getPostcode());
		pstmt.setString(10, dto.getAddr1());
		pstmt.setString(11, dto.getAddr2());
		i = pstmt.executeUpdate();
		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			
			if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
			if(con != null) try {con.close();} catch(SQLException ex) {}
		}
		
		return i;
	}
	
	
	public int isMember(Member dto) {
		int i = -1;
		
		try {
			con = getConnection();
			String sql = "select member_pass from member "
						+ " where member_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMemberId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(dto.getMemberPass())) {
					i = 1; //일치
				} else {
					i = 0; //불일치
				}
			} else {
				i = -1; //아이디가 없음.
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();} catch (SQLException ex) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
			if(conn != null) try {conn.close();} catch(SQLException ex) {}
		}
		
		
		return i;
	}
	
	
	public int idFind (Member dto) {
		int i = 0;
		
		try {
			con = getConnection();
			String sql = "select MEMBER_ID from MEMBER"
					+ " where MEMBER_EMAIL = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMemberEmail());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				if (rs.getString(1).equals(dto.getMemberEmail())) {
					i = 1;	//이메일에 해당하는 아이디가 있는경우
				} else {
					i = 0;	//없는 경우
				}
			}
			
			}catch (Exception e) {
				e.printStackTrace();
					
		}finally {
			if(rs != null) try {rs.close();} catch (SQLException ex) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
			if(conn != null) try {conn.close();} catch(SQLException ex) {}
		}
		
		return i;
	}
	
	public List modifyView (Member dto) {
		
		
		List list = new ArrayList();
		
		try {
			con = getConnection();
			String sql = "select MEMBER_ID, MEMBER_NAME, MEMBER_AGE, MEMBER_GENDER"
					+ " from MEMBER"
					+ " where MEMBER_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,dto.getMemberId());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Member ml = new Member();
				ml.setMemberId(rs.getString("MEMBER_ID"));
				ml.setMemberName(rs.getString("MEMBER_NAME"));
				ml.setMemberAge(rs.getInt("MEMBER_AGE"));
				ml.setMemberGender(rs.getString("MEMBER_GENDER"));
				list.add(ml);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs!= null) try {rs.close();} catch (SQLException ex) {}
			if (con != null) try {con.close();}catch (SQLException ex) {}
			if (pstmt != null) try {pstmt.close();} catch (SQLException ex) {}
		}
		
		
		
		
		return list;
	}
	
	
}
