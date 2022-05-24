package kr.co.hf.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.hf.domain.BoardButtonDTO;
import kr.co.hf.domain.BoardDAO;
import kr.co.hf.domain.BoardVO;

public class UserPostListService implements ForumService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BoardDAO dao = BoardDAO.getInstance();
		HttpSession session = request.getSession();
		String strpageNum = request.getParameter("pageNum");
		int usernum = (int) session.getAttribute("s_num");
		
		int pageNum = 1;
		
		if(strpageNum != null) {
			 pageNum = Integer.parseInt(strpageNum);
		}
		
		int boardCount = dao.getBoardCountUser(usernum);
		System.out.println(boardCount);
		int userNum = (int) session.getAttribute("s_num");
		
		BoardButtonDTO buttons = new BoardButtonDTO(boardCount, pageNum);
		List<BoardVO> boardList = dao.getUserPostList(userNum, pageNum);
		
		request.setAttribute("userNum", userNum);
		request.setAttribute("boardList", boardList);
		request.setAttribute("buttons", buttons);
		
	}

}
