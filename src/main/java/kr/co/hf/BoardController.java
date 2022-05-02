package kr.co.hf;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hf.domain.BoardDAO;
import kr.co.hf.domain.BoardVO;
import kr.co.hf.service.BoardDetailService;
import kr.co.hf.service.BoardInsertService;
import kr.co.hf.service.BoardListService;
import kr.co.hf.service.IBoardService;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
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
	
		String ui = null;
		
		BoardDAO dao = BoardDAO.getInstance();
		
		IBoardService sv = null;
		
		if(uri.equals("/HFprj/boardList.do")) {
			
			sv = new BoardListService();
			
			sv.execute(request, response);

			ui = "/board/boardList.jsp";
			
			
			
		} else if (uri.equals("/HFprj/boardDetail.do")) {
			
			sv = new BoardDetailService();
			
			sv.execute(request, response);
			
			ui = "/board/boardDetail.jsp";
			
		} else if (uri.equals("/HFprj/boardInsertForm.do")) {
			
			ui = "/board/boardInsertForm.jsp";
			
		} else if (uri.equals("/HFprj/boardInsert.do")) {
			
			sv = new BoardInsertService();
			
			sv.execute(request, response);
			
			ui = "/boardList.do";
			
		}
		
		RequestDispatcher dp = request.getRequestDispatcher(ui);
		dp.forward(request, response);
		
	}

}
