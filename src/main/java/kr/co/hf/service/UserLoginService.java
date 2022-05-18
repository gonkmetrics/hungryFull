package kr.co.hf.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.hf.domain.UserDAO;
import kr.co.hf.domain.UserVO;

public class UserLoginService implements ForumService{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String formId = request.getParameter("formId");
		String formPw = request.getParameter("formPw");
		
		String userId = null;
		String userPw = null;
		
		UserDAO dao = UserDAO.getInstance();
		UserVO user = dao.getUserInfo(formId);

		userId = user.getUserId();
		userPw = user.getUserPw();
		
		HttpSession session = request.getSession();
		System.out.println();
		String url = null;
		if(userId != null) {
			if(formPw.equals(userPw)) {
			request.setAttribute("s_id", userId);
			session.setAttribute("s_id", userId);
			url = "homepage.do";
		} else {
			url = "/user/PwFail.jsp";
		} } else {
			url = "/user/IdFail.jsp";
		} 
		
		 if(user.getIsAdmin() == 0) {
			request.setAttribute("s_isAdmin", 0);
			session.setAttribute("s_isAdmin", 0);
		}else if(user.getIsAdmin() == 1) {
			request.setAttribute("s_isAdmin", 1);
			session.setAttribute("s_isAdmin", 1);
		} 
		request.setAttribute("url", url); 
		}
		
	} 

