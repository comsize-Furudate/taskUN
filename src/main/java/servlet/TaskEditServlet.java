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

import model.dao.TaskDAO;
import model.entity.TaskBean;

/**
 * Servlet implementation class TaskEditServlet
 */
@WebServlet("/task-edit-servlet")
public class TaskEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TaskEditServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		TaskBean tb = (TaskBean) session.getAttribute("detail");
		TaskBean newtb = (TaskBean) session.getAttribute("newdetail");
		
		if (tb.getTaskName().equals(newtb.getTaskName()) && tb.getCategoryName().equals(newtb.getCategoryName())
				&& tb.getLimit().equals(newtb.getLimit()) && tb.getStatusName().equals(newtb.getStatusName())
				&& tb.getMemo().equals(newtb.getMemo())) {
			
			RequestDispatcher rd = request.getRequestDispatcher("task-edit-success.jsp");
			rd.forward(request, response);
			
		} else {
			
			TaskDAO tdao = new TaskDAO();
			int count;
			
			try {
				count = tdao.update(newtb);

				if (count == 0) {
					
					RequestDispatcher rd = request.getRequestDispatcher("task-edit-false.jsp");
					rd.forward(request, response);
					
				}else {
					
					RequestDispatcher rd = request.getRequestDispatcher("task-edit-success.jsp");
					rd.forward(request, response);
					
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				
				RequestDispatcher rd = request.getRequestDispatcher("task-edit-false.jsp");
				rd.forward(request, response);
				
				e.printStackTrace();
				
			}
		}
	}

}
