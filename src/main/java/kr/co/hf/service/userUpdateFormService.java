package kr.co.hf.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hf.domain.UserDAO;
import kr.co.hf.domain.UserVO;


public class userUpdateFormService implements UserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO dao = UserDAO.getInstance();
		String userId = request.getParameter("userId");
		UserVO user = dao.getUserInfo(userId);
		request.setAttribute("user", user);
		
	}

}
