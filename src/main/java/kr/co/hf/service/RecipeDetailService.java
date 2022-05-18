package kr.co.hf.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hf.domain.BoardDAO;
import kr.co.hf.domain.BoardVO;
import kr.co.hf.domain.ComDAO;
import kr.co.hf.domain.ComVO;
import kr.co.hf.domain.UserDAO;
import kr.co.hf.domain.UserVO;

public class RecipeDetailService implements ForumService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String strPostID = request.getParameter("postID");
		String strPostAuthor = request.getParameter("postAuthor");
		
		int postID = Integer.parseInt(strPostID);
		int postAuthor = Integer.parseInt(strPostAuthor);
		
		BoardDAO bdao = BoardDAO.getInstance();
		UserDAO udao = UserDAO.getInstance();
		
		UserVO user = udao.getUserInfoNum(postAuthor);
		
		BoardVO board = bdao.getBoardDetail(postID);
		
		ComDAO cdao = ComDAO.getInstance();
		
        List<ComVO> ComList = cdao.getComList(postID);
        request.setAttribute("ComList", ComList);
		request.setAttribute("user", user);
		request.setAttribute("board", board);
		
	}

}
