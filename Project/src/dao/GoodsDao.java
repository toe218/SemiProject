package dao;

import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import dto.Goods;

public class GoodsDao {

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
	
	public int goodInsert(Goods good) {
		
		int result = 0;
		int num =0;
		
		try {
			
			con= getConnection();
			sql= "select max(GOODS_NUMBER) from goods"; // 데이터의 최고숫자를 가져와서, 다음 번호를 새로 입력한 데이터에 배정
			pstmt =con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				num = rs.getInt(1)+1; // 새로운 글은 다음 번호이므로 +1
			}else {
				num=1;
			}
			
			sql="insert into goods(GOODS_NUMBER, GOODS_NAME, GOODS_PRICE, GOODS_IMAGE, GOODS_SUMMARY, sort, SORT_SEASON, GOODS_DETAIL"
					+ " , click, TOTAL_SALES , GOODS_REGDATE) values(?,?,?,?,?,?,?,?,?,?,sysdate)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			pstmt.setString(2, good.getGoodsName());
			pstmt.setInt(3, good.getGoodsPrice());
			pstmt.setString(4, good.getGoodsImage());
			pstmt.setString(5, good.getGoodsSummary());
			pstmt.setString(6, good.getSort());
			pstmt.setString(7, good.getSortSeason());
			pstmt.setString(8, good.getGoodsDetail());
			pstmt.setInt(9, 0);
			pstmt.setInt(10, 0);
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
		
			e.printStackTrace();
		
		}finally{
			
			if(rs != null) try {rs.close();} catch(SQLException ex) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
			if(con != null) try {con.close();} catch(SQLException ex) {}
			
		}
		
		return result;
		
	}
	
	public List goodsGet(){
		
		List goods = new ArrayList();
		
		try {
			con = getConnection();
			sql ="select * from goods";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Goods good = new Goods();
				
				good.setGoodsNumber(rs.getInt("GOODS_NUMBER"));
				good.setGoodsName(rs.getString("GOODS_NAME"));
				good.setGoodsPrice(rs.getInt("GOODS_PRICE"));
				good.setGoodsImage(rs.getString("GOODS_IMAGE"));
				good.setGoodsSummary(rs.getString("GOODS_SUMMARY"));
				good.setSort(rs.getString("SORT"));
				good.setSortSeason(rs.getString("SORT_SEASON"));
				good.setGoodsDetail(rs.getString("GOODS_DETAIL"));
				good.setTotalSales(rs.getInt("TOTAL_SALES"));
				good.setClick(rs.getInt("CLICK"));
				good.setGoodsRegdate(rs.getDate("GOODS_REGDATE"));
				
				goods.add(good);
				
			}
			
		}catch(Exception e){
		
			e.printStackTrace();
		
		}finally{
			
			if(rs != null) try {rs.close();} catch(SQLException ex) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
			if(con != null) try {con.close();} catch(SQLException ex) {}
			
		}
		
		return goods;
	}

	public Goods getGood(int goodsNumber) {
		
		Goods good = new Goods();
		int i =0;
		
		try {
			con = getConnection();
			sql = "update goods set click = click +1 where GOODS_NUMBER = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, goodsNumber);
			
			i = pstmt.executeUpdate();
			
			System.out.println(goodsNumber +"번 상품의 조회수가"+i+"개 증가했습니다");
			
			sql = "select * from goods where GOODS_NUMBER =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, goodsNumber);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				good.setGoodsNumber(rs.getInt("GOODS_NUMBER"));
				good.setGoodsName(rs.getString("GOODS_NAME"));
				good.setGoodsPrice(rs.getInt("GOODS_PRICE"));
				good.setGoodsImage(rs.getString("GOODS_IMAGE"));
				good.setGoodsSummary(rs.getString("GOODS_SUMMARY"));
				good.setSort(rs.getString("SORT"));
				good.setSortSeason(rs.getString("SORT_SEASON"));
				good.setGoodsDetail(rs.getString("GOODS_DETAIL"));
				good.setTotalSales(rs.getInt("TOTAL_SALES"));
				good.setClick(rs.getInt("CLICK"));
				good.setGoodsRegdate(rs.getDate("GOODS_REGDATE"));
				
			}
			
		}catch(Exception e) {
		
			e.printStackTrace();
		
		}finally{
			
			if(rs != null) try {rs.close();} catch(SQLException ex) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
			if(con != null) try {con.close();} catch(SQLException ex) {}
			
		}
		
		return good;
	}

	public void pay(int goodsNumber, int qty) {
		
		try {
			
			con = getConnection();
			sql = "update goods set TOTAL_SALES = TOTAL_SALES + ? where GOODS_NUMBER = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qty);
			pstmt.setInt(2, goodsNumber);
			pstmt.executeUpdate();
			
			System.out.println(goodsNumber+"번 상품을 "+qty+"개 구매하였습니다");
		
		}catch(Exception e) {
			
			e.printStackTrace();
		
		}finally{
			
			
			if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
			if(con != null) try {con.close();} catch(SQLException ex) {}
			
		}
		
		
		
	}

	public List getSellRank() {
		
		List goods = new ArrayList();
		int rankNum = 5;
		Goods good = null;
		
		try{
			con =getConnection();
			sql = " select * from(select rownum, GOODS_NUMBER, GOODS_NAME, GOODS_PRICE, GOODS_IMAGE, TOTAL_SALES "
					+ " from (select * from goods order by TOTAL_SALES desc) WHERE rownum <= ? )";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rankNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
			
			good = new Goods(); // 위에다 객체 생성만하고 사용하면 1,2,3,4,5 순으로 List에 저장되다가 중복으로 저장되어, 5번만 
			
			good.setGoodsNumber(rs.getInt("GOODS_NUMBER"));
			good.setGoodsName(rs.getString("GOODS_NAME"));	
			good.setGoodsPrice(rs.getInt("GOODS_PRICE"));
			good.setGoodsImage(rs.getString("GOODS_IMAGE"));
			good.setTotalSales(rs.getInt("TOTAL_SALES"));
			
			goods.add(good);
				
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
		
		}finally{
			
			if(rs != null) try {rs.close();} catch(SQLException ex) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
			if(con != null) try {con.close();} catch(SQLException ex) {}
			
		}
		
		return goods;
	}
	
