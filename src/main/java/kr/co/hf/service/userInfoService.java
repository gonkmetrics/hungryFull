package kr.co.hf.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hf.domain.UserDAO;
import kr.co.hf.domain.UserVO;


public class userInfoService implements UserService {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	UserDAO dao = UserDAO.getInstance();
	String struserNum = request.getParameter("userNum");
	int userNum = Integer.parseInt(struserNum);
	UserVO user = dao.getUserInfo(userNum);
	}
}
