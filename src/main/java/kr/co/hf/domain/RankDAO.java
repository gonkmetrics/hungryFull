package kr.co.hf.domain;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class RankDAO {
	
	
	private DataSource ds;

	public static RankDAO dao = new RankDAO();
	
	private RankDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
	public static RankDAO getInstance() {
		
		if(dao == null) {
			dao = new RankDAO();
		}
		return dao;
	}
	
	
	
	public List<PreviewVO> getRankOrderedList(int postID){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		List<RankVO> rankList = new ArrayList<>();
		
		try {
			con = ds.getConnection();
			String s = "SELECT * FROM rank ORDER BY rankPosition DESC";
			pstmt = con.prepareStatement(s);
			pstmt.setInt(1, postID);
			rs = pstmt.executeQuery();
			
			for(int i = 0; i < 10; i++) {
				if(rs.next()) {
					RankVO rank = new RankVO();
					rank.setRankID(rs.getInt(1));
					rank.setPostID(rs.getInt(2));
					rank.setRankPosition(rs.getInt(3));
					rankList.add(rank);
					
				}
			}			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
				rs.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return rankList;
		
		
	}
	

	
	
	
		
	
}