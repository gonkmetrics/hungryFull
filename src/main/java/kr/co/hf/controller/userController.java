package kr.co.hf.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.HF.domain.UserDAO;
import kr.co.HF.service.UserService;
import kr.co.hf.service.userInfoService;
import kr.co.hf.service.userJoinFormService;

/**
 * Servlet implementation class userController
 */
@WebServlet("*.do")
public class userController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request,response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doRequest(request,response);
	}
	private void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String ui = null;
		UserDAO dao = UserDAO.getInstance();
		UserService sv = null;
		
		if(uri.equals("/HFprj/userList.do")) {
			sv = new userInfoService();
			sv.execute(request,response);
			ui = "/user/getUserInfo.jsp";
		} else if (uri.equals("/HFprj/userJoinForm.do")) {
			sv = new userJoinFormService();
			sv.execute(request,response);
			ui = "/user/userJoinForm.jsp";
		}  else if (uri.equals("/MyFirstWeb/boardInsertForm.do")){
			ui = "/board/boardInsertForm.jsp";
		} else if(uri.equals("/MyFirstWeb/boardInsert.do")) {
			sv = new BoardInsertService();
			sv.execute(request,response);
			ui = "/boardList.do";
		} else if (uri.equals("/MyFirstWeb/boardDelete.do")) {
			sv = new BoardDeleteService();
			sv.execute(request,response);
			ui = "/boardList.do";
		} else if(uri.equals("/MyFirstWeb/boardUpdateForm.do")) {
			sv = new BoardUpdateFormService();
			sv.execute(request,response);
			ui = "/board/boardUpdateForm.jsp";
		} else if(uri.equals("/MyFirstWeb/boardUpdate.do")) {
			sv = new BoardUpdateService();
			sv.execute(request,response);
			ui = "/boardDetail.do?board_num=" + request.getParameter("board_num");
		}
		
		RequestDispatcher dp = request.getRequestDispatcher(ui);
		dp.forward(request, response);
		
	}

	private int BoardUpdateService(int boardNum) {
		// TODO Auto-generated method stub
		return 0;
	}


}
