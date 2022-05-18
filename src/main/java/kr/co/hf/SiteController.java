package kr.co.hf;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hf.service.AllUserService;
import kr.co.hf.service.BoardDeleteService;
import kr.co.hf.service.BoardDetailService;
import kr.co.hf.service.BoardInsertFormService;
import kr.co.hf.service.BoardInsertService;
import kr.co.hf.service.BoardListService;
import kr.co.hf.service.BoardUpdateFormService;
import kr.co.hf.service.BoardUpdateService;
import kr.co.hf.service.ComDeleteService;
import kr.co.hf.service.ComInsertService;
import kr.co.hf.service.ComUpdateFormService;
import kr.co.hf.service.ComUpdateService;
import kr.co.hf.service.ForumService;
import kr.co.hf.service.RecipeDetailService;
import kr.co.hf.service.UserDeleteService;
import kr.co.hf.service.UserJoinFormService;
import kr.co.hf.service.UserLoginService;
import kr.co.hf.service.UserLogoutService;
import kr.co.hf.service.UserUpdateFormService;
import kr.co.hf.service.UserUpdateService;


/**
 * Servlet implementation class SiteController
 */
@WebServlet("*.do")
public class SiteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SiteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	/*public void destroy() {
		// TODO Auto-generated method stub
	}*/

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	
protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/")+1);
		uri = uri.substring(0, uri.indexOf("."));
	
		String ui = null;
		
		ForumService sv = null;
		
		if(uri.equals("boardList")) {
			
			sv = new BoardListService();
			
			sv.execute(request, response);

			ui = "/board/getBoardList.jsp";

		}
		
		if (uri.equals("boardDetail")) {
			
			sv = new BoardDetailService();
			
			sv.execute(request, response);
			
			ui = "/board/boardDetail.jsp";
			
		}
		
		if (uri.equals("boardInsertForm")) {
			
			sv = new BoardInsertFormService();
			
			sv.execute(request, response);
			
			ui = "/board/boardInsertForm.jsp";
			
		}
		
		if (uri.equals("boardInsert")) {
			
			sv = new BoardInsertService();
			
			sv.execute(request, response);
			
			ui = "/homepage.do";
			
		}
		
		if (uri.equals("boardUpdate")) {
			
			sv = new BoardUpdateService();
			
			sv.execute(request, response);
			
			ui = "/homepage.do";
			
		}
		
		if (uri.equals("boardUpdateForm")) {
			
			sv = new BoardUpdateFormService();
			
			sv.execute(request, response);
			
			ui = "/board/boardUpdateForm.jsp";
		
		}
		
		if (uri.equals("boardDelete")) {
			
			sv = new BoardDeleteService();
			
			sv.execute(request, response);
			
			ui = "/homepage.do";
			
		}
		
		if (uri.equals("recipeDetail")) {
			
			sv = new RecipeDetailService();
			
			sv.execute(request, response);
			
			ui = "/recipe/recipeDetail.jsp";
			
		}
		
		if(uri.equals("ComUpdateForm")) {
			
			sv = new ComUpdateFormService();
			
			sv.execute(request, response);
			
			ui = "/Com/ComUpdateForm.jsp";
		
		}
		
		if(uri.equals("ComUpdate")) {
			
			sv = new ComUpdateService();
			
			sv.execute(request, response);
			
			ui = "/recipeDetail.do?postID=" + request.getParameter("postID");
			
		}
		
		if(uri.equals("ComDelete")) {
			
			sv = new ComDeleteService();
			
			sv.execute(request, response);
			
			ui = "/recipeDetail.do?postID=" + request.getParameter("postID");
			
		}
		
		if(uri.equals("ComInsertForm")) {
			
			ui = "/Com/ComInsertForm.jsp";
		
		}
		
		if(uri.equals("ComInsert")) {
			
			sv = new ComInsertService();
			
			sv.execute(request, response);
			
			ui = "/recipeDetail.do?postID=" + request.getParameter("postID");
			
		}
		
		if(uri.equals("homepage")){
			
			sv = new BoardListService();
			
			sv.execute(request, response);

			ui = "/board/homepage.jsp";
			
		}
		
		if (uri.equals("userLogin")) {
			
			ui = "/user/LoginForm.jsp";
		
		}		
		
		if(uri.equals("userLoginCheck")) {
			
			sv = new UserLoginService();
			sv.execute(request,response);
			ui = (String)request.getAttribute("url");
			System.out.println(ui);
			
		}
		
		if (uri.equals("userJoinForm")) {
			
			ui = "/user/JoinFormlight.jsp";
			
		}
		
		if(uri.equals("userJoinCheck")) {
			
			sv = new UserJoinFormService();
			sv.execute(request,response);
			ui = "/userLogin.do";
			
		}
		
		if(uri.equals("userLogout")) {
			
			sv = new UserLogoutService();
			sv.execute(request,response);
			ui = "/userLogin.do";
			
		}
		
		if(uri.equals("userUpdateForm")) {
			
			sv = new UserUpdateFormService();
			sv.execute(request,response);
			ui = "/user/UpdateForm.jsp";
			
		}
		
		if(uri.equals("userUpdate")) {
			
			sv = new UserUpdateService();
			sv.execute(request,response);
			ui = "/user/LoginComplete.jsp";
			
		}
		
		if(uri.equals("userDelete")) {
			
			sv = new UserDeleteService();
			sv.execute(request,response);
			ui = "/user/LoginForm.jsp";
			
		}
		
		if(uri.equals("AllUser")) {
			
			sv = new AllUserService();
			sv.execute(request,response);
			ui = "/user/getAllUserInfo.jsp";
		
		}
		
		RequestDispatcher dp = request.getRequestDispatcher(ui);
		dp.forward(request, response);
		
	}
	
}
