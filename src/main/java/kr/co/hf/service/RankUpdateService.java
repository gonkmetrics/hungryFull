package kr.co.hf.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.hf.domain.BoardDAO;
import kr.co.hf.domain.LikeDAO;
import kr.co.hf.domain.PostRankVO;

public class RankUpdateService implements ForumService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String strPostID = request.getParameter("postID");
		int postID = Integer.parseInt(strPostID);
		BoardDAO dao = BoardDAO.getInstance();
		HashMap<Integer, PostRankVO> hash_mapRank = new HashMap<>();
		//tree_mapRank = new
		int boardCount = dao.getBoardCount();
		HttpSession session = request.getSession();
		if(session.getAttribute("rankMap") == null) { //get from listener
			for(int countA = 0; countA < boardCount; countA++) {
				addRankMap(countA, hash_mapRank);
			}
			}else {
				addRankMap(postID, hash_mapRank);
			}
		
		hash_mapRank = sortByValue(hash_mapRank);
		//session.setAttribute("rankMap", hash_mapRank);
		//pass to listener
		
	}
	
	//add to hashmap
	public static void addRankMap(int postId, HashMap<Integer, PostRankVO> hash_map) {
		PostRankVO pro = new PostRankVO();
		LikeDAO likeDAO = LikeDAO.getInstance();
		int likeCount = likeDAO.getLikeCount(postId);
		pro.setLikeCount(likeCount);
		pro.setPostID(postId);
		hash_map.put(postId, pro);
	}
	
	//sort hashmap
    public static HashMap<Integer, PostRankVO> sortByValue(HashMap<Integer, PostRankVO> hm){
        HashMap<Integer, PostRankVO> temp
            = hm.entrySet()
                  .stream()
                  .sorted((i1, i2)
                              -> i1.getValue().compareTo(
                                  i2.getValue()))
                  .collect(Collectors.toMap(
                      Map.Entry::getKey,
                      Map.Entry::getValue,
                      (e1, e2) -> e1, LinkedHashMap::new));
        return temp;
    }
	

}
