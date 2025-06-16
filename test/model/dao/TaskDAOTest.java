package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
	@Test
	void Testupdate_success() {
		TaskDAO dao=new TaskDAO();
		TaskBean tb=new TaskBean();
		tb.setTaskName("テスト");
		tb.setCategoryId(1);
		LocalDate targetDate = DateTimeFormatter.ofPattern("yyyy/MM/dd")
				.parse("2019/03/01", LocalDate::from);
		tb.setLimit(targetDate);
		tb.setStatusCode("99");
		tb.setMemo("テスト");
		tb.setTaskId(3);
		
		try {
			int count =dao.update(tb);
			assertEquals(count,1 );
		}catch(SQLException | ClassNotFoundException | NullPointerException  e) {
			e.printStackTrace();
		}
	}
}
