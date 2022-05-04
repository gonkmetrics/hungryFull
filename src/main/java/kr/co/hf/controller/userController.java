package kr.co.hf.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hf.domain.UserDAO;
import kr.co.hf.service.UserService;
import kr.co.hf.service.userInfoService;
import kr.co.hf.service.userJoinFormService;
import kr.co.hf.service.userLoginService;

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
		
		if (uri.equals("/HFprj/userLogin.do")) {
			ui = "user/LoginForm.jsp";
		}		
		else if(uri.equals("/HFprj/userLoginCheck.do")) {
			sv = new userLoginService();
			sv.execute(request,response);
			ui = "/user/LoginComplete.jsp";
		} else if (uri.equals("/HFprj/userJoinForm.do")) {
			ui = "/user/JoinFormlight.jsp";
		} else if(uri.equals("/HFprj/userJoinCheck.do")) {
			sv = new userJoinFormService();
			sv.execute(request,response);
			ui = "/userLogin.do";
		} 

		RequestDispatcher dp = request.getRequestDispatcher(ui);
		dp.forward(request, response);
	}
	}

