package kr.co.hf.domain;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class LikeDAO {
	
	
	private DataSource ds;

	public static LikeDAO dao = new LikeDAO();
	
	private LikeDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static LikeDAO getInstance() {
		
		if(dao == null) {
			dao = new LikeDAO();
		}
		return dao;
	}
	
	//gets full list of like entries
	public List<LikeVO> getLikeList(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<LikeVO> likeList = new ArrayList<>();
		
		try {
			con = ds.getConnection();
			String s = "SELECT * FROM likes";
			pstmt = con.prepareStatement(s);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				LikeVO like = new LikeVO();
				like.setLikeID(rs.getInt(1));
				like.setLikeType(rs.getInt(2));
				like.setPostID(rs.getInt(3));
                like.setUserNum(rs.getInt(4));
				likeList.add(like);
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
		return likeList;	
	}
	
	//gets like count for specified post
	public int getLikeCount(int postID){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			con = ds.getConnection();
			String s = "SELECT COUNT(case when likeType=1 then 1 end) as total FROM likes WHERE postID = ?";
			pstmt = con.prepareStatement(s);
			pstmt.setInt(1, postID);
			rs = pstmt.executeQuery();
			
			rs.next();
			count = rs.getInt(1);
			
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
		return count;
		
		
	}
	
	//creates like entry for specified post with default likeType=1 (like=true)
	public String createLike(int postID, int userNum){
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			String s = "INSERT INTO likes VALUES(null,1,?,?)";
			pstmt = con.prepareStatement(s);
			pstmt.setInt(1, postID);
			pstmt.setInt(2, userNum);
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return "Like Created";
		
		
	}
	
	//toggles the likeType value for the specified like entry
	/*public void toggleLike(int postID, int likeType){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			String s = "UPDATE likes SET likeType=? WHERE postID=?";
			pstmt = con.prepareStatement(s);
			if(likeType == 0) {
				pstmt.setInt(1, 1);
			}else if(likeType == 1) {
				pstmt.setInt(1, 0);
			}
			pstmt.setInt(2, postID);
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return;
		
	}*/
	
	//gets LikeVO for specified user and post combination
	public LikeVO getLikeUP(int postID, int userNum){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LikeVO like = new LikeVO();
		
		try {
			con = ds.getConnection();
			String s = "SELECT * FROM likes WHERE postID=? AND userNum=?";
			pstmt = con.prepareStatement(s);
			pstmt.setInt(1, postID);
			pstmt.setInt(2, userNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				like.setLikeID(rs.getInt(1));
				like.setLikeType(rs.getInt(2));
				like.setPostID(rs.getInt(3));
                like.setUserNum(rs.getInt(4));
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
		return like;	
	}
	
	//gets all like for a user
	public List<LikeVO> getLikeUser(int userNum){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<LikeVO> likeList = new ArrayList<>();
		
		try {
			con = ds.getConnection();
			String s = "SELECT * FROM likes WHERE userNum=?";
			pstmt = con.prepareStatement(s);
			pstmt.setInt(1, userNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				LikeVO like = new LikeVO();
				like.setLikeID(rs.getInt(1));
				like.setLikeType(rs.getInt(2));
				like.setPostID(rs.getInt(3));
                like.setUserNum(rs.getInt(4));
				likeList.add(like);
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
		return likeList;	
	}
	
	//deletes like, instead of toggle
	public String deleteLike(int postID, int userNum){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			String s = "DELETE FROM likes WHERE postID=? AND userNum=?";
			pstmt = con.prepareStatement(s);
			pstmt.setInt(1, postID);
			pstmt.setInt(2, userNum);
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return "Like Deleted";
		}
	}
	
	

	
	
	
		
