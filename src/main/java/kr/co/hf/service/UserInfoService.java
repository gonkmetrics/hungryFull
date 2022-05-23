package kr.co.hf.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.hf.domain.BoardButtonDTO;
import kr.co.hf.domain.BoardDAO;
import kr.co.hf.domain.BoardVO;
import kr.co.hf.domain.LikeDAO;
import kr.co.hf.domain.LikeVO;
import kr.co.hf.domain.UserDAO;
import kr.co.hf.domain.UserVO;


public class UserInfoService implements ForumService{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	UserDAO udao = UserDAO.getInstance();
	BoardDAO bdao = BoardDAO.getInstance();
	LikeDAO ldao = LikeDAO.getInstance();
	HttpSession session = request.getSession();
	String userId = (String)session.getAttribute("s_id");
	
	String strpageNum = request.getParameter("pageNum");
	
	int pageNum = 1;
	
	if(strpageNum != null) {
		 pageNum = Integer.parseInt(strpageNum);
	}
	
	UserVO user = udao.getUserInfo(userId);
	List<LikeVO> like = ldao.getLikeUser(user.getUserNum());
	List<BoardVO> boardLike = new ArrayList<>();
	for(LikeVO likePost : like) {
		int post = likePost.getPostID();
		BoardVO bvo = bdao.getBoardDetail(post);
		boardLike.add(bvo);
	}
	int boardCount = boardLike.size();
	BoardButtonDTO buttons = new BoardButtonDTO(boardCount, pageNum);
	
	request.setAttribute("buttons", buttons);
	request.setAttribute("boardLike", boardLike);
	request.setAttribute("user", user);
	}
}
