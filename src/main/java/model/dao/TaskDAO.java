package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import model.entity.CategoryBean;
import model.entity.StatusBean;
import model.entity.TaskBean;

public class TaskDAO {
	
	public List<TaskBean> select() throws SQLException, ClassNotFoundException, ParseException ,NullPointerException {
		String sql = "SELECT t1.task_id,t1.task_name,t2.category_name,t1.limit_date,t1.user_id,t3.status_name,t1.memo,t1.create_datetime,t1.update_datetime FROM t_task t1  join m_category t2 on t1.category_id=t2.category_id join m_status t3 on t1.status_code=t3.status_code ORDER BY task_id ASC";
		List<TaskBean> taskList = new ArrayList<>();

		try (
				PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql)) {

			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				TaskBean t = new TaskBean();
				t.setTaskId(res.getInt("t1.task_id"));
				t.setTaskName(res.getString("t1.task_name"));
				t.setCategoryName(res.getString("t2.category_name"));
				t.setUserId(res.getString("t1.user_id"));
				t.setLimit(res.getDate("t1.limit_date"));				
				t.setStatusName(res.getString("t3.status_name"));
				t.setMemo(res.getString("t1.memo"));
				t.setCreateDateTime(res.getTimestamp("t1.create_datetime"));
				t.setUpdateDateTime(res.getTimestamp("t1.update_datetime"));
				taskList.add(t);
			}
			return taskList;
		}
	}
	
	
	public List<TaskBean> limit(String userId) throws SQLException, ClassNotFoundException, ParseException ,NullPointerException {
		
		String sql = "SELECT limit_date FROM t_task WHERE user_id=?";
		List<TaskBean> limitList = new ArrayList<>();
		
		
		try(PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql)) {
			
			pstmt.setString(1, userId);
			
			ResultSet res = pstmt.executeQuery();
			
			TaskBean tb = null;
			
			while(res.next()) {
				
				tb = new TaskBean();

				tb.setLimit(res.getDate("limit_date"));
				limitList.add(tb);
				
			}
			return limitList;
		}
		
		
	}
	
	public int delete(int taskId) throws SQLException, ClassNotFoundException {
		String sql = "delete t_task,t_comment  from t_task t1 join t_comment t2 on t1.task_id=t2.task_id where task_id=?";
		int count = 0;
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, taskId);
			count = pstmt.executeUpdate();
		}
		return count;
	}
	
	public int insert(TaskBean taskBean) throws ClassNotFoundException, SQLException {
		int count = 0;
		
		String sql = "insert into t_task values task_name,category_id,"
				+ "limit_date,user_id,status_code,memo,"
				+ "create_datetime values (?,?,?,?,?,?,?)";
		
		try(Connection con=ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			
			
			pstmt.setString(1, taskBean.getTaskName());
			pstmt.setInt(2, taskBean.getCategoryId());
			pstmt.setDate(3, Date.valueOf(taskBean.getLimit()));
			pstmt.setString(4, taskBean.getUserId());
			pstmt.setString(5,taskBean.getStatusCode());
			pstmt.setString(6, taskBean.getMemo());
			pstmt.setTimestamp(7,Timestamp.valueOf(taskBean.getCreateDateTime()) );
			
			count = pstmt.executeUpdate();
		}
		
		return count;
	}
	
	public List<CategoryBean> selectAllCategory() throws SQLException, ClassNotFoundException{
		String sql = "select category_id,category_name from m_category";
		List<CategoryBean> categoryList = new ArrayList<CategoryBean>();
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			
			ResultSet res=pstmt.executeQuery();
			while(res.next()) {
				CategoryBean cb = new CategoryBean();
				cb.setCategoryId(res.getInt("category_id"));
				cb.setCategoryName(res.getString("category_name"));
				categoryList.add(cb);
			}
			
		}
		return categoryList;
	}
	
	public List<StatusBean> selectAllStatus() throws SQLException, ClassNotFoundException{
		String sql = "select status_code,status_name from m_category";
		List<StatusBean> statusList = new ArrayList<StatusBean>();
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			
			ResultSet res=pstmt.executeQuery();
			while(res.next()) {
				StatusBean sb = new StatusBean();
				sb.setStatusCode(res.getString("category_id"));
				sb.setStatusName(res.getString("category_name"));
				statusList.add(sb);
			}
			
		}
		return statusList;
	}

}
