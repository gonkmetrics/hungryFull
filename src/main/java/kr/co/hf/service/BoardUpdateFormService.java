package kr.co.hf.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.hf.domain.BoardDAO;
import kr.co.hf.domain.BoardVO;
import kr.co.hf.domain.UserDAO;
import kr.co.hf.domain.UserVO;

public class BoardUpdateFormService implements ForumService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String strPostID = request.getParameter("postID");
		
		int postID = Integer.parseInt(strPostID);
		
		HttpSession session = request.getSession();
		
		String userId = (String)session.getAttribute("s_id");
		
		BoardDAO dao = BoardDAO.getInstance();
		UserDAO udao = UserDAO.getInstance();

		BoardVO board = dao.getBoardDetail(postID);
		UserVO user = udao.getUserInfo(userId);
		
		request.setAttribute("user", user);
		request.setAttribute("board", board);
	}

}
