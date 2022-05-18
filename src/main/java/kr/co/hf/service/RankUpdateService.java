package kr.co.hf.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.hf.domain.BoardDAO;
import kr.co.hf.domain.LikeDAO;
import kr.co.hf.domain.PostRankVO;

public class RankUpdateService implements Runnable{

	public void run(){
		// TODO Auto-generated method stub
		//request.setCharacterEncoding("UTF-8");
		//String strPostID = request.getParameter("postID");
		//int postID = Integer.parseInt(strPostID);
		BoardDAO dao = BoardDAO.getInstance();
		Map<Integer, PostRankVO> hash_mapRank = new HashMap<>();
		//tree_mapRank = new
		int boardCount = dao.getBoardCount();
		//HttpSession session = request.getSession();
		/*if(session.getAttribute("rankMap") == null) { get from listener */
			for(int countA = 0; countA < boardCount; countA++) {
				addRankMap(countA, hash_mapRank);
			}
			System.out.println(hash_mapRank);
			/*}*/
		
		/*else {
				addRankMap(postID, hash_mapRank);
			} */
			
			Map<Integer, PostRankVO> result = hash_mapRank.entrySet()
					  .stream()
					  .sorted(Map.Entry.<Integer, PostRankVO>comparingByValue())
					  .collect(Collectors.toMap(
					    Map.Entry::getKey, 
					    Map.Entry::getValue, 
					    (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		    
		
		//hash_mapRank = sortByComparator(hash_mapRank, null, false);
		//session.setAttribute("rankMap", hash_mapRank);
		//pass to listener
		
	}
	
	//add to hashmap
	private static void addRankMap(int postId, Map<Integer, PostRankVO> hash_map) {
		PostRankVO pro = new PostRankVO();
		LikeDAO likeDAO = LikeDAO.getInstance();
		int likeCount = likeDAO.getLikeCount(postId);
		pro.setLikeCount(likeCount);
		pro.setPostID(postId);
		hash_map.put(postId, pro);
	}
	
	//sort hashmap

}
	


