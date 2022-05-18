package kr.co.hf.service;

import com.opensymphony.xwork2.ActionSupport;

import kr.co.hf.domain.LikeDAO;
import kr.co.hf.domain.LikeVO;

public class LikeReportAction extends ActionSupport{
	private static final long serialVersionUID = -3827439829486925185L;
	private String postID;
	private String userNum;
	LikeVO like = null;
	private int likeType;
	
	public String getPostID() {
		return postID;
	}
	public void setPostID(String postID) {
		this.postID = postID;
	}
	public String getUserNum() {
		return userNum;
	}
	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		String postID = getPostID();
		String userNum = getUserNum();
		
		int pid = Integer.parseInt(postID);
		int unum = Integer.parseInt(userNum);
		
		LikeDAO dao = LikeDAO.getInstance();
		like = dao.getLikeUP(pid, unum);
		likeType = like.getLikeType();
		return "REPORT";
	}
	
	public LikeVO getLike() {
		return like;
	}
	public void setLike(LikeVO like) {
		this.like = like;
	}
	public int getLikeType() {
		return likeType;
	}
	public void setLikeType(int likeType) {
		this.likeType = likeType;
	}

}
