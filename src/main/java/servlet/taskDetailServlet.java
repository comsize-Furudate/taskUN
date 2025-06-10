package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.entity.TaskBean;

/**
 * Servlet implementation class taskDetailServlet
 */
@WebServlet("/taskDetailServlet")
public class taskDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public taskDetailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int i = Integer.parseInt(request.getParameter("task_id"));
		HttpSession session = request.getSession();
		List<TaskBean> tbList = (List) session.getAttribute("taskList");

		TaskBean tb = tbList.get(i - 1);
		String loginID = (String) session.getAttribute("id");
		boolean check;
		if (loginID.equals(tb.getUserId())) {
			check = true;
		} else {
			check = false;
		}
		session.setAttribute("check", check);
		session.setAttribute("detail", tb);
		RequestDispatcher rd = request.getRequestDispatcher("task-detail.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int i = Integer.parseInt(request.getParameter("task_id"));
		HttpSession session = request.getSession();
		List<TaskBean> tbList = (List) session.getAttribute("taskList");

		TaskBean tb = tbList.get(i - 1);
		String loginID = (String) session.getAttribute("id");
		boolean check;
		if (loginID.equals(tb.getUserId())) {
			check = true;
		} else {
			check = false;
		}
		session.setAttribute("check", check);
		session.setAttribute("detail", tb);
		RequestDispatcher rd = request.getRequestDispatcher("task-detail.jsp");
		rd.forward(request, response);
	}

}
