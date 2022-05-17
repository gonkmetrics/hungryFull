package kr.co.hf.domain;


public class LikeVO {
	private int likeID;
    private int likeType;
    private int postID;
    private int userNum;
	public int getLikeID() {
		return likeID;
	}
	public void setLikeID(int likeID) {
		this.likeID = likeID;
	}
	public int getLikeType() {
		return likeType;
	}
	public void setLikeType(int likeType) {
		this.likeType = likeType;
	}
	public int getPostID() {
		return postID;
	}
	public void setPostID(int postID) {
		this.postID = postID;
	}
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	@Override
	public String toString() {
		return "LikeVO [likeID=" + likeID + ", likeType=" + likeType + ", postID=" + postID + ", userNum=" + userNum
				+ "]";
	}


}