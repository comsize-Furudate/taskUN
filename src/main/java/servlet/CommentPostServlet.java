package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.CommentDAO;
import model.entity.CommentBean;
import model.entity.TaskBean;

/**
 * Servlet implementation class CommentPostServlet
 */
@WebServlet("/comment-post-servlet")
public class CommentPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		//入力されたコメントの取得
		String comment = request.getParameter("commentPost");
		if(comment.equals("コメントを投稿する。")||comment.equals("")) {
			RequestDispatcher rd = request.getRequestDispatcher("task-detail.jsp");
			rd.forward(request, response);
		}else {
		
		//Beanに詰める
		CommentBean bean =new CommentBean();
		bean.setTaskId(((TaskBean) session.getAttribute("detail")).getTaskId());
		bean.setUserId((String)session.getAttribute("id"));
		bean.setComment(comment);
		
		//コメントをDBに入れる
		CommentDAO dao = new CommentDAO();
		int result = 0;
		try {
			result = dao.insertComment(bean);	
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		if(result ==0) {
			RequestDispatcher rd =request.getRequestDispatcher("comment-post-failure.jsp");
			rd.forward(request, response);
		}
		//表示するコメントを取得する
		List<CommentBean> commentList;
		try {
			commentList = dao.selectComment(((TaskBean) session.getAttribute("detail")).getTaskId());
			session.setAttribute("commentList", commentList);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("task-detail.jsp");
		rd.forward(request, response);
		
	}

}}
