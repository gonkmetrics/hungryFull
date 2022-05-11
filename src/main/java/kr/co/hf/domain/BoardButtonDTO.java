package kr.co.hf.domain;

// 원래 VO(Value Object)와 DTO(Data Transfer Object)는 큰 차이를 두지 않고 사용합니다.
// 굳이 차이를 두자면 VO는 DB에서 가져온 자료를 그대로 전달할 때,
// DTO는 DB에서 꺼내온 데이터가 가공되어 전달할 때 쓰는것을 지칭합니다.
// 다만 DTO, VO는 엄격하게 구분되지 않고 프로그래머에 따라서는
// 그냥 DTO를 VO와 동일하게 쓰는 경우도 있으므로
// 사용하는 사람이 부르고 싶은대로 부르셔도 무방합니다.
public class BoardButtonDTO {
	private int boardCount;
	private int currentPage;
	private int totalPages;
	private int startPage; 
	private int endPage; 


	public BoardButtonDTO(int boardCount, int currentPage) {

		this.boardCount = boardCount;
		this.currentPage = currentPage;
		

		if(this.boardCount == 0) {

			this.totalPages = 0;
			this.startPage = 0;
			this.endPage = 0;
		} else {

			if(boardCount % 10 == 0) {
				
				this.totalPages = this.boardCount / 10;
			} else {
				
				this.totalPages = (this.boardCount / 10) + 1;
			}
			

			int navNum = 0;
			
			navNum = (((currentPage - 1) / 10) * 10) + 1; 
			
			this.startPage = navNum;
			

			this.endPage = navNum + (10 - 1); 

			if(this.totalPages < this.endPage) {
				this.endPage = this.totalPages;
			}
			
		}
	}
	
	public int getBoardCount() {
		return boardCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}
	
	@Override
	public String toString() {
		return "BoardButtonDTO [boardCount=" + boardCount + ", currentPage=" + currentPage + ", totalPages="
				+ totalPages + ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}
	
}
