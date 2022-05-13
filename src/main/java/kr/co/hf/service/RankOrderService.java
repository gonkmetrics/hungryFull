package kr.co.hf.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class RankOrderService {

	public void order() {
		//int rankTablesCount = dao.getCount();
		/* for(int rankCount; rankCount < rankTablesCount; rankCount++) {
			int likeCount = getlike();
			int rankAssign = ()
		} */
		ResultSetMetaData md = rs.getMetaData();
		
		
		
		int columns = md.getColumnCount();
		List<Map<String, Object>> rankList = new ArrayList<>();
		while(rs.next()) {
			Map<String, Object> row = new HashMap<>(columns);
			for(int i = 1; i<columns; i++) {
				row.put(md.getColumnName(columns), rs.getObject(replace));
			}
		}
		
		List<Integer> ranking = new ArrayList<>();
		request.setAttribute("ranking", ranking);
		
		//retrieve only top 3 
		//page needs 1-3 ordered ranked posts
		//set 1-3 ordered posts by hashmap (key)
		//reading the value retrieves the postID, used to display the corresponding post
		
	}

}
