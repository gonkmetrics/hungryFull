package kr.co.hf.domain;


public class LikeVO {
	private int likeID;
	private int postID;
    private int likeType;
    private int userID;
	
	
	@Override
	public String toString() {
		return "PreviewVO [likeID=" + likeID + ", postID=" + postID + ", userID=" + userID + ", likeType=" + likeType + "]";
	}


	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}


	public int getPostID() {
		return postID;
	}


	public void setPostID(int postID) {
		this.postID = postID;
	}


	public String getLikeType() {
		return likeType;
	}


	public void setLikeType(String likeType) {
		this.likeType = likeType;
	}

    public String getLikeID() {
		return likeID;
	}


	public void setLikeID(String rankID) {
		this.likeID = likeID;
	}
}