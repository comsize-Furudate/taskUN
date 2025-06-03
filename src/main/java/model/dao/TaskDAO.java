package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.entity.TaskBean;

public class TaskDAO {

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
		}
	}

}
