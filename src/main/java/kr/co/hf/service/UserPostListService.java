package kr.co.hf.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hf.domain.BoardButtonDTO;
import kr.co.hf.domain.BoardDAO;
import kr.co.hf.domain.BoardVO;

public class UserPostListService implements ForumService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BoardDAO dao = BoardDAO.getInstance();
		
		String strUserNum = request.getParameter("userNum");
		
		int userNum = Integer.parseInt(strUserNum);
		
		int pageNum = 1;
		
		int boardCount = dao.getBoardCount();
		
		BoardButtonDTO buttons = new BoardButtonDTO(boardCount, pageNum);
		
		List<BoardVO> boardList = dao.getUserPostList(userNum);
		
		request.setAttribute("boardList", boardList);
		request.setAttribute("buttons", buttons);
		
	}

}
