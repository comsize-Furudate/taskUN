package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.TaskDAO;
import model.dao.UserDAO;
import model.entity.TaskBean;
import model.entity.UserBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login-servlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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

		String userId = request.getParameter("userId");
		String pass = request.getParameter("password");

		UserDAO dao = new UserDAO();

		if (userId == null || userId.isEmpty()) {

			String error = "ユーザーID、パスワードを入力してください";
			request.setAttribute("error", error);

			RequestDispatcher rd = request.getRequestDispatcher("login-failure.jsp");
			rd.forward(request, response);

		} else if (userId.length() > 24 || pass.length() > 32) {

			String error = "ユーザーIDまたはパスワードが最大文字数を超えています";
			request.setAttribute("error", error);

			RequestDispatcher rd = request.getRequestDispatcher("login-failure.jsp");
			rd.forward(request, response);

		} 

		try {

			UserBean userbean = dao.logincheck(userId);

			

			if (userbean == null) {

				String error = "ユーザーIDまたはパスワードが正しくありません";
				request.setAttribute("error", error);

				RequestDispatcher rd = request.getRequestDispatcher("login-failure.jsp");
				rd.forward(request, response);
				
			}else if(!userbean.getPassword().equals(pass)) {
				
				
				String error = "ユーザーIDまたはパスワードが正しくありません";
				request.setAttribute("error", error);

				RequestDispatcher rd = request.getRequestDispatcher("login-failure.jsp");
				rd.forward(request, response);

			} else {

				HttpSession session = request.getSession();
				
				String name = userbean.getUserName();
			
				session.setAttribute("id", userId);
				session.setAttribute("name", name);
				session.setAttribute("pass", pass);

			}

			TaskDAO taskdao = new TaskDAO();

			LocalDate today = LocalDate.now();
			LocalDate todayAdd3 = today.plusDays(3);
			LocalDate todayAdd2 = today.plusDays(2);
			LocalDate todayAdd1 = today.plusDays(1);

			List<TaskBean> taskbeanList = (List<TaskBean>) taskdao.limit(userId);
			
			String msg = null;
		
			HttpSession session = request.getSession();
			
			for(TaskBean taskBean : taskbeanList) {
			
				if(taskBean != null) {
				
					LocalDate limit = ((TaskBean) taskBean).getLimit();
					
					if (limit.isAfter(today) && limit.isBefore(todayAdd1)) {
						
						msg = "期限が1日以内のタスクがあります";
						break;
						
					}else if(limit.isAfter(today) && limit.isBefore(todayAdd2)){
						
						msg = "期限が2日以内のタスクがあります";
						break;
						
					}else if(limit.isAfter(today) && limit.isBefore(todayAdd3)) {
						
						msg = "期限が3日以内のタスクがあります";
						
						
					}
					
					session.setAttribute("msg", msg);
					
				}
			}
			
			session.setAttribute("msg", msg);
			
			RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
			rd.forward(request, response);

		} catch (ClassNotFoundException | SQLException | NullPointerException | ParseException e) {

			e.printStackTrace();
		}
		
		
	}
}
