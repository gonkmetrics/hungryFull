package kr.co.hf.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserDAO {

	private DataSource ds=null;


	private static UserDAO dao = new UserDAO();

	private UserDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	public static UserDAO getInstance() {
		if(dao == null) {
			dao = new UserDAO();
		}
		return dao;
	}
	
	public List<UserVO> getAllUserList(){
	
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<UserVO> userList = new ArrayList<>();
		
		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM user";

			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {

				UserVO user = new UserVO();

				user.setUserNum(rs.getInt(1));
				user.setUserId(rs.getString(2));
				user.setUserPw(rs.getString(3));
				user.setUserName(rs.getString(4));
				user.setUserEmail(rs.getString(5));
				user.setUage(rs.getInt(6));
				user.setIsAdmin(rs.getInt(7));

				userList.add(user);
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
		return userList;
	}// getAllUserList() 끝나는 지점.
	

	public UserVO getUserInfo(String userId) {

		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		UserVO user = new UserVO();
		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM user WHERE userID = ?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
	
			if(rs.next()) {
				user.setUserNum(rs.getInt(1));
				user.setUserId(rs.getString(2));
				user.setUserPw(rs.getString(3));
				user.setUserName(rs.getString(4));
				user.setUserEmail(rs.getString(5));
				user.setUage(rs.getInt(6));
				user.setIsAdmin(rs.getInt(7));
			}

		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				con.close();
				rs.close();
				pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return user;
	}
	
	public void Delete(String userId){

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			String sql = "DELETE FROM user WHERE userID = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userId);
		
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}// userDelete 마무리
	
	public void JoinCheck(int userNum, String userId, String userPw, 
			String userName, String userEmail, int uage, int isAdmin){// userJoinCheck.jsp 확인
		Connection con = null;
		PreparedStatement pstmt=null;
		
		try {
			con = ds.getConnection();
			String sql = "INSERT INTO user VALUES(?, ?, ?, ?, ?, ?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userNum);
			pstmt.setString(2, userId);
			pstmt.setString(3, userPw);
			pstmt.setString(4, userName);
			pstmt.setString(5, userEmail);
			pstmt.setInt(6, uage);
			pstmt.setInt(7, isAdmin);

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
	}// userJoinCheck
	
	public UserVO Update (String userId) {

		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		UserVO user = new UserVO();
		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM user WHERE userID = ?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
	
			if(rs.next()) {
				user.setUserNum(rs.getInt(1));
				user.setUserId(rs.getString(2));
				user.setUserPw(rs.getString(3));
				user.setUserName(rs.getString(4));
				user.setUserEmail(rs.getString(5));
				user.setUage(rs.getInt(6));
				user.setIsAdmin(rs.getInt(7));
			}

		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				con.close();
				rs.close();
				pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return user;
	}
	
	public void UpdateCheck(String userId, String userPw, String userName, 
			String userEmail, int uage) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
		
			con = ds.getConnection();
			String sql = "UPDATE user SET userPw=?, userName=?, userEmail=?, uage=? WHERE userId=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(5, userId);
			pstmt.setString(1, userPw);
			pstmt.setString(2, userName);
			pstmt.setString(3, userEmail);
			pstmt.setInt(4, uage);
			
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		} 	
		
	}
	
	public UserVO getUserInfoNum(int userNum) {
		
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		UserVO user = new UserVO();
		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM user WHERE userNum = ?";
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, userNum);
			rs = pstmt.executeQuery();
	
			if(rs.next()) {
				user.setUserNum(rs.getInt(1));
				user.setUserId(rs.getString(2));
				user.setUserPw(rs.getString(3));
				user.setUserName(rs.getString(4));
				user.setUserEmail(rs.getString(5));
				user.setUage(rs.getInt(6));
				user.setIsAdmin(rs.getInt(7));
			}

		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				con.close();
				rs.close();
				pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return user;
		
		
	}

	public int getUserCount() {
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;//ResultSet은 실행쿼리문이 SELECT 구문인 경우 결과값을 받기 위해 필요합니다.
			int userCount = 0;
			
			try {
				con = ds.getConnection();
				String sql = "SELECT COUNT(*) FROM user";
				
				pstmt = con.prepareStatement(sql);
	
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					userCount = rs.getInt(1);
				}else {
					System.out.println("계정이 없습니다.");
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
			return userCount;
		}

		public List<UserVO> getAllUserList(int pageNum){
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<UserVO> userList = new ArrayList<>();
			
			try {
				con = ds.getConnection();
				int num = (pageNum - 1) *10;
				String sql = "SELECT * FROM user ORDER BY userNum DESC limit ?, 10;";
	
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, num);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
	
					UserVO user = new UserVO();
	
					user.setUserNum(rs.getInt(1));
					user.setUserId(rs.getString(2));
					user.setUserPw(rs.getString(3));
					user.setUserName(rs.getString(4));
					user.setUserEmail(rs.getString(5));
					user.setUage(rs.getInt(6));
					user.setIsAdmin(rs.getInt(7));
	
					userList.add(user);
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
			return userList;
		}// getAllUserList() 끝나는 지점.


}
