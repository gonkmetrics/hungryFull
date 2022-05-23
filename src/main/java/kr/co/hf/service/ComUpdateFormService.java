package kr.co.hf.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.hf.domain.ComDAO;
import kr.co.hf.domain.ComVO;

public class ComUpdateFormService implements ForumService{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		String commentid = request.getParameter("commentID");
		
		int commentID = Integer.parseInt(commentid);
		
		System.out.println("commentID");
		
		ComDAO dao = ComDAO.getInstance();
		
		ComVO com = dao.getComDetail(commentID);
		
		
		request.setAttribute("com", com);
	}

}
