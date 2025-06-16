package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
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
import model.entity.CategoryBean;
import model.entity.StatusBean;
import model.entity.TaskBean;

/**
 * Servlet implementation class TaskAddServlet
 */
@WebServlet("/task-add-servlet")
public class TaskAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		//セッションチェック
		if(session.getAttribute("id") == null) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		CategoryDAO dao = new CategoryDAO();
		StatusDAO sdao= new StatusDAO();
		try{
\			//プルダウン用の値の取得
			List<CategoryBean> categoryList = dao.selectAllCategory();
			List<StatusBean> statusList = sdao.selectAllStatus();
			//日付制御用の値の取得
			LocalDate today = LocalDate.now();
			
			session.setAttribute("categoryList", categoryList);
			session.setAttribute("statusList", statusList);
			session.setAttribute("today", today);
			
			RequestDispatcher rd = request.getRequestDispatcher("task-add-form.jsp");
			rd.forward(request, response);
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		//セッションチェック
		if(session.getAttribute("id") == null) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		try {
			//フォームで入力された値の取得
			String taskName = request.getParameter("taskName");
			int categoryId = Integer.parseInt(request.getParameter("category"));
			String limit = request.getParameter("limit");
			String statusCode = request.getParameter("status");
			String userId = request.getParameter("userId");
			String memo = request.getParameter("memo");
			
			//入力チェック
			if(taskName == null || userId == null || memo.length() > 100 || userId.length() > 24) {
				RequestDispatcher rd = request.getRequestDispatcher("task-add-failure.jsp");
				rd.forward(request, response);
			
			}
			//Beanに詰める	
			TaskBean taskBean = new TaskBean();
			taskBean.setTaskName(taskName);
			taskBean.setCategoryId(categoryId);
			
			if(limit != null) {
				LocalDate limit2 = LocalDate.parse(limit);
				LocalDate limit3=(LocalDate)session.getAttribute("today");
				if(limit3.isBefore(limit2.plusDays(1))){
					taskBean.setLimit(limit2);
				}else {
					RequestDispatcher rd = request.getRequestDispatcher("task-add-failure.jsp");
					rd.forward(request, response);
				}	
			}else {
				taskBean.setLimit((LocalDate)null);
			}
			taskBean.setStatusCode(statusCode);
			if(new UserDAO().logincheck(userId)!=null) {
				taskBean.setUserId(userId);
			}else {
				throw new SQLException();
			}
			
			taskBean.setMemo(memo);
			//taskBean.setCreateDateTime(LocalDateTime.now());
			
			//登録実行
			TaskDAO dao = new TaskDAO();
			int insertResult = 0;
			insertResult = dao.insert(taskBean);
			//結果分岐
			if(insertResult != 0) {
				RequestDispatcher rd = request.getRequestDispatcher("task-add-success.jsp");
				rd.forward(request, response);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("task-add-failure.jsp");
				rd.forward(request, response);
			}

		}catch(NullPointerException | NumberFormatException | DateTimeParseException e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("task-add-failure.jsp");
			rd.forward(request, response);
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("task-add-failure.jsp");
			rd.forward(request, response);
		
		}
	}

}
