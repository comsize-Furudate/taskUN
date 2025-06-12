package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

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
				t.setCreateDateTime(res.getDate("t1.create_datetime"));
				t.setUpdateDateTime(res.getDate("t1.update_datetime"));
				taskList.add(t);
			}
			return taskList;
		}
	}
	
	public TaskBean limit(String userId) throws SQLException, ClassNotFoundException, ParseException ,NullPointerException {
		
		String sql = "SELECT limit_date FROM t_task WHERE user_id=?";
		
		
		try(PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql)) {
			
			pstmt.setString(1, userId);
			
			ResultSet res = pstmt.executeQuery();
			
			TaskBean tb = null;
			
			while(res.next()) {
				
				tb = new TaskBean();

				tb.setLimit(res.getDate("limit_date"));
				
			}
			return tb;
		}
		
		
	}

}
