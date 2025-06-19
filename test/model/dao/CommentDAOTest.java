package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;


class CommentDAOTest {
	@Test
	void TestDeleteAllComment_Success() {
		CommentDAO dao =new CommentDAO();
		
		int count =0;
		try {
			count = dao.deleteAllComment(15);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		assertNotEquals(0,count);
	}
	
	@Test
	void TestDeleteAllComment_Failure() {
		CommentDAO dao =new CommentDAO();
		
		int count =0;
		try {
			count = dao.deleteAllComment(15);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		assertEquals(0,count);
	}
	

}
