package kr.co.hf;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hf.domain.BoardDAO;
import kr.co.hf.service.AllUserService;
import kr.co.hf.service.BoardDeleteService;
import kr.co.hf.service.BoardDetailService;
import kr.co.hf.service.BoardInsertService;
import kr.co.hf.service.BoardListService;
import kr.co.hf.service.BoardUpdateFormService;
import kr.co.hf.service.BoardUpdateService;
import kr.co.hf.service.ComDeleteService;
import kr.co.hf.service.ComInsertService;
import kr.co.hf.service.ComUpdateFormService;
import kr.co.hf.service.ComUpdateService;
import kr.co.hf.service.IBoardService;
import kr.co.hf.service.IRecipeService;
import kr.co.hf.service.RecipeDetailService;
import kr.co.hf.service.UserService;
import kr.co.hf.service.userDeleteService;
import kr.co.hf.service.userJoinFormService;
import kr.co.hf.service.userLoginService;
import kr.co.hf.service.userLogoutService;
import kr.co.hf.service.userUpdateFormService;
import kr.co.hf.service.userUpdateService;

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
	public void destroy() {
		// TODO Auto-generated method stub
	}

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
		
		BoardDAO dao = BoardDAO.getInstance();
		
		IBoardService sv = null;
		UserService usv = null;
		IRecipeService IRsv = null;
		
		if(uri.equals("boardList")) {
			
			sv = new BoardListService();
			
			sv.execute(request, response);

			ui = "/board/getBoardList.jsp";
			
			
			
		} else if (uri.equals("boardDetail")) {
			
			sv = new BoardDetailService();
			
			sv.execute(request, response);
			
			ui = "/board/boardDetail.jsp";
			
		} else if (uri.equals("boardInsertForm")) {
			
			ui = "/board/boardInsertForm.jsp";
			
		} else if (uri.equals("boardInsert")) {
			
			sv = new BoardInsertService();
			
			sv.execute(request, response);
			
			ui = "/boardList.do";
			
		} else if (uri.equals("boardUpdate")) {
			
			sv = new BoardUpdateService();
			
			sv.execute(request, response);
			
			ui = "/boardList.do";
			
		} else if (uri.equals("boardUpdateForm")) {
			
			sv = new BoardUpdateFormService();
			
			sv.execute(request, response);
			
			ui = "/board/boardUpdateForm.jsp";
		
		} else if (uri.equals("boardDelete")) {
			
			sv = new BoardDeleteService();
			
			sv.execute(request, response);
			
			ui = "/boardList.do";
			
		} else if (uri.equals("recipeDetail")) {
			
			IRsv = new RecipeDetailService();
			
			IRsv.execute(request, response);
			
			ui = "recipe/recipeDetail.jsp";
			
		} else if(uri.equals("ComUpdateForm")) {
			
			IRsv = new ComUpdateFormService();
			
			IRsv.execute(request, response);
			
			ui = "/Com/ComUpdateForm.jsp";
		
		} else if(uri.equals("ComUpdate")) {
			
			IRsv = new ComUpdateService();
			
			IRsv.execute(request, response);
			
			ui = "/recipeDetail.do?postID=" + request.getParameter("postID");
			
		} else if(uri.equals("ComDelete")) {
			
			IRsv = new ComDeleteService();
			
			IRsv.execute(request, response);
			
			ui = "/recipeDetail.do?postID=" + request.getParameter("postID");
			
		} else if(uri.equals("ComInsertForm")) {
			
			ui = "/Com/ComInsertForm.jsp";
		
		} else if(uri.equals("ComInsert")) {
			
			IRsv = new ComInsertService();
			
			IRsv.execute(request, response);
			
			ui = "/recipeDetail.do?postID=" + request.getParameter("postID");
			
		} else if(uri.equals("tamplateSample")){
			
			sv = new BoardListService();
			
			sv.execute(request, response);

			ui = "/tamplateSample.jsp";
			
		} else if (uri.equals("userLogin")) {
			ui = "/user/LoginForm.jsp";
		}		
		else if(uri.equals("userLoginCheck")) {
			usv = new userLoginService();
			usv.execute(request,response);
			ui = (String)request.getAttribute("url");
			System.out.println(ui);
		} else if (uri.equals("userJoinForm")) {
			ui = "/user/JoinFormlight.jsp";
		} else if(uri.equals("userJoinCheck")) {
			usv = new userJoinFormService();
			usv.execute(request,response);
			ui = "/userLogin.do";
		} else if(uri.equals("userLogout")) {
			usv = new userLogoutService();
			usv.execute(request,response);
			ui = "/userLogin.do";
		} else if(uri.equals("userUpdateForm")) {
			usv = new userUpdateFormService();
			usv.execute(request,response);
			ui = "/user/UpdateForm.jsp";
		} else if(uri.equals("userUpdate")) {
			usv = new userUpdateService();
			usv.execute(request,response);
			ui = "/user/LoginComplete.jsp";
		} else if(uri.equals("userDelete")) {
			usv = new userDeleteService();
			usv.execute(request,response);
			ui = "/user/LoginForm.jsp";
		} else if(uri.equals("AllUser")) {
			usv = new AllUserService();
			usv.execute(request,response);
			ui = "/user/getAllUserInfo.jsp";
		}
		
		RequestDispatcher dp = request.getRequestDispatcher(ui);
		dp.forward(request, response);
		
	}
	
}
