package kr.co.hf.service;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hf.domain.BoardButtonDTO;
import kr.co.hf.domain.BoardDAO;
import kr.co.hf.domain.BoardVO;
import kr.co.hf.domain.LikeDAO;

public class RankUpdateService implements IBoardService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String strPostID = request.getParameter("postID");
		
		int postID = Integer.parseInt(strPostID);
		
		LikeDAO likeDAO = LikeDAO.getInstance();
		BoardDAO dao = BoardDAO.getInstance();
		
		int boardCount = dao.getBoardCount();
		
		HashMap<Integer, Integer> boardRanking = new HashMap<Integer, Integer>();
		
		for(int countA = 0; countA < boardCount; countA++) {
			likeDAO.getLikeCount(countA);
			boardRanking.put(count.);
		}
		
		List<>
		
		//then, sort
		
		request.setAttribute("board", board);
		
	}
	

}
