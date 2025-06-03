package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.TaskBean;

public class taskDAO {
	public List<TaskBean> select() throws SQLException, ClassNotFoundException {
		String sql = "SELECT t1.task_id,t1.task_name,t2.category_name,t1.limit_date,t1.user_id,t3.status_name,t1.memo,t1.create_datetime,t1.update_datetime FROM  t1 t_task join m_category t2 on t1.category_code=t2.category_code join m_status t3 on t1.status_code=t3.status_code";
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
		}
	}
	public int update(TaskBean t) {
		String sql = "UPDATE t_task SET task_name=?, category_code=?,limit_date=?,status_code=?,memo=? WHERE task_id=?";
		try (
				PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql)) {

			pstmt.setInt(1, b.getCategoryCode());
			pstmt.setString(2, b.getItemName());
			pstmt.setInt(3, b.getPrice());
			pstmt.setInt(4, b.getItemCode());
			int count = pstmt.executeUpdate();
			return count;
	}
}
