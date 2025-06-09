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

import model.dao.UserDAO;
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

		} else {

			try {

				UserBean userbean = dao.logincheck(userId);

				String name = userbean.getUserName();

				if (userbean.getPassword().equals(pass)) {

					String loginsuccess = "成功";

					HttpSession session = request.getSession();
					session.setAttribute("loginsuccess", loginsuccess);
					session.setAttribute("id", userId);
					session.setAttribute("name", name);
					session.setAttribute("pass", pass);

					RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
					rd.forward(request, response);

				} else {
					String error = "ユーザーIDまたはパスワードが正しくありません";
					request.setAttribute("error", error);

					RequestDispatcher rd = request.getRequestDispatcher("login-failure.jsp");
					rd.forward(request, response);
				}

			} catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
			}
		}

	}
}
