package kr.co.hf.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import kr.co.hf.domain.BoardDAO;
import kr.co.hf.domain.LikeDAO;

public class RankUpdateService implements Callable<HashMap<Integer, Integer>>{

	public HashMap<Integer, Integer> run(){
		// TODO Auto-generated method stub
		/*
		 * request.setCharacterEncoding("UTF-8");
		String strPostID = request.getParameter("postID");
		int postID = Integer.parseInt(strPostID);
		BoardDAO dao = BoardDAO.getInstance();
		Map<Integer, PostRankVO> hash_mapRank = new HashMap<>();
		tree_mapRank = new
		int boardCount = dao.getBoardCount();
		//HttpSession session = request.getSession();
		if(session.getAttribute("rankMap") == null) { get from listener 
			for(int countA = 0; countA < boardCount; countA++) {
				addRankMap(countA, hash_mapRank);
			}
			System.out.println(hash_mapRank);
			}
		
		else {
				addRankMap(postID, hash_mapRank);
			} 
			
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
		*/
		
		//hashmap: postid is key, likecount is value
		
		
		HashMap<Integer, Integer> unsortedRankMap = new HashMap<>();
		HashMap<Integer, Integer> rankMap = new HashMap<>();
		
		//add entries
		BoardDAO daoB = BoardDAO.getInstance();
		LikeDAO daoL = LikeDAO.getInstance();
		int boardCount = daoB.getBoardCount();
		for(int countA = 0; countA < boardCount; countA++) {
			int like = daoL.getLikeCount(countA);
			if(like != 0) {
				unsortedRankMap.put(countA, like);
			}
			
		}
		
		rankMap = sortByValue(unsortedRankMap);
		System.out.println("service rank: "+rankMap);
		return rankMap;
		
		//SEND RANKMAP to LISTENER
		
		
		//then check nonexistent entries
		
		
		
	}
	
	private static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hm){
		List<Map.Entry<Integer, Integer> > list =
	               new LinkedList<Map.Entry<Integer, Integer> >(hm.entrySet());
		
		//sort using collections' methods
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
		
		return temp;
		
	}
	/*
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
	*/

	@Override
	public HashMap<Integer, Integer> call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
	


