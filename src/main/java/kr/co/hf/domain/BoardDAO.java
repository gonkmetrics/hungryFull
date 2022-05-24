package kr.co.hf.domain;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	
	private DataSource ds;
	
	public static BoardDAO dao = new BoardDAO();
	
	private BoardDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // BoardDAO END;
	

	
	public static BoardDAO getInstance() {
		
		if(dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	} //  BoardDAO getInstance END;
	
	
	
	public List<BoardVO> getBoardList(int pageNum){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<BoardVO> boardList = new ArrayList<>();
		
		try {
			
			
			con = ds.getConnection();
			
			int num = (pageNum - 1) * 10;
			
			String sql = "SELECT * FROM board ORDER BY postTime DESC limit ?, 10;";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			
			rs = pstmt.executeQuery();
			
			
				while(rs.next()) {
					BoardVO board = new BoardVO();
					
					board.setPostID(rs.getInt(1));
					board.setPostAuthor(rs.getInt(2));
					board.setPostTitle(rs.getString(3));
					board.setPostContent(rs.getString(4));
					board.setPostTime(rs.getDate(5));
					board.setPostLastModified(rs.getDate(6));
					board.setViewCount(rs.getInt(7));
					board.setPostType(rs.getInt(8));
					board.setImageLink(rs.getString(9));
					
					
					//System.out.println("board 값 데이터 디버깅 : " + board);
					boardList.add(board);
					
				}
			
			
			//System.out.println("boardList 값 데이터 디버깅 : " + boardList);
			
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
		
		return boardList;
	
	} // getBoardList END;
	
	
	public BoardVO getBoardDetail(int postID) {

		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		BoardVO board = new BoardVO();
		
		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM board WHERE postID =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, postID);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board.setPostID(rs.getInt(1));
				board.setPostAuthor(rs.getInt(2));
				board.setPostTitle(rs.getString(3));
				board.setPostContent(rs.getString(4));
				board.setPostTime(rs.getDate(5));
				board.setPostLastModified(rs.getDate(6));
				board.setViewCount(rs.getInt(7));
				board.setPostType(rs.getInt(8));
				board.setImageLink(rs.getString(9));
				
				//System.out.println("BoardVO 체크 : " + board);
			} else {
				//System.out.println("일치하는 데이터 (postID)가 없음");
			}
			
			
			} catch(Exception e){
				e.printStackTrace();
			} finally {
				
				try {
					con.close();
					rs.close();
					pstmt.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		
			return board;
			
	} // getBoardDetail END.
	
	
	
	public void boardInsert(int postAuthor, String postTitle, String postContent, int postType , String imageLink) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			
			String sql = "INSERT INTO board (postAuthor, postTitle, postContent, postType, imageLink, viewCount) VALUES (?, ?, ?, ?, ?, 0)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, postAuthor);
			pstmt.setString(2, postTitle);
			pstmt.setString(3, postContent);
			pstmt.setInt(4, postType);
			pstmt.setString(5, imageLink);
			
		
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
		
	} // boardInsert() END.
	
	
	
	public void boardDelete(int postID) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			String sql = "DELETE FROM board WHERE postID = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, postID);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				con.close();
				pstmt.close();
				}catch(Exception e) {
				e.printStackTrace();
				}
	
		}
	} //boardDelete END.
	
	
	public void boardUpdate(String postTitle, String postContent, int postType, int postID, String imageLink) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			String sql = "UPDATE board SET postTitle = ?, postContent = ?, postType = ?, imageLink = ?, postLastModified = now() WHERE postID = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, postTitle);
			pstmt.setString(2, postContent);
			pstmt.setInt(3, postType);
			pstmt.setString(4, imageLink);
			pstmt.setInt(5, postID);
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				con.close();
				pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();	
			}
			
		}
	} //  boardUpdate END.
	
	public void upViewCnt(int postID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();

			String sql = "UPDATE board SET viewCount = viewCount + 1 WHERE postID=?";
			pstmt =  con.prepareStatement(sql);
			
			pstmt.setInt(1, postID);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				con.close();
				pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();	
			}
			
		}
	} // upViewCnt END;
	
	public int getBoardCount() {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int boardCount = 0;
		
		try {
			con = ds.getConnection();
			String sql = "SELECT COUNT(*) FROM board";
			
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				boardCount = rs.getInt(1);
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
		return boardCount;
	} // getBoardCount END;
	
	public int getBoardCountUser(int userNum) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int boardCount = 0;
		
		try {
			con = ds.getConnection();
			String sql = "SELECT COUNT(*) FROM board WHERE postAuthor=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userNum);

			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				boardCount = rs.getInt(1);
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
		return boardCount;
	} // getBoardCount END;

	public List<BoardVO> getUserPostList(int userNum, int pageNum){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<BoardVO> boardList = new ArrayList<>();
		
		try {
			
			int num = (pageNum - 1) * 10;
			con = ds.getConnection();
			
			String sql = "SELECT * FROM board WHERE postAuthor = ? ORDER BY postID DESC limit ?, 10;";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userNum);
			pstmt.setInt(2, num);
			
			rs = pstmt.executeQuery();
			
			
				while(rs.next()) {
					BoardVO board = new BoardVO();
					
					board.setPostID(rs.getInt(1));
					board.setPostAuthor(rs.getInt(2));
					board.setPostTitle(rs.getString(3));
					board.setPostContent(rs.getString(4));
					board.setPostTime(rs.getDate(5));
					board.setPostLastModified(rs.getDate(6));
					board.setViewCount(rs.getInt(7));
					board.setPostType(rs.getInt(8));
					board.setImageLink(rs.getString(9));
					
					
					//System.out.println("board 값 데이터 디버깅 : " + board);
					boardList.add(board);
					
				}
			
			
			//System.out.println("boardList 값 데이터 디버깅 : " + boardList);
			
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
		
		return boardList;
	
	} // getUserPostList END;
	
	public List<BoardVO> getPostTypeList(int postType, int pageNum){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<BoardVO> boardList = new ArrayList<>();
		
		try {
			
			int num = (pageNum - 1) * 10;
			con = ds.getConnection();
			
			String sql = "SELECT * FROM board WHERE postType = ? ORDER BY postID DESC limit ?, 10;";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, postType);
			pstmt.setInt(2, num);
			
			rs = pstmt.executeQuery();
			
			
				while(rs.next()) {
					BoardVO board = new BoardVO();
					
					board.setPostID(rs.getInt(1));
					board.setPostAuthor(rs.getInt(2));
					board.setPostTitle(rs.getString(3));
					board.setPostContent(rs.getString(4));
					board.setPostTime(rs.getDate(5));
					board.setPostLastModified(rs.getDate(6));
					board.setViewCount(rs.getInt(7));
					board.setPostType(rs.getInt(8));
					board.setImageLink(rs.getString(9));
					
					
					//System.out.println("board 값 데이터 디버깅 : " + board);
					boardList.add(board);
					
				}
			
			
			//System.out.println("boardList 값 데이터 디버깅 : " + boardList);
			
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
		
		return boardList;
	
	} // getPostTypeList END;
	
	public List<BoardVO> getBoardListSearch(int pageNum, String query){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<BoardVO> boardList = new ArrayList<>();
		String substring = "%"+query+"%";
		
		try {
			
			
			con = ds.getConnection();
			
			int num = (pageNum - 1) * 10;
			
			String sql = "SELECT * FROM board WHERE postContent LIKE ? ORDER BY postTime DESC limit ?, 10";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, substring);
			pstmt.setInt(2, num);
			
			
			rs = pstmt.executeQuery();
			
			
				while(rs.next()) {
					BoardVO board = new BoardVO();
					
					board.setPostID(rs.getInt(1));
					board.setPostAuthor(rs.getInt(2));
					board.setPostTitle(rs.getString(3));
					board.setPostContent(rs.getString(4));
					board.setPostTime(rs.getDate(5));
					board.setPostLastModified(rs.getDate(6));
					board.setViewCount(rs.getInt(7));
					board.setPostType(rs.getInt(8));
					board.setImageLink(rs.getString(9));
					
					
					//System.out.println("board 값 데이터 디버깅 : " + board);
					boardList.add(board);
					
				}
			
			
			//System.out.println("boardList 값 데이터 디버깅 : " + boardList);
			
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
		
		return boardList;
	
	} // getBoardList END;
	
	public int getBoardCountSearch(String query) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int boardCount = 0;
		String substring = "%"+query+"%";
		
		try {
			con = ds.getConnection();
			String sql = "SELECT COUNT(*) FROM board WHERE postContent LIKE ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, substring);

			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				boardCount = rs.getInt(1);
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
		return boardCount;
	} // getBoardCount END;
	

	
	
} // BoardDAO END;

	
