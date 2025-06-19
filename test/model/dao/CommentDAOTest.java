package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

public class CommentDAOTest {
	
	@Test
	void Testdeletecomment_success() {
		
		CommentDAO dao = new CommentDAO();
		int id = 5;
		int count = 0;
		
		try {
			
			count = dao.deleteComment(id);
			
		}catch(SQLException | ClassNotFoundException | NullPointerException e) {
			
			e.printStackTrace();
		}
		
		assertEquals(1,count);
		
		
	}
	
	@Test
	void Testdeletecomment_failure() {
		
		CommentDAO dao = new CommentDAO();
		int id = 17;
		int count = 0;
		
		try {
			
			count = dao.deleteComment(id);
			
		}catch(SQLException | ClassNotFoundException | NullPointerException e) {
			
			e.printStackTrace();
		}
		
		assertEquals(0,count);
		
		
	}

}
