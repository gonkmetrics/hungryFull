package kr.co.hf;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hf.domain.BoardDAO;
import kr.co.hf.domain.BoardVO;

/**
 * Servlet implementation class BoardDetail
 */
@WebServlet("/boardDetail")
public class BoardDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String postID = request.getParameter("postID");
			
			BoardDAO dao = BoardDAO.getInstance();
			BoardVO board = dao.getBoardDetail(Integer.parseInt(postID));
			
			request.setAttribute("board", board);
			
			RequestDispatcher dp = request.getRequestDispatcher("/");
			
			dp.forward(request, response);
			
	}


}
