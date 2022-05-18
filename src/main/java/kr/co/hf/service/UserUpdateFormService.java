package kr.co.hf.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.hf.domain.UserDAO;
import kr.co.hf.domain.UserVO;


public class UserUpdateFormService implements ForumService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String userId = (String)request.getParameter("s_id");
		System.out.println(userId);
		UserDAO dao = UserDAO.getInstance();
		UserVO user = dao.Update(userId);
		request.setAttribute("user",user);
		
	}

}
