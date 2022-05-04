package kr.co.hf.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.hf.domain.UserDAO;
import kr.co.hf.domain.UserVO;

public class userLoginService implements UserService {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO dao = UserDAO.getInstance(); 

		String formId = request.getParameter("formId");
		String formPw = request.getParameter("formPw");
		
		String userId = null;
		String userPw = null;
		
		UserVO user = dao.getUserInfo(formId);

		userId = user.getUserId();
		userPw = user.getUserPw();
		
		HttpSession session = request.getSession();
		session.getAttribute("s_id");
		session.getAttribute("s_pw");
		
		String url = null;
		if(userId != null){
			if(formPw.equals(userPw)){
				session.setAttribute("s_id", userId);	
				url = "LoginComplete.jsp";
			} else {
				url = "PwFail.jsp";
			}
		} else {
			url = "IdFail.jsp";
		} response.sendRedirect("LoginComplete.jsp");
		request.setAttribute("userId",userId);
	} 
}
