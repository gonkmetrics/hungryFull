package kr.co.hf.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hf.domain.LikeDAO;

public class LikeReportService implements ForumService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		
		String postID = request.getParameter("postid");
		String userNum = request.getParameter("usernum");
		
		int pid = Integer.parseInt(postID);
		int unum = Integer.parseInt(userNum);
		
		LikeDAO dao = LikeDAO.getInstance();
		dao.getLikeUP(pid, unum);
		
	}
	
}
