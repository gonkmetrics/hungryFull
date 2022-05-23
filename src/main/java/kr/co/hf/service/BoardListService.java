package kr.co.hf.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.hf.domain.BoardButtonDTO;
import kr.co.hf.domain.BoardDAO;
import kr.co.hf.domain.BoardVO;
import kr.co.hf.domain.LikeDAO;

public class BoardListService implements ForumService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BoardDAO dao = BoardDAO.getInstance();
		LikeDAO daoL = LikeDAO.getInstance();
		
		String strpageNum = request.getParameter("pageNum");
		
		int pageNum = 1;
		
		if(strpageNum != null) {
			 pageNum = Integer.parseInt(strpageNum);
		}
		
		int boardCount = dao.getBoardCount();
		
		BoardButtonDTO buttons = new BoardButtonDTO(boardCount, pageNum);
		
		
		List<BoardVO> boardList = dao.getBoardList(pageNum);
		HttpSession session = request.getSession();
		ServletContext context = session.getServletContext();
		int r1 = (int) context.getAttribute("rank1");
		int r2 = (int) context.getAttribute("rank2");
		//context.getAttribute("rank1");
		
		BoardVO bo1 = dao.getBoardDetail(r1);
		BoardVO bo2 = dao.getBoardDetail(r2);
		//BoardVO bo2 = dao.getBoardDetail(r2);
		
		int bl1 = daoL.getLikeCount(r1);
		int bl2 = daoL.getLikeCount(r2);
		//int bl1 = daoL.getLikeCount(r1);
		
		request.setAttribute("bo1", bo1);
		request.setAttribute("bo2", bo2);
		//request.setAttribute("buttons", buttons);
		
		request.setAttribute("bl1", bl1);
		request.setAttribute("bl2", bl2);
		//request.setAttribute("bo2", bo2);
		
		request.setAttribute("boardList", boardList);
		request.setAttribute("buttons", buttons);
		
	}

}
