package kr.co.hf.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.hf.domain.UserDAO;
import kr.co.hf.domain.UserVO;

public class userDeleteService implements UserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("s_id");
		UserDAO dao = UserDAO.getInstance();
		dao.Delete(userId);
		
		session.invalidate();
}
}