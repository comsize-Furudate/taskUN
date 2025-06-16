package model.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import model.entity.TaskBean;

public class TaskDAO {
<<<<<<< HEAD
	public List<TaskBean> select() throws SQLException, ClassNotFoundException, ParseException, NullPointerException {
=======
	public List<TaskBean> select() throws SQLException, ClassNotFoundException, ParseException ,NullPointerException {
>>>>>>> ed3fd5d15e89c3492413f408b3ca24b08096d0a4
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
<<<<<<< HEAD
				t.setLimit(res.getDate("t1.limit_date"));
=======
				t.setLimit(res.getDate("t1.limit_date"));				
>>>>>>> ed3fd5d15e89c3492413f408b3ca24b08096d0a4
				t.setStatusName(res.getString("t3.status_name"));
				t.setMemo(res.getString("t1.memo"));
				t.setCreateDateTime(res.getTimestamp("t1.create_datetime"));
				t.setUpdateDateTime(res.getTimestamp("t1.update_datetime"));
				taskList.add(t);
			}
			return taskList;
		}
	}
	public int update(TaskBean tb) throws SQLException, ClassNotFoundException
	{
		String sql ="UPDATE t_task SET task_name = ? , category_id = ? , limit_date= ? , status_code= ? , memo=? WHERE task_id=?";
		try (
				PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql)) {

<<<<<<< HEAD
	public int update(TaskBean tb) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE t_task SET task_name = ? , category_id = ? , limit_date= ? , status_code= ? , memo=? WHERE task_id=?";
		try (
				PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql)) {

			pstmt.setString(1, tb.getTaskName());
			pstmt.setInt(2, tb.getCategoryId());
			pstmt.setDate(3, Date.valueOf(tb.getLimit()));
			pstmt.setString(4, tb.getStatusCode());
			pstmt.setString(5, tb.getMemo());
			pstmt.setInt(6, tb.getTaskId());

			int count = pstmt.executeUpdate();
			return count;
		}
	}
}
=======
			pstmt.setString(1,tb.getTaskName() );
			pstmt.setInt(2, tb.getCategoryId());
			pstmt.setDate(3, Date.valueOf(tb.getLimit()));
			pstmt.setInt(4, tb.getStatusCode());
			pstmt.setString(5, tb.getMemo());
			pstmt.setInt(6,tb.getTaskId());
			
			int count = pstmt.executeUpdate();
			return count;
	}
}}
>>>>>>> ed3fd5d15e89c3492413f408b3ca24b08096d0a4
