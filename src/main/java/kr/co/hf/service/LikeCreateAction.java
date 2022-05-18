package kr.co.hf.service;

import com.opensymphony.xwork2.ActionSupport;

import kr.co.hf.domain.LikeDAO;

public class LikeCreateAction extends ActionSupport{
	private static final long serialVersionUID = -3827439829486925185L;
	private String postID;
	private String userNum;
	private String msg;
	
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
		msg = dao.createLike(pid, unum);
		return "CREATE";
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
