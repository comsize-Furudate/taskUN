package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.entity.TaskBean;

class TaskDAOTest {

	@Test
	void Testlimit_success() {

		TaskDAO dao = new TaskDAO();
		List<TaskBean> limitList = new ArrayList<>();
		String id = "yamagata";

		try {

			limitList = dao.limit(id);

		} catch (SQLException | ClassNotFoundException | NullPointerException | ParseException e) {

			e.printStackTrace();
		}

		assertNotNull(limitList);
	}
	
	@Test
	void Testlimit_failure() {
		
		TaskDAO dao = new TaskDAO();
		List<TaskBean> limitList = new ArrayList<>();
		String id = "yamada";

		try {

			limitList = dao.limit(id);

		} catch (SQLException | ClassNotFoundException | NullPointerException | ParseException e) {

			e.printStackTrace();
			assertNull(limitList);
		}

		
		
		
	}
	
	@Test
	void Testdelete_success() {
		
		TaskDAO dao = new TaskDAO();
		int id = 17;
		int count = 0;
		
		try {
			
			count = dao.delete(id);
			
		}catch(SQLException | ClassNotFoundException | NullPointerException e) {
			
			e.printStackTrace();
		}
		
		assertEquals(1,count);
		
		
	}
	
	@Test
	void Testdelete_failure() {
		
		TaskDAO dao = new TaskDAO();
		int id = 17;
		int count = 0;
		
		try {
			
			count = dao.delete(id);
			
		}catch(SQLException | ClassNotFoundException | NullPointerException e) {
			
			e.printStackTrace();
		}
		
		assertEquals(0,count);
		
		
	}


}
