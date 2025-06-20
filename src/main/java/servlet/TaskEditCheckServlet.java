package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.entity.TaskBean;

/**
 * Servlet implementation class TaskEditCheckServlet
 */
@WebServlet("/task-edit-check-servlet")
public class TaskEditCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskEditCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int i = Integer.parseInt(request.getParameter("task_id"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		TaskBean tb=(TaskBean)session.getAttribute("detail");
		TaskBean newtb=new TaskBean();
		newtb.setTaskId(tb.getTaskId());
		if(request.getParameter("task_name").equals("")) {
			newtb.setTaskName(tb.getTaskName());
		}else {
			newtb.setTaskName(request.getParameter("task_name"));
		}
		String[] categorys=request.getParameter("category_name").split(",", 2);
		newtb.setCategoryId(Integer.parseInt(categorys[0]));
		newtb.setCategoryName(categorys[1]);
		String limitstr =request.getParameter("limit");
		if(limitstr.equals("")) {
			newtb.setLimit(tb.getLimit());
		}else {
			LocalDate targetDate = DateTimeFormatter.ofPattern("yyyy-MM-dd")
			        .parse(limitstr, LocalDate::from);
			newtb.setLimit(targetDate);
		}
		String[] statuses=request.getParameter("status_name").split(",", 2);
		newtb.setStatusCode(statuses[0]);
		newtb.setStatusName(statuses[1]);
		if(request.getParameter("task_name").equals("")) {
			newtb.setTaskName(tb.getTaskName());
		}else {
			newtb.setTaskName(request.getParameter("task_name"));
		}
		if(request.getParameter("memo").equals("")) {
			newtb.setMemo(tb.getMemo());
		}else {
			newtb.setMemo(request.getParameter("memo"));
		}
		newtb.setCreateDateTime(tb.getCreateDateTime());
		
		session.setAttribute("newdetail", newtb);
		RequestDispatcher rd = request.getRequestDispatcher("task-edit-check.jsp");
		rd.forward(request, response);

	}
	

}
