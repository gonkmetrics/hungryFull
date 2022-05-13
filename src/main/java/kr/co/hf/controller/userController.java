package kr.co.hf.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hf.domain.UserDAO;
import kr.co.hf.service.AllUserService;
import kr.co.hf.service.UserService;
import kr.co.hf.service.userDeleteService;
import kr.co.hf.service.userInfoService;
import kr.co.hf.service.userJoinFormService;
import kr.co.hf.service.userLoginService;
import kr.co.hf.service.userLogoutService;
import kr.co.hf.service.userUpdateFormService;
import kr.co.hf.service.userUpdateService;


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
        uri = uri.substring(uri.lastIndexOf("/")+1);
        uri = uri.substring(0, uri.indexOf("."));
		
		if (uri.equals("userLogin")) {
			ui = "user/LoginForm.jsp";
		}		
		else if(uri.equals("userLoginCheck")) {
			sv = new userLoginService();
			sv.execute(request,response);
			ui = (String)request.getAttribute("url");
		} else if (uri.equals("userJoinForm")) {
			ui = "/user/JoinFormlight.jsp";
		} else if(uri.equals("userJoinCheck")) {
			sv = new userJoinFormService();
			sv.execute(request,response);
			ui = "/userLogin.do";
		} else if(uri.equals("userLogout")) {
			sv = new userLogoutService();
			sv.execute(request,response);
			ui = "/userLogin.do";
		} else if(uri.equals("userUpdateForm")) {
			sv = new userUpdateFormService();
			sv.execute(request,response);
			ui = "/user/UpdateForm.jsp";
		} else if(uri.equals("userUpdate")) {
			sv = new userUpdateService();
			sv.execute(request,response);
			ui = "/user/LoginComplete.jsp";
		} else if(uri.equals("userDelete")) {
			sv = new userDeleteService();
			sv.execute(request,response);
			ui = "user/LoginForm.jsp";
		} else if(uri.equals("AllUser")) {
			sv = new AllUserService();
			sv.execute(request,response);
			ui = "user/getAllUserInfo.jsp";
		}
		System.out.println(ui);
		RequestDispatcher dp = request.getRequestDispatcher(ui);
		dp.forward(request, response);
	}
	}

