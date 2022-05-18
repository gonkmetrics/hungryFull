package kr.co.hf.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hf.domain.UserDAO;
import kr.co.hf.domain.UserVO;

public class AllUserService implements ForumService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		UserDAO dao = UserDAO.getInstance();
		List<UserVO> userList = dao.getAllUserList();
		request.setAttribute("userList", userList);
}

}