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

		int postID = Integer.parseInt(strPostID);
		
		BoardDAO bdao = BoardDAO.getInstance();

		UserDAO udao = UserDAO.getInstance();
		
		BoardVO board = bdao.getBoardDetail(postID);
		bdao.upViewCnt(postID);
		
		int userNum = board.getPostAuthor();
		
		ComDAO cdao = ComDAO.getInstance();
		
		UserVO user = udao.getUserInfoNum(userNum);

        List<ComVO> ComList = cdao.getComList(postID);
        
        request.setAttribute("user", user);
        request.setAttribute("ComList", ComList);
		request.setAttribute("board", board);
		
	}

}
