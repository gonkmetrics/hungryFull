package kr.co.hf.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hf.domain.UserDAO;

public class userUpdateService implements UserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		UserDAO dao = UserDAO.getInstance();
		
		String userId = request.getParameter("fId");
		String userPw = request.getParameter("fPw");
		String userName = request.getParameter("fName");
		String userEmail = request.getParameter("fEmail");
		String struage = request.getParameter("fuage");
		int uage = Integer.parseInt(struage);
		
		
		// 가입로직을 실행해주세요.
		dao.UpdateCheck(userPw, userName, userEmail, uage, userId);
		
	}

}
