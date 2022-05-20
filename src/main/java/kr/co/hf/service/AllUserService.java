package kr.co.hf.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.hf.domain.UserDAO;
import kr.co.hf.domain.UserVO;
import kr.co.hf.domain.AllUserButtonDTO;


public class AllUserService implements ForumService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO dao = UserDAO.getInstance();
		HttpSession session = request.getSession();
		
		String sId = (String)session.getAttribute("s_id");
		System.out.println("관리자 아이디 : " + sId);

		String strpageNum = request.getParameter("pageNum");

		int pageNum = 1;
		if(strpageNum != null) {
			 pageNum = Integer.parseInt(strpageNum);
		}
		
		
		int userCount = dao.getUserCount();
		AllUserButtonDTO buttons = new AllUserButtonDTO(userCount, pageNum);
		List<UserVO> userList = dao.getAllUserList(pageNum);
		request.setAttribute("buttons", buttons);
		request.setAttribute("userList", userList);
		System.out.println("button" + buttons);
		System.out.println("userList" + userList);
		System.out.println("userCount" + userCount);
}

}