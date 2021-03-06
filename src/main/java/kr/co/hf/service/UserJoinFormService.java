package kr.co.hf.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.hf.domain.UserDAO;

public class UserJoinFormService implements ForumService{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		UserDAO dao = UserDAO.getInstance();
		String struserNum = request.getParameter("userNum");
		int userNum = 0;
		if(struserNum.equals("")) {
		} else {
			 userNum = Integer.parseInt(struserNum);
		}
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		String struage = request.getParameter("uage");
		int uage = Integer.parseInt(struage);
		String strisAdmin = request.getParameter("isAdmin");

		int isAdmin = 0;
		if(strisAdmin.equals("")) {
		} else {
			 isAdmin = Integer.parseInt(strisAdmin);
		}
		dao.JoinCheck(userNum, userId, userPw, userName, userEmail, uage, isAdmin);
		request.setAttribute("s_id", userId);
		HttpSession session = request.getSession();
		session.setAttribute("s_id", userId);
	}

}
