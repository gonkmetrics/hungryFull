package kr.co.hf.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hf.domain.UserDAO;

public class UserUpdateService implements ForumService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		UserDAO dao = UserDAO.getInstance();
		
		String struserNum = request.getParameter("userNum");
		int userNum = 0;
		if(struserNum.equals("")) {
		} else {
			 userNum = Integer.parseInt(struserNum);
		}
		
		String userId = request.getParameter("s_id");
		String userPw = request.getParameter("user_pw");
		String userName = request.getParameter("user_name");
		String userEmail = request.getParameter("user_email");
		
		String struage = request.getParameter("user_age");
		int uage = 0;
		if(struage.equals("")) {
		} else {
			 uage = Integer.parseInt(struage);
		}
		String strisAdmin = request.getParameter("isAdmin");

		int isAdmin = 0;
		if(strisAdmin.equals("")) {
		} else {
			 isAdmin = Integer.parseInt(strisAdmin);
		}

		dao.UpdateCheck(userId, userPw, userName, userEmail, uage);
		
	}

}
