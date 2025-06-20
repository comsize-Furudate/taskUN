package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.CommentDAO;
import model.dao.TaskDAO;
import model.entity.TaskBean;

/**
 * Servlet implementation class TaskDeleteServlet
 */
@WebServlet("/task-delete-servlet")
public class TaskDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	request.setCharacterEncoding("utf-8");
		 	HttpSession session = request.getSession();
		 	//セッションチェック
		 	if(session.getAttribute("id") == null) {
		 		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		 		rd.forward(request, response);
		 		
		 	}
		 	//削除するタスクのタスクIDを受け取る
		 	TaskBean bean = (TaskBean)session.getAttribute("detail");
		 	int taskId = bean.getTaskId();
		 	
		 	//先にコメントの削除する。
		 	CommentDAO cd = new CommentDAO();
		 	try {
				int count = cd.deleteAllComment(taskId);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		 	
		 	//タスク削除を行う
		 	TaskDAO dao = new TaskDAO();
		 	int deleteResult = 0;//deleteの戻り値入れる変数
		 	try {
				deleteResult = dao.delete(taskId);
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
		 	
		 	//結果分岐
		 	if(deleteResult != 0) {
		 		RequestDispatcher rd = request.getRequestDispatcher("task-delete-success.jsp");
		 		rd.forward(request, response);
		 	}else {
		 		RequestDispatcher rd = request.getRequestDispatcher("task-delete-failure.jsp");
		 		rd.forward(request, response);
		 	}
		 	
		 	
	}

}
