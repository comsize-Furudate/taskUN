package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import model.entity.UserBean;

class UserDAOTest {

	@Test
	void Testlogincheck_success() {
		
		UserDAO dao = new UserDAO();
		UserBean bean = new UserBean();
		String id = "yamagata";
		
		try {
			bean = dao.logincheck(id);
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		assertNotNull(bean);
	}
	
	@Test
	void Testlogincheck_failure() {
		
		UserDAO dao = new UserDAO();
		UserBean bean = new UserBean();
		String id = "yamada";
		
		try {
			bean = dao.logincheck(id);
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		assertNull(bean);
	}

}
