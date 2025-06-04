package model.dao;

<<<<<<< HEAD
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
=======
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
>>>>>>> d76b576c85ad9efd6f9b70c66d3feff91417e333
import java.util.ArrayList;
import java.util.List;

import model.entity.TaskBean;

public class TaskDAO {
<<<<<<< HEAD
	public List<TaskBean> select() throws SQLException, ClassNotFoundException {
		String sql = "SELECT t1.task_id,t1.task_name,t2.category_name,t1.limit_date,t1.user_id,t3.status_name,t1.memo,t1.create_datetime,t1.update_datetime FROM  t1 t_task join m_category t2 on t1.category_code=t2.category_code join m_status t3 on t1.status_code=t3.status_code ORDER BY taskId ASC";
		List<TaskBean> taskList = new ArrayList<>();

		try (
				PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql)) {

			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				TaskBean t = new TaskBean();
				t.setTaskId(res.getInt("t1.task_id"));
				t.setTaskName(res.getString("t1.task_name"));
				t.setCategoryName(res.getString("t2.category_name"));
				t.setLimit(res.getDate("t1.limit_date"));
				t.setStatusName(res.getString("t3.status_name"));
				t.setMemo(res.getString("t1.memo"));
				t.setCreateDateTime(res.getDate("t1.create_datetime"));
				t.setUpdateDateTime(res.getDate("t1.update_datetime"));
				taskList.add(t);
			}
			return taskList;
=======

	public List<TaskBean> selectAll() throws ClassNotFoundException, SQLException{
		
		List<TaskBean> tasklist = new ArrayList<>();
		
		String sql ="SELECT * FROM t_task";
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
				int taskId = res.getInt("task_id");
				String taskName = res.getString("task_name");
				int categoryId = res.getInt("category_id");
				Date limitDate = res.getDate("limit_date");
				String userId = res.getString("user_id");
				int statusCode = res.getInt("status_code");
				String mamo = res.getString("memo");
				Timestamp createDatetime = res.getTimestamp("create_datetime");
				Timestamp updateDatetime = res.getTimestamp("update_datetime");
				
				TaskBean taskbean = new TaskBean();
				
				taskbean.setTaskId(taskId);
				taskbean.setTaskName(taskName);
				taskbean.setCategoryId(categoryId);
				taskbean.setLimit(limitDate);
				taskbean.setUserId(userId);
				taskbean.setStatusCode(statusCode);
				taskbean.setMemo(mamo);
				taskbean.setCreateDatetime(createDatetime);
				taskbean.setUpdateDateTime(updateDatetime);
				
				tasklist.add(taskbean);
				
			}
			return tasklist;
>>>>>>> d76b576c85ad9efd6f9b70c66d3feff91417e333
		}
	}

}
