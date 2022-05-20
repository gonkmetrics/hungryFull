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
		String strpageNum = request.getParameter("pageNum");
		
		int pageNum = 1;
		
		if(strpageNum != null) {
			 pageNum = Integer.parseInt(strpageNum);
		}
		
		int boardCount = dao.getBoardCount();
		int userNum = Integer.parseInt(strUserNum);
		
		BoardButtonDTO buttons = new BoardButtonDTO(boardCount, pageNum);
		List<BoardVO> boardList = dao.getUserPostList(userNum, pageNum);
		
		request.setAttribute("userNum", userNum);
		request.setAttribute("boardList", boardList);
		request.setAttribute("buttons", buttons);
		
	}

}