package kr.co.hf.service;

import java.io.IOException;
import java.util.ArrayList;
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
		HttpSession session = request.getSession();
		String strpageNum = request.getParameter("pageNum");
		
		int pageNum = 1;
		
		if(strpageNum != null) {
			 pageNum = Integer.parseInt(strpageNum);
		}
		

		int boardCount = dao.getBoardCount();

		
		BoardButtonDTO buttons = new BoardButtonDTO(boardCount, pageNum);
		
		
		List<BoardVO> boardList = dao.getBoardList(pageNum);
		
		ServletContext context = session.getServletContext();
		ArrayList<Integer> displayKeys = (ArrayList<Integer>) context.getAttribute("displayKeys");
		Boolean listKeysTrue = (Boolean) context.getAttribute("listKeysTrue");
		System.out.println(listKeysTrue);
		//context.getAttribute("rank1");
		
		ArrayList<BoardVO> bo = new ArrayList<>();
		ArrayList<Integer> bl = new ArrayList<>();
		
		if(listKeysTrue == true) {
			for(int c=0; c<3; c++) {
				bo.add(dao.getBoardDetail(displayKeys.get(c)));
				bl.add(daoL.getLikeCount(c));
			}
		}
		
		System.out.println("Check BO:"+bo);
		
		//BoardVO bo2 = dao.getBoardDetail(r2);
		
		
		//int bl1 = daoL.getLikeCount(r1);
		
		request.setAttribute("bo", bo);
		//request.setAttribute("buttons", buttons);
		
		request.setAttribute("bl", bl);
		//request.setAttribute("bo2", bo2);
		
		request.setAttribute("boardList", boardList);
		request.setAttribute("buttons", buttons);
		
	}

}
