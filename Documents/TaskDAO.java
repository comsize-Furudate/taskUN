package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.entity.TaskBean;

public class TaskDAO {
	
	public List<TaskBean> selectAll() throws ClassNotFoundException, SQLException{
		
		String sql ="SELECT * FROM t_task";
		
		
	}

}
