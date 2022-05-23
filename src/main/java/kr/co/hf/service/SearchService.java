package kr.co.hf.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.hf.domain.UserDAO;
import kr.co.hf.domain.UserVO;
import kr.co.hf.domain.AllUserButtonDTO;
import kr.co.hf.domain.BoardButtonDTO;
import kr.co.hf.domain.BoardDAO;
import kr.co.hf.domain.BoardVO;


public class SearchService implements ForumService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BoardDAO dao = BoardDAO.getInstance();
		
		String strpageNum = request.getParameter("pageNum");
		String query = request.getParameter("query");
		
		int pageNum = 1;
		
		if(strpageNum != null) {
			 pageNum = Integer.parseInt(strpageNum);
		}
		
		int boardCount = dao.getBoardCountSearch(query);
		
		BoardButtonDTO buttons = new BoardButtonDTO(boardCount, pageNum);
		
		List<BoardVO> boardList = dao.getBoardListSearch(pageNum, query);
		
		request.setAttribute("boardList", boardList);
		request.setAttribute("buttons", buttons);
}

}