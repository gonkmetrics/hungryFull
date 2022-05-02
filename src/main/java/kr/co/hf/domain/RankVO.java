package kr.co.hf.domain;


public class PreviewVO {
	private int rankID;
	private int postID;
    private int rankPosition;
	
	
	@Override
	public String toString() {
		return "PreviewVO [rankID=" + rankID + ", postID=" + postID + ", rankPosition=" + rankPosition + "]";
	}


	public int getRankPosition() {
		return rankPosition;
	}


	public void setRankPosition(int rankPosition) {
		this.rankPosition = rankPosition;
	}


	public int getPostID() {
		return postID;
	}


	public void setPostID(int postID) {
		this.postID = postID;
	}


	public String getRankID() {
		return rankID;
	}


	public void setRankID(String rankID) {
		this.rankID = rankID;
	}
}