public List getClickRank() {
		
		List goods = new ArrayList();
		int rankNum = 5;
		Goods good = null;
		
		try{
			con =getConnection();
			sql = " select * from(select rownum, GOODS_NUMBER, GOODS_NAME, GOODS_PRICE, GOODS_IMAGE, CLICK "
					+ " from (select * from goods order by CLICK desc) WHERE rownum <= ? )";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rankNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
			
			good = new Goods();
			
			// 객체를 새로 만들어주지 않으면, 같은 주소값을 가지는 객체(주소 200)5개에(주소값이 같아도 객체 중복 생성이 가능하다) 계속 다른 값(1,2,3,4,5)을 저장하게 되다가, 
			// 결국 마지막에 저장된 값(5)을 주소가 같은 각각의 객체(200)가 같은 값(5)을 가지게 된다. >> 주소가 같으면 값을 공유하므로 5개의 같은 주소 객체(200)가 한 값(5)을 공유한다!    
			
			good.setGoodsNumber(rs.getInt("GOODS_NUMBER"));
			good.setGoodsName(rs.getString("GOODS_NAME"));	
			good.setGoodsPrice(rs.getInt("GOODS_PRICE"));
			good.setGoodsImage(rs.getString("GOODS_IMAGE"));
			good.setClick(rs.getInt("CLICK"));
			
			goods.add(good);
				
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
		
		}finally{
			
			if(rs != null) try {rs.close();} catch(SQLException ex) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
			if(con != null) try {con.close();} catch(SQLException ex) {}
			
		}
		
		return goods;
	}

	public int goodDelete(int num) {
	
	int result = 0;
	
	try {

		con = getConnection();
		sql = "delete from goods where GOODS_NUMBER =? ";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, num);
		result = pstmt.executeUpdate();
		
	}catch(Exception e) {
		
		e.printStackTrace();
		
	}finally{
		
		if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
		if(con != null) try {con.close();} catch(SQLException ex) {}
		
	}
	
	return result;
}
	
}
