package kr.co.hf.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.hf.domain.ComDAO;
import kr.co.hf.domain.ComVO;

public class ComUpdateService implements ForumService{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		ComDAO dao = ComDAO.getInstance();
		
		String commentid = request.getParameter("commentID");
		String postid = request.getParameter("postID");
		
		int commentID = Integer.parseInt(commentid);
		
		String content = request.getParameter("commentContent");
		String author = request.getParameter("commentAuthor");
		request.setAttribute("postID", postid);
		dao.ComUpdate(content, author, commentID);
	}

}
