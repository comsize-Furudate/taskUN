package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.entity.TaskBean;

class TaskDAOTest {

	@Test
	void Testselect_success() {
		
		TaskDAO dao = new TaskDAO();
		
		try {
			
			List<TaskBean> bean = (List<TaskBean>) dao.select();
			assertNotNull(bean);
			
		}catch(SQLException | ClassNotFoundException | NullPointerException | ParseException e) {
			
			e.printStackTrace();
		}
		
	}

}
